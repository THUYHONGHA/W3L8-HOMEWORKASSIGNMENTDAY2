package problem1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Marketing> ma = new ArrayList<Marketing>();
		ma.add(new Marketing("Thuy Hong", "Laptop", 10000));
		ma.add(new Marketing("Test", "Desktop", 5000));
		ma.add(new Marketing("Test1", "Desktop", 800));
		ma.add(new Marketing("Hong", "Desktop", 80000));
		ma.add(new Marketing("Thuy", "Laptop", 19000));
		System.out.println(ma);
		ma.remove(1);
		System.out.println("Details of sale: \n" + ma);
		ma.set(0, new Marketing("Rose", "Laptop", 15000));
		System.out.println(ma);
		System.out.println(ma.size());
		Collections.sort(ma, Marketing.AMOUNT);
		System.out.println(ma);
		System.out.println(Marketing.AMOUNT.compare(ma.get(2), ma.get(3)));
		System.out.println(ma.get(2).equals(ma.get(3)));
		ma = Marketing.listMoreThan1000(ma);
		System.out.println(ma);
		Collections.sort(ma, Marketing.EMPLOYEENAME);
		System.out.println(ma);
		

	}

}
