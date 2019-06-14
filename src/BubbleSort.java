
/**
 * This BubbleSort class implements the ISorter interface. 
 * The sort method in this class uses bubble sort to sort a given array.
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 * @see ISorter
 */
public class BubbleSort implements ISorter{
	
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
	public BubbleSort() {
		this.algorithm = "BubbleSort";
	}
	

	
	/** 
	 * This method sorts a given array using bubble sort and return the stats of that sort.
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
		int swaps = -1;
		while (swaps != 0) {
			swaps = 0;
			int j = a.length-1;
			for(int i = 0; i < j; i++) {
				this.numComparisons++;
				if(a[i] > a[i+1]) {
					swap(a, i, i+1);
					swaps++;
				}
			}
			j--;
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
