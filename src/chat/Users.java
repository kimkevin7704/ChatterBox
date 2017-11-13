package chat;
import java.util.*;

public class Users {
	
	List<User> userList = new ArrayList<User>();
	
	public void addUser(User user)
	{
		userList.add(user);
	}
}