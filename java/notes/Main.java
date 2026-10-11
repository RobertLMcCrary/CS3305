public class Main {
    // low is first, last element is high
    // create i, j, and pivot
    // select pivot (easier to just select last element, if select a middle index
    // then just swap middle index with the last element and run the algorithm)
    //
    // j checks each number, advances forward regardless
    // i marks the position where the next number smaller than the pivot should go
    //
    // 1. i and j both start at the beginning of the list
    // 2. is j < pivot, yes: swap i and j then advance i and j, no: just advance j
    //
    // do this until all elements to the left of pivot are checked
    // then swap pivot and i
    //
    // now pivot is in its sorted correct spot
    //
    // now partition is complete, you have elements to the left of pivot and elemnts
    // to the right
    // now recursively run algorithm on left partition and right partition
    static void quickSort(int[] nums, int low, int high) {
    }

    static void mergeSort(int[] nums) {
    }

    static void bucketSort(int[] nums) {
    }

    public static void main(String[] args) {
        int[] nums = { 34, 12, 4, 56, 78, 45, 23, 89, 4 };
        int[] nums2 = { 8, 3, 7, 4, 2, 6, 5, 1 };
    }
}
