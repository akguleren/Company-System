
public class RegularEmployee extends Employee {
	private double performanceScore;
	private double bonus;
	//We are creating the constructors.
	public RegularEmployee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus,
							String hasDriverLicence, double salary, java.util.Calendar hireDate, Department department, double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setPerformanceScore(performanceScore);
	}
	public RegularEmployee(Employee employee, double perfScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(),
				employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setPerformanceScore(perfScore);
	}
	public double getPerformanceScore() {
		return performanceScore;
	}
	public void setPerformanceScore(double performanceScore) throws Exception {
		if(performanceScore < 0)
			throw new Exception("Performance score can't be negative");
		this.performanceScore = performanceScore;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) throws Exception {
		if(bonus < 0)
			throw new Exception("Bonus value can't be negative");
		bonus = Math.round(bonus * 100.00) / 100.00; //I did this operation to get 2 digits after decimal point.
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return super.toString() + "\n" + "\t\tRegularEmployee Info [performanceScore=" + performanceScore + ", bonus=" + bonus + "]";
	}
	
	
}
