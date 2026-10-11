
// Class:            CS 3305/<add your section number here>
// Term:             <Add semester and year here, e.g., Spring 2026>
// Student Name:     <Add your name here>
// Instructor:       Professor <add your professor's name here>
// Assignment No.:   <Add assignment number here>
// IDE name:         <Add your IDE name here>

/*
This program implements the concept of rating hotels over a number of years. The rating is represented by 
a number of stars: one star (lowest quality) to five stars (highest quality). The only data field the class
has is a two-dimensional array of values representing the quality ratings. Dimension 1 (rows) represents
the hotels and dimension 2 (columns) represents the years. The class constructor method takes two parameters
representing the number of hotels and the number of years. These values decide the size of the array
(rows x columns). The ratings are randomly generated integer values (between 1 and 5 inclusive) and stored
in the array. The class defines 7 methods to implement this concept.*
*/

import java.text.NumberFormat;

public class HotelRating
{
   private int[][] ratings; // Encapsulated data field for ratings
   
   public HotelRating(int hotelNum, int yearNum) // Constructuor to create array and fill with random ratings
   {
      // Ensure we have at least 1 hotel and 1 year
      if (hotelNum <= 0)
      {
         hotelNum = 1;
      }
      if (yearNum <= 0)
      {
         yearNum = 1;
      }
       // 2D array to store hotel ratings
      ratings = new int[hotelNum][yearNum];
      
      for (int h = 0; h < hotelNum; h++)
      {
         for (int y = 0; y < yearNum; y++)
         {
            ratings[h][y] = (int)(Math.random() * 5) + 1; // assign random int rating between 1-5 (inclusive)
         }
      }
   }
   
   public int[] fiveStarHotels() // fiveStarHotels: indices of hotels with at least one 5-star rating
   {
      int hotelNum = ratings.length;
      
      // Count how many hotels qualify for five stars ratings
      int count = 0;
      for (int h = 0; h < hotelNum; h++)
      {
         if (hasAtLeastRating(h, 5))
         {
            count++;
         }
      }
      
      // Store those hotel indices in an array
      int[] result = new int[count];
      int idx = 0;
      for (int h = 0; h < hotelNum; h++)
      {
         if (hasAtLeastRating(h, 5)) // Call helper method hasAtLeastRating()
         {
            result[idx] = h;
            idx++;
         }
      }
      
      return result;
   }
   
   public void averageRatings() //averageRatings: print average rating for hotels
   {
      // Format 2 decimals
      NumberFormat fmt = NumberFormat.getNumberInstance();
      fmt.setMinimumFractionDigits(2);
      fmt.setMaximumFractionDigits(2);
      
      // Loop through and print average ratings
      System.out.println("Average Ratings are:");
      for (int h = 0; h < ratings.length; h++)
      {
         double avg = computeAverageForHotel(h); // Call helper method computeAverageForHotel()
         System.out.printf("\t%-37s %s%n", "Hotel " + h + ":", fmt.format(avg));
      }
   }
   
   public void fourOrMoreStars() //fourOrMoreStars: indices of hotels with at least one 4+ star rating
   {
      String indices = "";
      boolean first = true;
      
      for (int h = 0; h < ratings.length; h++)
      {
         if (hasAtLeastRating(h, 4))  // Call helper method hasAtLeastRating
         {
            if (!first)
            {
               indices += ", ";
            }
            indices += h;
            first = false;
         }
      }
      // Print label and indices
      System.out.printf("%-40s %s%n", "Four or more stars hotels indices:", indices);
   }
   
   public boolean anyFiveStars() //true if any hotel has at least one 5 star rating
   {
      for (int h = 0; h <ratings.length; h++)
      {
         if (hasAtLeastRating(h, 5)) // call helper method hasAtLeastRating()
         {
            return true;
         }
      }
      return false;
   }
   
   public int bestHotel() // Return index of best Hotel
   {
      int bestIdx = 0; // Initially, set hotel 0 to be the best hotel
      double bestAvg = computeAverageForHotel(0); // Call helper method computeAverageForHotel()
      
      for (int h = 1; h < ratings.length; h++) // Loop through all hotels to determine the best hotel
      {
         double avg = computeAverageForHotel(h); // Call helper method computeAverageForHotel()
            if (avg >  bestAvg)
            {
               bestAvg = avg;
               bestIdx = h;
            }
      }
      return bestIdx;
   }
   
   public int worstHotel() // Return index of worst hotel
   {
      int worstIdx = 0; // Initially, set hotel 0 to be the worst hotel
      double worstAvg = computeAverageForHotel(0); // Call helper method computeAverageForHotel()
      
      for (int h = 1; h < ratings.length; h++) // Loop through all hotels to determine the worst hotel
      {
         double avg = computeAverageForHotel(h); // Call helper method computeAverageForHotel()
            if (avg <  worstAvg)
            {
               worstAvg = avg;
               worstIdx = h;
            }
      }
      return worstIdx;
   }
   
   public void printChart() // Display the chart of ratings for each hotel & year
   {
      int hotelNum = ratings.length;
      int yearNum = ratings[0].length;
      
      int labelWidth = 10;
      int colWidth = 8; 
      
      // Print the table header
      System.out.print("\t");
      System.out.printf("%-" + labelWidth + "s", "");
      
      // Print the table columns headers
      for (int y = 0; y < yearNum; y++)
      {
         System.out.printf("%-" + colWidth + "s", "Year" + (y+1));
         
      }
      System.out.println();
      System.out.print("\t");
      for (int i = 0; i < labelWidth + colWidth * yearNum; i++)
      {
         System.out.print("-");
      }
      System.out.println();
      
      // Print the table rows, one for each hotel
      for (int h = 0; h < hotelNum; h++)
      {
         System.out.print("\t");
         System.out.printf("%-" + labelWidth + "s","Hotel " + h + ":");
         for (int y = 0; y < yearNum; y++)
         {
            // Loop through and print rating stars for each notel and year
            String stars = "";
            for (int s= 0; s < ratings[h][y]; s++)
            {
               stars += "*";
            }
            System.out.printf("%-" + colWidth + "s", stars);
         }
         System.out.println();
      }
   }
   
    //Helper method to check if at least 1 hotel has cerain rating
   private boolean hasAtLeastRating(int hotelIdx, int minRating)
   {
      for (int y = 0; y < ratings[hotelIdx].length; y++) // Loop through all hotels
      {
         if (ratings[hotelIdx][y] >= minRating)
         {
            return true;
         }
      }
      return false;
   }
   
   //Helper method to compute average for a given hotel
   private double computeAverageForHotel(int hotelIdx)
   {
      int sum = 0;
      for (int y = 0; y < ratings[hotelIdx].length; y++)  // compute the sum
      {
         sum += ratings[hotelIdx][y];
      }
      return (double)sum / ratings[hotelIdx].length;  // Compute the average
   }
}
