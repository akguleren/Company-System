import java.util.Calendar;
public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;
	
	public Person (int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus, String hasDriverLicence) throws Exception {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		setMaritalStatus(maritalStatus);  //We use set methods for the next 3 variables to convert them from Strings to byte or Strings to boolean.
		setHasDriverLicence(hasDriverLicence);
		setGender(gender);
	}
	public void setGender(String gender) throws Exception {	//We check the strings. We assign the values to the variable depending on the strings.
		if(!gender.equals("Man") && !gender.equals("Woman"))
			throw new Exception("Invalid gender");
		if(gender.equals("Man"))
			this.gender = 2;
		else if (gender.equals("Woman"))
			this.gender = 1;
		else
			System.out.println("Invalid gender");
	}
	public String getGender() {
		String gen;
		if(gender == 1 || gender == 1) //We check the values. We assign Strings to variable 'gen' depending on the strings.
			gen = "Woman";
		else
			gen = "Man";
		
		return gen;
	}
	public void setMaritalStatus(String status) throws Exception {  //We check the strings. We assign the values to the variable depending on the strings.
		if(!status.equals("Single") && !status.equals("Married"))
			throw new Exception("Invalid status");
		if(status.equals("Single"))			
			maritalStatus = 1;
		else if (status.equals("Married"))
			maritalStatus = 2;
		else
			System.out.println("Invalid status");
	}
	public String getMaritalStatus() { //We check the values. We assign Strings to variable 'status' depending on the strings.
		String status;
		if(maritalStatus == 1)
			status = "Single";
		else
			status = "Married";
		return status;
	}
	public void setHasDriverLicence(String info) throws Exception { //We check the strings. We assign the values to the variable depending on the strings.
		if(!info.equals("Yes") && !info.equals("No"))
			throw new Exception("Invalid licence info");
		if(info.equals("Yes"))
			hasDriverLicence = true;
		else if (info.equals("No"))
			hasDriverLicence = false;
		else
			System.out.println("Invalid info");
	}
	public String getHasDriverLicence() { //We check the values. We assign Strings to variable 'License' depending on the strings.
		String License;
		if(hasDriverLicence)
			License = "Yes";
		else
			License = "No";
		return License;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) throws Exception {
		if(id < 0)
			throw new Exception("ID value can't be negative");
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws Exception {
		if(firstName.length() < 3)
			throw new Exception("First name's length can't be less than 3");
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws Exception {
		if(lastName.length() < 3)
			throw new Exception("Last name's length can't be less than 3");
		this.lastName = lastName;
	}
	public java.util.Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}
	public static Calendar setAndGetDate(String date) { //I add this methods to convert date which is in string format to Calendar.
		Calendar cal = Calendar.getInstance();
		String[] newDate = date.split("/");
		cal.set(Integer.parseInt(newDate[2]),Integer.parseInt(newDate[1]), Integer.parseInt(newDate[0]));
		return cal;
	}
	public static String getDate(Calendar date) { //I add this method to get a date format from a variable that is in Calendar format.
		return date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR);
	}
	@Override
	public String toString() {
		return "\t\tPerson Info [id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", gender: " + getGender() + "]";	
	}
	public String toStringFull() { //I created this method to get all the information about person.
		return "Person Info [id: " + id + ", firstName: " + firstName + ", lastName: " + lastName + ", gender: " + getGender() + ", birthDate: " + 
				birthDate.get(Calendar.DAY_OF_MONTH) + "/" + birthDate.get(Calendar.MONTH) + "/" + birthDate.get(Calendar.YEAR) + 
				", maritalStatus: " + getMaritalStatus() + ", hasDriverLicence: " + getHasDriverLicence() +"]";
				
	}
	
}
