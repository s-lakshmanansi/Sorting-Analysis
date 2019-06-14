
/**
 * This InsertionSort class implements the ISorter interface. 
 * The sort method in this class uses insertion sort to sort a given array.
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 * @see ISorter
 */
public class InsertionSort implements ISorter{

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
	public InsertionSort() {
		this.algorithm = "InsertionSort";
	}
	
	/** 
	 * This method sorts a given array using insertion sort and return the stats of that sort.
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
		for(int i = 1; i < a.length; i++) {
        	int j = i - 1;
        	this.numComparisons++;
        	while(j >=0 && a[i] < a[j]) {
        		this.numComparisons++;
        		j--;
        	}
        	if(j != i - 1) {
        		removeAdd(a, i, j + 1);
        	}
        }
		long end = System.nanoTime();
		return new SortStats(this.algorithm, this.numItems, this.numComparisons, this.numMoves, end - start);
	}
	
	/**
	 * This private method moves and inserts a value from one index to another
	 * @param array A variable of type int array
	 * @param remove A variable of type int representing value to be removed
	 * @param add A variable of type int representing index where it should be added
	 * @exception IllegalArgumentException if indexes are out of range
	 */
	public void removeAdd(int[]array, int remove, int add) {
		if(remove < 0 || remove >= array.length || add < 0 || add >= array.length) {
			throw new IllegalArgumentException("indexes out of range");
		}
		int key = array[remove];
		this.numMoves++;
		for(int i = remove; i < array.length - 1; i++) {
			array[i] = array[i+1];
			this.numMoves++;
		}
		for(int i = array.length - 1; i > add; i--) {
			array[i] = array[i-1];
			this.numMoves++;
		}
		array[add] = key;
		this.numMoves++;
	}
}


