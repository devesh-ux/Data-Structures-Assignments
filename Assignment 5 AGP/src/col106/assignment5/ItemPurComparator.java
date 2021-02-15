package col106.assignment5;

import java.util.Comparator;

public class ItemPurComparator implements Comparator<ItemNode> {

	@Override
	public int compare(ItemNode o1, ItemNode o2) {
		// TODO Auto-generated method stub
		if(o1.calcmain>o2.calcmain) {
			return 1;
		}
		else if(o1.calcmain<o2.calcmain) {
			return -1;
		}
		else {
			int comparison = 0;
            comparison = o1.getItemName().compareTo(o2.getItemName());
            return 0-comparison;
		}
	}

}
