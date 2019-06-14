
/**
 * This SortStats class implements the ISortStats interface. 
 * This class sorts all the statistics given.
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 * @see ISortStats
 */
public class SortStats implements ISortStats{
	/**
	 * Private String variable keeps track of the algorithm name
	 */
	private String algorithm;
	
	/**
	 * Private int variable keeps track of number of items in the array being sorted
	 */
	private int items;
	
	/**
	 * Private int variable keeps track of number of comparisons made by the sorter
	 */
	private int comparisons;
	
	/**
	 * Private int variable keeps track of number of moves made by the sorter when sorting
	 */
	private int moves;
	
	/**
	 * Private long variable that stores the amount of time int nanoseconds taken for the sorting method
	 */
	private long time = 0;
	
	
	/**
	 * This constructor requires all of the inputs and stores them as private fields
	 * 
	 * @param a A variable of String type representing the algorithm name
	 * @param i A variable of int type representing the number of items
	 * @param c A variable of int type representing the number of comparisons
	 * @param m A variable of int type representing the number of moves
	 * @param t A variable of long type representing the number of time in nanoseconds
	 */
	public SortStats(String a, int i, int c, int m, long t) {
		this.algorithm = a;
		this.items = i;
		this.comparisons = c;
		this.moves = m;
		this.time = t;
	}
	
	
	/**
	 * This method returns the algorithm type
	 * 
	 * @return A String data type
	 * @see ISortStats#getAlgorithm()
	 */
	public String getAlgorithm() {
		return this.algorithm;
	}
	
	/**
	 * This method returns the number of items
	 * 
	 * @return items An int data type
	 * @see ISortStats#getNumItems()
	 */
	public int getNumItems() {
		return this.items;
	}

	/**
	 * This method returns the number of comparisons
	 * 
	 * @return An int data type
	 * @see ISortStats#getNumComparisons()
	 */
	public int getNumComparisons() {
		return this.comparisons;
	}

	/**
	 * This method returns the number of moves
	 * 
	 * @return An int data type
	 * @see ISortStats#getNumMoves()
	 */
	public int getNumMoves() {
		return this.moves;
	}

	/**
	 * This method returns the amount of time in nanoseconds
	 * 
	 * @return An long data type
	 * @see ISortStats#getNumNanoseconds()
	 */
	public long getNumNanoseconds() {
		return this.time;
	}
	
	
	/**
	 * This method overrides the toString method and returns the stats formatted neatly 
	 * 
	 * @return A String data type
	 */
	public String toString() {
		return "Algorithm\t: " + this.algorithm + 
				"\nNumItems\t: " + this.items +
				"\nNumComparisons\t: " + this.comparisons +
				"\nNumMoves\t: " + this.moves + 
				"\nNumNanoseconds\t: " + this.time;
	}

}
