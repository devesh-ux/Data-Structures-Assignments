//package Mirrors;

import java.io.*;

import java.util.Scanner;
class InverseDoesNotExistException extends Exception
{
	public InverseDoesNotExistException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}
class SubBlockNotFoundException extends Exception
{
	public SubBlockNotFoundException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}
class IncompatibleDimensionException extends Exception
{
	public IncompatibleDimensionException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}


public class TwoDBlockMatrix{
	float[][] arr;
	
	public TwoDBlockMatrix(float[][] array) {
		 arr=new float[array.length][array[0].length];
		 for (int i = 0 ;i<array.length;i++) {
			 for (int j=0;j<array[0].length;j++) {
				 this.arr[i][j]= array[i][j];
			 }
		 }
		 }
	 static TwoDBlockMatrix buildTwoDBlockMatrix (java.io.InputStream in) {
	 Scanner x =new Scanner(in);	      
	 float [][] arr = new float[10][10];
	        int row = 0;
            int col = 0;
	
		 	while(x.hasNext()) {
		          String pe = x.nextLine();
		          int je = pe.length();
		          
		          while(pe.charAt(0)!= '#') {
		        	  String[] arr1 = pe.split(" ");
		        	  int i = Integer.parseInt(arr1[0]);
		        	  int j = Integer.parseInt(arr1[1]);
		        	  i = i-1;
		        	  
		        	  j = j-1;
		        	  
		        	  pe = x.nextLine();
		        	  je = pe.length();
		        	  while(pe.charAt(je-1)== ';') {		        		  
			        	  pe = pe.replace(";", "");
			    		  String[] arr2 = pe.split(" ");
			    		  int len1 = arr2.length;
			        	  int k=0;
			        	  int temp = j;
			        	  while (k <len1) {
			        		  
			        		  arr[i][temp] = Float.parseFloat(arr2[k]);
			        		  k++;
			        		  temp++;
			        		  if(temp>col) {
			        		  col= col+1;}
			        	  }
			        	  i++;
			        	  if(i>row) {
			        		  row= row+1;}
			        	  pe =  x.nextLine();
			        	  je = pe.length();}
		        	        
		        	  
		        		  }
		          
		         
		  	  
		      }
		 	
		 	float [][] arr6 = new float[row][col];
      	  for (int p = 0; p < row ; p++) {
      		  for (int q = 0;q<col;q++) {
      			  arr6[p][q] = arr[p][q];
      			  }
      	  }
      	  return new TwoDBlockMatrix(arr6);
		          				   
	 	 }
	 
	 
	 
	 
	 
	 static void getCofactor(float A[][], float temp[][], int p, int q, int n) 
	 { 
	     int i = 0, j = 0; 
	   
	     // Looping for each element of the matrix 
	     for (int row = 0; row < n; row++) 
	     { 
	         for (int col = 0; col < n; col++) 
	         { 
	             // Copying into temporary matrix only those element 
	             // which are not in given row and column 
	             if (row != p && col != q) 
	             { 
	                 temp[i][j++] = A[row][col]; 
	   
	                 // Row is filled, so increase row index and 
	                 // reset col index 
	                 if (j == n - 1) 
	                 { 
	                     j = 0; 
	                     i++; 
	                 } 
	             } 
	         } 
	     } 
	 } 
	   
	 /* Recursive function for finding determinant of matrix. 
	 n is current dimension of A[][]. */
	 static float determinant(float A[][], int n) 
	 { 
	     int D = 0; // Initialize result 
	   
	     // Base case : if matrix contains single element 
	     if (n == 1) 
	         return A[0][0]; 
	   
	     float [][]temp = new float[n-1][n-1]; // To store cofactors 
	   
	     int sign = 1; // To store sign multiplier 
	   
	     // Iterate for each element of first row 
	     for (int f = 0; f < n; f++) 
	     { 
	         // Getting Cofactor of A[0][f] 
	         getCofactor(A, temp, 0, f, n); 
	         D += sign * A[0][f] * determinant(temp, n - 1); 
	   
	         // terms are to be added with alternate sign 
	         sign = -1*sign; 
	     } 
	   
	     return D; 
	 } 
	   
	 // Function to get adjoint of A[N][N] in adj[N][N]. 
	 /*static void adjoint(int A[][],int [][]adj) 
	 { 
	     if (N == 1) 
	     { 
	         adj[0][0] = 1; 
	         return; 
	     } 
	   
	     // temp is used to store cofactors of A[][] 
	     int sign = 1; 
	     int [][]temp = new int[N][N]; 
	   
	     for (int i = 0; i < N; i++) 
	     { 
	         for (int j = 0; j < N; j++) 
	         { 
	             // Get cofactor of A[i][j] 
	             getCofactor(A, temp, i, j, N); 
	   
	             // sign of adj[j][i] positive if sum of row 
	             // and column indexes is even. 
	             sign = ((i + j) % 2 == 0)? 1: -1; 
	   
	             // Interchanging rows and columns to get the 
	             // transpose of the cofactor matrix 
	             adj[j][i] = (sign)*(determinant(temp, N-1)); 
	         } 
	     } 
	 }*/ 
	   
	 // Function to calculate and store inverse, returns false if 
	 // matrix is singular 
	 /*static boolean inverse(int A[][], float [][]inverse) 
	 { 
	     // Find determinant of A[][] 
	     int det = determinant(A, N); 
	     if (det == 0) 
	     { 
	         System.out.print("Singular matrix, can't find its inverse"); 
	         return false; 
	     } 
	   
	     // Find adjoint 
	     int [][]adj = new int[N][N]; 
	     adjoint(A, adj); 
	   
	     // Find Inverse using formula "inverse(A) = adj(A)/det(A)" 
	     for (int i = 0; i < N; i++) 
	         for (int j = 0; j < N; j++) 
	             inverse[i][j] = adj[i][j]/(float)det; 
	   
	     return true; 
	 }*/ 
	   

	
	

  
       
       public TwoDBlockMatrix transpose() {
    	   
    	   float [][] arr2 = new float[arr[0].length][arr.length];
    	   for (int i =0; i <arr.length ; i++) {
    			  for (int j = 0;j<arr[0].length;j++) {
    				  arr2[j][i]= arr[i][j];
    				  
    			  }
    			 
    		  }
    	   TwoDBlockMatrix obj= new TwoDBlockMatrix(arr2);
			 return obj;
    		
       }
       public  TwoDBlockMatrix multiply(TwoDBlockMatrix other) throws IncompatibleDimensionException {
    	   if (arr[0].length!=other.arr.length) {
    			throw new IncompatibleDimensionException("Multiply dont exist");

    	   }
    	   else {

    	    float [][] arr4 = new float[arr.length][other.arr[0].length];
    	    if(arr[0].length != other.arr.length) {
    	    	System.out.println("exception");
    	    }
    	    else {
    	    for(int i =0;i<arr.length;i++) {
    	    	for(int j = 0;j<other.arr[0].length;j++) {
    	    		for (int k = 0;k<arr[0].length;k++) {
    	    			arr4[i][j] +=  arr[i][k]*other.arr[k][j];
    	    			
    	    		}
    	    	}
    	    	
    	    }
    	    }
    	    TwoDBlockMatrix obj= new TwoDBlockMatrix(arr4);
			 return obj;
    	   }
    	   
    	   
       }
       
       
       public TwoDBlockMatrix inverse() throws InverseDoesNotExistException{
    	   if (arr.length!=arr[0].length || determinant(arr,arr.length)==0) {
    			throw new InverseDoesNotExistException("Inverse dont exist");

    	   }
    	   else {
    		   float[][] arr10=new float[arr.length][arr.length];
    		   return new TwoDBlockMatrix(arr10);
    	   }
       }
       
       
    	
     public  TwoDBlockMatrix getSubBlock (int row_start, int col_start, int row_end, int col_end) throws SubBlockNotFoundException {
    	 if (row_end>arr.length+1||col_start>arr[0].length+1||row_start>arr.length||col_start>arr[0].length) {
    			throw new SubBlockNotFoundException("SubBlock dont exist");

    	 }
    	 else {
    	 float [][] arr5 = new float[row_end-row_start][col_end-col_start];
    	         int row1= 0;
    	         int col1= 0;
    	 for (int m =row_start-1 ;m<row_end-1;m++)
    	 {      
    	 
    		 for(int n =col_start-1 ;n<col_end-1;n++)
    		 {

    			 arr5[row1][col1]= arr[m][n];
       			 col1 = col1+1;
    		 }
    		 col1=0;
    		 row1= row1+1;
    		  }

//    	              float [][] arr7 = new float[row1][col1];
//    	              for(int k= 0; k<row1-1;k++) 
//        	                   {
//        		 for(int l = 0; l<col1-1;l++)
//        			        {
//        			 arr7[k][l]= arr5[k][l];
//        			 
//        		 }
//        		 
//        	 }
    	              
    	           //   float [][] arr7 = new float[row1][col1];
    	              
    	 TwoDBlockMatrix obj= new TwoDBlockMatrix(arr5);
		 return obj;
    	 }
	   
    	
    	 
     }
    /* public static void main(String[] args) throws FileNotFoundException, SubBlockNotFoundException, IncompatibleDimensionException {
    	 FileInputStream fstream = new FileInputStream("assignment.txt");
    	 TwoDBlockMatrix obj;
    	 obj=buildTwoDBlockMatrix(fstream);
    	 for (int i = 0;i<obj.arr.length;i++) {
    		 for (int j = 0;j<obj.arr[i].length;j++) {
    			 System.out.print(obj.arr[i][j]+" ");
    		 }
    		 System.out.println();
    	 }
    	 System.out.println();
    	 TwoDBlockMatrix objt;
    	 objt=obj.transpose();
    	 for (int i = 0;i<objt.arr.length;i++) {
    		 for (int j = 0;j<objt.arr[i].length;j++) {
    			 System.out.print(objt.arr[i][j]+" ");
    		 }
    		 System.out.println();
    	 }
    	 System.out.println();
    	 TwoDBlockMatrix ojk;
    	 ojk=objt.multiply(obj);
    	 for (int i = 0;i<ojk.arr.length;i++) {
    		 for (int j = 0;j<ojk.arr[i].length;j++) {
    			 System.out.print(ojk.arr[i][j]+" ");
    		 }
    		 System.out.println();
    	 }
    	 System.out.println();
    	 TwoDBlockMatrix okl;
    	 okl=obj.getSubBlock(1,1,2,2);
    	 for (int i = 0;i<okl.arr.length;i++) {
    		 for (int j = 0;j<okl.arr[i].length;j++) {
    			 System.out.print(okl.arr[i][j]+" ");
    		 }
    		 System.out.println();
    	 }
    	 System.out.println();
    	 //TwoDBlockMatrix ogl;
    	 
    	String str1 = obj.toString();
    	System.out.println(str1);
    	
     }*/

	public String toString(){
		String w = null;
		float[][] temp = this.arr;
		for(int i=0;i<temp.length; i++){
			int j=0;
			while(j <temp[0].length){
				if(temp[i][j] == 0)
					j++;
				else{
					int start_row = i;
					int end_row = i;
					int start_col = j;
					int end_col = j;
					while(end_col+1 < temp[0].length){
						if(temp[start_row][end_col+1] != 0)
								end_col++;
						else 
							break;
					}
					
					while(end_row+1 < temp.length){
						int y = 0;
						for(int r = start_col; r<= end_col;r++) {
							if(temp[end_row +1][r] != 0)
								y++;
						}
						if(y == (end_col - start_col +1))
							end_row++;
						else
							break;
					}
					if(w == null)
						w =(start_row+1) + " " + (start_col+1) + "\n";
					else
						w =  w + (start_row+1) + " " + (start_col+1) + "\n";
					for(int l = start_row ; l <= end_row ; l++) {
						for(int h = start_col; h < end_col; h++) {
							w = w + temp[l][h] + " ";
						}
						w = w + temp[l][end_col] +";" +"\n";
					}
					w = w +"#" +"\n";
					for(int m = start_row; m<= end_row; m++) {
						for(int n = start_col; n <= end_col; n++) {
							temp[m][n] = 0;
						}
					}
				}
			}
		}
		return w;
	}
	
	}







    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    






