package chat;

import javax.swing.*;
import java.awt.event.*;

public class ChatRoom implements ActionListener{
	private static String SEND_BUTTON_TEXT = "send";
	
	JLabel userIDText, activeUsers;
	JTextArea chatRoomText;
	JTextField chatText;
	JButton send;
	User currentUser;
	Users userList;
	ChatLog thisChatLog;
	ChatRooms chatrooms;
	
	ChatRoom (User user, ChatLog chatlog, ChatRooms theChatrooms, Users theUserList) 
	{
		JFrame chatFrame = new JFrame();
		currentUser = user;
		thisChatLog = chatlog;
		chatrooms = theChatrooms;
		userList = theUserList;
		
		userIDText = new JLabel("logged in as " + user.getUserName());
		userIDText.setBounds(10, 10, 300, 30);
		activeUsers = new JLabel("Active Users:\n" + theUserList.getUserList());
		activeUsers.setBounds(350, 10, 100, 200);
		chatRoomText = new JTextArea();
		chatRoomText.setText(chatlog.getChatLogString());
		chatRoomText.setBounds(10, 50, 400, 300);
		chatRoomText.setEditable(false);
		chatText = new JTextField();
		chatText.setBounds(10, 370, 250, 30);
		send = new JButton(SEND_BUTTON_TEXT);
		send.setBounds(270, 370, 90, 30);
		send.addActionListener(this);
		
		chatFrame.setSize(500, 500);
		chatFrame.add(userIDText);
		chatFrame.add(activeUsers);
		chatFrame.add(chatRoomText);
		chatFrame.add(chatText);
		chatFrame.add(send);
		
		chatFrame.setLayout(null);
		chatFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Message messageToSend = new Message(currentUser, chatText.getText());
		//refresh text input box
		chatText.setText("");
		thisChatLog.addToChatLog(messageToSend);
		//update text in other chatrooms
		chatrooms.updateChatRooms();
	}
}
