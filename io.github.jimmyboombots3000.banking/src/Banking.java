import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banking {

	static String strBadChoice = "Invalid choice, please try again";

	// Create key-value pairs giving each BankClient object an ID number
	static Map<Integer, BankClient> clientMap = new HashMap<Integer, BankClient>();;

	static Scanner in = new Scanner(System.in);

	// Load sample data
	static void LoadTestClients() {
		clientMap.put(1, new BankClient("Bob Jones", 1));
		clientMap.put(2, new BankClient("Sarah Davis", 2));
		clientMap.put(3, new BankClient("Amy Friendly", 1));
		clientMap.put(4, new BankClient("Johnny Smith", 1));
		clientMap.put(5, new BankClient("Carol Spears", 2));

	}

	// TODO Needs better authentication
	static int CheckUserPermissionAccess() {

		System.out.println("Enter your username:");
		String username = in.nextLine(); // Currently unused

		System.out.println("Enter your password:");
		String password = in.nextLine();

		if (password.equals("123")) {
			return 1;
		} else
			return 0;
	}

	static void ChangeCustomerChoice() {
		int selectedClientNum = 0;
		int newService = 0;
		BankClient selectedClient = null;

		// Prompt user to select client
		do {
			System.out.println("Enter the number of the client that you wish to change");
			while (!in.hasNextInt()) {
				System.out.println(strBadChoice);
				in.next();
			}
			selectedClientNum = in.nextInt();
			selectedClient = clientMap.get(selectedClientNum);
			assert true;

		} while (selectedClient == null);

		// Prompt user to select new option
		do {
			System.out.println("Please enter the client's new service choice\n(1 = Brokerage, 2 = Retirement)");
			while (!in.hasNextInt()) {
				System.out.println(strBadChoice);
				in.next();
			}
			newService = in.nextInt();
			selectedClient = clientMap.get(selectedClientNum);
			assert true;

		} while (newService != 1 && newService != 2);

		// Change selected client to selected option
		BankClient changedClient = clientMap.get(selectedClientNum);
		changedClient.ChangeCustomerChoice(newService);
		System.out.println("\nChanged: ");
		changedClient.DisplayClient();


	}

	static void DisplayMenu() {
		System.out.println("\nWhat would you like to do?");
		System.out.println("DISPLAY the client list (enter 1)");
		System.out.println("CHANGE a client's choice (enter 2)");
		System.out.println("Exit the program.. (enter 3)");

		return;
	}

	// Prints to console info for each BankClient object in Map
	static void DisplayInfo() {

		for (Map.Entry<Integer, BankClient> i : clientMap.entrySet()) {
			System.out.print(i.getKey() + ". ");
			i.getValue().DisplayClient();
		}

		return;
	}

	public static void main(String args[]) {
		int authenticated = 0;
		int menuChoice = 0;

		// Test routine for loading local test objects
		LoadTestClients();

		System.out.println("Hello! Welcome to our Investment Company");

		while (authenticated != 1) {
			authenticated = CheckUserPermissionAccess();
			if (authenticated == 1)
				break;
			System.out.println("Invalid Password. Please try again");
		}

		while (menuChoice != 3) {
			// display menu
			DisplayMenu();

			try {
				menuChoice = in.nextInt();
				System.out.println("\nYou chose " + menuChoice);

			} catch (Exception e) {
				in.next();
			}

			switch (menuChoice) {
			case 1:
				DisplayInfo();
				break;
			case 2:
				ChangeCustomerChoice();
				break;
			case 3:
				System.out.println("Cheerio!");
				break;
			default:
				System.out.println(strBadChoice);
				break;
			}
		}

		return;
	}

}
