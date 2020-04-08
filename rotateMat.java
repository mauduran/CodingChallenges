import java.util.function.Function;

public class rotateMat {
	
	static void printMat(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.printf("%d\t", mat[i][j]);
			}
			System.out.println();
		}
	}
	
	static void rotateSegment(int mat[][], int i, int j, int value, int iteration) {
		
		if(iteration>3) return;
		if(iteration==0) value = mat[i][j];
		
		int n = mat.length;
		
		int temp = mat[j][n-1-i];
		
		mat[j][n-1-i] = value;
		
		rotateSegment(mat, j, n-1-i, temp, iteration+1);
	}
	
	
	static void rotateBox(int mat[][]) {
		int t =  mat.length/2;
		for(int i = 0; i< t; i++) {
			for(int j = i; j<mat.length-1-i;j++){
				rotateSegment(mat, i, j, -1, 0);
			}
	
			// System.out.println(i);
//			System.out.printf("\n\n\n");
		}
	}
	
	public static void main(String[] args) {
	
		int n = 5;
		
		int mat[][] = new int[n][n];
		
		int count = 1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = count;
				count++;
			}
		}
		
		// printMat(mat);
		
		rotateBox(mat);
		rotateBox(mat);
		rotateBox(mat);
		rotateBox(mat);
		
//		rotateSegment(mat, 1, 1, -1, 0);
		System.out.printf("\n \n");
		
		Function<Integer,Integer> incrementByOne = number -> number+1;

		System.out.println(incrementByOne.apply(2));


		// printMat(mat);

	}

}
