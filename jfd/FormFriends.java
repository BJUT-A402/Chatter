import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Jul 14 16:10:41 CST 2021
 */



/**
 * @author somnusym
 */
public class FormFriends  {

	private void listFriendsMouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void btnAddFriendActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnMyDetailActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnChangeThemeActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miSendMessageActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miPersonDetailActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miDeleteFriendActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void listFriendsFocusLost(FocusEvent e) {
		// TODO add your code here
	}

	private void listAllUsersFocusLost(FocusEvent e) {
		// TODO add your code here
	}

	private void listAllUsersValueChanged(ListSelectionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		this.Friends = new JFrame();
		this.lbMyFriends = new JLabel();
		this.spFriends = new JScrollPane();
		this.listFriends = new JList<>();
		this.lbAllUsers = new JLabel();
		this.spAllusers = new JScrollPane();
		this.listAllUsers = new JList();
		this.btnAddFriend = new JButton();
		this.btnMyDetail = new JButton();
		this.btnChangeTheme = new JButton();
		this.pmFriends = new JPopupMenu();
		this.miSendMessage = new JMenuItem();
		this.miPersonDetail = new JMenuItem();
		this.miDeleteFriend = new JMenuItem();

		//======== Friends ========
		{
			this.Friends.setMinimumSize(new Dimension(220, 440));
			this.Friends.setTitle("\u6e05\u98ce\u98de\u96ea");
			this.Friends.setResizable(false);
			this.Friends.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			var FriendsContentPane = this.Friends.getContentPane();
			FriendsContentPane.setLayout(new MigLayout(
				"hidemode 3,alignx center",
				// columns
				"[grow]",
				// rows
				"[]" +
				"[grow]" +
				"[]" +
				"[]" +
				"[]"));

			//---- lbMyFriends ----
			this.lbMyFriends.setText("\u6211\u7684\u597d\u53cb");
			this.lbMyFriends.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
			FriendsContentPane.add(this.lbMyFriends, "cell 0 0,gapx 2");

			//======== spFriends ========
			{

				//---- listFriends ----
				this.listFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				this.listFriends.setModel(new AbstractListModel<String>() {
					String[] values = {
						"\u5ed6\u601d\u6e90",
						"\u8d3e\u5b89\u5353",
						"\u5b59\u6708\u660e",
						"\u51af\u5251\u8c6a",
						"\u8d75\u777f",
						"\u51af\u5609\u4f26"
					};
					@Override
					public int getSize() { return this.values.length; }
					@Override
					public String getElementAt(int i) { return this.values[i]; }
				});
				this.listFriends.setFocusable(false);
				this.listFriends.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
				this.listFriends.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listFriendsMouseClicked(e);
					}
				});
				this.listFriends.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						listFriendsFocusLost(e);
					}
				});
				this.spFriends.setViewportView(this.listFriends);
			}
			FriendsContentPane.add(this.spFriends, "cell 0 1,grow,gapx 2 2");

			//---- lbAllUsers ----
			this.lbAllUsers.setText("\u6240\u6709\u7528\u6237\uff08\u670d\u52a1\u5668\uff09");
			this.lbAllUsers.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
			FriendsContentPane.add(this.lbAllUsers, "cell 0 2,gapx 2");

			//======== spAllusers ========
			{

				//---- listAllUsers ----
				this.listAllUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				this.listAllUsers.setFocusable(false);
				this.listAllUsers.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
				this.listAllUsers.addListSelectionListener(e -> listAllUsersValueChanged(e));
				this.spAllusers.setViewportView(this.listAllUsers);
			}
			FriendsContentPane.add(this.spAllusers, "cell 0 3,grow,gapx 2 2");

			//---- btnAddFriend ----
			this.btnAddFriend.setText("\u6dfb\u52a0\u597d\u53cb");
			this.btnAddFriend.setFocusable(false);
			this.btnAddFriend.addActionListener(e -> btnAddFriendActionPerformed(e));
			FriendsContentPane.add(this.btnAddFriend, "cell 0 4,alignx center,growx 0,width 60");

			//---- btnMyDetail ----
			this.btnMyDetail.setText("\u6211\u7684\u8d44\u6599");
			this.btnMyDetail.setFocusable(false);
			this.btnMyDetail.addActionListener(e -> btnMyDetailActionPerformed(e));
			FriendsContentPane.add(this.btnMyDetail, "cell 0 4,alignx center,growx 0,width 60");

			//---- btnChangeTheme ----
			this.btnChangeTheme.setText("\u66f4\u6539\u4e3b\u9898");
			this.btnChangeTheme.setFocusable(false);
			this.btnChangeTheme.addActionListener(e -> btnChangeThemeActionPerformed(e));
			FriendsContentPane.add(this.btnChangeTheme, "cell 0 4");
			this.Friends.setSize(260, 550);
			this.Friends.setLocationRelativeTo(this.Friends.getOwner());
		}

		//======== pmFriends ========
		{

			//---- miSendMessage ----
			this.miSendMessage.setText("\u53d1\u9001\u6d88\u606f");
			this.miSendMessage.addActionListener(e -> miSendMessageActionPerformed(e));
			this.pmFriends.add(this.miSendMessage);

			//---- miPersonDetail ----
			this.miPersonDetail.setText("\u67e5\u770b\u8d44\u6599");
			this.miPersonDetail.addActionListener(e -> miPersonDetailActionPerformed(e));
			this.pmFriends.add(this.miPersonDetail);

			//---- miDeleteFriend ----
			this.miDeleteFriend.setText("\u5220\u9664\u597d\u53cb");
			this.miDeleteFriend.addActionListener(e -> miDeleteFriendActionPerformed(e));
			this.pmFriends.add(this.miDeleteFriend);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	public JFrame Friends;
	private JLabel lbMyFriends;
	private JScrollPane spFriends;
	private JList<String> listFriends;
	private JLabel lbAllUsers;
	private JScrollPane spAllusers;
	private JList listAllUsers;
	private JButton btnAddFriend;
	private JButton btnMyDetail;
	private JButton btnChangeTheme;
	private JPopupMenu pmFriends;
	private JMenuItem miSendMessage;
	private JMenuItem miPersonDetail;
	private JMenuItem miDeleteFriend;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
