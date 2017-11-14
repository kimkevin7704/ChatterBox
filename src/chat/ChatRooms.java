package chat;
import java.util.*;

public class ChatRooms {
	
	List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();
	
	public void addChatRoom(ChatRoom room)
	{
		chatRooms.add(room);
	}
	
	//go through each chatroom and update text
	public void updateChatRooms()
	{
		for (int i = 0; i < chatRooms.size(); i++)
		{
			chatRooms.get(i).chatRoomText.setText(chatRooms.get(i).thisChatLog.getChatLogString());
			chatRooms.get(i).activeUsers.setText(chatRooms.get(i).userList.getUserList());
		}
	}
}
