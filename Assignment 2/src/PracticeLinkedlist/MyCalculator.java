
class MyCalculator {
	//private Object infixtopost;

    MyCalculator() {
		// return null;
		
	}
	
	 String[] infix(String expression) {
		 String st1 = expression;
		 st1 = st1.replace(" ","");
		//System.out.println(st1);
		 String[] arr1 = new String[st1.length()];
		 for(int k=0;k<arr1.length;k++) 
			 arr1[k]="";
		 int i = 0;
		  int j=0 ;
		 while(i < st1.length()) {
			  char c=st1.charAt(i);
			 if(c=='('||c==')'||c=='*'||c=='+'||c=='-') {
				    arr1[j]+=c;
					 j++;
					 i++;
				}
			 else {
				 while (c!='('||c!=')'||c!='*'||c!='+'||c!='-') {
					 arr1[j]+=c;
					 i++;
					 if(i<st1.length()) {
						 c=st1.charAt(i);
						 if(c=='('||c==')'||c=='*'||c=='+'||c=='-') {
							 j++;
							 break;
						 }
					 }
					 else break;
					 
				 }
			}
		 }	 
					 
//					 st3 = st3 + st2 ;
//					 //k++;
//				 i++;
//				 st2.equals(st1.charAt(i));
//				 arr1[j]= st3;
//				
//				 if (st2.equals("(")||st2.equals(")")||st2.equals("*")||st2.equals("+")||st2.equals("-")) {
//					 j++;
//				 }
//				 }
	 
		
		 for(int o = 0 ;o<arr1.length;o++) {
			 System.out.print(arr1[o]+" ");
		 }
		 System.out.println();
		 return arr1 ;
		 
		
	 }
	
	 String[] infixtopost(String[] arr1) throws EmptyStackException {
		 String[] arr2 = new String[arr1.length];
		 MyStack<String> d = new MyStack<String>();
		 int j =0 ;
		 int w=0;
		 for(int k=0;k<arr1.length;k++) {
			
			 
			 if (!(arr1[k].equals("(")||arr1[k].equals(")")||arr1[k].equals("*")||arr1[k].equals("+")||arr1[k].equals("-"))) {
				 arr2[j]= arr1[k];
				 
				//System.out.println("1+2");
				 j++;
			 }
			 else if(arr1[k].equals("(")){
				 w++;
				 d.push(arr1[k]);
			 }
			 else if(arr1[k].equals(")")) {
				 w++;
				 while(!d.top().equals("(")) {
					 arr2[j] = d.pop();
					 j++;
					 
				 }
				 d.pop();
			 }
			 else if(arr1[k].equals("*")) {
				 if(d.isEmpty()) {
					 d.push(arr1[k]);
	//				 System.out.print(d.pop());	
				 }
				 else if (d.top().equals("(")||d.top().equals("+")||d.top().equals("-")) {
					 d.push(arr1[k]);
				 }
				 else  {
				 if(d.top().equals("*")) {
					 arr2[j]= d.pop();
					 j++;
					 d.push(arr1[k]);
				 }
				 }
			 }
			 else if(arr1[k].equals("+")) {
				 if(d.isEmpty()) {
					 d.push(arr1[k]);
				 }
				 else if(d.top().equals("(")) {
					 d.push(arr1[k]);
				 }
				 else {
				 if (d.top().equals("*")||d.top().equals("-")||d.top().equals("+")) {
					 arr2[j]= d.pop();
					 
					 j++;
					
				 }
				 d.push(arr1[k]);
				// System.out.print(d.pop());
				 }
			 }
			 else if(arr1[k].equals("-")) {
				 if(d.top().equals("(")) {
					 d.push(arr1[k]);
				 }
				 else {
				 if (d.top().equals("*")||d.top().equals("+")||d.top().equals("-")) {
					 arr2[j]= d.pop();
					 j++;
					 
				 }
				 d.push(arr1[k]);
				 }
				 
			 }
          }
		 while(!d.isEmpty()) {
			 arr2[j]=d.pop();
			 j++;
	 }
		String[] arr8=new String[arr2.length-w-1]; 
			 for(int o = 0 ;o<(arr2.length-w-1);o++) {
				 if (arr2[o].equals("")) {
					 continue;
				 }
				 arr8[o]=arr2[o];
				 //System.out.println(o);
				 System.out.print(arr8[o]+",");
			 }

			 
			System.out.println(); 
			System.out.println(arr8[12]);
		 
		 return arr8;
	 }
	 int calculate(String expression) throws EmptyStackException {
		 MyCalculator obj1 = new  MyCalculator();
		 
		 
		 MyStack<String> g = new MyStack<String>();
		 String[] arr5 = infixtopost(obj1.infix(expression));
		 int result = 0;
		 System.out.println(arr5.length);
		 for(int p=0;p<arr5.length;p++) {
			 //System.out.println(p);
			// System.out.println(arr5[p]);
			 if (!(arr5[p].equals("*")||arr5[p].equals("+")||arr5[p].equals("-"))) {
				 
				 g.push(arr5[p]);
//				 result = 0;
			 }
			 else {
				 if(!g.isEmpty())
				 { 
				 int A =Integer.parseInt(g.pop());
				 //System.out.println("t");
				 int B = Integer.parseInt(g.pop());
				 //System.out.println("b");
//				 System.out.println("t");
				 if(arr5[p].equals("*")) {
					 result=  B*A;
					 g.push(Integer.toString(result));
				 }
				 if(arr5[p].equals("+")) {
					 result=  B+A;
					 g.push(Integer.toString(result));
				 }
				 if(arr5[p].equals("-")) {
					 result=  B-A;
					 g.push(Integer.toString(result));
				 }}
				 
//				 result = Integer.parseInt(result+(B + arr5[p] + A));
//				 g.push(Integer.toString(result));
			 }
			
					 
		 }
		 return result;
		 
			
			 
		 }
	 /* public static void main(String[] args) {
			 MyCalculator obj = new  MyCalculator();
			  int t = obj.calculate("(1+(4+5+2)-3)+(6+18)");
//			  for(int o = 0 ;o<arr1.length;o++) {
//					 System.out.println(arr1[o]+" ");
//				 }
//			  obj.infixtopost(arr1);
			  System.out.println(t);
			  

			  
			}*/
		 }
	 


