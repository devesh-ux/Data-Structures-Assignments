package PracticeLinkedlist;




class EmptyStackException extends Exception
{
	public EmptyStackException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}

//import com.sun.jdi.StackFrame;

 class MyStack<T>   {
	
	static Object[] arr;
	static int defaultSize = 1000000;
	int t1 = -1;
	
	public MyStack()	{				//: Constructor for MyStack class. Initialize an empty array of type T.
		this(defaultSize);
	}
	
	public MyStack (int size)	{
		arr = new Object [size];
		//this.t1 = -1;
	}
	
	public void push(T value)	{
		t1++;
		arr[t1] = value;
	}
	
	T pop() throws EmptyStackException	{
	if (arr.length==0 ) { 
		throw new EmptyStackException("pop dont exist");

	}
		

		else {
			T x = (T)arr[t1];
			
			arr[t1] = null;
			t1--;
			return x;
		}
		//return null;
	}	
	
	T top() throws EmptyStackException	{
		if(arr.length==0){
		throw new EmptyStackException("pop dont exist");

		}
	else {
			return (T) (arr[t1]);
					
		}
	}
	
	boolean isEmpty()	{
		return (t1<0);
	}
	/*public static void main(String args[]) {
		MyStack<String> obj = new MyStack<String>();
		obj.top();
		obj.push("+");
		obj.push("+");
		obj.push("+");
		obj.push("+");
	//	 System.out.println("Size of the stack: " + obj.size());
		 
		    // iterate through stack
		   // System.out.println("Following items pushed to Stack as of now:");
		    while (!obj.isEmpty()) {
		    	
		      System.out.println(obj.pop());
		    }
	}*/
	
}






