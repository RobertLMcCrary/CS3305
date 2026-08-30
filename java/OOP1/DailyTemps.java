// Name: Robert McCrary
// Class: CS3305 - Data Structures
// Term: Fall 2026
// Instrctor: Umama Tasnim 
// Assignment: 1
// IDE Name: Neovim

public class DailyTemps {
    private double[] TempList = new double[7];
    private static final String[] DAY_NAMES = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    DailyTemps(double mon, double tues, double wed, double thurs, double fri, double sat, double sun) {
        this.TempList[0] = mon;
        this.TempList[1] = tues;
        this.TempList[2] = wed;
        this.TempList[3] = thurs;
        this.TempList[4] = fri;
        this.TempList[5] = sat;
        this.TempList[6] = sun;
    }

    /*
     * second parameter is a newTemp double
     *
     * first param can either be an index or a name
     * 
     * passing in an index is faster
     * 
     * passing in a string is more readable
     * but involves mapping the string to
     * the corresponding day of the week
     */
    public void setTemp(int dayIndex, double newTemp) {
        // check if index is out of bounds
        // just concatenating here becasue only working with one var
        if (dayIndex < 0 || dayIndex > 0) {
            throw new IndexOutOfBoundsException("Index of day must be 0-6, got: " + dayIndex);
        }

        this.TempList[dayIndex] = newTemp;
    }

    public int Freezing() {
        int count = 0;

        for (int i = 0; i < this.TempList.length; i++) {
            if (TempList[i] < 32) {
                count++;
            }
        }

        return count;
    }

    /*
     * have to run a linear search because
     * we need the day and the value, can't just get the
     * max value here
     */
    public String Warmest() {
        int maxIndex = 0;

        for (int i = 0; i < this.TempList.length; i++) {
            if (TempList[i] > maxIndex) {
                maxIndex = i;
            }
        }

        return DAY_NAMES[maxIndex];
    }

    public void printTemps() {
        for (int i = 0; i < this.TempList.length; i++) {
            // concatenating again here because only working with 2 values
            System.out.println(DAY_NAMES[i] + "\t" + this.TempList[i]);
        }
    }
}
