package leetcode.ch;

public class RotateMatrix {
	
	 public void rotate(int[][] matrix) {
	     
		 int n = matrix.length;
		 
		 int curI = 0;
		 int curJ = 0;
		 int tmp = 0;
		 int[] values = new int[4];
		 
		 int minI = (n%2==0)? n/2 -1 : n/2;
		 int minJ = (n%2==0) ? n/2 - 1 : n/2 -1;
		 
		 for (int i=0; i<= minI; i++) {
			 for (int j=0; j<= minJ; j++) {
				
				 curI = i;
				 curJ = j;
				 values[0] = matrix[curI][curJ];
				 
				 tmp = curI;
				 curI = curJ;
				 curJ = (n-1) - tmp;
				 
				 values[1] = matrix[curI][curJ];
				 matrix[curI][curJ] = values[0];
				 
				 tmp = curI;
				 curI = curJ;
				 curJ = (n-1) - tmp;
				 
				 values[2] = matrix[curI][curJ];
				 matrix[curI][curJ] = values[1];
				 
				 tmp = curI;
				 curI = curJ;
				 curJ = (n-1) - tmp;
				 
				 values[3] = matrix[curI][curJ];
				 matrix[curI][curJ] = values[2];
				 
				 matrix[i][j] = values[3];
				 
 				 
			 }
		 }
	        
	 }
	
	 

	 

}
