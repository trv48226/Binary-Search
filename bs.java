package bs;
/**
 * @author Trevor Vollendorf and Alex Harker
 **/
public class bs {
	public static int binarySearch(int[] array, int target) {
		int max = array.length;
		int min = 0;
		int mid = (max - min)/2 + min;
		if (array.length == 0) {
			return -1;
		}
		while (array[mid] != target) {
			mid = (max - min)/2 + min;
			if (array[mid] == target) {
				return mid;
			}
			if (max <= min) {
				return -1;
			}
			if (array[mid] > target) {
				max = mid;
				continue;	
			}
			if (array[mid] < target) {
				min = mid;
				continue;	
			}
		}
		return mid;
	}
}
