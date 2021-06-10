
import java.util.ArrayList;
public class Developer extends RegularEmployee {
	private ArrayList<Project> projects;
	public static int numberOfDevelopers;
	//We are creating the constructors
	public Developer(int id, String firstName, String lastName, String gender,java.util.Calendar birthDate, String maritalStatus,
					String hasDriverLicence,double salary, java.util.Calendar hireDate, Department department, double pScore, ArrayList<Project> p) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		projects = p;
		numberOfDevelopers++; //We are increasing the number of developers every time when a constructor is invoked.
	}
	//We are giving a regular employee to the constructor and calling super class' constructor with the parameters we got from regular employee.
	public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
		super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender(),re.getBirthDate(),re.getMaritalStatus(),re.getHasDriverLicence(),
				re.getSalary(),re.getHireDate(), re.getDepartment(),re.getPerformanceScore());
		projects = p;
		numberOfDevelopers++; //We are increasing the number of developers every time when a constructor is invoked.
	}
	public boolean addProject(Project s) {
		return projects.add(s);
	}
	public boolean removeProject(Project s) {
		for(int k = 0; k < projects.size(); k++) {
			if(projects.get(k).getProjectName().equals(s.getProjectName())) {	//We check if the names of projects matches or not.
				projects.remove(k);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) throws Exception {
		if(projects.contains(null))
			throw new Exception("Projects can't contain null objects");
		this.projects = projects;
	}
	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}
	public static void setNumberOfDevelopers(int numberOfDevelopers) throws Exception {
		if(numberOfDevelopers < 0)
			throw new Exception("Number of developers can't be negative");
		Developer.numberOfDevelopers = numberOfDevelopers;
	}
	@Override
	public String toString() {
		return "Developer" + "\n" + super.toString() + "\n\t\t" + projects.toString();
	}

}
