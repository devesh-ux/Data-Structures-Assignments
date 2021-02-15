package col106.assignment5;

import java.util.Comparator;

public class transactionfun implements Comparator<PurchaseNode> {

	@Override
	public int compare(PurchaseNode o1, PurchaseNode o2) {
		if(o1.dateobj.year>o2.dateobj.year) {
			return 1;
		}
		else if(o1.dateobj.year<o2.dateobj.year) {
			return -1;
		}
		else {
			if(o1.dateobj.month>o2.dateobj.month) {
				return 1;
			}
			else if(o1.dateobj.month<o2.dateobj.month) {
				return -1;
			}
			else {
				if(o1.dateobj.day>o2.dateobj.day) {
					return 1;
				}
				else if(o1.dateobj.day<o2.dateobj.day) {
					return -1;
				}
				else {
					 return 0;
				}
			}
		}	
	}

}
