package col106.assignment3.Election;
import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable, E extends Comparable> implements BSTInterface<T, E>  {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
//	 T key1;
//	 E data;

	 class Node<T,E> {
		 T key1;
		 E data;
		Node<T,E> left,right;
		Node(T key1, E data){
			this.key1= key1;
			this.data= data;
			left = null;
			right = null;
		}

	}
	public static void main() {
		BSTDriverCode BDC = new BSTDriverCode();
		System.setOut(BDC.fileout());
	}
	/*
	 * end code
	 * start writing your code from here
	 */
	
	//write your code here 
	Node<T,E> root;
	Node<T,E> parent;
	BST(){
		root=null;
	}
	
    public void insert(T key, E value) {
    	Node<T,E> new_node = new Node<T,E>(key,value);
    	if(root == null) {
    		root = new_node;
    		return;
    	}
    		Node<T,E> curr=root;
    		Node<T,E> parent;
       while(true) {
    	   parent = curr;
    		if((value).compareTo(curr.data) < 0) {
    			curr = curr.left;
    			if(curr == null) {
    				parent.left = new_node;
    				break;
    			}
    		}    		
   			else {
   				curr = curr.right;
   				if(curr == null) {
    				parent.right = new_node;
    				break;
    			}
   			}
       }
    }
    public void update(T key, E value) {
    	delete(key);
    	insert(key,value);
    	//System.out.println("update element"); 
		//write your code here
    }
    E value;
    public void delete(T key) {
    	root = deleterec(key );
    	// System.out.println("delete element"); 
    }
    public Node<T,E> deleterec(T key) {
    	Node<T,E> curr;
    	curr= search( key);
    	parent(root,key,null); 
    	if(curr.left == (null)&&curr.right == (null)) {
    		if(curr.equals(parent.left)) {
    			parent.left = null;
    			return root;
    		}
    		else {
    			parent.right = null;
    			return root;
    		}
    	}
    else if((curr.left == null)||(curr.right == null)){
    		if(curr.left == null) {
    			if(curr.equals(parent.left)) {
    				parent.left = curr.right;
    				curr.right = null;
    				return root;
    			}
    			else {
    				parent.right = curr.right;
    				curr.right = null;
    				return root;
    			}
    		}
    		else {
    			if(curr.equals(parent.left)) {
    				parent.left = curr.left;
    				curr.left = null;
    				return root;
    			}
    			else {
    				parent.right = curr.left;
    				curr.left = null;
    				return root;
    			}
    			
    		}
    	}
    else {	
    	if(curr.right!= null) {
    		Node<T,E> min = minoderight(curr.right);
    		E r = (E) curr.data;
    		curr.data = min.data ;
    		min.data = r;
    		T r1 = (T) curr.key1;
    		curr.key1 = min.key1 ;
    		min.key1 = r1;
    		 parent(root,key,null);
    		 if(min == parent.right) {
    		 if(min.right!= null && min.left == null) {
    			 parent.right = min.right;
    		 }
    		 else {
    			 parent.right = null;
    		 }
    		 }
    		 else {
    				 
    		  if(min.right!= null) {
    		    parent.left = min.right;
    		    min.right = null;
    		 }
    		 else {
    		parent.left = null;
    		}
    		 }
    		return root;
    		
    	}
    	else {
    		parent(root,key,null);
    		if(curr==parent.right) {
    			parent.right = null;
    		}
    		else {
    			parent.left = null;
    		}
    		return root;
    		
    	}
    }
    }
    
    Node<T,E> minoderight(Node<T,E> node){
    	if (node.left == null) {
    		return node;
    	}
    	while(node.left != null) {
    		node = node.left;
    	}
    	return node;
    }
    void  parent(Node<T,E> node,T key2,Node<T,E> prev){
    	
    	if (node==null) {
    		return;
    	}
    	if((node.key1).equals(key2)) {
    		parent= prev;
    	}
    	else {
    		 parent( node.left, key2,node);
    		 parent(node.right, key2,node);
    	}
    }
    
    Node<T,E>  search(T key) {
    	 if (root == null) {  
    	        return root;}    
    	    Queue<Node > q = new LinkedList();  
    	    q.add(root);     
    	    while (q.size() > 0)  
    	    { 
    	          Node<T,E> temp = q.peek();  
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
    

    public void printBST () {
		//write your code here
    	Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
            Node<T,E> temp = queue.poll();
          
            System.out.println(temp.key1 + ", "+temp.data); 
            if (temp.left != null) { 
                queue.add(temp.left); 
            } 
            if (temp.right != null) { 
                queue.add(temp.right); 
            }
            
        }
    }
//    public static void main(String[] args) {
//    	BST<Integer,Integer> b=new BST<>();
//    	b.insert(1,50);
//    	b.insert(2,-1);
//    	b.insert(3,60);
//    	b.insert(4,0);
//    	b.insert(5,55);
//    	b.insert(6,-3);
//    	b.insert(100,51);
//    	b.insert(7,56);
//    	b.insert(8,53);
//    	b.insert(9,-4);
//    	b.printBST();
//    	
//    	//b.update(10,50);
//    	
//    	b.delete(1);
//    	b.printBST();
//    	b.update(9,52);
//    	b.printBST();
//    	b.insert(10,61);
//    	b.printBST();
//    	b.delete(2);
//    	b.printBST();
//    	b.update(5,65);
//    	b.update(3,63);
//    	b.printBST();
//    
//
//    }

}