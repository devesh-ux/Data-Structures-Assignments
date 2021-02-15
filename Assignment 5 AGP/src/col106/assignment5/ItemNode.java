package col106.assignment5;

import java.util.Comparator;


public class ItemNode implements ItemInterface, Comparator<ItemNode> {

	int itemId;
	String itemName;
	int stock;
	int dayhi = 1 ;
	int monthi = 8;
	int yearhi = 1970;
	float calcmain = 0;
	LLMergeSort mergeSortobj1 = new LLMergeSort(); 
	
	LinkedList<PurchaseNode> purchaseTransactions=new LinkedList<>();
	
	public ItemNode(int itemId, String itemName, int stock){
		this.itemId = itemId;
		this.itemName = itemName;
		this.stock = stock;
	}

	public int getItemId(){
		//Enter your code here
		return itemId;
	}

	public  String getItemName(){
		//Enter your code here
		return itemName;
	}

	public int getStockLeft(){
		//Enter your code here	
		return stock;
	}
	
	public void updatecalci(float x) {
		calcmain  = x;
	}
	
	public LinkedList<PurchaseNode> purTransactions(LinkedList<PurchaseNode> t) {
		LinkedList<PurchaseNode> ans = mergeSortobj1.MergeSort(t, new transactionfun());
		return ans;
	}

	public void addTransaction(PurchaseNode purchaseT){
		//Enter your code here
		stock = stock - purchaseT.numItemPurchased;
		purchaseTransactions.add(purchaseT);
		LinkedList<PurchaseNode> purchasesort = purTransactions(purchaseTransactions);
		purchaseTransactions = purchasesort;
		 dayhi = purchasesort.getTail().getData().dateobj.day;
		monthi = purchasesort.getTail().getData().dateobj.month;
	    yearhi = purchasesort.getTail().getData().dateobj.year;
	}

	public Node<PurchaseNode> getPurchaseHead(){
		//Enter your code here
		return purchaseTransactions.getHead();
	}

	@Override
	public int compare(ItemNode o1, ItemNode o2) {
		// TODO Auto-generated method stub
		if(o1.stock>o2.stock){
            return 1;
        }else if(o1.stock<o2.stock){
            return -1;
        }
        	else{
                int comparison = 0;
                comparison = o1.getItemName().compareTo(o2.getItemName());
                return comparison;
            }
	}
}

