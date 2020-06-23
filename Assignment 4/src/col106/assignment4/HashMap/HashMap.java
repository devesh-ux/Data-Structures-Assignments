package col106.assignment4.HashMap;
import java.io.IOException;
import java.util.Vector;

public class HashMap<V> implements HashMapInterface<V> {
	int maxsize;
	String keyarr[];
	private V[] valarr;
	V r;

	public HashMap(int size) {
		 
		maxsize = size;
		keyarr = new String[maxsize];
		valarr = (V[]) new Object[maxsize];
		// write your code here
	}
	public long hash(String s) {
		if(s == null) {
			return 0;
		}
		long h = 0;
		int a = 41;
		int i;
		for( i= s.length() -1  ; i >= 0 ;i--) {
			int r = s.charAt(i);
			h = (h*a)+(r);
			//System.out.println(h);
		}
			return h;
	}

	public V put(String key, V value){
		int t = (int) (hash(key) % maxsize);
		int t1 = t;
//		System.out.println(hash(key));
		//System.out.println(t);
		
		if((keyarr[t])== (null)) {
			keyarr[t] = key;
			valarr[t] = value;			
			return null;
		}
		while((keyarr[t])!= null) {
			if(  hash(key) == hash(keyarr[t])) {	
			//	System.out.println(t);
				V prev = valarr[t];
				valarr[t] = value;
				
				return prev;
				}
			
			else if(hash(key) != hash(keyarr[t])) {
				t = (t+1) % maxsize;
				if((keyarr[t])== null) {
					//System.out.println(keyarr[t]);
					keyarr[t] = key ;
					valarr[t] = value;
					return null;
			}
			   }
			if(t == t1) {
				return null;
			}
			}
		
		
		return null;
		// write your code here
	}

	public V get(String key){
		int t = (int) (hash(key) % maxsize);
		int t1 = t;
//		if((keyarr[t]).equals(null)) {
		if((keyarr[t])==(null)) {
			return null;
		}
		if(hash(keyarr[t]) == hash(key)) {
			V a = valarr[t];
			return a;
		}
		while((keyarr[t])!=(null)) {			
			if(hash(keyarr[t]) != hash(key) ) {				
				t = (t+1) % maxsize;
				if(t == t1) {
					return null;
				}
				if( (keyarr[t])!=(null)) {
					if( hash(keyarr[t]) == hash(key)) {
					
					V a = valarr[t];
					return a;
					}
			   }
				else {
					//System.out.print("dedjb c");
					return null;
				}
			
				
				
				
			}
//			else {
//				return null;
//			}
			
		}
		
		// write your code here
		return null;
	}

	public boolean remove(String key){
		// write your code here
		int t = (int) (hash(key) % maxsize);
		int t1 = t;
		if((keyarr[t])==(null)) {
			return false;
		}
		if(hash(keyarr[t]) == hash(key)) {
			  keyarr[t] = null;
			  valarr[t] = null;
			  int k1 = (t+1) % maxsize;
//			   while(!(keyarr[k1]).equals(null)) {
			  while((keyarr[k1])!=(null)) {
				   String k2 = keyarr[k1];
				   r =  valarr[k1];
				   keyarr[k1] = null;
				   valarr[k1] = null;
				   put(k2,r);
				   k1 = (k1+1) % maxsize;
				   
				   
			   }
			  return true;
		}
		else if(hash(keyarr[t]) != hash(key)) {
			while((keyarr[t])!=(null)) {
				t = (t+1)% maxsize;
				if(t == t1) {
					return false;
				}
				if(hash(keyarr[t]) == hash(key)) {
					  keyarr[t] = null;
					  valarr[t] = null;
					  int k1 = (t+1) % maxsize;
					   while((keyarr[k1])!=(null)) {
						   String k2 = keyarr[k1];
						   r =  valarr[k1];
						   keyarr[k1] = null;
						   valarr[k1] = null;
						   put(k2,r);
						   k1 = (k1+1) % maxsize;
						   
						   
					   }
					  return true;
				}
				else if((keyarr[t])==(null)) {
					return false;
				}
				
			}
		}
		
		
		
		
		return false;
	}

	public boolean contains(String key){
		return get(key)!= null;
		// write your code here
		
	}

	public Vector<String> getKeysInOrder(){
		// write your code here
		Vector<String> v1 = new Vector<String>();
		for(int j = 0 ; j< keyarr.length;j++) {
			if((keyarr[j]  != (null) )) {
				v1.add(keyarr[j]);
			}
		}

		
		return v1;
	}
	public static void main(String args[]) throws IOException {
		HashMap<Integer> obj = new HashMap<Integer>(43);
		HashMapDriverCode.ma();
	}
	
	
}
