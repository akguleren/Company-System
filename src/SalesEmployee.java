
import java.util.ArrayList;
public class SalesEmployee extends RegularEmployee {
	private ArrayList<Product> sales;
	public static int numberOfSalesEmployees;
	//We are creating the constructors.
	public SalesEmployee (int id, String firstName, String lastName, String gender,java.util.Calendar birthDate, String maritalStatus,
			 			String hasDriverLicence,double salary, java.util.Calendar hireDate, Department department, double pScore, ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		setSales(s);
	}
	public SalesEmployee (RegularEmployee re, ArrayList<Product> s) throws Exception	{
		super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender(),re.getBirthDate(),re.getMaritalStatus(),re.getHasDriverLicence(),
				re.getSalary(),re.getHireDate(), re.getDepartment(),re.getPerformanceScore());
		setSales(s);
	}
	public boolean addSale(Product s) {
		return sales.add(s);
	}
	public boolean removeSale(Product s) throws Exception {
		if(!sales.contains(s))
			throw new Exception("Product doesn't in the array");
		return sales.remove(s);
	}
	public ArrayList<Product> getSales() {
		return sales;
	}
	public void setSales(ArrayList<Product> sales) throws Exception {
		if(sales.contains(null))
			throw new Exception("Sales array can't contain null values");
		this.sales = sales;
	}
	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}
	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) throws Exception {
		if(numberOfSalesEmployees < 0)
			throw new Exception("Number of sales employees can't be negative");
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
	}
	@Override
	public String toString() {
		return "SalesEmployee\n" + super.toString() + "\n\t\t" + sales + "]";
	}
	
}
