
public class Employee extends Person {
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public int numberOfEmployees;
	
	//We are creating 2 constructors. First one gets all parameters for person, second one gets a person object and rest of the variables.
	public Employee(int id, String firstName, String lastName, String gender,java.util.Calendar birthDate, String maritalStatus, 
					String hasDriverLicence, double salary, java.util.Calendar hireDate, Department department) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		setDepartment(department);
		setHireDate(hireDate);
		setSalary(salary);
		numberOfEmployees++; //We increment the value of numberOfEmployees every time when a constructor is invoked.
	}
	//Through the person object we get other variables.
	public Employee(Person person, double salary, java.util.Calendar hireDate, Department department) throws Exception {
		super(person.getId(),person.getFirstName(), person.getLastName(),person.getGender(),person.getBirthDate(),person.getMaritalStatus(),person.getHasDriverLicence());
		setDepartment(department);
		setHireDate(hireDate);
		setSalary(salary);
		numberOfEmployees++; //We increment the value of numberOfEmployees every time when a constructor is invoked.
	}
	
	public double raiseSalary(double percent) throws Exception {
		if(percent > 1  || percent < 0)
			throw new Exception("Percent value can't be bigger than 1 or less than 0");
		salary += percent * salary; 
		return salary;
	}
	public double raiseSalary(int amount) throws Exception {
		if(amount < 0)
			throw new Exception("The raise amount can't be negative");
		salary += amount;
		return salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws Exception {
		if(salary < 0)
			throw new Exception("Salary value can't be negative");
		this.salary = salary;
	}

	public java.util.Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) throws Exception {
		if(department.equals(null))
			throw new Exception("Department object can't be null");
		this.department = department;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) throws Exception {
		if(numberOfEmployees < 0)
			throw new Exception("Number of employees can't be negative");
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "\t\tEmployee Info [salary=" + salary + ", hireDate=" + Person.getDate(hireDate) + "]";
				 
	}
				
			

}
