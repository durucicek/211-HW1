
public class SalesManagement {
	private Sales[][] sales= new Sales[3][];
	
	public SalesManagement(Sales[] supplier1Sales, Sales[] supplier2Sales, Sales[] supplier3Sales) {
		sales[0] = supplier1Sales;
		sales[1] = supplier2Sales;
		sales[2] = supplier3Sales;
	}

		//copyleyip returnle
	public Sales[][] getSales() {
		return sales;
	}

	public void setSales(Sales[][] sales) {
		this.sales = sales;
	}
}
