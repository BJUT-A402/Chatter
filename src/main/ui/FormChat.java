package ui;

import DTO.User;
import Kernel.*;
import chat.Chatter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Objects;

public class FormChat extends Form {
    public User tosend;

    public void updateRecords() {
        User user = Chatter.curUser;
        if (user != null) {
            tpHisMsg.setText("");
            for (int i = 0; i < user.getRecords().size(); i++) {
                tpHisMsg.setText(tpHisMsg.getText() + user.getRecords().get(i) + "\n");
            }
        }
    }

    public FormChat() {
        initComponents();
    }

    private void btnMsgRecActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnSendMsgActionPerformed(ActionEvent e) {
        String message = tpInputMsg.getText().trim();

        if (message.isBlank())
            return;

        Kernel.sendMessage("@" + tosend.getID() + ":" + message);
        tosend.getRecords().add(Chatter.curUser.getNickname() + ":" + message);

        StyledDocument inputSDoc = tpInputMsg.getStyledDocument(); //获取读取的StyledDocument
        StyledDocument outSDoc = tpHisMsg.getStyledDocument(); //获取欲输出的StyledDocument
        try {
            outSDoc.insertString(tpHisMsg.getCaretPosition(), tosend.getID() + ":\n", null);//从光标处插入文字
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }

        for (int i = 0; i < inputSDoc.getLength(); i++) { //遍历读取的StyledDocument

            if (inputSDoc.getCharacterElement(i).getName().equals("icon")) { //如果发现是icon元素，那么：
                Element ele = inputSDoc.getCharacterElement(i);
                ImageIcon icon = (ImageIcon) StyleConstants.getIcon(ele.getAttributes());
                icon.setImage(icon.getImage().getScaledInstance(143, 132, Image.SCALE_DEFAULT));//设置（图片）文件的大小
                tpHisMsg.insertIcon(icon);//插入icon元素
                try {
                    outSDoc.insertString(tpHisMsg.getCaretPosition(), "\n", null);//从光标处插入文字
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }

            } else {//如果不是icon（可以判断是文字，因为目前只有图片元素插入）
                try {
                    String s = inputSDoc.getText(i, 1);
                    outSDoc.insertString(tpHisMsg.getCaretPosition(), s, null);//从光标处插入文字
                    if (i == inputSDoc.getLength() - 1)
                        outSDoc.insertString(tpHisMsg.getCaretPosition(), "\n", null);//从光标处插入文字
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }

        }
        tpInputMsg.setText("");

    }

    private void btnPicActionPerformed(ActionEvent e) {
        // TODO add your code here

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");//创建这个文件的规范
        File f = null;
        chooser.setFileFilter(filter);//加上这个文件规范
        int result = chooser.showOpenDialog(Chat);
        if (result == JFileChooser.APPROVE_OPTION) {

            f = chooser.getSelectedFile(); //选择的文件 返回给 File
            //  chooser.getSelectedFile();
            String pic_path;
            pic_path = f.getParent() + "\\" + f.getName();//将文件的路径 给变为String
            ImageIcon i = new ImageIcon(pic_path); //创建一个ImageIcon 并给一个这个文件an的路径
            i.setImage(i.getImage().getScaledInstance(143, 132, Image.SCALE_DEFAULT));//设置（图片）文件的大小
            tpInputMsg.insertIcon(i);
            //tpInputMsg.insertIcon(new ImageIcon(chooser.getSelectedFile().toString()));
        }
    }

    private void btnFileActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void tpInputMsgKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this.Chat = new JFrame();
        this.spHisMsg = new JScrollPane();
        this.tpHisMsg = new JTextPane();
        this.lbAvatar = new JLabel();
        this.lbNickID = new JLabel();
        this.btnPic = new JButton();
        this.btnFile = new JButton();
        this.btnMsgRec = new JButton();
        this.spInputMsg = new JScrollPane();
        this.tpInputMsg = new JTextPane();
        this.btnSendMsg = new JButton();

        //======== Chat ========
        {
            this.Chat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.Chat.setMinimumSize(new Dimension(600, 600));
            this.Chat.setResizable(false);
            this.Chat.setTitle("聊天");
            Container ChatContentPane = this.Chat.getContentPane();
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
                this.tpHisMsg.setEditable(false);
                this.tpHisMsg.setText("\u5386\u53f2\u6d88\u606f");
                this.tpHisMsg.setFocusable(false);
                this.tpHisMsg.setForeground(Color.blue);
                this.tpHisMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
                this.spHisMsg.setViewportView(this.tpHisMsg);
            }
            ChatContentPane.add(this.spHisMsg, "span 2 2,grow");

            //---- lbAvatar ----
            this.lbAvatar.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/\u5934\u50cf \u7537\u5b69 100.png"))));
            ChatContentPane.add(this.lbAvatar, "cell 2 0,alignx center,growx 0");

            //---- lbNickID ----
            this.lbNickID.setText("\u8d75\u777f\uff0818071024\uff09");
            ChatContentPane.add(this.lbNickID, "cell 2 1,align center top,grow 0 0");

            //---- btnPic ----
            this.btnPic.setText("\u56fe\u7247");
            this.btnPic.setFocusPainted(false);
            this.btnPic.setFocusable(false);
            this.btnPic.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            this.btnPic.addActionListener(e -> btnPicActionPerformed(e));
            ChatContentPane.add(this.btnPic, "cell 0 2");

            //---- btnFile ----
            this.btnFile.setText("\u6587\u4ef6");
            this.btnFile.setFocusPainted(false);
            this.btnFile.setFocusable(false);
            this.btnFile.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            this.btnFile.addActionListener(e -> btnFileActionPerformed(e));
            ChatContentPane.add(this.btnFile, "cell 0 2");

            //---- btnMsgRec ----
            this.btnMsgRec.setText("\u804a\u5929\u8bb0\u5f55");
            this.btnMsgRec.setFocusPainted(false);
            this.btnMsgRec.setFocusable(false);
            this.btnMsgRec.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            this.btnMsgRec.addActionListener(e -> btnMsgRecActionPerformed(e));
            ChatContentPane.add(this.btnMsgRec, "cell 1 2,alignx right,growx 0");

            //======== spInputMsg ========
            {

                //---- tpInputMsg ----
                this.tpInputMsg.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                this.tpInputMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
                this.tpInputMsg.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        tpInputMsgKeyReleased(e);
                    }
                });
                this.spInputMsg.setViewportView(this.tpInputMsg);
            }
            ChatContentPane.add(this.spInputMsg, "cell 0 3 2 1,grow");

            //---- btnSendMsg ----
            this.btnSendMsg.setText("\u53d1\u9001");
            this.btnSendMsg.setActionCommand("SendMessage");
            this.btnSendMsg.setFocusable(false);
            this.btnSendMsg.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            this.btnSendMsg.addActionListener(e -> btnSendMsgActionPerformed(e));
            ChatContentPane.add(this.btnSendMsg, "cell 1 4,alignx right");
            this.Chat.setSize(600, 600);
            this.Chat.setLocationRelativeTo(null);
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
    private JButton btnMsgRec;
    private JScrollPane spInputMsg;
    private JTextPane tpInputMsg;
    private JButton btnSendMsg;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
