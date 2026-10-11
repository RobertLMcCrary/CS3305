// Add your header here

import java.util.Scanner;

public class myTest_No_HT
{
   public static void main (String[] args)
   {
      LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object
   
      for (int i=1; i <= 5; i++) //add 5 nodes to the list
      {
         myList.addLastNode(i*10);
      } 
      
      //print out the list content
      System.out.print("\nMy test list values are:  ");
      myList.printList();
      System.out.println();    
   } 
}
    
