
/**
 * This SelectionSort class implements the ISorter interface. 
 * The sort method in this class uses selection sort to sort a given array.
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 * @see ISorter
 */
public class SelectionSort implements ISorter{

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
	public SelectionSort() {
		this.algorithm = "SelectionSort";
	}
	
	/** 
	 * This method sorts a given array using selection sort and return the stats of that sort.
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
		for(int i = 0; i < a.length; i++) {	
			int min = a[i];
			int index = i;
			for(int j = i; j < a.length; j++) {
				this.numComparisons++;
				if(a[j] < min) {
					min = a[j];
					index = j;
				}
			}
			swap(a, i, index);
		}
		long end = System.nanoTime();
		return new SortStats(this.algorithm, this.numItems, this.numComparisons, this.numMoves, end - start);
	}
	
	/**
	 * This private method swaps two given indexes of an array
	 * @param array A variable of type int array
	 * @param a A variable of type int representing first index
	 * @param b A variable of type int representing second index
	 * @exception IllegalArgumentException if swapping indexes are out of range
	 */
	private void swap(int[] array, int a, int b) {
		if(a < 0 || b < 0 || a >= array.length || b >= array.length) {
			throw new IllegalArgumentException("swapping index out of range");
		}
		if(a != b) {
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
			this.numMoves += 3;
		}
	}

}

