
public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	//We are creating constructors here.
	public Product(String sName, java.util.Calendar sDate, double price) throws Exception {
		setProductName(sName);
		setSaleDate(sDate);
		setPrice(price);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) throws Exception {
		if(productName.length() < 3)
			throw new Exception("Product name must have at least 3 letters");
		this.productName = productName;
	}

	public java.util.Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if(price < 0)
			throw new Exception("Price value can't be negative");
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", transactionDate=" + Person.getDate(saleDate) + ", price=" + price + "]";
	}

}
