package chat;

public class User {

	private String userName;
	
	User(String userInput)
	{
		userName = userInput;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String name) {
		userName = name;
	}
}
