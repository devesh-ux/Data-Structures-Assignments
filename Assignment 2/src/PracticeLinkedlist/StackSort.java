package PracticeLinkedlist;



class StackSort {
	//int[] ar1 = new int[1024];
	
	
	String[] ar3 = new String[1];
	 MyStack<Integer> p = new MyStack<Integer>();
	 int[] ar4 = new int[1024];
	 StackSort(){
		 
	 }
	 String[] sort(int[] ar1) throws EmptyStackException {
		 String[] ar2 = new String[2*ar1.length];
	 
	 int c = 0;
	 
	  p.push(ar1[0]);
	 ar2[c]= "PUSH";
	 c++;
	
	 int d =0 ;
	 for(int q = 1;q<ar1.length;q++) {
		 if(p.top()<ar1[q]) {
			 
			 ar4[d]= p.pop();
			 d++;
			 ar2[c]= "POP";
			 c++;
			 while(!p.isEmpty())
			 {if(p.top()<ar1[q]) {
				 ar4[d]= p.pop();
				 d++;
				 ar2[c]= "POP";
				 c++; 
			 }
			 else break;
			 }
			 p.push(ar1[q]);
			 ar2[c]= "PUSH";
			 c++;
			 
	 }
		 else {
			 if (p.top()>=ar1[q]) {
				p.push(ar1[q]);
				 ar2[c]= "PUSH";
				 c++;
				
			 }
		 }
		 
		 
		 
	 }
	 while (!p.isEmpty()) {
		 ar4[d]= p.pop();
		 d++;
		 ar2[c]= "POP";
		 c++;
     }
	 for(int x=0;x<d-1;x++) {
		 if(ar4[x]>ar4[x+1]) {
			 ar3[0] = "NOTPOSSIBLE";
			//System.out.println(ar3[0]);
			 return ar3;
		 }
		 
	 }
//	 for(int y =0 ;y<ar2.length;y++) {
//			System.out.print(ar2[y]+ " ");
//		} 
	 
	 return(ar2);
	
}
	/* public static void main(String[] args) throws EmptyStackException {
		int[] arr6 = new int[] {4,6,2};
		 StackSort obj = new StackSort();
		 obj.sort(arr6);
	 }
//	private void sort(int i, int j, int k, int l, int m) {
//		// TODO Auto-generated method stub
//		
//	}*/

}



