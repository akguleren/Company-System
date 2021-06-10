
public class Department {
	private int departmentId;
	private String departmentName;
	//We are creating the constructors
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) throws Exception {
		if(departmentId < 0)
			throw new Exception("Department ID can't be zero or negative");
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) throws Exception {
		if(departmentName.length() < 3)
			throw new Exception("Department name must have at least 3 letters");
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}
