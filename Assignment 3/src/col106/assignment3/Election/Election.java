package col106.assignment3.Election;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import col106.assignment3.BST.BSTDriverCode;
import col106.assignment3.BST.BSTInterface;
//import col106.assignment3.BST.BST.Node;
//import col106.assignment3.BST.BST.Node;

//import col106.assignment3.BST.BST.Node;
class Node{
	 candidate key1;
	 int val;
	Node left,right;
	Node(candidate key1, int data){
		this.key1= key1;
		this.val= data;
		left = null;
		right = null;
	}
}
class Party {
	String name = null;
	ArrayList<candidate> partycan = null;
	int totalvotes;
	Party(String x){
		this.name = x;
		totalvotes = 0;
		partycan = new ArrayList<candidate>();
	}
	String get_name() {
		return this.name;
	}
	void add_vote(int vote) {
		this.totalvotes = this.totalvotes + vote;
	}
	 int get_vote() {
		return totalvotes;
	}
	void add_can(candidate x) {
		partycan.add(x);
		int y = Integer.parseInt(x.votes);
		this.totalvotes = this.totalvotes + y;
	}
	
}
 class candidate implements Comparable<candidate> {
	String name; 
	String candID;
	String state;
	String district;
	String constituency;
	String party;
	String votes;
	public candidate(String name, String candID, String state, String district, String constituency, String party, String votes) {
		this.name = name;
		this.candID = candID;
		this.state = state;
		this.district= district;
		this.constituency = constituency;
		this.party = party;
		this.votes = votes;
		
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getCandID() {
		return candID;
	}
//	public void setCandID(String candID) {
//		this.candID = candID;
//	}
	public String getState() {
		return state;
	}
//	public void setState(String state) {
//		this.state = state;
//	}
	public String getDistrict() {
		return district;
	}
//	public void setDistrict(String district) {
//		this.district = district;
//	}
	public String getConstituency() {
		return constituency;
	}
//	public void setConstituency(String constituency) {
//		this.constituency = constituency;
//	}
	public String getParty() {
		return party;
	}
//	public void setParty(String party) {
//		this.party = party;
//	}
	public String getVotes() {
		return votes;
	}
//	public void setVotes(String votes) {
//		this.votes = votes;
//	}
//	
@Override
public int compareTo(candidate o) {
	// TODO Auto-generated method stub
	return 0;
}

}

class BST1 {
	Node root;
	Node parent;
	public BST1(){
		root=null;
	}
	public void insert(candidate key, int value) {
    	Node new_node = new Node(key,value);
    	if(root == null) {
    		root = new_node;
    		return;
    	}
    		Node curr=root;
    		Node parent;
       while(true) {
    	   parent = curr;
    		if(value < curr.val) {
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
    public void update(String cand_id, int value) {
    	Node temp = search(cand_id);
    	delete(cand_id);
    	insert(temp.key1,value);
    }
    int value;
    public void delete(String cand_id) {
    	root = deleterec(cand_id);
    }
    public Node deleterec(String cand_id) {
    	Node curr;
    	curr= search(cand_id);
    	parent(root,curr.key1,null); 
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
    		Node min = minoderight(curr.right);
    		int r = curr.val;
    		curr.val = min.val ;
    		min.val = r;
    		candidate r1 =  curr.key1;
    		curr.key1 = min.key1 ;
    		min.key1 = r1;
    		 parent(root,min.key1,null);
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
    		parent(root,curr.key1,null);
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
    
    Node minoderight(Node node){
    	if (node.left == null) {
    		return node;
    	}
    	while(node.left != null) {
    		node = node.left;
    	}
    	return node;
    }
    void  parent(Node node,candidate key2,Node prev){
    	
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
    
    Node  search(String cand_id) {
    	 if (root == null) {  
    	        return root;}    
    	    Queue<Node> q = new LinkedList();  
    	    q.add(root);     
    	    while (q.size() > 0)  
    	    { 
    	          Node temp = q.peek();  
    	        if (temp.key1.candID.equals(cand_id)) { 
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
            Node temp = queue.poll();
          
            System.out.println(temp.key1 + ", "+temp.val); 
            if (temp.left != null) { 
                queue.add(temp.left); 
            } 
            if (temp.right != null) { 
                queue.add(temp.right); 
            }
            
        }
    }
}

public class Election implements ElectionInterface {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	public static void main(String[] args) throws IOException {
		
	}
	/*
	 * end code
	 */
	
	//write your code here 
	BST1 can_bst = new BST1();
	ArrayList<Party> party_list = new ArrayList<Party>();
	//ArrayList<candidate> CandidateRecord = new ArrayList<candidate>();
    public void insert(String name, String candID, String state, String district, String constituency, String party, String votes){
    	candidate ob1 = new candidate( name, candID, state, district, constituency, party, votes);
        //CandidateRecord.add(ob1);
    	
    	//write your code here
    	int vote = Integer.parseInt(votes); 
    	can_bst.insert(ob1,vote);
    	boolean z = false;
    	for(int i=0;i<party_list.size();i++) {
    		if (party_list.get(i).get_name()==party){
    			party_list.get(i).add_can(ob1);
    			z = true;
    			break;
    		}
    	}
    	if(z == false) {
    		Party q = new Party(party);
    		q.add_can(ob1);
    		party_list.add(q);
    	}
	}
	public void updateVote(String name, String candID, String votes){
		//write your code here
	//	candidate ob5 = new candidate( name, candID,  votes);
		Node temp = can_bst.search(candID);
		temp.key1.votes = votes;
		Node new1 = new Node(temp.key1,Integer.parseInt(votes));		
//		//System.out.println(temp.key1.candID);
		
		can_bst.delete(candID);
		int y = Integer.parseInt(votes);
		can_bst.insert(new1.key1, y);
	    
	}
	
	Stack<candidate> stackOfCan = new Stack<>();
	public void topkInConstituency(String constituency, String k){
		int size_ = Integer.parseInt(k);
		stackOfCan = new Stack<>();
		printInorder(can_bst.root,constituency);
		if(stackOfCan.capacity()<=size_) {
			while(!stackOfCan.empty()) {
				candidate temp = stackOfCan.pop();
				System.out.println(temp.name);
			}
		}
		else {
			for(int y=0;y<size_;y++) {
			//	candidate temp = stackOfCan.pop();
			//	System.out.println(temp.name);
			}
		}
		
	}
	void printInorder(Node node,String cons) 
    { 
        if (node == null) 
        { return;} 
  
        /* first recur on left child */
        if(node.left != null) {
        printInorder(node.left,cons);} 
  
       // then print the data of node *
        if(node.key1.constituency.equals(cons)) {
        	stackOfCan.add(node.key1);
        	System.out.println(node.key1.name);
        }
  
        /* now recur on right child */
        if(node.right != null) {
        printInorder(node.right,cons); }
    } 
	
//	ArrayList<String> sort(ArrayList<String> aa){
//			for (int i = 0; i < count; i++) 
//	        {
//	            for (int j = i + 1; j < count; j++) { 
//	                if (num[i] > num[j]) 
//	                {
//	                    temp = num[i];
//	                    num[i] = num[j];
//	                    num[j] = temp;
//	                }
//	            }
//	        }
//		
//		return null;
//	}
	public void leadingPartyInState(String state){
		//write your code here
		//search state 
		ArrayList<String> lead_party = new ArrayList<String>();
		int max = 0;
		for(int r=0;r<party_list.size();r++) {
			int party_vote=0;
			for(int u=0;u<party_list.get(r).partycan.size();u++) {
				candidate tt = party_list.get(r).partycan.get(u);
				if(tt.state.equals(state))
					party_vote = party_vote + Integer.parseInt(tt.votes);
			}
			if (party_vote > max ) {
				max = party_vote;
				lead_party = null;
				lead_party = new ArrayList<String>();
				lead_party.add(party_list.get(r).name);
			}
			else if(party_vote == max) {
				lead_party.add(party_list.get(r).name);
			}
		}
		if(lead_party.size()==1) {
			System.out.println(lead_party.get(0));
			return;
		}
		else {
			for (int i = 0; i < lead_party.size(); i++) 
		        {
		            for (int j = i + 1; j < lead_party.size(); j++) { 
		                if (lead_party.get(i).compareTo(lead_party.get(j))>0) 
		                {
		                    String tem=lead_party.get(j);
		                    lead_party.set(j, lead_party.get(i));
		                    lead_party.set(i, tem);
		                }
		            }
		        }
			for (int i = 0; i < lead_party.size(); i++) {
				System.out.println(lead_party.get(i)+"jhhjuh");
			}
		}
	}
	public void cancelVoteConstituency(String constituency){
		//write your code here
		//search constituency
		//store in a linked list
		//and then delete now one by one
		//System.out.println("jhhjuh");
		for(int r3 = 0;r3<party_list.size();r3++) {
			
			for(int u1 =0;u1 <party_list.get(r3).partycan.size();u1++){
				
				candidate cc1 = party_list.get(r3).partycan.get(u1);
				
				if(cc1.constituency.contentEquals(constituency)) {
					//System.out.println("jhhjuh");
					can_bst.delete(cc1.candID);
					
				}
//				System.out.println("jhhjuh");
			}
		}
		
	}
	public void leadingPartyOverall(){
		ArrayList<String> lead_party1 = new ArrayList<String>();
		int max1  = 0;
		for(int r1=0;r1<party_list.size();r1++) {
			if(party_list.get(r1).totalvotes > max1) {
				//lead_party1 = null;
				max1 = party_list.get(r1).totalvotes;
				lead_party1 = null;
				lead_party1 = new ArrayList<String>();
				lead_party1.add(party_list.get(r1).name);
				}
			else if(party_list.get(r1).totalvotes == max1) {
				lead_party1.add(party_list.get(r1).name);
			}
		}
		if(lead_party1.size()==1) {
			System.out.println(lead_party1.get(0));
			return;
		}
		else {
			for (int i = 0; i < lead_party1.size(); i++) 
		        {
		            for (int j = i + 1; j < lead_party1.size(); j++) { 
		                if (lead_party1.get(i).compareTo(lead_party1.get(j))>0) 
		                {
		                    String tem=lead_party1.get(j);
		                    lead_party1.set(j, lead_party1.get(i));
		                    lead_party1.set(i, tem);
		                }
		            }
		        }
			for (int i = 0; i < lead_party1.size(); i++) {
				System.out.print(lead_party1.get(i) + " ");
			}
		}
		
		//write your code here
		
			
		
	}
	public void voteShareInState(String party,String state){
		int vote_state = 0 ;
		int vote_share = 0 ;
		for(int r2 = 0;r2 < party_list.size();r2++) {
				for(int u1=0;u1<party_list.get(r2).partycan.size();u1++) {
					candidate tt1 = party_list.get(r2).partycan.get(u1);
					if(tt1.state.equals(state) && tt1.party.equals(party) ){
						vote_share  = vote_share  + Integer.parseInt(tt1.votes);
					}
					if(tt1.state.equals(state)) {
						vote_state  = vote_state  + Integer.parseInt(tt1.votes);
					}
					
				}
				
			}
		vote_share = vote_share*100;
		double v = (vote_share/vote_state);
		int vote_ = (int)v;
		System.out.print(vote_);
		}
		//write your code here
	
	
	public void printElectionLevelOrder() {
		
		Queue<Node> queue = new LinkedList<Node>(); 
		
        queue.add(can_bst.root); 
        while (!queue.isEmpty())  
        { 
            Node temp = queue.poll();
          
            System.out.println(temp.key1.name +", "+ temp.key1.candID +", "+temp.key1.state+", "+temp.key1.district +", "+temp.key1.constituency +", "+temp.key1.party +", "+temp.val); 
            if (temp.left != null) { 
                queue.add(temp.left); 
            } 
            if (temp.right != null) { 
                queue.add(temp.right); 
            }
            
        }
		//write your code here
		
	}
}











