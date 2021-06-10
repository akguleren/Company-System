import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class Test {
	//The purpose of this system is to create a company system that can perform basic operations.
	public static void main(String[] args) throws Exception {
		//I create new ArrayList to hold each type of objects polymorphically.
		ArrayList<Department> departmentArray = new ArrayList<Department>();   
		ArrayList<Person> personArray = new ArrayList<Person>();
		ArrayList<Customer> customerArray = new ArrayList<Customer>();
		ArrayList<Project> projectArray = new ArrayList<Project>();
		ArrayList<Product> productArray = new ArrayList<Product>();
		ArrayList<RegularEmployee> regularEmpArray = new ArrayList<RegularEmployee>();
		ArrayList<SalesEmployee> salesEmpArray = new ArrayList<SalesEmployee>();
		ArrayList<Employee> employeeArray = new ArrayList<Employee>();
		ArrayList<Manager> managerArray = new ArrayList<Manager>();
		ArrayList<Developer> developerArray = new ArrayList<Developer>();
		//I declare the objects to use it later.
		Department department;
		Project project;
		Person person;
		Product product;
		Developer developer;
		RegularEmployee regularEmployee;
		SalesEmployee salesEmployee;
		Employee employee;
		Manager manager;
		Customer customer;
		
		File file = new File("input.txt");
		Scanner o = new Scanner(file);	 									//We create a scanner and giving input file to it.
			while(o.hasNext()) {	   										//We create a loop to read all the lines in the input file.
				String keyWord = o.next();									//We get the first word from beginning of each line and assign it to keyword.
					if(keyWord.equals("Department")) {						//We check the keyword.
						department = new Department(o.nextInt(), o.next());	//We create a new department.
						departmentArray.add(department);					//We add the new department to the array list.
					}
					else if(keyWord.equals("Project")) {											//We check the keyword.
						String pName = o.next();													
						project = new Project(pName, Person.setAndGetDate(o.next()), o.next());		//We create a new project object.
						projectArray.add(project);													//We add the new project to the array list.
					}
					else if(keyWord.equals("Person")) {																//We check the keyword.
						String fName = o.next();																	//In next lines we get the variables from scanner.
						String lName = o.next();
						int id = o.nextInt();
						String gender = o.next();
						Calendar bDate = Person.setAndGetDate(o.next());
						String maritalStatus = o.next();
						String hasDriverLicence = o.next();
						person = new Person(id, fName, lName, gender, bDate, maritalStatus, hasDriverLicence);		//We create a person object.
						personArray.add(person);																	//We add it to the array list.
				
					}
					else if(keyWord.equals("Product")) {											//We check the keyword.
						String productName = o.next();												//We get the variables from scanner and assign them to new variables.
						String saleDate = o.next();
						double price = o.nextDouble();
						product = new Product(productName, Person.setAndGetDate(saleDate), price);	//We create a new product with the variables that we got from scanner.
						productArray.add(product);													//We add the new product to array list.
					}
					else if(keyWord.equals("Developer")) {											//We check the keyword.
						ArrayList<Project> devProjectArray = new ArrayList<Project>();				//I declared this array list here because it will get reset every time we get in this if statement.
						int id = o.nextInt();
						for(int k = 0; k < projectArray.size(); k++) {
							//Since developer's number of projects can change we check if the next word is a keyword or not.
							if(o.hasNext("Department") || o.hasNext("Developer") || o.hasNext("Product") || o.hasNext("Project") || o.hasNext("Employee") || !o.hasNext() ||
								o.hasNext("Person") || o.hasNext("RegularEmployee") || o.hasNext("Manager") || o.hasNext("SalesEmployee") || o.hasNext("Customer"))
								break;
							String m = o.next();	//I'm not going to use o.next() directly in the next lines because it is in a for loop.It would cause some trouble.So i used a string.
							for(int j = 0; j < projectArray.size(); j++) {
								if(projectArray.get(j).getProjectName().equals(m)) { //I check if the names of projects are equal or not.
									devProjectArray.add(projectArray.get(j));		 //If they are equal i add the project in to the developer's project array.
									break;
								}
							}
						}
						for(int l = 0; l < regularEmpArray.size(); l++) {
							if(regularEmpArray.get(l).getId() == id) {
								developer = new Developer(regularEmpArray.get(l), devProjectArray); //After creating the dev's project array i create a new developer.
								developerArray.add(developer);										//I store the developer object in an array list.
								break;
							}
						}
					}	
					else if(keyWord.equals("Customer")) {									//We check the keyword.
						ArrayList<Product> customerProArray = new ArrayList<Product>();	    //I declared this array list here because it will get reset every time we get in this if statement.
						int id = o.nextInt();
						for(int k = 0; k < productArray.size(); k++) {
							//Since customer's number of products can change we check if the next word is a keyword or not.
							if(o.hasNext("Department") || o.hasNext("Developer") || o.hasNext("Product") || o.hasNext("Project") || o.hasNext("Employee") || !o.hasNext() ||
									o.hasNext("Person") || o.hasNext("RegularEmployee") || o.hasNext("Manager") || o.hasNext("SalesEmployee") || o.hasNext("Customer"))
									break;
								String m = o.next();										//I'm not going to use o.next() directly in the next lines because it is in a for loop.It would cause some trouble.So i used a string.
							for(int j = 0; j < productArray.size(); j++) {
								if(productArray.get(j).getProductName().equals(m)) {		//I check if the name of the products are equal or not.
									customerProArray.add(productArray.get(j));				//I add the product to the array list.
									break;
								}
							}
 						}
						for(int l = 0; l < personArray.size(); l++) {
							if(personArray.get(l).getId() == id) {							   //I check if the id's are equal or not.If they are i create new object with that person.
								customer = new Customer(personArray.get(l), customerProArray); //I created a new customer object
								customerArray.add(customer);								   //I store the customer object in an array list.
								break;
							}
						}
					}
					else if(keyWord.equals("RegularEmployee")) {				//We check the keyword.
						int id = o.nextInt();
						for(int k = 0; k < employeeArray.size(); k++) {
							if(employeeArray.get(k).getId() == id) {			//I check if the id's are equal or not.If they are i create new object with that employee.
								regularEmployee = new RegularEmployee(employeeArray.get(k), o.nextDouble());  //Created the new regular employee object.
								regularEmpArray.add(regularEmployee);		//I add the object to the array.
							}
						}
					}
					else if(keyWord.equals("SalesEmployee")) {			//We check the keyword.
						ArrayList<Product> sales = new ArrayList<Product>();	//We declared the array list here to make it empty every iteration.
						int id = o.nextInt();				
						for(int k = 0; k < regularEmpArray.size(); k++) {
							//Since the number of products that the sales employee sold can change, we check if the next word is the keyword or not.
							if(o.hasNext("Department") || o.hasNext("Developer") || o.hasNext("Product") || o.hasNext("Project") || o.hasNext("Employee") || !o.hasNext() ||
									o.hasNext("Person") || o.hasNext("RegularEmployee") || o.hasNext("Manager") || o.hasNext("SalesEmployee") || o.hasNext("Customer"))
									break;
							String m = o.next();
							for(int j = 0; j < projectArray.size(); j++) {
								if(productArray.get(j).getProductName().equals(m)) {
									sales.add(productArray.get(j));	//We add products that the sales employee sold to the sales array.
									break;
								}
							}
						}
						for(int l = 0; l < regularEmpArray.size(); l++) {
							if(regularEmpArray.get(l).getId() == id) {
								salesEmployee = new SalesEmployee(regularEmpArray.get(l), sales);	//We create the sales employee array.
								salesEmpArray.add(salesEmployee);									//We add the object to the sales employee array.
								break;
							}
						}
					}
					else if(keyWord.equals("Employee")) {		//We check the keyword.
						int m = 0;								//I declared this value here because i don't want to lose it after the end of the loop.
						int id = o.nextInt();
						double salary = o.nextDouble();
						String bDate = o.next();
						String depName = o.next();
						for(m = 0; m < departmentArray.size(); m++) {
							if(departmentArray.get(m).getDepartmentName().equals(depName))	//I get the department of the employee.
								break;
						}
						for(int l = 0; l < personArray.size(); l++) {
							if(personArray.get(l).getId() == id) {
								employee = new Employee(personArray.get(l), salary, Person.setAndGetDate(bDate), departmentArray.get(m)); //We create the object here.
								employeeArray.add(employee);		//We add object to the array.
								break;
							}
						}	
					}
					else if(keyWord.equals("Manager")) {		//We check the keyword.
						int id = o.nextInt();
						for(int l = 0; l < employeeArray.size(); l++) {
							if(employeeArray.get(l).getId() == id) {
								manager = new Manager(employeeArray.get(l), o.nextDouble());	//We create the object.
								managerArray.add(manager);			//We add the object to the array.
								break;
							}
						}	
					}
				}	
					o.close();				//Since we are done with the Scanner object we close it.
					//At this point we are done with the input reading section.
				for(int k = 0; k < managerArray.size(); k++) {
					for(int j = 0; j < regularEmpArray.size(); j++) {
						if(managerArray.get(k).getDepartment().getDepartmentName().equals(regularEmpArray.get(j).getDepartment().getDepartmentName())) {	//We get the manager of the department.
							managerArray.get(k).addEmployee(regularEmpArray.get(j));		//We add the regular employees to the manager's regular employee array.
						}
					}
				}	
				for(int k = 0; k < managerArray.size(); k++) {
					managerArray.get(k).distributeBonusBudget();	//We call distribute bonus budget method.
					managerArray.get(k).raiseSalary(0.2);			//We raise the salaries of managers by 0.2 percent.
				}
				for(int k = 0; k < developerArray.size(); k++) {
					developerArray.get(k).raiseSalary(0.23);		//We raise the salaries of developers by 0.23 percent.
				}
				for(int k = 0; k < salesEmpArray.size(); k++) {
					salesEmpArray.get(k).raiseSalary(0.18);			//We raise the salaries of sales employees by 0.18 percent.
				}
				for(int k = 0; k < regularEmpArray.size(); k++) {
					for(int l = 0; l < developerArray.size(); l++) {
						if(regularEmpArray.get(k).getId() == developerArray.get(l).getId()) {
							developerArray.get(l).setBonus(regularEmpArray.get(k).getBonus());   //We set the bonuses of developers.
						}
					}
				}
				for(int k = 0; k < regularEmpArray.size(); k++) {
					for(int l = 0; l < salesEmpArray.size(); l++) {
						if(regularEmpArray.get(k).getId() == salesEmpArray.get(l).getId()) {
							salesEmpArray.get(l).setBonus(regularEmpArray.get(k).getBonus());		//We set the bonuses for sales employees.
						}
					}
				}
				double maxSale = 0;
				double tempMaxSale = 0;
				for(int k = 0; k < salesEmpArray.get(0).getSales().size();k++) {
				maxSale += salesEmpArray.get(0).getSales().get(k).getPrice();			//We set a default value for maximum sale price.
				}
				SalesEmployee maxSaleEmp = salesEmpArray.get(0);							//We set a default object for sales employee that made the most valuable sales.
				for(int k = 0; k < salesEmpArray.size(); k++) {		
					for(int l = 1; l < salesEmpArray.get(k).getSales().size(); l++) {
						tempMaxSale = 0;
						tempMaxSale += salesEmpArray.get(k).getSales().get(l).getPrice();	//We set a temp value for max sale to compare it with current max sale.
					}
					if(tempMaxSale > maxSale)	{			//If there is a higher maximum sale price value we update the sales employee and max sale value.
						maxSaleEmp = salesEmpArray.get(k);
						maxSale = tempMaxSale;
					}	
				}
				maxSaleEmp.raiseSalary(1000);				//We raise the salary of the sales employee that made the most valuable sales.
				File outFile = new File("output.txt");		//We declare an output file.
				PrintWriter out = new PrintWriter(outFile);			//We declare the printWriter and give the output file to it.
				for(int k = 0; k < departmentArray.size(); k++) {	//We are starting to print information to file.
					int count = 0;
					out.println("\n*************************************************************************************\n");
					out.println(departmentArray.get(k).toString());		//We print the department.
					for(int l = 0; l < managerArray.size(); l++) {
						if(managerArray.get(l).getDepartment().equals(departmentArray.get(k))) {
							out.println(managerArray.get(l).toString());		//We print the manager of the department.
							for(int b = 0; b < personArray.size(); b++) {
								if(managerArray.get(l).getId() == personArray.get(b).getId()) {
									personArray.remove(b);						//After printing manager we remove it from person array. So we don't print it again at the end.
									break;
								}
							}
							for(int m = 0; m < developerArray.size(); m++) {
								if(managerArray.get(l).getDepartment().getDepartmentName().equals(developerArray.get(m).getDepartment().getDepartmentName())) {
									count++;						//We hold the value of different types of employees with variable count.
									out.print("\t" + count + ".");
									out.println(developerArray.get(m).toString());	//We print the developers.
									for(int n = 0; n < personArray.size(); n++) {
										if(developerArray.get(m).getId() == personArray.get(n).getId()) {
											personArray.remove(n);	//We remove the developer from the array.
											break;
										}
									}
									for(int n = 0; n < regularEmpArray.size(); n++) {
										if(developerArray.get(m).getId() == regularEmpArray.get(n).getId()) {
											regularEmpArray.remove(n);	//We also remove it from the regular employee array to get a correct output.
										}
									}
								}
							}
							for(int m = 0; m < salesEmpArray.size(); m++) {
								if(managerArray.get(l).getDepartment().getDepartmentName().equals(salesEmpArray.get(m).getDepartment().getDepartmentName())) {
									count++;
									out.print("\t" + count + ".");
									out.println(salesEmpArray.get(m).toString());	//We print sales employees here.
									for(int n = 0; n < personArray.size(); n++) {
										if(salesEmpArray.get(m).getId() == personArray.get(n).getId()) {
											personArray.remove(n);		//We remove the printed sales employee from the person array.
											break;
										}
									}
									for(int n = 0; n < regularEmpArray.size(); n++) {
										if(salesEmpArray.get(m).getId() == regularEmpArray.get(n).getId()) {
											regularEmpArray.remove(n);	//We remove the printed sales employee from the regular employees array.
											break;
										}
									}
								}
							}
							for(int m = 0; m < regularEmpArray.size(); m++) {
								if(managerArray.get(l).getDepartment().getDepartmentName().equals(regularEmpArray.get(m).getDepartment().getDepartmentName())) {
									count++;
									out.print("\t" + count + ".RegularEmployee\n");
									out.println(regularEmpArray.get(m).toString());		//We print the regular employees of the department.
									for(int n = 0; n < personArray.size(); n++) {
										if(regularEmpArray.get(m).getId() == personArray.get(n).getId())
											personArray.remove(n);			//We remove the printed regular employees from person array.
									}
								}
							}
						}
					}
				}
				out.println("\n**************************************CUSTOMERS**************************************\n");
				for(int k = 0; k < customerArray.size(); k++) {
					out.println(customerArray.get(k).toString());		//We print customers here.
					for(int n = 0; n < personArray.size(); n++) {
						if(customerArray.get(k).getId() == personArray.get(n).getId())
							personArray.remove(n);					//We remove them from person array.
					}
				}
				out.println("\n***************************************PEOPLE****************************************\n");
				for(int k = 0; k < personArray.size(); k++) {
					out.println(personArray.get(k).toStringFull());			//We print the full information about the rest of the people.
				}		
				out.close();		//We close the printWriter to save the outputs to the file.
		}		
	}