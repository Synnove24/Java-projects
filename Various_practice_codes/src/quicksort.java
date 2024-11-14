import java.util.*;

public class quicksort { // start class

    public static int[] init(int n){ // start init
        int[] a = new int[n];
        Random b = new Random();
        for (int i = 0; i < n; i++) { // start for 
            a[i] = b.nextInt(11);
            
        } // end for
        return a;
    } // end init


    public static void quickSort(int arr[], int begin, int end)
    { // start quickSort
        if (begin < end) { // start if
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements of the 2 sub-arrays
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        } // end if
    } // end quickSort

    private static int partition(int arr[], int begin, int end)
    { // start partition
        int pivot = arr[end];
        int i = (begin-1);

        for (int j=begin; j<end; j++)
        {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    } // end partition 

        public static void main(String[] args) { // start main
        // take in an integer input from the user
        int n = Integer.parseInt(args[0]);
        int[]a = init(n);
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, (a.length-1));
        System.out.println(Arrays.toString(a));

    } // end main


} // end class