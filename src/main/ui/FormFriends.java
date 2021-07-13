package ui;

import DTO.User;
import chat.Chatter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class FormFriends extends Form {
    private ArrayList<User> 

    public FormFriends() {
        initComponents();
    }

    private void btnAddFriendActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void listFriendsMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            String item = listFriends.getModel().getElementAt(listFriends.getSelectedIndex()).toString();
            String[] temp = item.split("_");
            if (FormManager.FC.setChat(Integer.parseInt(temp[1])))
                FormManager.FC.show(true);
        }
    }

    private void miPersonDetailActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void miDeleteFriendActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnMyDetailActionPerformed(ActionEvent e) {
        FormManager.FD.setUser(Chatter.curUser);
        FormManager.FD.show(true);
    }

    private void btnChangeThemeActionPerformed(ActionEvent e) {
        FormManager.FT.show(true);
    }

    private void miSendMessageActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void updateFriendsList() {

        listFriends.setModel(new AbstractListModel<>() {
            ArrayList<Integer> values = Chatter.curUser.getFriends();

            @Override
            public int getSize() {
                return values.size();
            }

            @Override
            public String getElementAt(int i) {
                return String.valueOf(values.get(i));
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Friends = new JFrame();
        lbMyFriends = new JLabel();
        spFriends = new JScrollPane();
        listFriends = new JList<>();
        btnAddFriend = new JButton();
        btnMyDetail = new JButton();
        btnChangeTheme = new JButton();
        pmFriends = new JPopupMenu();
        miSendMessage = new JMenuItem();
        miPersonDetail = new JMenuItem();
        miDeleteFriend = new JMenuItem();

        //======== Friends ========
        {
            Friends.setMinimumSize(new Dimension(220, 440));
            Friends.setTitle("\u6e05\u98ce\u98de\u96ea");
            Friends.setResizable(false);
            Friends.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Friends.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    updateFriendsList();
                }
            });
            Container FriendsContentPane = Friends.getContentPane();
            FriendsContentPane.setLayout(new MigLayout(
                    "hidemode 3,alignx center",
                    // columns
                    "[grow]",
                    // rows
                    "[]" +
                            "[grow]" +
                            "[]"));

            //---- lbMyFriends ----
            lbMyFriends.setText("\u6211\u7684\u597d\u53cb");
            lbMyFriends.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
            FriendsContentPane.add(lbMyFriends, "cell 0 0,gapx 2");

            //======== spFriends ========
            {

                //---- listFriends ----
                listFriends.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                listFriends.setFocusable(false);
                listFriends.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                listFriends.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        listFriendsMouseClicked(e);
                    }
                });
                spFriends.setViewportView(listFriends);
            }
            FriendsContentPane.add(spFriends, "cell 0 1,grow,gapx 2 2");

            //---- btnAddFriend ----
            btnAddFriend.setText("\u6dfb\u52a0\u597d\u53cb");
            btnAddFriend.setFocusable(false);
            btnAddFriend.addActionListener(e -> btnAddFriendActionPerformed(e));
            FriendsContentPane.add(btnAddFriend, "cell 0 2,alignx center,growx 0,width 50");

            //---- btnMyDetail ----
            btnMyDetail.setText("\u6211\u7684\u8d44\u6599");
            btnMyDetail.setFocusable(false);
            btnMyDetail.addActionListener(e -> btnMyDetailActionPerformed(e));
            FriendsContentPane.add(btnMyDetail, "cell 0 2,alignx center,growx 0,width 50");

            //---- btnChangeTheme ----
            btnChangeTheme.setText("\u66f4\u6539\u4e3b\u9898");
            btnChangeTheme.setFocusable(false);
            btnChangeTheme.addActionListener(e -> btnChangeThemeActionPerformed(e));
            FriendsContentPane.add(btnChangeTheme, "cell 0 2");
            Friends.setSize(270, 550);
            Friends.setLocationRelativeTo(Friends.getOwner());
        }

        //======== pmFriends ========
        {

            //---- miSendMessage ----
            miSendMessage.setText("\u53d1\u9001\u6d88\u606f");
            miSendMessage.addActionListener(e -> miSendMessageActionPerformed(e));
            pmFriends.add(miSendMessage);

            //---- miPersonDetail ----
            miPersonDetail.setText("\u67e5\u770b\u8d44\u6599");
            miPersonDetail.addActionListener(e -> miPersonDetailActionPerformed(e));
            pmFriends.add(miPersonDetail);

            //---- miDeleteFriend ----
            miDeleteFriend.setText("\u5220\u9664\u597d\u53cb");
            miDeleteFriend.addActionListener(e -> miDeleteFriendActionPerformed(e));
            pmFriends.add(miDeleteFriend);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Friends;
    private JLabel lbMyFriends;
    private JScrollPane spFriends;
    private JList<String> listFriends;
    private JButton btnAddFriend;
    private JButton btnMyDetail;
    private JButton btnChangeTheme;
    private JPopupMenu pmFriends;
    private JMenuItem miSendMessage;
    private JMenuItem miPersonDetail;
    private JMenuItem miDeleteFriend;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
