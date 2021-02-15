package col106.assignment5;

//import java.io.IOException;
import java.util.Comparator;



public class StockMgmt implements StockMgmtInterface {
	
	
	//!!!!!!!*********DON'T CREATE YOUR OWN OBJECTS OF LLMergeSort*********!!!!!!!
	//use these only this object to sort
	LLMergeSort mergeSortobj;

	LinkedList<CategoryNode> categories;

	//DO NOT MNODIFY THIS CONSTRUCTOR
	public StockMgmt() {

		mergeSortobj = new LLMergeSort();
		categories = new LinkedList<CategoryNode>();
		
		categories.add(new CategoryNode(1, "mobile"));
		categories.add(new CategoryNode(2, "utensils"));
		categories.add(new CategoryNode(3, "sanitary"));
		categories.add(new CategoryNode(4, "medicalEquipment"));
		categories.add(new CategoryNode(5, "clothes"));

	}

	public void addItem(int categoryId, int itemId, String itemName, int stock) {
		
		//Your code goes here
		Node<CategoryNode> temp = categories.getHead();
		while(temp != null) {
			if(temp.getData().getCategoryId() ==  categoryId) {
				LinkedList<ItemNode> additemlist = temp.getData().itemList;
				additemlist.add(new ItemNode(itemId,itemName,stock));
				break;
			}
			else {
				temp = temp.next;
			}
		}
	}

	public void addItemTransaction(int categoryId, int itemId, String itemName, int numItemPurchased, int day, int month, int year) {
		//Your code goes here
		PurchaseNode purchaset = new PurchaseNode( numItemPurchased, day, month, year);
		Node<CategoryNode> curr = categories.getHead();
		while(curr != null) {
			if(curr.getData().getCategoryId() ==  categoryId) {
				Node<ItemNode> curitem = curr.getData().itemList.getHead();
				while(curitem != null) {
					if(curitem.getData().itemId == itemId) {
						curitem.getData().addTransaction(purchaset);
						//System.out.println("desdbs");
						break;
					}
					else {
						curitem = curitem.next;
					}
				}
				break;
			}
			else {
				curr = curr.next;
			}
			
		}
		
	}

	//Query 1
	public LinkedList<ItemNode> sortByLastDate() {
		//Your code goes here
		LinkedList<ItemNode> sortitemlist = new LinkedList<ItemNode>();
		Node<CategoryNode> qonecurr = categories.getHead();
		while(qonecurr != null) {
			Node<ItemNode> qonecuritem = qonecurr.getData().itemList.getHead();
			while(qonecuritem != null) {
				sortitemlist.add(qonecuritem.getData());
				qonecuritem = qonecuritem.next;
			}
			qonecurr = qonecurr.next;
		}
		LinkedList<ItemNode> ansDate = mergeSortobj.sort(sortitemlist,new ItemLastDateComparator());
	
		return ansDate;
	}

	//Query 2
	public LinkedList<ItemNode> sortByPurchasePeriod(int day1, int month1, int year1, int day2, int month2, int year2) {
		//Your code goes here
		LinkedList<ItemNode> sortpurlist = new LinkedList<ItemNode>();
		Node<CategoryNode> qonepur = categories.getHead();
		while(qonepur != null) {
			Node<ItemNode> qonepuritem = qonepur.getData().itemList.getHead();
			while(qonepuritem != null) {
				sortpurlist.add(qonepuritem.data);
				int l = 0;
				int h = 0;
				int numpurchaset = 0;
				int r = 0;
				Node<PurchaseNode> transcurr = qonepuritem.data.getPurchaseHead();
				while(transcurr != null) {
					if( transcurr.data.dateobj.year > year1 && transcurr.data.dateobj.year < year2) {
						r++;
						numpurchaset = numpurchaset + transcurr.data.numItemPurchased;
						if( r == 1) {
							l = transcurr.data.dateobj.year;
							h = transcurr.data.dateobj.year;
							transcurr  = transcurr.next;
						}
						else if(r > 1) {
							h = transcurr.data.dateobj.year;
							transcurr  = transcurr.next;
						}
					}
					else if((transcurr.data.dateobj.year == year1 && transcurr.data.dateobj.month > month1 )||(transcurr.data.dateobj.year == year2 && transcurr.data.dateobj.month < month2)) {
						//System.out.println("Devesh");
						r++;
						//System.out.println(r + " name of year " + transcurr.data.dateobj.year);
						numpurchaset = numpurchaset + transcurr.data.numItemPurchased;
						if( r == 1) {
							l = transcurr.data.dateobj.year;
							h = transcurr.data.dateobj.year;
							transcurr  = transcurr.next;
						}
						else if(r > 1) {
							h = transcurr.data.dateobj.year;
							transcurr  = transcurr.next;
						}
					}
					else if((transcurr.data.dateobj.year == year1 && transcurr.data.dateobj.month == month1 && transcurr.data.dateobj.day > day1 )||(transcurr.data.dateobj.year == year2 && transcurr.data.dateobj.month == month2 && transcurr.data.dateobj.day < day2 )) {
						r++;
						numpurchaset = numpurchaset + transcurr.data.numItemPurchased;
						if( r == 1) {
							l = transcurr.data.dateobj.year;
							h = transcurr.data.dateobj.year;
							transcurr  = transcurr.next;
						}
						else if(r > 1) {
							h = transcurr.data.dateobj.year;
							transcurr  = transcurr.next;
						}
					}
					else {
						transcurr  = transcurr.next;
					}
			        
				}
				
				float clcit1 = (numpurchaset)/((h-l)+1);
				//System.out.println(clcit1 +" "+ qonepuritem.data.itemName);
				qonepuritem.data.updatecalci(clcit1);
				qonepuritem = qonepuritem.next;
			}
			qonepur = qonepur.next;
		}
		LinkedList<ItemNode> finalans =  mergeSortobj.sort(sortpurlist ,new ItemPurComparator());
		return finalans;
	}

	//Query 3
	public LinkedList<ItemNode> sortByStockForCategory(int category) {
		//Your code goes here
		LinkedList<ItemNode> sortitemstock = new LinkedList<ItemNode>();
		LinkedList<ItemNode> superfinal = new LinkedList<ItemNode>();
		Node<CategoryNode> qonecurrs = categories.getHead();
		while(qonecurrs  != null) {
			if(qonecurrs.getData().getCategoryId() == category) {
				Node<ItemNode> qonecuritems = qonecurrs.getData().itemList.getHead();
				while(qonecuritems != null) {
					
					sortitemstock.add(qonecuritems.getData());
					qonecuritems = qonecuritems.next;
				}
				break;
			}
			else {
				qonecurrs = qonecurrs.next;
			}
		}
		LinkedList<ItemNode> ansLL =	mergeSortobj.sort(sortitemstock,new ItemStockComparator());
		return ansLL;
	}

	//Query 4
	public LinkedList<ItemNode> filterByCategorySortByDate(int category) {
		//Your code goes here
		LinkedList<ItemNode> sortitemfilter = new LinkedList<ItemNode>();
		Node<CategoryNode> qonecurrf = categories.getHead();
		while(qonecurrf  != null) {
			if(qonecurrf.getData().getCategoryId() == category) {
				Node<ItemNode> qonecurfilter = qonecurrf.getData().itemList.getHead();
				while(qonecurfilter != null) {
					
					sortitemfilter.add(qonecurfilter.getData());
					qonecurfilter = qonecurfilter.next;
				}
				break;
			}
			else {
				qonecurrf = qonecurrf.next;
			}
		}
		LinkedList<ItemNode> ansFF =	mergeSortobj.sort(sortitemfilter,new ItemDateComparator());
		
		return ansFF;
	}

	//!!!!!*****DO NOT MODIFY THIS METHOD*****!!!!!//
	public LinkedList<ItemNode> checkMergeSort() {
		LinkedList<ItemNode> retLst = mergeSortobj.getGlobalList();
		mergeSortobj.clearGlobalList();
		return retLst;
	}
	
	
//	public static void main(String args[]) throws IOException {
//		DriverCode.test();
//	}
}
