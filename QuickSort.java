import java.util.Scanner;
public class QuickSort {
	/* An all static (no objects) version of quick sort.
	*/
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
   
   public static int partition(int numbers [], int start, int end) {
      int low = 0;
      int high = 0;
      int midpoint = 0;
     // int pivot = 0;
	  int pivot;
      int temp = 0;
      boolean done = false;


      /* Pick middle element as pivot */
      midpoint = start + (end - start) / 2;
      pivot = numbers[midpoint];
      tellUser("\tin partition() with start " + start + ", end " + end + ", pivot " + pivot);
	  
      low = start;
      high = end;

      while (!done) {

         /* Increment low while numbers[low] < pivot */
         while (numbers[low] < pivot) {
            ++low;
         }

         /* Decrement h while pivot < numbers[h] */
         while (pivot < numbers[high]) {
            --high;
         }

         /* If there are zero or one items remaining,
            all numbers are partitioned. Return h */
         if (low >= high) {
            done = true;
         } else {
            /* Swap numbers[low] and numbers[high],
               update low and high */
            temp = numbers[low];
            numbers[low] = numbers[high];
            numbers[high] = temp;

            ++low;
            --high;
         }
      }

	  tellUser("\treturning " + high + " from partition()");
	  displayArray(numbers);
      return high;
   }

   public static void quicksort(int numbers[], int start, int end) {
      int lowPartitionEnd = 0;

	  tellUser("in quicksort() with start " + start + ", end " + end);
      /* Base case: If there are 1 or zero entries to sort,
       partition is already sorted */
      if (start >= end) {
		 tellUser("-> leaving quicksort");
         return;
      }

      /* Partition the data within the array. Value j returned
         from partitioning is location of last item in low partition. */
      lowPartitionEnd = partition(numbers, start, end);

      /* Recursively sort low partition (start to lowPartitionEnd) and
         high partition (lowPartitionEnd + 1 to end) */
      quicksort(numbers, start, lowPartitionEnd);
      quicksort(numbers, lowPartitionEnd + 1, end);

      return;
   }

   public static void main(String [] args) {
      int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
      final int NUMBERS_SIZE = 8;
      int i = 0;

      System.out.print("UNSORTED: ");
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      /* Initial call to quicksort */
      quicksort(numbers, 0, NUMBERS_SIZE - 1);

      System.out.print("SORTED: ");
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      return;
   }
}