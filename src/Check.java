
/**
 * This Check class contains one method that checks if an array is already sorted 
 * Created for APCS P.5 Mr.Peterson
 *
 * @author Sidharth Lakshmanan
 */
public class Check {
	
	/**
	 * public null constructor
	 */
	public Check() {
	}
	
	
	/**
	 * @param a A variable of type int array
	 * @return A boolean data type
	 */
	public boolean isInOrder(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i+1]) {
				return false;
			}
		}
		return true;
	}
}
