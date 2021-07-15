import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
/*
 * Created by JFormDesigner on Thu Jul 15 10:51:54 CST 2021
 */



/**
 * @author somnusym
 */
public class FormLogin  {

	private void btnRegisterActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnLoginActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void pwPasswordKeyTyped(KeyEvent e) {
		// TODO add your code here
	}

	private void tfAccountActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Login = new JFrame();
		btnRegister = new JButton();
		btnLogin = new JButton();
		pwPassword = new JPasswordField();
		lbPassword = new JLabel();
		lbAccount = new JLabel();
		tfAccount = new JTextField();

		//======== Login ========
		{
			Login.setTitle("\u767b\u5f55");
			Login.setResizable(false);
			Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			var LoginContentPane = Login.getContentPane();

			//---- btnRegister ----
			btnRegister.setText("\u6ce8\u518c");
			btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));

			//---- btnLogin ----
			btnLogin.setText("\u767b\u5f55");
			btnLogin.addActionListener(e -> btnLoginActionPerformed(e));

			//---- pwPassword ----
			pwPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwPasswordKeyTyped(e);
				}
			});

			//---- lbPassword ----
			lbPassword.setText("\u5bc6\u7801\uff1a");

			//---- lbAccount ----
			lbAccount.setText("\u8d26\u53f7\uff1a");

			//---- tfAccount ----
			tfAccount.addActionListener(e -> tfAccountActionPerformed(e));

			GroupLayout LoginContentPaneLayout = new GroupLayout(LoginContentPane);
			LoginContentPane.setLayout(LoginContentPaneLayout);
			LoginContentPaneLayout.setHorizontalGroup(
				LoginContentPaneLayout.createParallelGroup()
					.addGroup(LoginContentPaneLayout.createSequentialGroup()
						.addGap(125, 125, 125)
						.addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addGroup(LoginContentPaneLayout.createSequentialGroup()
								.addComponent(lbAccount)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(tfAccount))
							.addGroup(LoginContentPaneLayout.createSequentialGroup()
								.addComponent(lbPassword)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pwPassword))
							.addGroup(GroupLayout.Alignment.TRAILING, LoginContentPaneLayout.createSequentialGroup()
								.addComponent(btnRegister)
								.addGap(77, 77, 77)
								.addComponent(btnLogin)))
						.addContainerGap(119, Short.MAX_VALUE))
			);
			LoginContentPaneLayout.setVerticalGroup(
				LoginContentPaneLayout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, LoginContentPaneLayout.createSequentialGroup()
						.addContainerGap(74, Short.MAX_VALUE)
						.addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(lbAccount)
							.addComponent(tfAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(lbPassword)
							.addComponent(pwPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(btnRegister)
							.addComponent(btnLogin))
						.addGap(79, 79, 79))
			);
			Login.pack();
			Login.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame Login;
	private JButton btnRegister;
	private JButton btnLogin;
	private JPasswordField pwPassword;
	private JLabel lbPassword;
	private JLabel lbAccount;
	private JTextField tfAccount;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
