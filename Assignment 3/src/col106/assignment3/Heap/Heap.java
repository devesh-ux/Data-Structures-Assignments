package col106.assignment3.Heap;

import java.io.IOException;
import java.util.ArrayList;


public class Heap<T extends Comparable, E extends Comparable> implements HeapInterface <T, E> {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
//	public static void main() {
//		HeapDriverCode HDC = new HeapDriverCode();
//		System.setOut(HDC.fileout());
//	}
	/*
	 * end code
	 */
	int lep;
	Heap(){
		lep = 0;
	}
	ArrayList<E> obj1 = new ArrayList<E>();
	ArrayList<T> obj2 = new ArrayList<T>();
	
	// write your code here	
	public ArrayList<E> swap(int i,int j) {
		E l ;
		l = obj1.get(i);
		obj1.set(i,obj1.get(j));
		obj1.set(j,l);
		return obj1;
	}
	public ArrayList<T> swap1(int i1,int j1) {
		T h ;
		h = obj2.get(i1);
		obj2.set(i1,obj2.get(j1));
		obj2.set(j1,h);
		return obj2;
	}
	
	
	
	public void insert(T key, E value) {
		if(lep == 0) {
			obj1.add(lep,value);
			obj2.add(lep,key);
			lep++;
		}
		else if(value.compareTo(obj1.get((lep-1)/2)) < 0||value.compareTo(obj1.get((lep-1)/2)) == 0) {
		obj1.add(lep,value);
		obj2.add(lep,key);
		lep++;
		}
		else if(value.compareTo(obj1.get((lep-1)/2)) > 0) {
			obj1.add(lep,value);
			obj2.add(lep,key);
			int count;
			count = lep;
			while(value.compareTo(obj1.get((count-1)/2)) > 0 && count>0){
				swap(count, (count-1)/2);
				swap1(count, (count-1)/2);
				count = (count-1)/2;
			  
			}
			lep++;
		}
		
		
		//write your code here 
		
	}
	              T key;
	              E value;
	   public ArrayList<E> Heapify(int l) {
		   
	        while(((2*l+2)<obj1.size())&&(((obj1.get(2*l+2)).compareTo(obj1.get((2*l)+1)) < 0)||(obj1.get(2*l+1)).compareTo(obj1.get((2*l)+2)) < 0)) {
	        	if((obj1.get(l)).compareTo(obj1.get(2*l+1)) > 0 && (obj1.get(l)).compareTo(obj1.get(2*l+2)) > 0) {
	        		return obj1;
	        	}
	        	if ((obj1.get(2*l+2)).compareTo(obj1.get((2*l)+1)) < 0) {
	        				swap(l,(2*l+1));
	        				swap1(l,(2*l+1));
	        				l = (2*l)+1;
	        			}
	        	else if ((obj1.get(2*l+1)).compareTo(obj1.get((2*l)+2)) < 0) {
	        		swap(l,(2*l+2));
    				swap1(l,(2*l+2));
	        		
	        				l = (2*l)+2;
	        			}
	        
	        	else {
	        			return obj1;
	        			}
	        		}
	        if((2*l+2)== obj1.size()&&(obj1.get(l)).compareTo(obj1.get(2*l+1)) <0) {
	        	swap(l,(2*l+1));
	        }
	        		
	        		
	        		return obj1;
	        	}
	   public void Heapify1(int x){
		   while((obj1.get((x-1)/2).compareTo(obj1.get(x))) < 0 && x>0 ){
			   swap(x,((x-1)/2));
			   swap1(x,((x-1)/2));
			   x = (x-1)/2;
			   if(x<=0) {
				   break;
			   }
		   }
		  
	   }

    	              

	public E extractMax() {
		E r = obj1.get(0);
		swap(0,(obj1.size()-1));
		swap1(0,(obj2.size()-1));
		obj1.remove(obj1.size()-1);
		obj2.remove(obj2.size()-1);
		lep--;
		Heapify(0);
		//write your code here
		//System.out.println("maximum element" + r);
		
		return r;
	}

	int search(T ke) { 
	int r;
		for( r = 0;r<obj2.size();r++ ) {
			if(obj2.get(r).compareTo(ke) == 0) {
				break;
				
			}
			
		}
		return r;
	}
	

	public void delete(T key) {
		int j = search(key);
		swap(j,(obj1.size()-1));
		swap1(j,(obj2.size()-1));
		obj1.remove(obj1.size()-1);
		obj2.remove(obj2.size()-1);
		lep--;
		if (j!=obj1.size()) {
			 Heapify(j);
			 Heapify1(j);					 
		}
		

		// System.out.println("delete element");

	}

	public void increaseKey(T key, E value) {
		//write your code here
		int p = search(key);
		obj1.set(p,value);
		Heapify1(p);
		//System.out.println("update element");
		
	}

	public void printHeap() {
		for(int k =0 ;k<obj1.size();k++) {
		    System.out.println(obj2.get(k)+", "+ obj1.get(k));
		//write your code here
	}	
		//write your code here
	}
	public static void main(String[] args) throws IOException  {
		 Heap<Integer, Integer> heap = new Heap();
		 HeapDriverCode.ma();
		 
	}
}

