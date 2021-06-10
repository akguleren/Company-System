
import java.util.ArrayList;
public class Customer extends Person {
	private ArrayList<Product> products;
	//We are creating the constructors here.
	public Customer(int id, String firstName, String lastName, String gender,java.util.Calendar birthDate, 
					String maritalStatus,String hasDriverLicence,ArrayList<Product> products) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;
	}
	//This constructor calls super class with the parameters that we got from person.
	public Customer(Person person, ArrayList<Product> products) throws Exception {
		super(person.getId(),person.getFirstName(), person.getLastName(),person.getGender(),person.getBirthDate(),person.getMaritalStatus(),person.getHasDriverLicence());
		this.products = products;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) throws Exception {
		if(products.contains(null))
			throw new Exception("Product array can't contain null values.");
		this.products = products;
	}
	@Override
	public String toString() {
		return "Customer id:" + getId() + " products=" + products + "]";
	}
			
}
