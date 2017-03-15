package problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Marketing {
	String employeeName;
	String productName;
	double salesAmount;

	public Marketing(String employeeName, String productName, double salesAmount) {
		this.employeeName = employeeName;
		this.productName = productName;
		this.salesAmount = salesAmount;
	}

	Marketing(){}
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String toString() {
		return "Employee Name: " + employeeName + " Product Name: " + productName + " Sales Amount: " + salesAmount
				+ "\n";
	}

	
	public static final Comparator<Marketing> AMOUNT= new Comparator<Marketing>() {
		public int compare(Marketing o1, Marketing o2) {
		if (o1.salesAmount > o2.salesAmount)
			return 1;
		if (o1.salesAmount < o2.salesAmount)
			return -1;
		if (o1.productName.equals(o2.productName)){
			if(o1.employeeName.equals(o2.employeeName))
				return 0;
			return 2;
		}
		return 3;		
	}
	};
	

	public static final Comparator<Marketing> EMPLOYEENAME = new Comparator<Marketing>() {
		public int compare(Marketing o1, Marketing o2){			
			if(o1.getEmployeeName().compareToIgnoreCase(o2.getEmployeeName())>0) return 1;
			if(o1.getEmployeeName().compareToIgnoreCase(o2.getEmployeeName())<0) return -1;
			if(o1.getEmployeeName().equalsIgnoreCase(o2.getEmployeeName())){
				if(o1.getProductName().equals(o2.getProductName())){
					if(o1.getSalesAmount()==o2.getSalesAmount())
						return 3;
				}
				return 2;
			}
			return 0;
		}
	};
	public boolean equals(Object ob) {
		if (ob == null) {
			return false;
		}
		if (ob.getClass() != this.getClass())
			return false;
		Marketing ma = (Marketing) ob;
		boolean isEqual = ma.salesAmount == this.salesAmount && ma.productName.equals(this.productName)
				&& ma.employeeName.equals(this.employeeName);
		return isEqual;
	}
	
	public static List<Marketing> listMoreThan1000(List<Marketing> list){ 		
		List<Marketing> malist= new ArrayList<Marketing>();
		for(Marketing ma: list){
			if(ma==null||list==null) return null;
			if(ma.getSalesAmount()>1000)
				malist.add(ma);
		}
		return malist;
	} 

}
