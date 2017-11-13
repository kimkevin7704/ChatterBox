package chat;

public class Message {
	
	private User user;
	private String message;
	
	Message(User theUser, String theMessage)
	{
		user = theUser;
		message = theMessage;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public String getDetailMessage()
	{
		return user.getUserName() + ": " + message;
	}
}
