package col106.assignment5;

import java.util.Comparator;


/*
Implementation of MergeSort Algorithm :
    1. you get linked list of size <=1 you just return the list as it is already sorted
    2. Find mid node using findSplit method(Don't forget to add mid element to globalList before returning it)
    3. Create two LinkedList lt (with head = head and tail = mid) and rt (with head = mid.next and tail = tail)
    4. Now recursively MergSort lt and rt Linked lists(Maintain this order)
    5. Now merge these two lists that we got from recursive calls using given crieteria for ordering
    6. Return merged Linked list
*/

public class LLMergeSort <T extends Comparator<T>>  {
	
  private Comparator<T> c;
  
  LinkedList<T> final1 = new LinkedList<T>();

  
  public LinkedList<T> sort(LinkedList<T> llin, Comparator<T>comparator){
	  LinkedList<T> ans = MergeSort(llin,comparator);
	  return ans;
  }
  LinkedList<T>  globalList = new LinkedList<T>();

  //CALL THIS METHOD AFTER EVERY CALL OF findSplit and DO NOT MODIFY THIS METHOD
  public void adjustGlobalPointer(T node){
      globalList.add(node);
  }

//  public int compare
  // Utility function to get the middle of the linked list
  public Node<T> findSplit(LinkedList<T>  lst) {
    //find middle node of LL :
    Node<T> middle = lst.getHead();
    int n = lst.getSize();
    if(n % 2 == 0) {
    	int t = 1;
    	while(t != (n/2)) {
    		middle = middle.next;
    		t++;
    	}
    }
    else if(n % 2 != 0) {
    	if(n != 1) {
    		int j = 1;
    		while(j != ((n/2)+1)) {
    			middle = middle.next;
    			j++;
    		}
    	}
    	
    }
    //Enter your code here
   // System.out.println("Devesh");
    //!!!!!*****DO NOT REMOVE THIS METHOD CALL (change the argument apprpriately)*****!!!!!
    adjustGlobalPointer(middle.getData()); //Add object of ItemNode after finding mid in each call
    return middle;
  }
  
  public LinkedList<T> SortedMerge(LinkedList<T> a , LinkedList<T> b,Comparator<T> comparator) {
	  
	  
	  LinkedList<T> dummy = new LinkedList<T>();	  
	  Node<T> n1 = a.getHead();
	  Node<T> n2 = b.getHead();
	  
	  while(true) {
		  if(n1 == null) {
			  while(n2!= null) {
				  dummy.add(n2.data);
				  n2 = n2.next;
			  }
			 break;
		  }
		  if(n2 == null) {
			  while(n1!= null) {
				  dummy.add(n1.data);
				  n1 = n1.next;
			  }
			  break;
		  }
		  if(comparator.compare(n1.getData(),n2.getData()) < 0 || comparator.compare(n1.getData(),n2.getData()) == 0) {
			  dummy.add(n1.data);
			  n1  = n1.next;
				  
			 }
		  else {
				  dummy.add(n2.data);
				  n2 = n2.next;
			  }
	  }
	  return dummy;
  }


  public LinkedList<T>  MergeSort(LinkedList<T>  lst,Comparator<T> comparator) {
	  if(lst.getHead() == null || lst.getHead().next == null) {
		  return lst;
	  }
	      Node<T> headcurr = lst.getHead();
		  Node<T> mid = findSplit(lst);
		  Node<T> midnext = mid.next;
		  LinkedList<T> midnext1 = new LinkedList<T>();
		  while(headcurr!= mid.next) {
			  midnext1.add(headcurr.getData());
			  headcurr = headcurr.next;
		  }
		  LinkedList<T> midnext2 = new LinkedList<T>();
		  while(midnext!= null) {
			  midnext2.add(midnext.getData());
			 midnext = midnext.next;
		  }
		  LinkedList<T> left = MergeSort(midnext1,comparator);
		  LinkedList<T> right = MergeSort(midnext2,comparator);	  
		  final1 = SortedMerge(left,right,comparator);
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
    return final1;
  }

  //DO NOT CALL OR MODIFY THESE METHODS IN YOUR CALL THIS IS FOR USE IN DRIVER CODE
  public LinkedList<T> getGlobalList() {
    return this.globalList;
  }

  public void clearGlobalList(){
    globalList  = new LinkedList<>();
  }

}
