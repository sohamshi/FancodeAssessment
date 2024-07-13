package testRunner;

import org.testng.annotations.Test;

import FancodeAssignment.TodosGeneration.getUserListFancodeCity;

public class TestRunner {

	@Test
	public void fancodeTestRunner()
	{
		
		getUserListFancodeCity generate = new getUserListFancodeCity();
		generate.GetUserList();
		
	}

}
