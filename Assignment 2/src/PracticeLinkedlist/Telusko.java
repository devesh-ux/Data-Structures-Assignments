package PracticeLinkedlist;
//Inheritance
public class Telusko {
	public static void main(String args[]) {
		B obj1 = new B();
		obj1.a = 4;
		obj1.b = 4;
		obj1.add();
		obj1.sub();
		

		
           System.out.println(obj1.minus);
           System.out.println(obj1.sum);
	}

}

class A{
	 int a,b,sum;
	 
	 
	 public void add() {
		sum = a+b ;  
		 
	 }
	
	
}

class B extends A{
	int minus;
	public void sub() {
	      minus= a-b;	
	}
	
	
}

