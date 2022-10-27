
public class Sales {
	String ID;
	String costumer;
	String product;
	String salesDate;
	double salesPrice;
	
	public Sales(String ID, String costumer, String product, String salesDate) {
		this.ID = ID;
		this.costumer = costumer;
		this.product = product;
		this.salesDate = salesDate;
	}
	
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public static Sales[] salesArrayMaker(String[][] array) {
		Sales[] salesArray = new Sales[array.length];
		for (int i = 1; i < array.length; i++) {
			salesArray[i] = new Sales(array[i][0],array[i][1],array[i][2],array[i][3]);
		}
		return salesArray;
	}
	
	public String getProduct() {
		return product;
	}
	
	//copyleyip returnle
	public double getSalesPrice() {
		return salesPrice;
	}
	
	
	public static Sales[] setSalesPriceArray (Product[] productArray, Sales[] salesArray, double[] salesPriceArray) {
		for(int i = 1; i < salesArray.length; i++) {
			String salesProductID = salesArray[i].getProduct();
			//System.out.println(salesProductID);
			for(int x = 1; x < productArray.length; x++) {
				if(productArray[x]!=null) {
					String productID = productArray[x].getID();
					if(salesProductID != null && productID != null && salesProductID.equals(productID)) {
						salesArray[i].setSalesPrice(salesPriceArray[x]);
						System.out.println(salesArray[i].getSalesPrice());
					}
				}
			}
		}
		
		return salesArray;
	}
	

	
}
