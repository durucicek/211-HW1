import java.io.IOException;

public class SalesQuery {
	Customer[] customers;
	static Supplier supplier1;
	Supplier supplier2;
	Supplier supplier3;
	static SalesManagement sales;
	
	
	
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
		
	// max product price 
	public static void getMostExpensiveProduct() {
	Sales maxSalesPrice = sales.getSales()[0][1];				//indexte problem olabilir
    for(int i=2; i<sales.getSales()[0].length; i++) {
        if(sales.getSales()[0][i].getSalesPrice()>=maxSalesPrice.getSalesPrice()) 
            maxSalesPrice=sales.getSales()[0][i];
    }
    
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.product.substring(1))].ID);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.product.substring(1))].title);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.product.substring(1))].rate);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.product.substring(1))].numberOfReviews);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxSalesPrice.product.substring(1))].price);
    System.out.println("----->" + " with sales price: " + maxSalesPrice.salesPrice);
    // 
    
   
    System.out.println();
    System.out.println();
    
	}
	    
    // max profit
	public static void getMostProfitableProduct() {
    Sales maxProfit = sales.getSales()[0][1];    
    for(int m=1; m<sales.getSales()[0].length; m++) {
    	if(sales.getSales()[0][m].getSalesPrice() - supplier1.getProducts()[Integer.parseInt(sales.getSales()[0][m].getProduct().substring(1))].getPrice() > 
    					maxProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(maxProfit.getProduct().substring(1))].getPrice())
    		maxProfit = sales.getSales()[0][m];
    	

    }
   
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.product.substring(1))].ID);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.product.substring(1))].title);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.product.substring(1))].rate);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.product.substring(1))].numberOfReviews);
    System.out.println(supplier1.getProducts()[Integer.parseInt(maxProfit.product.substring(1))].price);
    System.out.println("----->" + " most profit: " + (maxProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(maxProfit.product.substring(1))].price));
	//

    
    System.out.println();
	}
    
    // least profit product
	public static void getLeastProfitableProduct() {
	    Sales leastProfit = sales.getSales()[0][1];			
	    for(int n=1; n<sales.getSales()[0].length; n++) {
	    	if(sales.getSales()[0][n].getSalesPrice() - supplier1.getProducts()[Integer.parseInt(sales.getSales()[0][n].getProduct().substring(1))].getPrice() < 
	    				leastProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].getPrice()) {
	    		leastProfit = sales.getSales()[0][n];
	    	}
	    }
	   
   
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.product.substring(1))].ID);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.product.substring(1))].title);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.product.substring(1))].rate);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.product.substring(1))].numberOfReviews);
	    System.out.println(supplier1.getProducts()[Integer.parseInt(leastProfit.product.substring(1))].price);
	    System.out.println("----->" + " least profit: " + (leastProfit.getSalesPrice() - supplier1.getProducts()[Integer.parseInt(leastProfit.getProduct().substring(1))].getPrice()));
    //


    System.out.println();
    
	}
	
	
    // total profit    
	public static void getTotalProfit() {
    long total_profit = 0;
    for(int k=1; k<sales.getSales()[0].length; k++) {
    	total_profit += sales.getSales()[0][k].getSalesPrice() - supplier1.getProducts()[Integer.parseInt(sales.getSales()[0][k].getProduct().substring(1))].getPrice();
    }
    
    System.out.println("-----> total profit: " + total_profit);
    //
	
	    
	}
	    

}