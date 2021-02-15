package col106.assignment5;

import java.util.Comparator;

public class ItemLastDateComparator implements Comparator<ItemNode> {

	@Override
	public int compare(ItemNode o1, ItemNode o2) {
		if(o1.yearhi>o2.yearhi) {
			return 1;
		}
		else if(o1.yearhi<o2.yearhi) {
			return -1;
		}
		else {
			if(o1.monthi>o2.monthi) {
				return 1;
			}
			else if(o1.monthi<o2.monthi) {
				return -1;
			}
			else {
				if(o1.dayhi>o2.dayhi) {
					return 1;
				}
				else if(o1.dayhi<o2.dayhi) {
					return -1;
				}
				else {
					 int comparison = 0;
			            comparison = o1.getItemName().compareTo(o2.getItemName());
			            return 0-comparison;
				}
			}
		}	
	}
}
