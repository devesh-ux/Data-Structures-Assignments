package col106.assignment4.WeakAVLMap;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class WeakAVLMap<K extends Comparable,V> implements WeakAVLMapInterface<K,V>{
	class Node<K,V>{
		int height;
		K key1;
		V val;
		int rank;
		
		Node<K,V> left,right;
		Node(K key1,V val){
			this.key1 = key1;
			this.val = val;
			rank = 1;
			left = null;
			right = null;
			height = 1;
			
		}
	}
	Node<K,V> root;
	Node<K,V> parent;
	Node<K,V> parent1;
	int rot;
	
	public WeakAVLMap(){
		root = null;
		rot =0;
		// write your code here
	}
	 int height(Node<K,V> N) { 
	        if (N == null) 
	            return 0; 
	  
	        return N.height; 
	    } 
	
	
	
	
	Node<K,V>  parent(Node<K,V> node,K key2,Node<K,V> prev){
    	
    	if (node==null) {
    		return null;
    	}
    	if((node.key1).equals(key2)) {
    		parent= prev;
    	}
    	else {
    		 parent( node.left, key2,node);
    		 parent(node.right, key2,node);
    	}
    	return parent;
    }
    
    Node<K,V>  search(K key) {
    	 if (root == null) {  
    	        return root;}    
    	    Queue<Node > q = new LinkedList();  
    	    q.add(root);     
    	    while (q.size() > 0)  
    	    { 
    	          Node<K,V> temp = q.peek();  
    	        if (temp.key1.equals(key)) { 
    	        	return temp;
    	        } 
    	        q.remove();  
    	        if (temp.left != null)  
    	            q.add(temp.left);  
    	        if (temp.right != null)  
    	            q.add(temp.right);  
    	    }
			return null;  
    	  }

   
    void Restructure(Node<K,V> t) {
    	//System.out.print("devesh");
    	Node<K,V> q = parent(root,t.key1,null);
    	Node<K,V> p = parent(root,q.key1,null);
    	if(p==  null) {
    		return;
    	}
    	if( p == root) {
    		if( p.left==q) {
    			if( q.left ==t) {
    				rot++;
    				root = q;
    				p.left = q.right;
    				q.right = p;
    				p.rank--;
    				}
    			else if( q.right == t) {
    				rot = rot +2;
    				root = t;
    				q.right = t.left;
    				p.left = t.right;
    				t.left = q;
    				t.right = p;
    				p.rank--;
    				q.rank--;
    				t.rank++;
    			}
    			
    		}
    		else if( p.right==q) {
    			if( q.left==t) {
    				rot = rot +2;
    				root = t;
    				p.right = t.left;
    				q.left = t.right;
    				t.left = p;
    				t.right = q;
    				p.rank--;
    				q.rank--;
    				t.rank++;
    				}
    			else if(q.right==t) {
    				rot++;
    				root = q;
    				p.right = q.left;
    				q.left = p;
    				p.rank--;
    			}
    		}
    	}
    	else if(p!= root) {
    	Node<K,V> baap = parent(root,p.key1,null);
    	 if( baap.left==p) {
    		 if( p.left==q) {
     			if( q.left ==t) {
     				rot++;
     				baap.left = q;
     				p.left = q.right;
     				q.right = p;
     				p.rank--;
     				}
     			else if( q.right == t) {
     				rot = rot +2;
     				baap.left = t;
     				q.right = t.left;
     				p.left = t.right;
     				t.left = q;
     				t.right = p;
     				p.rank--;
    				q.rank--;
    				t.rank++;
     			}
     			
     		}
     		else if( p.right==q) {
     			if( q.left==t) {
     				rot = rot +2;
     				baap.left = t;
     				p.right = t.left;
     				q.left = t.right;
     				t.left = p;
     				t.right = q;
     				p.rank--;
    				q.rank--;
    				t.rank++;
     				}
     			else if(q.right==t) {
     				rot++;
     				baap.left = q;
     				p.right = q.left;
     				q.left = p;
     				p.rank--;
     			}
     		}
    	}
    	 else if(baap.right == p) {
    		 if( p.left==q) {
      			if( q.left ==t) {
      				rot++;
      				baap.right = q;
      				p.left = q.right;
      				q.right = p;
      				p.rank--;
      				}
      			else if( q.right == t) {
      				rot = rot +2;
      				baap.right = t;
      				q.right = t.left;
      				p.left = t.right;
      				t.left = q;
      				t.right = p;
      				p.rank--;
    				q.rank--;
    				t.rank++;
      			}
      			
      		}
      		else if( p.right==q) {
      			if( q.left==t) {
      				rot = rot +2;
      				baap.right = t;
      				p.right = t.left;
      				q.left = t.right;
      				t.left = p;
      				t.right = q;
      				p.rank--;
    				q.rank--;
    				t.rank++;
      				}
      			else if(q.right==t) {
      				rot++;
      				baap.right = q;
      				p.right = q.left;
      				q.left = p;
      				p.rank--;
      			}
      		}
    	 }
    	}
    }
    public int rank(Node<K,V> n2) {
    	if(n2 == null) {
    		return 0;
    	}
    	else {
    		return (n2.rank);
    	}
    }
   
    
  public void Rebalance1(Node<K,V> curr,K key1){
    	Node<K,V> rankchangen1 = parent(root,key1,null);
    	 //System.out.print(rankchangen1.key1);
    	int rankchange1 = rank(rankchangen1);
    	 //System.out.print(rankchangen1.rank);
    	int rankcurr = rank(curr);
    	 if(curr == root && rankcurr == rankchange1-1 ) {	
    		 return;
    	 }
    	if(rankchangen1 != root) {
    	Node<K,V> rankchangen2 = parent(root,rankchangen1.key1,null);
    		int rankchange2 = rank(rankchangen2);
		 if(rankchangen2 == null) {
				return;
			}
	    
	    else if(rankcurr == rankchange1) {
		 //System.out.print("devesh");
			if(curr==rankchangen1.left ) {
//				System.out.print("devesh");
				int curr1sib = rank(rankchangen1.right);
				if(curr1sib == rankchange1-1) {

					if(rankchange1 == rankchange2 -2 ) {
						rankchangen1.rank++;
						
					}
					else if(rankchange1 == rankchange2 - 1) {
						//System.out.print("devesh");
						rankchangen1.rank++;
						//System.out.print(rankchangen1.key1 + "   ");
					Rebalance1(rankchangen1,rankchangen1.key1);
					}
				}
				else if(curr1sib == rankchange1-2) {
					if(curr.right== null) {
						Node<K,V> t = curr.left;
						Restructure(t);
					}
					else if(curr.left== null) {
						Node<K,V> t = curr.right;
						Restructure(t);
					}
					else {
						int curlefr = rank(curr.left);
						int currigr = rank(curr.right);
						if(curlefr > currigr) {
						Node<K,V> t = curr.left;
						Restructure(t);
						}
						else if(curlefr < currigr) {
							Node<K,V> t = curr.right;
							Restructure(t);
						}
						
					}
				}
			}
			else if(rankchangen1.right == curr ) {
//			System.out.print("devesh");
				int curr2sib = rank(rankchangen1.left);
				//System.out.print(rankchange1);
				if(curr2sib == rankchange1-1) {
					//System.out.print("devesh");
					if(rankchange1 == rankchange2 -2 ) {
						rankchangen1.rank++;
						//System.out.print("devesh");
					}
					else if(rankchange1 == rankchange2 - 1) {
						rankchangen1.rank++;
						
					//System.out.print("devesh");
					Rebalance1(rankchangen1,rankchangen1.key1);
				}
				}
				else if(curr2sib == rankchange1-2) {
					if(curr.right== null) {
						Node<K,V> t = curr.left;
						Restructure(t);
					}
					else if(curr.left== null) {
						Node<K,V> t = curr.right;
						Restructure(t);
					}
					else {
						int curlefr = rank(curr.left);
						int currigr = rank(curr.right);
						if(curlefr > currigr) {
						Node<K,V> t = curr.left;
						Restructure(t);
						}
						else if(curlefr < currigr) {
							Node<K,V> t = curr.right;
							Restructure(t);
						}
						
					}
				}
			}
		}
		
		}
    	
    	
    	else {
    		//System.out.print("devesh");
 
    		
    		 if(rankcurr == rankchange1) {
    			//System.out.print("devesh");
    				if(rankchangen1.left == curr ) {
    					int curr1sib = rank(rankchangen1.right);
    					//System.out.print(curr1sib);
    					//System.out.print(rankchange1);
    					if(curr1sib == rankchange1-1) {
    						//System.out.print("devesh");
    						rankchangen1.rank++;
    					}
    					
  					else if ( rankchange1 - 2  == curr1sib ) {
    					//else {
    						//System.out.print("devesh");
    						if(curr.right== null) {
    							Node<K,V> t = curr.left;
    							Restructure(t);
    						}
    						else if(curr.left== null) {
    							Node<K,V> t = curr.right;
    							Restructure(t);
    						}
    						else {
    							int curlefr = rank(curr.left);
    							int currigr = rank(curr.right);
    							if(curlefr > currigr) {
    							Node<K,V> t = curr.left;
    							Restructure(t);
    							}
    							else if(curlefr < currigr) {
    								Node<K,V> t = curr.right;
    								Restructure(t);
    							}
    							
    						}
    						
    					}
    				}
    				else if(curr==rankchangen1.right  ) {
    					
    					int curr2sib = rank(rankchangen1.left);
    					//System.out.print(curr2sib);
    					if(curr2sib == rankchange1-1) {
    						rankchangen1.rank++;
    						//System.out.print("devesh");
    					}
    					else if(curr2sib == rankchange1-2) {
    						//System.out.print("devesh");
    						if(curr.right== null) {
    							Node<K,V> t = curr.left;
    							Restructure(t);
    						}
    						else if(curr.left== null) {
    							Node<K,V> t = curr.right;
    							Restructure(t);
    						}
    						else {
    							int curlefr = rank(curr.left);
    							int currigr = rank(curr.right);
    							if(curlefr > currigr) {
    							Node<K,V> t = curr.left;
    							Restructure(t);
    							}
    							else if(curlefr < currigr) {
    								Node<K,V> t = curr.right;
    								Restructure(t);
    							}
    							
    						}
    					}
    				}
    			}
    		}
    	}
  

    
	public V put(K key, V value){
		Node<K,V> new_node = new Node<K,V>(key,value);
		Node<K,V> curr = root;
		 rank(root);
		if(root == null) {
    		root = new_node;
    		return null;
    	} 
		while(true) {
			 parent1 = curr;
	    		if((key).compareTo(curr.key1) < 0) {
	    			 
	    			curr = curr.left;
	    			if(curr == null) {
	    				parent1.left = new_node;
	    				curr = parent1.left;
	    				//curr.rank++;
	    				Rebalance1(curr,key);
	    				
	    				break;
	    			}
	    		}    		
	   			else if((key).compareTo(curr.key1) > 0) {
	   				curr = curr.right;
	   				if(curr == null) {
	    				parent1.right = new_node;
	    				curr = parent1.right;
	    				//curr.rank++;
	    				//System.out.print(curr.rank);
	    				Rebalance1(curr,key);
	    				//System.out.print("devesh");
	    				break;
	    			}
	   			}
	   			else {
	   				V vale = curr.val;
	   				curr.val = value;
	   				return vale;
	   			}
		}
		return null;
	}
	void Restructure2(Node<K,V> t) {
		Node<K,V> s = parent(root,t.key1,null);
    	Node<K,V> p = parent(root,s.key1,null);
    	//System.out.println(root.key1);
//    	System.out.println(s.key1);
    	if( p == root) {
    		if( p.left==s) {
    			if( s.left ==t) {
    				rot++;
    				root = s;
    				p.left = s.right;
    				s.right = p;
    				p.rank--;
    				s.rank++;
    				if(p.left == null&& p.right== null&& p.rank==2) {
    					p.rank--;
    				}
    				
    				}
    			else if( s.right == t) {
    				rot = rot +2;
    				root = t;
    				s.right = t.left;
    				p.left = t.right;
    				t.left = s;
    				t.right = p;
    				s.rank--;
    				t.rank = t.rank +2 ;
    				p.rank = p.rank - 2 ;
    				if(p.left == null&& p.right== null&& p.rank==2) {
    					p.rank--;
    				}
    				
    			}
    			
    		}
    		else if( p.right==s) {
    			if( s.left==t) {
    				rot = rot +2;
    				root = t;
    				p.right = t.left;
    				s.left = t.right;
    				t.left = p;
    				t.right = s;
    				s.rank--;
    				t.rank = t.rank +2 ;
    				p.rank = p.rank - 2 ;
    				if(p.left == null&& p.right== null&& p.rank==2) {
    					p.rank--;
    				}
    				}
    			else if(s.right==t) {
    				rot++;
    				root = s;
    				p.right = s.left;
    				s.left = p;
    				p.rank--;
    				s.rank++;
    				if(p.left == null&& p.right== null&& p.rank==2) {
    					p.rank--;
    				}
    			}
    		}
    	}
    	else if(p!= root) {
    	//	System.out.println("devesh");
        	Node<K,V> baap = parent(root,p.key1,null);
        	 if( baap.left==p) {
        		// System.out.println("devesh");
        		 if( p.left==s) {
        			// System.out.println("devesh");
         			if( s.left == t) {
         				//System.out.println("devesh");
         				rot++;
         				
         				
         			 baap.left = s; 
         			
         			p.left = s.right;
         			s.right =p;
         			
         				p.rank--;
        				s.rank++;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
         				}
         			else if( s.right == t) {
         			//	System.out.println("devesh");
         				rot = rot +2;
         				baap.left = t;
         				s.right = t.left;
         				p.left = t.right;
         				t.left = s;
         				t.right = p;
         				s.rank--;
        				t.rank = t.rank +2 ;
        				p.rank = p.rank - 2 ;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
         			}
         			
         		}
         		else if( p.right==s) {
         			if( s.left==t) {
         				rot = rot +2;
         				baap.left = t;
         				p.right = t.left;
         				s.left = t.right;
         				t.left = p;
         				t.right = s;
         				s.rank--;
        				t.rank = t.rank +2 ;
        				p.rank = p.rank - 2 ;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
         				}
         			else if(s.right==t) {
         				rot++;
         				baap.left = s;
         				p.right = s.left;
         				s.left = p;
         				p.rank--;
        				s.rank++;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
         			}
         		}
        	}
        	 else if(baap.right == p) {
        		 if( p.left==s) {
          			if( s.left ==t) {
          				rot++;
          				baap.right = s;
          				p.left = s.right;
          				s.right = p;
          				p.rank--;
        				s.rank++;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
          				}
          			else if( s.right == t) {
          				rot = rot +2;
          				baap.right = t;
          				s.right = t.left;
          				p.left = t.right;
          				t.left = s;
          				t.right = p;
          				s.rank--;
        				t.rank = t.rank +2 ;
        				p.rank = p.rank - 2 ;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
          			}
          			
          		}
          		else if( p.right==s) {
          			if( s.left==t) {
          				rot = rot +2;
          				baap.right = t;
          				p.right = t.left;
          				s.left = t.right;
          				t.left = p;
          				t.right = s;
          				s.rank--;
        				t.rank = t.rank +2 ;
        				p.rank = p.rank - 2 ;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
          				}
          			else if(s.right==t) {
          				rot++;
          				baap.right = s;
          				p.right = s.left;
          				s.left = p;
          				p.rank--;
        				s.rank++;
        				if(p.left == null&& p.right== null&& p.rank==2) {
        					p.rank--;
        				}
          			}
          		}
        	 }
        	}
	}
	public void Rebalance2(Node<K,V> p,Node<K,V> q,Node<K,V> s) {
		int rankp = rank(p);
		int ranks = rank(s);
		if(p == null) {
			return;
		}
		if(q != null) {
		if(q.rank == p.rank-2 ||q.rank == p.rank-1 ) {
			return;
		}
		}

		if(p != root) {	
		Node<K,V> parentp = parent(root,p.key1,null);
		int rankparp = rank(parentp);
		
	//	System.out.println(ranks);
		if(ranks == rankp -2 ) {
			if(rankp == rankparp-1 ) {
				p.rank--;
			}
			else if(rankp == rankparp-2) {
				if(parentp.left == p) {
					p.rank--;
				Rebalance2(parentp,p,parentp.right);
				}
				else if(parentp.right == p) {
					p.rank--;
					Rebalance2(parentp,p,parentp.left);
				}
			}
		}
		else if(ranks == rankp -1) {
			if(s.left!= null  || s.right != null) {
			
			int ranks1 = rank(s.left);
			int ranks2 = rank(s.right);
			if(ranks1 == ranks -2 && ranks2 == ranks -2) {
				if(rankp == rankparp-1) {
					p.rank--;
					s.rank--;
				}
				else if(rankp == rankparp-2) {
					if(parentp.left == p) {
						p.rank--;
						s.rank--;
						Rebalance2(parentp,p,parentp.right);
					}
					else if(parentp.right == p) {
						p.rank--;
						s.rank--;
						Rebalance2(parentp,p,parentp.left);
					}
				}
			}
			else if(ranks1 == ranks -1 || ranks2 == ranks -1) {
				if(ranks1 == ranks -1 && ranks2 == ranks -1) {
					if(s== p.left) {
						Node<K,V> t = s.left;
						Restructure2(t);
					}
					else {
						Node<K,V> t = s.right;
						Restructure2(t);
					}
				}
				else {
					if(ranks1 == ranks -1) {
						Node<K,V> t = s.left;
						Restructure2(t);
					}
					else {
						Node<K,V> t = s.right;
						Restructure2(t);
					}
				}
			}
			}
			else {
				return;
			}
		}
	}
	else {
		if(ranks == rankp -2 ) {
				p.rank--;
			}
		else if(ranks == rankp -1) {
			if(s.left!= null  || s.right != null) {
				int ranks1 = rank(s.left);
				int ranks2 = rank(s.right);
				if(ranks1 == ranks -2 &&ranks2 == ranks -2) {
					p.rank--;
					s.rank--;
				}
				else if(ranks1 == ranks -1 || ranks2 == ranks -1) {
					if(ranks1 == ranks -1 && ranks2 == ranks -1) {
						if(s== p.left) {
							Node<K,V> t = s.left;
							Restructure2(t);
						}
						else {
							Node<K,V> t = s.right;
							Restructure2(t);
						}
					}
					else {
						if(ranks1 == ranks -1) {
							Node<K,V> t = s.left;
							Restructure2(t);
						}
						else {
							Node<K,V> t = s.right;
							Restructure2(t);
						}
				}
				
			}
		}
			else {
				return;
			}
	}
		}
	}
	 Node<K,V> minoderight(Node<K,V> node){
	    	if (node.left == null) {
	    		return node;
	    	}
	    	while(node.left != null) {
	    		node = node.left;
	    	}
	    	return node;
	    }

	public V remove(K key){
		Node<K,V> v;
    	v= search( key);
    	
    	
    	//int rankv = rank(v);
    	if(v== null) {
    		return null;
    	}
    	else {
    		V v1 = v.val;
     	
//    		Node<K,V> p = parent(root,key,null);
//    		int rankp = rank(p);
    	if(v.left == (null)&& v.right == (null)) {
    		if(v!= root) {
    		Node<K,V> p = parent(root,key,null);
    		//int rankp = rank(p);
    		if(v.equals(p.left)) {
    			Node<K,V> s = p.right;
    			Node<K,V> q = null;
    			p.left = null;
    			if(p.rank== 2 && p.left== null && p.right==  null) {
    				if(p!=root) {
    				Node<K,V> parentp = parent(root,p.key1,null);
    				
    
    				if(p == parentp.left ) {
    					p.rank--;
    					Rebalance2(parentp,p,parentp.right);
    				}
    				else if(p == parentp.right) {
    					p.rank--;
    					Rebalance2(parentp,p,parentp.left);
    				}
    				}
    				else {
    					p.rank--;
    				}
    			}
    			
    			else {
    				Rebalance2(p,q,s);
    				
    			}
                  //Rebalance2(p,q,s);
    			return v1;
    			
    		}
    		else {
    			Node<K,V> s1 = p.left;
    			Node<K,V> q = null;
    			p.right = null;
    		//	System.out.println(p.rank);
                  if(p.rank== 2 && p.left== null && p.right==  null) {
                	  if(p != root) {
    				
    				Node<K,V> parentp = parent(root,p.key1,null);
    				//int rankparp = rank(parentp);
    				//System.out.print(p.rank);
    				
    				
    				if(p == parentp.left ) {
    					p.rank--;
    					Rebalance2(parentp,p,parentp.right);
    				}
    				else if(p == parentp.right) {
    					p.rank--;
    					Rebalance2(parentp,p,parentp.left);
    				}
    				}
                	  else {
                		  p.rank--;
                	  }
                  }
                  else {
                	  Rebalance2(p,q,s1);
                	  
                  }
                  return v1;
    			
    		}
    		}
    		else {
    			root = null;
    			//v = null;
    			return v1;
    		}
    	}
    else if((v.left == null)||(v.right == null)){
    	if(v!= root) {
    	Node<K,V> p = parent(root,key,null);
    		
    	//rankv = 1;
    		if(v.left == null) {
    			
        		//int rankp = rank(p);
    			Node<K,V> q = v.right;
    			//int rankq = rank(q);
    			if(v.equals(p.left)) {
    				Node<K,V> s1 = p.right;
    				p.left = q;
    				v.right = null;
    				Rebalance2(p,q,s1);
    				
    				return v1;
    			}
    			else {
    				Node<K,V> s1 = p.left;
    				p.right = q;
    				v.right = null;
    				Rebalance2(p,q,s1);
    				return v1;
    			}
    		}
    		else {
    			Node<K,V> q1 = v.left;
    			if(v.equals(p.left)) {
    				Node<K,V> s1 = p.right;
    				p.left = q1;
    				v.left = null;
    				Rebalance2(p,q1,s1);
    				return v1;
    			}
    			else {
    				Node<K,V> s1 = p.left;
    				p.right = q1;
    				v.left = null;
    				Rebalance2(p,q1,s1);
    				return v1;
    			}
    			
    		}
    	}
    	else {
    		if(v.left == null) {
    			//root = v.right;
    			Node<K,V> q = v.right;
    			Node<K,V> s = null;
    			Node<K,V> p = null;
    			root = q;
    			v.right =  null;
    			Rebalance2(p,q,s);
    			return v1;
    		}
    		else {
    			Node<K,V> q = v.left;
    			Node<K,V> s = null;
    			Node<K,V> p = null;
    			root = q;
    			v.left = null;
    			Rebalance2(p,q,s);
    			return v1;
    		}
    		
    	}
    	}
	
    else {	
    	if(v.right!= null) {
    		Node<K,V> min = minoderight(v.right);
    		K r = (K) v.key1;
    		v.key1 = min.key1 ;
    		min.key1 = r;
    		V r1 = (V) v.val;
    		v.val = min.val ;
    		min.val = r1;
    		Node<K,V> p = parent(root,key,null);
    		 if(min == p.right) {
    			 Node<K,V> s = p.left;
    		 if(min.right!= null && min.left == null) {
    			 Node<K,V> q = min.right;
    			 p.right = q;
    			 Rebalance2(p,q,s);
    			 return v1;
    		 }
    		 else {
    			 Node<K,V> q =null;
    			 p.right = null;
    			 Rebalance2(p,q,s);
    			 return v1;
    		 }
    		 }
    		 else {
    			 Node<K,V> s = p.right; 
    		  if(min.right!= null) {
    			  Node<K,V> q = min.right;
    		    p.left = q;
    		    min.right = null;
    		    Rebalance2(p,q,s);
    		    return v1;
    		 }
    		 else {
    			 Node<K,V> q =  null;
    		p.left = null;
    		Rebalance2(p,q,s);
    		return v1;
    		}
    		 }
    		//return null;
    		
    	}
//    	else {
//    		Node<K,V> p1 = parent(root,key,null);
//    		if(v==p1.right) {
//    			p1.right = null;
//    		}
//    		else {
//    			p1.left = null;
//    		}
//    		return null;
//    		
//    	}
    }
		
		// write your code her 
		return null;
	}
	}

	public V get(K key){
		// write your code her 
		Node<K,V> getnode = search( key);
		if(getnode!= null) {
		//System.out.println("value of element with key k"  + getnode.val +  " ");
		return getnode.val;
		}
		else {
			//System.out.println("null" + " ");
			return null;
		}
		
		//return null;
	}
	Vector<K> v3 = new Vector<K>();
	Vector<V> v4 = new Vector<V>();
	 void returnInorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        /* first recur on left child */
	        returnInorder(node.left); 
	  
	        /* then print the data of node */
//	        System.out.print(node.key1 + " "); 
	        
	        v3.addElement((K) node.key1);
	        v4.addElement((V) node.val);
	        
	        
	        /* now recur on right child */
	        returnInorder(node.right); 
	    } 

	public Vector<V> searchRange(K key1, K key2){
		Vector<V> v5 = new Vector<V>();
		returnInorder(root);
		//System.out.println(v3.get(1));
		int i = 0;
		//(v3.get(i)).comapareTo(key2) < 0
		while(i <v3.size()&&((v3.get(i)).compareTo(key2) < 0 || (v3.get(i)).compareTo(key2) == 0 ) ) {
			if((v3.get(i)).compareTo(key1) > 0 || (v3.get(i)).compareTo(key1) == 0) {
				v5.addElement(v4.get(i));	
				i++;
			}
			else {
				i++;
			}
		}
		

//		for (int j = 0 ;j<v5.size();j++) {
//        	System.out.println("values between keys:" + v5.get(j) + " ");
//        }
		v3.clear();
		v4.clear();
		
		return v5;
	}

	public int rotateCount(){
	//	System.out.println("rotate count" + rot + " ");
		return rot;
		// write your code her 
		
	}

	public int getHeight(){
		int h = treeHeight(root);
		//System.out.println("height"+" " +h + " ");
		// write your code her 
		return h;
	}
	int treeHeight(Node node)  
    { 
        // Base Case 
        if (node == null) 
            return 0; 
   
        // Create an empty queue for level order tarversal 
        Queue<Node> q = new LinkedList(); 
   
        // Enqueue Root and initialize height 
        q.add(node); 
        int height = 0; 
   
        while (1 == 1)  
        { 
            // nodeCount (queue size) indicates number of nodes 
            // at current lelvel. 
            int nodeCount = q.size(); 
            if (nodeCount == 0) 
                return height; 
            height++; 
   
            // Dequeue all nodes of current level and Enqueue all 
            // nodes of next level 
            while (nodeCount > 0)  
            { 
                Node newnode = q.peek(); 
                q.remove(); 
                if (newnode.left != null) 
                    q.add(newnode.left); 
                if (newnode.right != null) 
                    q.add(newnode.right); 
                nodeCount--; 
            } 
        } 
    } 

	public Vector<K> BFS(){
		Vector<K> v2 = new Vector<K>();
		Vector<Integer> v3 = new Vector<Integer>();
		Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
            Node<K,V> temp = queue.poll();
            if(temp!= null) {
            v2.add(temp.key1);
            v3.add(temp.rank);
           
            if (temp.left != null) { 
                queue.add(temp.left); 
            } 
            if (temp.right != null) { 
                queue.add(temp.right); 
            }
            }
//            else {
//            	System.out.println("BFS order :" + " ");
//            }
        }
//        for (int i = 0 ;i<v3.size();i++) {
//        	System.out.print( v3.get(i) + " ");
//        }
		// write your code her 
		return v2;
	}
	
	public static void main(String args[]) throws IOException {
		WeakAVLMap<Integer,Integer> ob1 = new WeakAVLMap<Integer,Integer>();
		WAVLDriverCode.ma();
//devesh
	
	}

}
