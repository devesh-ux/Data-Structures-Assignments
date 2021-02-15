package col106.assignment5;

import java.util.Comparator;

public class PurchaseNode implements PurchaseInterface,Comparator<PurchaseNode>{

	int numItemPurchased = 0;
	DateNode dateobj = null;

	public PurchaseNode(int numItems, int day, int month, int year){
		this.dateobj = new DateNode(day, month, year);
		numItemPurchased = numItems;
	}

	public DateNode getDate(){
		return this.dateobj;
	}

	public int numItemsPurchased(){
		return this.numItemPurchased;
	}

	@Override
	public int compare(PurchaseNode o1, PurchaseNode o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
