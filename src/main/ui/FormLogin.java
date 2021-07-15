package ui;

import DTO.User;
import chat.Chatter;
import Utils.*;
import Kernel.Kernel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author somnusym
 */
public class FormLogin extends Form {

    public FormLogin() {
        initComponents();
    }

    private void pwPasswordKeyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }

    private void login() {
        if (ftfAccount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "用户名不可为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (pwPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "密码不可为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int errorCode = Account.validateLogin(Integer.parseInt(ftfAccount.getText()), String.valueOf(pwPassword.getPassword()));
        if (errorCode != CError.SUCCESS) {
            CError.error(errorCode);
            return;
        }
        Chatter.curUser = User.getUser(Integer.parseInt(ftfAccount.getText()));
        if (Kernel.connectServer()) {
            FormManager.FL.show(false);
            FormManager.FF.show(true);
        }
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        FormManager.FL.show(false);
        FormManager.FR.show(true);
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        login();
    }

    private void rbtnSellerStateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void rbtnConsumerStateChanged(ChangeEvent e) {
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
        ftfAccount = new JFormattedTextField();
        cbAutoLogin = new JCheckBox();
        cbPassword = new JCheckBox();

        //======== Login ========
        {
            Login.setTitle("\u767b\u5f55");
            Login.setResizable(false);
            Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container LoginContentPane = Login.getContentPane();
            LoginContentPane.setLayout(null);

            //---- btnRegister ----
            btnRegister.setText("\u6ce8\u518c\u8d26\u53f7");
            btnRegister.addActionListener(this::btnRegisterActionPerformed);
            LoginContentPane.add(btnRegister);
            btnRegister.setBounds(new Rectangle(new Point(110, 185), btnRegister.getPreferredSize()));

            //---- btnLogin ----
            btnLogin.setText("\u767b\u5f55");
            btnLogin.addActionListener(this::btnLoginActionPerformed);
            LoginContentPane.add(btnLogin);
            btnLogin.setBounds(new Rectangle(new Point(290, 185), btnLogin.getPreferredSize()));
            LoginContentPane.add(pwPassword);
            pwPassword.setBounds(120, 90, 269, pwPassword.getPreferredSize().height);

            //---- lbPassword ----
            lbPassword.setText("\u5bc6\u7801\uff1a");
            LoginContentPane.add(lbPassword);
            lbPassword.setBounds(new Rectangle(new Point(75, 95), lbPassword.getPreferredSize()));

            //---- lbAccount ----
            lbAccount.setText("\u8d26\u53f7\uff1a");
            LoginContentPane.add(lbAccount);
            lbAccount.setBounds(new Rectangle(new Point(75, 50), lbAccount.getPreferredSize()));
            LoginContentPane.add(ftfAccount);
            ftfAccount.setBounds(120, 45, 270, ftfAccount.getPreferredSize().height);

            //---- cbAutoLogin ----
            cbAutoLogin.setText("\u81ea\u52a8\u767b\u5f55");
            cbAutoLogin.setFocusable(false);
            LoginContentPane.add(cbAutoLogin);
            cbAutoLogin.setBounds(new Rectangle(new Point(110, 145), cbAutoLogin.getPreferredSize()));

            //---- cbPassword ----
            cbPassword.setText("\u8bb0\u4f4f\u5bc6\u7801");
            cbPassword.setFocusable(false);
            LoginContentPane.add(cbPassword);
            cbPassword.setBounds(290, 145, 71, 21);

            pwPassword.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    pwPasswordKeyReleased(e);
                }
            });

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < LoginContentPane.getComponentCount(); i++) {
                    Rectangle bounds = LoginContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = LoginContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                LoginContentPane.setMinimumSize(preferredSize);
                LoginContentPane.setPreferredSize(preferredSize);
            }
            Login.setSize(465, 275);
            Login.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Login;
    private JButton btnRegister;
    private JButton btnLogin;
    private JPasswordField pwPassword;
    private JLabel lbPassword;
    private JLabel lbAccount;
    private JFormattedTextField ftfAccount;
    private JCheckBox cbAutoLogin;
    private JCheckBox cbPassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
