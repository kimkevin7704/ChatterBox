package chat;

import java.awt.event.*;
import javax.swing.*;

public class StartChat implements ActionListener{
	private static String WELCOME = "Welcome to the chatroom!";
	private static String USER_PROMPT = "Please enter your user name";
	private static String SUBMIT_BUTTON_TEXT = "Enter Chatroom";
	private static String UPDATED_PROMPT = "Add new users";
	private boolean isUpdate;
	
	JFrame frame;
	JLabel welcome, promptID, addNewUser;
	JTextField userInput;
	JButton submit;
	Users userList;
	ChatRooms chatRooms;
	ChatRoom chatroom;
	ChatLog chatlog;
	
	StartChat()
	{
		//switch for refreshing frame after submission
		isUpdate = false;
		
		frame = new JFrame();
		frame.setSize(330, 340);
		//makes array list to hold User objects
		userList = new Users();
		//makes chat log for current chat
		chatlog = new ChatLog();
		//makes array list to hold ChatRoom objects
		chatRooms = new ChatRooms();
		
		welcome = new JLabel(WELCOME);
		welcome.setBounds(50,50,300,30);
		promptID = new JLabel(USER_PROMPT);
		promptID.setBounds(50,75,300,30);
		userInput = new JTextField("");
		userInput.setBounds(50,125,200,30);
		submit = new JButton(SUBMIT_BUTTON_TEXT);
		submit.setBounds(50,175,200,50);
		//submit able to detect mouseclick
		submit.addActionListener(this);
		addNewUser = new JLabel(UPDATED_PROMPT);
		addNewUser.setBounds(50,75,300,30);
		
		frame.add(welcome);
		frame.add(promptID);
		frame.add(userInput);
		frame.add(submit);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}

	//when submit button is pressed make new chatroom and update all existing chatrooms
	@Override
	public void actionPerformed(ActionEvent e) {
		this.makeChatroom();
		this.updateWindow();
	}
	
	public void makeChatroom()
	{
		//get text user submitted for username
		String userSubmit = userInput.getText();
		//makes new user and adds username
		User user = new User(userSubmit);
		//add user to user array
		userList.addUser(user);
		//refresh text box
		userInput.setText("");
		//make a new chatroom for user
		chatroom = new ChatRoom(user, chatlog, chatRooms);
		//add chatroom to chatroom array
		chatRooms.addChatRoom(chatroom);
	}
	
	public void updateWindow()
	{
		if(!isUpdate)
		{
			//remove original prompts
			frame.remove(welcome);
			frame.remove(promptID);
			//replace prompt with new prompt
			frame.add(addNewUser);
			//refresh frame
			frame.validate();
			frame.invalidate();
			frame.repaint();
			//switch to prevent frame refresh
			isUpdate = true;
		}
	}
}
