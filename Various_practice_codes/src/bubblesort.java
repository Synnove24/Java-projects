import java.util.Arrays;
import java.util.Random;

public class bubblesort {

	public static int[] array1;
	/*
	 * Function that puts random integers between 1 - 10 into the array <p>
	 * 
	 * @param: int, size of the array
	 * 
	 * @return: int[], an array with random integers between 1 - 10 in each element
	 */
	public static void initialization(int size) {
		Random b = new Random();
		array1 = new int[size];
		for (int i = 0; i < size; i++) {
			array1[i] = b.nextInt(2);
		}
	}

	/*
	 * This function takes in an array and swaps two integers <p>
	 * 
	 * @param: int[], an array waiting to be swapped
	 * 
	 * @param: int i, first integer to be swapped
	 * 
	 * @param: int j, second integer to be swapped
	 * 
	 * @return: int[], an array with i and j integers swapped
	 */
	public static void swap( int i, int j) {
		int temp; // temp variable to remember
		temp = array1[j];
		array1[j] = array1[i];
		array1[i] = temp;
	}

	/*
	 * This function takes in a unsorted array and perform bubbleSort on the array
	 * <p>
	 * 
	 * @param: int[], an unsorted array
	 * 
	 * @return: int[], a sorted array, sorted using bubble sort.
	 */
	public static void bubbleSort() {
		boolean flag = true;

		while (flag == true) { // start big while
			flag = false;
			for (int i = 0; i < array1.length - 1; i++) { // start for
					if (array1[i] > array1[i + 1]) {// start if
					swap(i, i + 1);
					flag = true;
				} // end if
			} // end for
		} // end big while
	}

	public static void main(String[] args) {
		int userInput = 30;
		initialization(userInput);
		// print out a before array
		System.out.println(Arrays.toString(array1));
		bubbleSort();
		System.out.println(Arrays.toString(array1));
	}
}