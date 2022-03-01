package bs;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


// Trevor Vollendorf and Alex Harker
class binarySearchTests {
	
	@Test
	void testPowerOfTwo() {
		powerOfTwoHelper(15);
		powerOfTwoHelper(16);
		powerOfTwoHelper(17);
	}
	
	void powerOfTwoHelper(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < length; i++) {
			assertEquals(bs.binarySearch(arr, i), i);
		}
	}
	
	@Test 
	void extremeLength() {
		powerOfTwoHelper(10000000);
	}
	
	@Test
	void incorrectSearch() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		assertEquals(bs.binarySearch(arr,-1), -1);
		int emptyArr[] = {};
		assertEquals(bs.binarySearch(emptyArr, 10), -1);
	}
	
	@Test
	void duplicateTests() {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			if(i < 8)
				arr[i] = -10;
			else
				arr[i] = i;
		}
		int index = bs.binarySearch(arr, -10);
		assertTrue(index >= 0 && index <= 7);
		assertEquals(bs.binarySearch(arr, 8), 8);
	}
	
	@Test
	void negativeValues() {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i - 50;
		}
		for (int i = 0; i < 10; i++) {
			assertEquals(bs.binarySearch(arr, i - 50), i);
		}
	}
	
	
	@Test
	void extremeValues() {
		int[] arr = {Integer.MIN_VALUE, Integer.MAX_VALUE};
		assertEquals(bs.binarySearch(arr, Integer.MIN_VALUE), 0);
		assertEquals(bs.binarySearch(arr, Integer.MAX_VALUE), 1);
		assertEquals(bs.binarySearch(arr, Integer.MAX_VALUE - 1), -1);
	}
	
	@Test
	void randomData() {
		int[] arr = new int[50000];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 200 - 100);
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int response = bs.binarySearch(arr, arr[i]);
			assertEquals(arr[i], arr[response]);
		}
	}

}
