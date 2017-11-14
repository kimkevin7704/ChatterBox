package chat;

import java.util.*;

public class ChatLog {
	
	List<Message> chatHistory = new ArrayList<Message>();
	
	public void addToChatLog(Message message)
	{
		chatHistory.add(message);
	}

	public List<Message> getChatLog()
	{
		return chatHistory;
	}
	
	//returns string from messages in chatlog
	public String getChatLogString()
	{
		String chatLogString = new String("");
		
		//if more than 20 messages, only display 20 most recent messages
		int messageLimit;
		if(chatHistory.size() > 20)
			messageLimit = chatHistory.size() - 20;
		else
			messageLimit = 0;
		
		//make string of last 20 messages to print
		for(int i = messageLimit; i < chatHistory.size(); i++)
		{
			chatLogString = chatLogString + chatHistory.get(i).getDetailMessage() + "\n";
		}
		
		return chatLogString;
	}
}
