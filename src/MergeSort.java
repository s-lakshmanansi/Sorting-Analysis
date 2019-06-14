
/**
 * This MergeSort class implements the ISorter interface. 
 * The sort method in this class uses merge sort to sort a given array.
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 * @see ISorter
 */
import java.util.Arrays;

public class MergeSort implements ISorter{

	/**
	 * Private String variable keeps track of the algorithm name
	 */
	private String algorithm;
	
	/**
	 * Private int variable keeps track of number of items in the array being sorted
	 */
	private int numItems;
	
	/**
	 * Private int variable keeps track of number of comparisons made by the sorter
	 */
	private int numComparisons;
	
	/**
	 * Private int variable keeps track of number of moves made by the sorter when sorting
	 */
	private int numMoves;
	
	/**
	 * public null constructor
	 */
	public MergeSort() {
		this.algorithm = "MergeSort";
	}
	
	/** 
	 * This method sorts a given array using merge sort and return the stats of that sort.
	 * 
	 * @param a A variable of type int array
	 * @return a new SortStats data type
	 * @see ISorter#sort(int[])
	 */
	public ISortStats sort(int[] a) {
		this.numComparisons = 0;
		this.numMoves = 0;
		this.numItems = a.length;
		long start = System.nanoTime();
		mergeSort(a);
		long end = System.nanoTime();
		return new SortStats(this.algorithm, this.numItems, this.numComparisons, this.numMoves, end - start);
	}
	
	
	/**
	 * This private method uses recursion to merge sort a given array
	 * 
	 * @param array A variable of type int array
	 */
	private void mergeSort(int[] array) {
		if (array.length > 1) {
			int[] left = Arrays.copyOfRange(array, 0, array.length/2);
			int[] right = Arrays.copyOfRange(array, array.length/2, array.length);
			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
		}
	}
	
	
	/**
	 * This private method merges two given arrays into the original array in sorted order
	 * 
	 * @param array A variable of type int array
	 * @param left A variable of type int array
	 * @param right A variable of type int array
	 */
	private void merge(int[] array, int[] left, int[] right) {
		int l = 0;
		int r = 0;
		for(int i = 0; i < array.length; i++) {
			if(r >= right.length) {
				array[i] = left[l++];
			}
			else if (l >= left.length) {
				array[i] = right[r++];
			}
			else if (right[r] >= left[l]) {
				array[i] = left[l++];
				this.numComparisons++;
			}
			else {
				array[i] = right[r++];
				this.numComparisons++;
			}
			this.numMoves++;
		}
	}

}
