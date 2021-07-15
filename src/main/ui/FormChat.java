package ui;

import DTO.User;
import Kernel.Kernel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Objects;

public class FormChat extends Form {
    public User tosend;

    public void updateRecords() {
        StringBuilder sb = new StringBuilder();
        for (String str : tosend.getRecords()) {
            sb.append(str).append("<br>");
        }
        tpHisMsg.setText(sb.toString());
    }

    public FormChat() {
        initComponents();
    }

    private void tpInputMsgKeyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
            tpInputMsg.setText("");
        }
    }

    private void sendMessage() {
        boolean online = false;
        String item = tosend.getNickname() + "_" + tosend.getID();
        for (int i = 0; i < FormManager.FF.listAllUsers.getModel().getSize(); i++) {
            if (FormManager.FF.listAllUsers.getModel().getElementAt(i).equals(item)) {
                online = true;
                break;
            }
        }
        if (!online) {
            JOptionPane.showMessageDialog(null, "对方不在线！");
            return;
        }

        String message = tpInputMsg.getText().trim();

        if (message.isBlank())
            return;

        Kernel.sendMessage("@" + tosend.getID() + ":" + message);
    }

    private void btnSendMsgActionPerformed(ActionEvent e) {
        sendMessage();
        tpInputMsg.setText("");
    }

    private void btnPicActionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");//创建这个文件的规范
        File f = null;
        chooser.setFileFilter(filter);//加上这个文件规范
        int result = chooser.showOpenDialog(Chat);
        if (result == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile(); //选择的文件 返回给 File
            Kernel.sendMessage("@<" + tosend.getID() + ":" + f.getName());
        }
    }

    private void btnFileActionPerformed(ActionEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Chat = new JFrame();
        spHisMsg = new JScrollPane();
        tpHisMsg = new JTextPane();
        lbAvatar = new JLabel();
        lbNickID = new JLabel();
        btnPic = new JButton();
        btnFile = new JButton();
        spInputMsg = new JScrollPane();
        tpInputMsg = new JTextPane();
        btnSendMsg = new JButton();

        //======== Chat ========
        {
            Chat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Chat.setMinimumSize(new Dimension(600, 600));
            Chat.setResizable(false);
            Chat.setTitle("聊天");
            Chat.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    showing = false;
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    showing = true;
                }
            });
            Container ChatContentPane = Chat.getContentPane();
            ChatContentPane.setLayout(new MigLayout(
                    "insets panel,hidemode 3",
                    // columns
                    "[grow]" +
                            "[grow]" +
                            "[150!]",
                    // rows
                    "[200]" +
                            "[200]" +
                            "[40]" +
                            "[120]" +
                            "[40]"));

            //======== spHisMsg ========
            {

                //---- tpHisMsg ----
                tpHisMsg.setEditable(false);
                tpHisMsg.setText("\u5386\u53f2\u6d88\u606f");
                tpHisMsg.setFocusable(false);
                tpHisMsg.setForeground(Color.blue);
                tpHisMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
                tpHisMsg.setContentType("text/html");
                spHisMsg.setViewportView(tpHisMsg);
                tpInputMsg.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        tpInputMsgKeyReleased(e);
                    }
                });
            }
            ChatContentPane.add(spHisMsg, "span 2 2,grow");

            //---- lbAvatar ----
            lbAvatar.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/\u5934\u50cf \u7537\u5b69 100.png"))));
            ChatContentPane.add(lbAvatar, "cell 2 0,alignx center,growx 0");

            //---- lbNickID ----
            lbNickID.setText("\u8d75\u777f\uff0818071024\uff09");
            ChatContentPane.add(lbNickID, "cell 2 1,align center top,grow 0 0");

            //---- btnPic ----
            btnPic.setText("\u56fe\u7247");
            btnPic.setFocusPainted(false);
            btnPic.setFocusable(false);
            btnPic.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            btnPic.addActionListener(e -> btnPicActionPerformed(e));
            ChatContentPane.add(btnPic, "cell 0 2");

            //---- btnFile ----
            btnFile.setText("\u6587\u4ef6");
            btnFile.setFocusPainted(false);
            btnFile.setFocusable(false);
            btnFile.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            btnFile.addActionListener(e -> btnFileActionPerformed(e));
            ChatContentPane.add(btnFile, "cell 0 2");

            //======== spInputMsg ========
            {

                //---- tpInputMsg ----
                tpInputMsg.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                tpInputMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
                spInputMsg.setViewportView(tpInputMsg);
            }
            ChatContentPane.add(spInputMsg, "cell 0 3 2 1,grow");

            //---- btnSendMsg ----
            btnSendMsg.setText("\u53d1\u9001");
            btnSendMsg.setActionCommand("SendMessage");
            btnSendMsg.setFocusable(false);
            btnSendMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            btnSendMsg.addActionListener(e -> btnSendMsgActionPerformed(e));
            ChatContentPane.add(btnSendMsg, "cell 1 4,alignx right");
            Chat.setSize(600, 600);
            Chat.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public boolean setChat(int uid) {
        // 数据库中根据uid获取用户信息
        tosend = User.getUser(uid);
        if (tosend == null)
            return false;
        lbNickID.setText(tosend.getNickname() + "(" + tosend.getID() + ")");
        return true;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Chat;
    private JScrollPane spHisMsg;
    private JTextPane tpHisMsg;
    private JLabel lbAvatar;
    private JLabel lbNickID;
    private JButton btnPic;
    private JButton btnFile;
    private JScrollPane spInputMsg;
    private JTextPane tpInputMsg;
    private JButton btnSendMsg;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
