package FancodeAssignment.TodosGeneration;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getUserListFancodeCity {

	Response responseOfGetUsersList;
	RequestSpecification requestspecification;
	public ArrayList<String> UserinFancodeCity;
	Response responseTodos;

	public void GetUserList() {
		// RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
		responseOfGetUsersList = RestAssured.given().get("http://jsonplaceholder.typicode.com/users");
		String usersResponse = responseOfGetUsersList.prettyPrint();
		JsonPath jsonpath = responseOfGetUsersList.jsonPath();
		System.out.println(usersResponse);

		int totalCountofUsers = jsonpath.getList("id").size();
		ArrayList<String> UserinFancodeCity = new ArrayList<String>();
		String[] UsersnotinFancodeCity = new String[totalCountofUsers];

		for (int i = 0; i < totalCountofUsers; i++) {
			String latitudeFancodeCity = jsonpath.getString("[" + i + "].address.geo.lat");
			String longitudeFancodeCity = jsonpath.getString("[" + i + "].address.geo.lng");

			double ltdFancode = Double.parseDouble(latitudeFancodeCity);
			double lngFancode = Double.parseDouble(longitudeFancodeCity);

			if (ltdFancode >= -40 && ltdFancode <= 5 && lngFancode >= 5 && lngFancode <= 100) {
				String userId = jsonpath.getString("[" + i + "].id");
				UserinFancodeCity.add(userId);
				// System.out.println(UserinFancodeCity);
			} else {
				System.out.println("User is not in FanCode city");
			}
		}

		System.out.println("The users in Fancode city are: " + UserinFancodeCity);

		// to get the user's completed todos
		int totalNoofTodoscount = 0;
		ArrayList<String> totalNoofTodos = new ArrayList<String>();
		responseTodos = RestAssured.given().get("http://jsonplaceholder.typicode.com/todos");
		String userTodos = responseTodos.prettyPrint();

		JsonPath jsonpathToDo = responseTodos.jsonPath();
		int countOfUsersIds = jsonpathToDo.getList("title").size();
		System.out.println(countOfUsersIds);

		List<Boolean> listOfTodos = jsonpathToDo.getList("completed");
		List<Integer> listOfUsers = jsonpathToDo.getList("userId");
		int count = 0;
		for (int k = 0; k < UserinFancodeCity.size(); k++) {
			int value = Integer.parseInt(UserinFancodeCity.get(k));
			switch (value) {
			case 1:
				ArrayList<Integer> user1 = new ArrayList<Integer>();
				ArrayList<Integer> temp1 = new ArrayList<Integer>();
				for (int a : listOfUsers) {
					if (a == 1) {
						user1.add(a);
					}

				}
				double totalTodos = user1.size();
				// System.out.println(totalTodos);

				for (int b = 0; b < listOfTodos.size(); b++) {
					if (listOfUsers.get(b).equals(value) && listOfTodos.get(b)) {
						count = count + 1;
					}
				}
				System.out.println("User 1 has total " + count + " todos task");

				// to calculate percentage
				double percentageCompletionforUser1;
				percentageCompletionforUser1 = count / totalTodos * 100;
				System.out.println(percentageCompletionforUser1);

				if (percentageCompletionforUser1 > 50) {
					System.out.println("User has completed more than 50% of his tasks");
				}

				count = 0;
				break;

			case 5:
				ArrayList<Integer> user2 = new ArrayList<Integer>();
				for (int a : listOfUsers) {
					if (a == 5) {
						user2.add(a);
					}
				}
				// System.out.println(user2);
				double totalTodosforUser2 = user2.size();
				System.out.println(totalTodosforUser2);

				for (int b = 0; b < listOfTodos.size(); b++) {
					if (listOfUsers.get(b).equals(value) && listOfTodos.get(b)) {
						count = count + 1;
					}
				}
				System.out.println("User 5 has total " + count + " todos task");

				// to calculate percentage
				double percentageCompletionforUser2;
				percentageCompletionforUser2 = count / totalTodosforUser2 * 100;
				System.out.println(percentageCompletionforUser2);

				if (percentageCompletionforUser2 > 50) {
					System.out.println("User has completed more than 50% of his tasks");
				}
				count = 0;
				break;

			case 10:
				ArrayList<Integer> user3 = new ArrayList<Integer>();
				for (int a : listOfUsers) {
					if (a == 10) {
						user3.add(a);
					}
				}
				double totalTodosforUser3 = user3.size();
				System.out.println(totalTodosforUser3);

				for (int b = 0; b < listOfTodos.size(); b++) {
					if (listOfUsers.get(b).equals(value) && listOfTodos.get(b)) {
						count = count + 1;
					}
				}
				System.out.println("User 10 has total " + count + " todos task");

				// to calculate percentage
				double percentageCompletionforUser3;
				percentageCompletionforUser3 = count / totalTodosforUser3 * 100;
				System.out.println(percentageCompletionforUser3);

				if (percentageCompletionforUser3 > 50) {
					System.out.println("User has completed more than 50% of his tasks");
				}
				break;

			}
		}

	}
}
