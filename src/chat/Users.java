package chat;
import java.util.*;

public class Users {
	
	List<User> userList = new ArrayList<User>();
	String userListString = "";
	
	public void addUser(User user)
	{
		userList.add(user);
	}
	
	public String getUserList()
	{
		for(int i = 0; i < userList.size(); i++)
		{
			userListString = userListString + userList.get(i).getUserName() + "\n";
		}
		return userListString;
	}
}