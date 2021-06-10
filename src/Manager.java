
import java.util.ArrayList;
public class Manager extends Employee {
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>(); //We declare the arraylist.
	private ArrayList<Manager> managerArray;
	private double bonusBudget;
	//We are creating the constructors.
	public Manager(int id, String firstName, String lastName, String gender,java.util.Calendar birthDate, String maritalStatus, 
			String hasDriverLicence, double salary, java.util.Calendar hireDate, Department department, double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		this.bonusBudget = bonusBudget;
	}
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(),
				employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	public void removeEmployee(Employee e) {
		regularEmployees.remove(e);
	}
	public void distributeBonusBudget() throws Exception {
		double total = 0;
		double unit;
		for(int i = 0; i < regularEmployees.size(); i++) {
			total += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
		}
		unit = bonusBudget / total;
		for(int i = 0; i < regularEmployees.size(); i++) {
			double bonus = unit * regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
			regularEmployees.get(i).setBonus(bonus); //After making the calculations we set the bonus for each regular employee.
		}
	}
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) throws Exception {
		if(regularEmployees.equals(null))
			throw new Exception("Regular employee array can't contain null objects");
		this.regularEmployees = regularEmployees;
	}
	public double getBonusBudget() {
		return bonusBudget;
	}
	public void setBonusBudget(double bonusBudget) throws Exception {
		if(bonusBudget < 0)
			throw new Exception("Bonus budget can't be negative");
		this.bonusBudget = bonusBudget;
	}
	public ArrayList<Manager> getManagerArray() {
		return managerArray;
	}
	public void setManagerArray(ArrayList<Manager> managerArray) throws Exception {
		if(managerArray.contains(null))
			throw new Exception("Manager array can't contain null objects");
		this.managerArray = managerArray;
	}
	public String toString() {
		return "Manager [id: " + getId()  + ", " + getFirstName() + " " +getLastName() + " # of Employees " + regularEmployees.size() + "]";
	}
			
}
