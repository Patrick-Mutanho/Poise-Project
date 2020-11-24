package com.poised.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Poised Project
 * This is project management software
 * 
 * @author Patrick Mutanho
 * @version 1, 11 Nov 2020
 */

public class Main {
	
	//Main application method
	public static void main(String[] args) {
		 /**
		    * <p>
		    * The main method where the control of the program is determined
		    * @param fileObjectList String Array list object which stores project objects data in string format
		    * @param projectList Array list object which stores all project objects created
		    * @param projectDataString  String object which stores objects information with special characters within the string
		    * @param processedString String Array which stores project objects information as individual strings
		    * @since version 1.00
		    */
		
		ArrayList<String> fileObjectList = new ArrayList<String>();
		ArrayList<Project> projectList = new ArrayList<Project>();
		String projectDataString = null;
		String[] processedString = null;
		
		// read information from the text file and stores it in the fileObjectList ArrayList
		fileObjectList = readFile();
		
		//Iterate over each element in the fileObjectList
		for (int i =0; i < fileObjectList.size(); i++) {
			
			//store each line in the text file in  projectDataString 
			projectDataString = fileObjectList.get(i);
			
			// separate the data in projectDataString in a array
			processedString = projectDataString.split("#");
			
			// Create client object for the particular project object currently stored in fileObjectList.get(i)
			Person client = new Person (processedString[11],processedString [15],processedString [14],processedString [13], processedString [12]);
		    
			// Create architect object for the particular project object currently stored in fileObjectList.get(i)
			Person architect = new Person (processedString[16],processedString [20],processedString [19],processedString [18], processedString [17]);
			
			//Create contractor object for the particular project object currently stored in fileObjectList.get(i)
			Person contractor = new Person (processedString[21],processedString [25],processedString [24],processedString [23], processedString [22]);
			
			//Create project object for the particular project object currently stored in fileObjectList.get(i)
			Project newProject = new Project(Double.parseDouble(processedString[2]), Double.parseDouble(processedString[4]), Double.parseDouble(processedString[10])
					, 0, Double.parseDouble(processedString[9]), 
					processedString[0], processedString[1], processedString[8],processedString[11] ,
					processedString[5], processedString[6], processedString[7],client,architect , contractor);
			
			//Add the project object to a Project ArrayList
			projectList.add(newProject);
		}
		
		int count = -1;
		
		//While loop ensures program keeps running until user decides to exit
		while(count < 0) {
			
			//display main menu
			displayMenu();
			
			//get user input from user in response to the menu
			int userResponse = userMenuReponse();
			
			// Switch statement to control program flow and select what the user wants to do
			switch(userResponse) {
			
			case 1:
				
				//Adds new project
				Project newProject = createProjectObject();
				projectList.add(newProject);
				break;
				
			case 2:
				
				//updates a existing project
				projectList = updateProject(projectList);
				break;
			    
			case 3:
				
				//Displays uncompleted projects
				displayUncompleteProjects(projectList);
				break;
				
			case 4:
				
				//finalizes a project
				projectList = finalizeProject(projectList);
				break;
			    
			case 5:
				
				//displays overdue projects
				findOverdueProjects(projectList);
				break;
				
			case 6:
				
				//exits the program 
				count =1;
				System.out.print("The Data has been saved");
			
			}
				
	    //writeToFile (projectList);
			//writes new data to file
			write(projectList);
	    
		}
	}

	/**
	 * <p>
	  * The Method reads file which contains project data
	  * @param list ArrayList which stores project object data on each line of the file
	  * @return The method returns an ArrayList of type String which contains project object data on each line of the file as an element of the ArrayList
	  * @since version 1.00
	  */
public static ArrayList<String> readFile() {
	
	/**
	  * The Method reads file which contains project data
	  * @param list ArrayList which stores project object data on each line of the file
	  * @return The method returns an ArrayList of type String which contains project object data on each line of the file as an element of the ArrayList
	  * @since version 1.00
	  */
	
	ArrayList<String> list = new ArrayList<String>();
	try {
		
		File x = new File ("C:\\Users\\Patrick\\eclipse-workspace\\PoiseFinalProject\\src\\output.txt");
		Scanner scan = new Scanner (x);
		//read out everything in the file to a list
		while (scan.hasNext()) {
		    list.add(scan.nextLine());
		}
	}
	catch( FileNotFoundException e) {
		
		System.out.println ( "Could not open File" );
		
	}
	
	return list;	
}

/**
 * The Method displays menu options of the operations the user can perform in the program
 * @since version 1.00
 */
private static void displayMenu() {
	
	
	System.out.println ("Select from the options below \n"
			+ "1->Add New Project \n"
			+ "2->Update Existing Project\n"
			+ "3->See list of Uncompleted Projects\n"
			+ "4->Finalize Project \n"
			+ "5->See list of Overdue Projects \n"
			+ "6->Quit \n");
			
	System.out.println();
	
	}

/**
 * The Method reads file which contains project data
 * @param  userInput Integer variable which is set to the value corresponding to an operation on the menu 
 * @return The method returns an integer which corresponds to an operation on the menu which the user selecte
 * @since version 1.00
 */
private static int userMenuReponse() {
	
	int userInput = 0;
	Scanner response = new Scanner (System.in);
		
		try {
			
			userInput  = response.nextInt();
			response.nextLine();
		}
		catch(NoSuchElementException | NumberFormatException e ) {
			System.out.println("Please enter numeric value between 1-5 to select option from menu: ");
	    	response.next();
	    	response.nextLine();
		}
	     
	if (userInput == 1 || userInput == 2 || userInput == 3 ||
		userInput == 4 || userInput == 5 || userInput == 6 ) {
	}
	
	else {
		System.out.println ("TRY AGAIN!!.... ");
	 }
	
	return userInput;
	
}

/**
 * The method create a Person object
 * @return The method returns a Project object
 * @see Person Detail in Person Object
 * @since version 1.00
 */
private static Person createPersonObject() {
	
	Scanner response = new Scanner (System.in);
	String personName = null ,personPhysicalAdress = null,personEmailAdress = null, personProfession = null;
	String personTelephoneNumber = null;	
	
	try {
		
	    //initialize and define all variables the Person object
		System.out.println ("Enter the name : ");
		personName= response.nextLine();
		    
		System.out.println ("Enter profession: ");
		personProfession = response.nextLine();	
		    
	    System.out.println ("Enter Physical Address: ");
		personPhysicalAdress = response.nextLine();	
		    
		System.out.println ("Enter the Email Adress: ");
		personEmailAdress = response.nextLine();	
		    
		System.out.println ("Enter the Telephone Number : ");
		personTelephoneNumber  = response.nextLine();
		  
	    }
	    
	catch(NoSuchElementException | NumberFormatException e ) {
	    System.out.println("Please provide input: ");
	    response.next();
	    response.nextLine();
	    }
	
	//Instantiate a Person Object
	Person personObject = new Person (personName, personTelephoneNumber,  personPhysicalAdress ,
			personEmailAdress, personProfession);
	
	return personObject;
	
	}

/**
 * The method create a Project object
 * @return The method returns a Project object
 * @see Person Detail in Person Object
 * @since version 1.00
 */

private static Project createProjectObject() {
	
	double projectNumber = 0,erfNumber = 0, chargeFee = 0,amountPaid = 0;
	String projectName = null,buildingType = null, siteAdrress = null, startDate = null, 
	completeDate = null, deadlineDate = null, projectStatus = null, deadline =null;
	Person client, architect, contractor;
	
	Scanner response = new Scanner (System.in);
	
	// create a Person object
	System.out.println("Enter Clients details:");
    client = createPersonObject();
		 
	System.out.println("\n");
		 
	System.out.println("Enter Architects details:");
	architect = createPersonObject();
		   
	System.out.println("\n");
			 
	System.out.println("Enter Contractors details:");
	contractor = createPersonObject(); 
	
	System.out.println("\n");
	
	try {
		
		//initialize variables for the Person class
		System.out.println("Enter Project Name: ");
		projectName = response.nextLine();
					
		System.out.println("Enter Building Type: ");
		buildingType = response.nextLine();
					
		System.out.println("Enter Site Address: ");
		siteAdrress = response.nextLine();
				    
	    System.out.println ("Enter Start Date: ");
	    System.out.println("Enter new Completion Date (yyyy-mm-dd): ");
		startDate = response.nextLine();
	    
		System.out.println ("Enter Project Status : ");
		projectStatus = response.nextLine();
		
		System.out.println ("Enter Deadline Date: ");
		System.out.println("Enter new Completion Date (yyyy-mm-dd): ");
		deadline = response.nextLine();
				 
		System.out.println ("Enter Complete Date: ");
		System.out.println("Enter new Completion Date (yyyy-mm-dd): ");
		completeDate =  response.nextLine();
			
	}
	
	catch(NoSuchElementException | NumberFormatException e ) {
		
		System.out.println("Please enter a string input only: ");
    	response.next();
    	response.nextLine();
		
		}
			
	try {
		System.out.println ("Enter Project Number: ");
		projectNumber = response.nextDouble();
		response.nextLine();
							    
		System.out.println ("Enter ERF Number: ");
		erfNumber = response.nextDouble();
		response.nextLine();
							    
		System.out.println ("Enter Charge Fee: ");
		chargeFee = response.nextDouble();
		response.nextLine();
					
		System.out.println ("Enter Amount Paid : ");
		amountPaid = response.nextDouble();
		response.nextLine();
				
		}
	catch(NoSuchElementException | NumberFormatException e ) {
		 System.out.println("Please enter a numeric input only, please: ");
		 response.next();
	     response.nextLine();	
				}
	
	Project newProject = new Project(projectNumber, erfNumber,
		 chargeFee, amountPaid,
		 amountPaid, projectName, 
		 buildingType, siteAdrress, startDate, 
		 completeDate, deadlineDate, projectStatus, 
		 client, architect, contractor );
	
    return newProject;
}

/**
 * The method create a Project object
 * <p>
 * The method create a Project object
 * @param projectList Array list that contains all the project objects
 * @return The method returns a Project object
 * @see Person Detail in Person Object
 * @since version 1.00
 */

public static ArrayList<Project> updateProject(ArrayList<Project> projectList) {
	/**
	 * The method create a Project object
	 * @param projectList Array list that contains all the project objects
	 * @return The method returns a Project object
	 * @see Person Detail in Person Object
	 * @since version 1.00
	 */
	int count = -1;
	String projectCompleteDate;
	String projectStatus;
	String deadlineDate;
	double amountPaid;
	//Loop to keep the program running until the user decides to quit
	while (count < 0) {
		
	    Scanner response = new Scanner(System.in);
	    String userInput;
	    
	    // Display menu of operations available
		System.out.print("Please select what you would like to update: \n"
					+ "1->Completion Date \n"
					+ "2->Status of Project \n"
					+ "3->Project Deadline \n"
					+ "4->Amount Paid \n"
					+ "5->Quit \n");
		
		int userResponse = userMenuReponse();
		
		//option 5 to quit
		if (userResponse == 5) {
			
			break;
			
		}
		
		else {
			
			System.out.println("Enter name of project you would like to change:  ");
			userInput = response.nextLine();
			
		}
		
		//search for project and change the desired parameter
		for (int i = 0; i < projectList.size(); i++) {
			
			if ( projectList.get(i).getProjectName().equals(userInput)) {
					
			switch(userResponse) {
					
			case 1:
				
				try {
					
					System.out.println("Enter new Completion Date (yyyy-mm-dd): ");
					projectCompleteDate = response.nextLine();
					projectList.get(i).setCompleteDate(projectCompleteDate);
					
				}
				catch(NoSuchElementException | NumberFormatException e ) {
					System.out.println("Please provide input: ");
				    response.next();
				    response.nextLine(); 
							}
			break;		
			case 2:
						
				try {
					
					System.out.println("Enter new Status of project, Please enter yes or no: ");
					projectStatus = response.nextLine(); 
					projectList.get(i).setProjectStatus(projectStatus);
					
				}
				catch(NoSuchElementException | NumberFormatException e ) {
					
					System.out.println("Please provide input: ");
					response.next();
					response.nextLine(); 
					
					     }
			break;	
			case 3:
				
				try {
					
					System.out.println("Enter new Deadline date Date  (yyyy-mm-dd): ");
					deadlineDate  = response.nextLine();
					projectList.get(i).setDeadlineDate(deadlineDate); 
					
				}
				catch(NoSuchElementException | NumberFormatException e ) {
					
					System.out.println("Please provide input: ");
					response.next();
					response.nextLine(); 
					
							}
			
			break;
			case 4:
						
				try {
					
					System.out.println("Enter new amount paid: ");
					amountPaid = response.nextDouble(); 
					projectList.get(i).setAmountPaid(amountPaid); 
					
							}
				
				catch(NoSuchElementException | NumberFormatException e ) {
					System.out.println("Please provide input: ");
					response.next();
					response.nextLine(); 
							}
			break;
			case 5:
				
				count = -1;
				System.out.print("Project Data has been updated");
						}
							
					}
			
					}
		}
	return projectList;
}

/**
 * @param projectList Array list that contains all the project objects
 * The method displays uncompleted projects
 * @since version 1.00
 */
public static void displayUncompleteProjects(ArrayList<Project> projectList) {
	
	
	for (int i = 0; i < projectList.size(); i++ ) {
	
		
		if ( projectList.get(i).equals("no")) {
			
			System.out.println("The following projects are incomplete: ");
			
			System.out.println(projectList.get(i).getProjectName());
			
		}
    }

}

/**
 * <p>
 * @param projectList Array list that contains all the project objects
 * The method performs operations to finalize details of a project
 * @return projectList The method returns a ArrayList  which contain project list objects that have been updated
 * @since version 1.00
 */

public static ArrayList<Project> finalizeProject(ArrayList<Project> projectList) {
	
	
	
	Scanner response = new Scanner(System.in);
	System.out.println("Enter name of project you want to finalize:  ");
	String userInput = response.nextLine();
		
	for (int i = 0; i < projectList.size(); i++) {
		
		//Search for project which the user would like to update
		if ( projectList.get(i).equals(userInput)) {
			
			//Check to see if there is an outstanding balance
			double invoiceAmount = projectList.get(i).getAmountPaid() - projectList.get(i).getChargeFee();
				
			if (invoiceAmount>0) {
			
			// Mark project as uncompleted
			System.out.println ("The invoice amount is: R"+ invoiceAmount );
			projectList.get(i).setProjectStatus("no");
				}
			
			//Mark project as complete
			else {
				projectList.get(i).setProjectStatus("yes");
			        System.out.print("Project Status Changed To Complete\n");
				}
				
			}
	
     }
	return projectList;
	
}

/**
 * <p>
 * The method finds project that are marked as uncompleted
 * @param projectList Array List that contains all the project objects
 * @return result Returns result if the date is overdue or not
 * @since version 1.00
 */
public static String findOverdueProjects(ArrayList<Project> projectList) {
	
	String result = null;
	
	for (int i = 0; i < projectList.size(); i++) {
		
		Project searchProjectObject = projectList.get(i);
		
		//Get current date
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		String today = getToday("yyyy-MM-dd");
		
		try {
			
			//get projectDeadlineDate in a required format and instantiate it as a Date object
			Date projectDeadlineDate = sdformat.parse(searchProjectObject.getDeadline());
			//get curentDate in a required format and instantiate it as a Date object
			Date curentDate = sdformat.parse(today);
			
			// Decide if project is overdue or not
			if(curentDate.compareTo(projectDeadlineDate) <0){// not expired
               
				result = "Not overdue";
				
		    }
			
			else if (curentDate.compareTo(projectDeadlineDate) == 0){// not expired
				result = "Not overdue";
		    }
			
			else {
				
				System.out.print(searchProjectObject.getProjectName());
				System.out.println(searchProjectObject.getDeadline());
				
			}
			
		}
		catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	return result;
		
	}

//Method to get date into a string
public static String getToday(String format){
    Date date = new Date();
    return new SimpleDateFormat(format).format(date);
}	

/**
 * <p>
 * The method makes the details of the project into a string stores them in a string
 * @param projectList Array List that contains all the project objects
 * @return result Returns result if the date is overdue or not
 * @since version 1.00
 */

public static String objectDataToString(Project projectObject) {  
	
	String projectData =projectObject.getProjectName() + "#" + projectObject.getBuildingType() +
			"#" + projectObject.getProjectNumber() + "#" +
			projectObject.getAmountDue() + "#" + projectObject.getErfNumber()+ "#" 
			+ projectObject.getCompleteDate()+ "#" + projectObject.getDeadline()+ "#" + 
			projectObject.getProjectStatus()+ "#" + projectObject.getSiteAdrress()+"#" + 
			projectObject.getAmountPaid()+"#"+ projectObject.getChargeFee()+ "#"+
			projectObject.getStartDate()+"#" + projectObject.getClient().getName() +"#" + 
			projectObject.getClient().getProfession() +"#" + projectObject.getClient().getPhysicalAdrress() +"#" +
			projectObject.getClient().getEmailAdrress()+"#" + projectObject.getClient().getTelephoneNumber()+"#" + 
			projectObject.getArchitect().getName() +"#" + projectObject.getArchitect().getProfession() +"#" + 
			projectObject.getArchitect().getPhysicalAdrress() +"#"+projectObject.getArchitect().getEmailAdrress()+"#" + 
			projectObject.getArchitect().getTelephoneNumber()+"#"+ projectObject.getContractor().getName() +"#" + 
			projectObject.getContractor().getProfession() +"#" + projectObject.getContractor().getPhysicalAdrress() +"#"+
			projectObject.getContractor().getEmailAdrress()+"#" + projectObject.getContractor().getTelephoneNumber();
	
	return projectData;
}

//Method to write to a file
public static void writeToFile (ArrayList<Project> projectList) {
	
	String individualProjectData= null;
	
    for (int i = 0; i < projectList.size(); i++) {
 
    	Project projectObject = projectList.get(i);
    	individualProjectData += objectDataToString(projectObject);
    }
   
    	try {
    		// please change this directory to where your file is located
    		File file = new File("C:\\Users\\Patrick\\eclipse-workspace\\PoiseFinalProject\\src\\output.txt");
    		file.delete();
    		FileWriter fr = new FileWriter(file, true);
    		BufferedWriter br = new BufferedWriter(fr);
    		PrintWriter pr = new PrintWriter(br);
    		pr.println(individualProjectData);
    		pr.close();
    		br.close();
    		fr.close();
    		}
    		catch (Exception e) {
    			System.out.println("Error");
    		}
    }

//Method to write
public static void write(ArrayList<Project> projectList) {
	
	String individualProjectData= null;
		
	    for (int i = 0; i < projectList.size(); i++) {
	 
	    	Project projectObject = projectList.get(i);
	    	individualProjectData += objectDataToString(projectObject);
	    }
   
	File file = new File("C:\\Users\\Patrick\\eclipse-workspace\\PoiseFinalProject\\src\\output.txt");
    FileWriter fr = null;
    try {
        fr = new FileWriter(file);
        fr.write(individualProjectData);
    } catch (IOException e) {
        e.printStackTrace();
    }finally{
        //close resources
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	
}



