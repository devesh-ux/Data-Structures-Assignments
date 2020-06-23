package col106.assignment3.BST;

public class Node<T,E> {
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
