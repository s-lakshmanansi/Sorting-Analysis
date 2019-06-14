
/**
 * This Program class tests all of the sorting algorithms and displays the results using SortStats.
 * --The first set of tests test each sorting method against varying sizes of arrays.
 * --The second set of tests test each sorting method against varying orders of arrays size 4096.
 * <p>
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 * @see SortStats
 * 
 */
import java.util.*;

public class Program {
	
	/**
	 * This main method tests the sorting methods and prints out the stats to the console
	 * 
	 * @param args A string array containing the command line arguments.
	 */
	public static void main(String[] args) {
		Check check = new Check();
		ISorter[] sorters= {new BubbleSort(), new InsertionSort(), new SelectionSort(), new MergeSort()};
		String[] orders = {"Random", "Reverse", "Ordered"};
		System.out.println("Tests 1: Random Arrays of Various Lengths\n");
		for (int i = 2; i <= 4096; i+=i) {
			int[] a = testArray(orders[0], i);
			for (int j = 0; j < sorters.length; j++) {
				int[] a1 = Arrays.copyOf(a, a.length);
				ISortStats stats = sorters[j].sort(a1);
				if(check.isInOrder(a1)) {
					System.out.println(stats);
				}
			}
			System.out.println();
		}
		System.out.println("Tests 2: Different Orders of Arrays\n");
		for (int i = 0; i < orders.length; i++) {
			int[] a = testArray(orders[i], 4096);
			System.out.println(orders[i] + ':');
			for (int j = 0; j < sorters.length; j++) {
				int[] a1 = Arrays.copyOf(a, a.length);
				ISortStats stats = sorters[j].sort(a1);
				if(check.isInOrder(a1)) {
					System.out.println(stats);
				}
			}
			System.out.println();
		}
	}
	
	
	/**
	 * This method creates a test array based on the type ("Ordered", "Random", and "Reverse") and size
	 * 
	 * @param type A variable of type String representing type of order of the array:"Ordered", "Random", or "Reverse"
	 * @param size A variable of type int representing size of the array
	 * @return An int array data type
	 */
	public static int[] testArray(String type, int size) {
		Random rand = new Random();
		int[] array = new int [size];
		for(int i = 0; i < array.length; i++) {
			if(type.equals("Reverse")) {
				array[i] = size + 5 - i;
			}
			else {
				array[i] = i + 1;
			}
		}
		if(type.equals("Random")) {
			for (int i=0; i<array.length; i++) {
			    int space = rand.nextInt(array.length);
			    int temp = array[i];
			    array[i] = array[space];
			    array[space] = temp;
			}
		}
		return array;
	}
}
