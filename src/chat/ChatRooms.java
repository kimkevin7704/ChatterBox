package chat;
import java.util.*;

public class ChatRooms {
	
	List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();
	
	public void addChatRoom(ChatRoom room)
	{
		chatRooms.add(room);
	}
	
	public void updateChatRooms()
	{
		for (int i = 0; i < chatRooms.size(); i++)
		{
			chatRooms.get(i).chatRoomText.setText(chatRooms.get(i).thisChatLog.getChatLogString());
		}
	}
}
