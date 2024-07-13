package testRunner;

import org.testng.annotations.Test;

import FancodeAssignment.TodosGeneration.getUserListFancodeCity;

/* 
 * This java file is to the run the test to find out the if the users in Fancode city have completed more than 50% of their tasks
 * GetUserList will print the results
 * 
 * 
 * */
public class TestRunner {

	@Test
	public void fancodeTestRunner()
	{
		
		getUserListFancodeCity generate = new getUserListFancodeCity();
		generate.GetUserList();
		
	}

}
