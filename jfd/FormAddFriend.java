import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Jul 14 21:18:08 CST 2021
 */



/**
 * @author somnusym
 */
public class FormAddFriend {
	public FormAddFriend() {
		initComponents();
	}

	private void btnOKActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		AddFriend = new JFrame();
		tfID = new JTextField();
		btnOK = new JButton();

		//======== AddFriend ========
		{
			AddFriend.setResizable(false);
			var AddFriendContentPane = AddFriend.getContentPane();
			AddFriendContentPane.setLayout(null);
			AddFriendContentPane.add(tfID);
			tfID.setBounds(15, 10, 135, tfID.getPreferredSize().height);

			//---- btnOK ----
			btnOK.setText("\u786e\u5b9a");
			btnOK.addActionListener(e -> btnOKActionPerformed(e));
			AddFriendContentPane.add(btnOK);
			btnOK.setBounds(new Rectangle(new Point(160, 10), btnOK.getPreferredSize()));

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < AddFriendContentPane.getComponentCount(); i++) {
					Rectangle bounds = AddFriendContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = AddFriendContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				AddFriendContentPane.setMinimumSize(preferredSize);
				AddFriendContentPane.setPreferredSize(preferredSize);
			}
			AddFriend.setSize(250, 85);
			AddFriend.setLocationRelativeTo(AddFriend.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame AddFriend;
	private JTextField tfID;
	private JButton btnOK;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
