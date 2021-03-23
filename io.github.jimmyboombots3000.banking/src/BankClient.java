
class BankClient {
	
	private String clientName;
	private int clientType;

	public BankClient(String name, int type) {
		this.clientName = name;
		this.clientType = type;
	}
	
	void DisplayClient() {
		System.out.println(clientName + " selected option " + clientType);
		return;
	}
	
	void ChangeCustomerChoice(int newType) {
		this.clientType = newType;		
	}
		
}

