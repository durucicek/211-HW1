import java.io.IOException;

public class SalesQuery {
	Customer[] customers;
	Supplier supplier1;
	Supplier supplier2;
	Supplier supplier3;
	SalesManagement sales;
	
	
	
	//Initializes everything
	public SalesQuery() throws IOException {
		Customer [] customers = FileIO.getCustomers();
		this.customers = customers;
		Product[] s1_productArray = FileIO.getProductsforSuppilerOne();
		Product[] s2_productArray = FileIO.getProductsforSuppilerTwo();
		Product[] s3_productArray = FileIO.getProductsforSuppilerThree();
		supplier1 = new Supplier(s1_productArray);
		supplier2 = new Supplier(s2_productArray);
		supplier3 = new Supplier(s3_productArray);
		Sales[] s1_salesArray = FileIO.getSalesforSuppilerOne(s1_productArray);
		Sales[] s2_salesArray = FileIO.getSalesforSuppilerOne(s2_productArray);
		Sales[] s3_salesArray = FileIO.getSalesforSuppilerOne(s3_productArray);
		sales = new SalesManagement(s1_salesArray, s2_salesArray, s3_salesArray);
	}
	
}
