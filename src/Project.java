
public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	
	public Project(String pName, java.util.Calendar startDate, String state) throws Exception {
		setProjectName(pName);
		setStartDate(startDate);
		setState(state);
	}
	public void setState(String state) throws Exception {	//We check the state and convert it to boolean from String.
		if(!state.equals("Open") && !state.equals("Close"))
			throw new Exception("Invalid state");
		if(state.equals("Open"))
			this.state = true;
		else if (state.equals("Close"))
			this.state = false;
		else
			System.out.println("Invalid state");
	}
	public String getState() {		//We check the boolean value of the state and convert it to String.
		String s;		
		if(state)
			s = "Open";
		else
			s = "Close";
		return s;
	}
	public void close() {
		state = false;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) throws Exception {
		if(projectName.length() < 3)
			throw new Exception("Project name must have at least 3 letters");
		if(projectName.equals(null))
			throw new Exception("Project name can't be null");
		this.projectName = projectName;
	}
	public java.util.Calendar getStartDate() {		
		return startDate;
	}
	public void setStartDate(java.util.Calendar startDate) {
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", startDate=" + Person.getDate(startDate) + ", state=" + state + "]";
	}

}
