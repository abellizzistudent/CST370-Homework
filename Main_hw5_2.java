
/*
 * Title: Main_hw5_2.java
 * Abstract: Display the performance of two different sorting algorithms (merge sort and quick sort)
MergeSort written by and found at  https://www.geeksforgeeks.org/merge-sort/
QuickSort written and found at https://www.geeksforgeeks.org/java-program-for-quicksort/
 * Name:Anna Bellizzi
 * Date:12/6/2022
 */
import java.util.*;

class Main 
{
     /////////////////////// MERGESORT /////////////////////////// 
//   https://www.geeksforgeeks.org/merge-sort/              //
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 /////////////////////// QUICKSORT /////////////////////////// 
//https://www.geeksforgeeks.org/java-program-for-quicksort/ //
    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
  
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // get number of elements that the user will enter on the next line
        int n = input.nextInt();
        input.close();
      
        int array[] = new int[n];
        int dupArray[] = new int[n];
      
        Random rand = new Random();
      
        for (int i = 0 ; i < n; i++ )
        {
            array[i] = rand.nextInt();
            dupArray[i] = array[i];
        }
        //System.out.println("original array1: " + Arrays.toString(array));
        //System.out.println("original array2: " + Arrays.toString(dupArray)); 
        
        System.out.println("===================== Execution Time ====================");
        //capture start time
        long start = System.currentTimeMillis();
        
      //System.out.println("start: " + System.currentTimeMillis());
        
      //MergeSort the array
        mergeSort(array, 0, array.length - 1);
        //capture end time
        long end = System.currentTimeMillis();
        
      //System.out.println("end: " + System.currentTimeMillis());
      
        //double difference = (end-start)/1000;
        //print result
        //String mSort = String.format("Merge sort:   %.6f", number / 1000.0);
        System.out.println("Merge sort:   " + (end - start) + " milliseconds");
        //System.out.println("Merge sort:   " + (end - start) + " milliseconds");
        //System.out.println("Sorted array1: " + Arrays.toString(array));
        //System.out.println("Unsorted array2 : " + Arrays.toString(dupArray));

        
        long start2 = System.currentTimeMillis();
        //MergeSort the array
        quickSort(dupArray, 0, dupArray.length - 1);
        //capture end time
        long end2 = System.currentTimeMillis();
        //print result
        //number = end - start;
        //String qSort = String.format("Quick sort:   %.6f", number / 1000.0);
        //System.out.println(qSort + " milliseconds"); */
        System.out.println("Quick sort:   " + (end2 - start2) + " milliseconds");
        //System.out.println("Quick sort:   " + (end - start) + " milliseconds");
        //System.out.println("array2 sorted : " + Arrays.toString(dupArray));
        System.out.println("=========================================================");
    }
}

