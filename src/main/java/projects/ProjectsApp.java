package projects;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import entity.Project;
import projects.exception.DbException;
import projects.service.ProjectService;

public class ProjectsApp {
	
	private Scanner scanner = new Scanner(System.in);
	
	private ProjectService projectService = new ProjectService();

	// @formatter:off
	/*
	 * 1a. Add a private instance variable named "operations". The type is List<String>. 
	 * Initialize it using List.of with the following value: "1) Add a project". 
	 * To prevent the Eclipse formatter from reformatting the list,surround the variable declaration 
	 * with // @formatter:off and // @formatter:on 
	 */
	private List<String> operations = List.of(
		"1) Add a project"
	);
	// @formatter:on

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//3. create a new Projects App object and call the method 'processUserSelections()
		
		new ProjectsApp().processUserSections();

	}
	//4 . create the processUserSelections() method as an instance method to display menu selections
	//get a selection from the user and act on the selection
	private void processUserSections() {
		//4a. Add a local variable:
		boolean done = false;
		//4b. Add a while loop below the local variable. Loop until the variable done is true.
		while (!done) {
			{
			//4c. create try/catch block to catch and handle Exceptions
				try {
					int selection = getUserSelection();
			/*
			 * 9a	Add a switch statement below the method call to getUserSelection(). 
			 * 9b.  Add the first case of -1. Inside this case, call exitMenu() and assign the result of the method call to the local variable done.
			 * 9c.  Add the default case. Print a message: "\n" + selection + " is not a valid selection. Try again.".	
			 */
					switch (selection) {
					case -1:
						done = exitMenu();
						break;
					case 1:
						createProject();
						break;

					default:
						System.out.println("\n" + selection + " is not a valid selection. Try again.");
					}
				} catch (Exception e) {
					System.out.println("\nError: " + e + " Try again");
				}

			}
		}
	}

	private void createProject() {
		String projectName = getStringInput("Enter the project name");
		BigDecimal estimatedHours = new BigDecimal(getStringInput("Enter the estimated hours"));
		BigDecimal actualHours = new BigDecimal(getStringInput("Enter the actual hours"));
		int difficulty = getIntInput("Enter the project difficulty (1-5)");
		String notes = getStringInput("Enter the project notes");
		
		Project project = new Project();
		
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		@SuppressWarnings("unused")
		Project dbProject = projectService.addProject(project);
		System.out.println("You have succesfully created project: + dbProject");
			
		
	}
	
	@SuppressWarnings("unused")
	private BigDecimal getDecimalInput(String prompt) {
		String input = getStringInput(prompt);
		if (Objects.isNull(input)) {
			return null;
		}
		// 
		try {
			return new BigDecimal(input);
		//	In the catch block throw a new DbException with the message, input + " is not a valid number. Try again."
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid decimal number");
		}

	}
	
	
	private boolean exitMenu() {

		System.out.println("\nExiting the menu.");
		return true;
	}
	//5. create getUserSelection method to print the operations and accept user input as an integer
	private int getUserSelection() {
		//5a. make a method call to printOperations() - no parameters and no return
		printOperations();
		//5b. Add a method call to getIntInput(). Assign the results of the method call to a variable named input of type Integer. 
		Integer input = getIntInput("Enter a menu selection");
		//5c. add a return statement that checks to see if the value in the local variable input is null
		//return -1 if it is
		return Objects.isNull(input) ? -1 : input;

	}
	//7. Create method getIntInput
	private Integer getIntInput(String prompt) {
		//7a. assign a local variable named input 
		//of type String to the results of the method call getStringInput(prompt).
		String input = getStringInput(prompt);
		//7b. test the value in the variable input. If it is null, return null. Use Objects.isNull() for the null check.
		if (Objects.isNull(input)) {
			return null;
		}
		//7c. Create a try/catch block to test that the value returned by getStringInput() can be converted to an Integer
		// In the try block, convert the value of input, which is a String, to an Integer and return it. 
		try {
			return Integer.valueOf(input);
		//	In the catch block throw a new DbException with the message, input + " is not a valid number. Try again."
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number");
		}

	}
	// 8. Create getStringinput Method
	//8a. use println to keep cursor on the same line. 
	//8b. Assign a String variable named input to the results of a method call to scanner.nextLine().
	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String input = scanner.nextLine();
		//8c. If input is blank return null. Otherwise return the trimmed value.
		return input.isBlank() ? null : input.trim();

	}
	//6. Create the method printOperations(). It takes no parameters and returns nothing. 
	 
	private void printOperations() {
		//6a. print a line to the console
		System.out.println("\nThese are the available selections.  Press the Enter key to quit:");
		//6b. print available menu selections, one on each line indented 2 or 3 spaces
		operations.forEach(line -> System.out.println("  " + line));

	}

}
