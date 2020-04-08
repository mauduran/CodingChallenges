
import java.util.Arrays;

public class productArray {
	//
	public static int[] genProductArray(int [] myArray) {
		int [] products = new int[myArray.length];
		
		
		int product = 1;
		
		for (int i = 0; i < myArray.length; i++) {
			product *= myArray[i];
		}
		
		for (int i = 0; i < products.length; i++) {
			products[i] = product / myArray[i];
		}
		
		
		//{1, 2, 3, 4, 5}
		
		
		// {1, 1, 2, 6, 24}
		
		// {120, 60, 20, 5, 1}
		
		
		
		return products;
		
	}
	
	public static int [] genProductArrayNoDiv(int [] myArray) {
		int[] left = new int[myArray.length];
		int[] right = new int[myArray.length];
		int[] newArray = new int[myArray.length];
		
		for (int i = 0; i < myArray.length; i++) {
			if(i==0) {
				left[i] = 1;
				right[newArray.length-1-i] = 1;
			} else {
				left[i] = left[i-1]*myArray[i-1];
				right[newArray.length-1-i] = right[newArray.length-i]* myArray[newArray.length-i] ;
			}
		}
		
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = left[i] * right[i];
		}
		
		return newArray;
	}
	
	public static void main(String[] args) {
		int [] myArray = {1, 2, 3, 4, 5};
		int [] products = genProductArrayNoDiv(myArray);
		
		System.out.println(Arrays.toString(products));
		
		products = genProductArray(myArray);
		System.out.println(Arrays.toString(products));
		
	}
}
