import java.util.Scanner;

/* An all static (no objects) version of merge sort
*/

public class MergeSort {
	
   public final static boolean TRACE = true;
	
   public static void tellUser(String message) {
      Scanner sc = new Scanner(System.in);
      String userInput;
      if (TRACE) {
	     System.out.println(message);
	     userInput = sc.nextLine();
	  }
   }
   
   public static void displayArray(int a[]) {
		if (TRACE) {
			for (int i=0; i < a.length; i++)
				System.out.print(a[i] + " ");
		}
		System.out.println();
	}
   
   public static void merge(int numbers [], int start, int midpoint, int end) {
      int mergedSize = end - start + 1;       // Size of merged partition
      int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
      int mergePos = 0;                 // Position to insert merged number
      int leftPos = 0;                  // Position of elements in left partition
      int rightPos = 0;                 // Position of elements in right partition

      leftPos = start;                      // Initialize left partition position
      rightPos = midpoint + 1;                 // Initialize right partition position
	  
	  tellUser("\tin merge with start " + start + ", midpoint " + midpoint + ", end "+ end);

      // Add smallest element from left or right partition to merged numbers
      while (leftPos <= midpoint && rightPos <= end) {
         if (numbers[leftPos] < numbers[rightPos]) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
         } 
         else {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
         }
         ++mergePos;
      }

      // If left partition is not empty, add remaining elements to merged numbers
      while (leftPos <= midpoint) {
         mergedNumbers[mergePos] = numbers[leftPos];
         ++leftPos;
         ++mergePos;
      }

      // If right partition is not empty, add remaining elements to merged numbers
      while (rightPos <= end) {
         mergedNumbers[mergePos] = numbers[rightPos];
         ++rightPos;
         ++mergePos;
      }

      // Copy merge number back to numbers
      for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
         numbers[start + mergePos] = mergedNumbers[mergePos];
      }
	  
   tellUser("\treturning from merge, array is: ");
   displayArray(numbers);
   }


   public static void mergeSort(int numbers [], int start, int end) {
	  tellUser("in mergeSort with start: " + start + ", end " + end);
	   
      // int midpoint = 0;
	  int midpoint;

      if (start < end) {
         midpoint = (start + end) / 2;  // Find the midpoint in the partition

         // Recursively sort left and right partitions
         mergeSort(numbers, start, midpoint);
		 tellUser("finished the first recursive mergeSort()");
         mergeSort(numbers, midpoint + 1, end);
		 tellUser("finished the second recursive mergeSort()");

         // Merge left and right partition in sorted order
         merge(numbers, start, midpoint, end);
      }
   }

   public static void main(String [] args) {
      int numbers [] = {85, 24, 63, 45, 17, 31, 96, 50};
      int i = 0;

      System.out.print("UNSORTED: ");
	  displayArray(numbers);

      /* initial call to quicksort with index */
      mergeSort(numbers, 0, numbers.length - 1);

      System.out.print("SORTED: ");
      displayArray(numbers);

      return;
   }
}