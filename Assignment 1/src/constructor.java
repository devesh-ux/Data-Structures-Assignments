public class constructor 
{
	int p;
//	constructor(){
//		
//	}
	public  int convert(String d) {
		
		p = Integer.parseInt(d);
		return p;
	}
	public static void main(String args[])
	{
		
		constructor o1 = new constructor();
		o1.convert("021");
	}

}


