package ui;

import DTO.User;
import Utils.Account;
import chat.Chatter;
import net.miginfocom.swing.MigLayout;
import Kernel.Kernel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static Utils.Utils.updateFriendsList;


public class FormFriends extends Form {
    public ArrayList<User> friends = new ArrayList<User>();
    public ArrayList<String> list = new ArrayList<>();

    public FormFriends() {
        initComponents();
    }

    private void btnAddFriendActionPerformed(ActionEvent e) {
        FormManager.FAF.show(true);
    }

    private void listFriendsMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            sendMessageW();
        } else if (e.isMetaDown()) {
            int index = listFriends.locationToIndex(e.getPoint());
            listFriends.setSelectedIndex(index);
            pmFriends.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private void miPersonDetailActionPerformed(ActionEvent e) {
        User u = User.getUser(Integer.parseInt(listFriends.getSelectedValue().split("_")[1]));
        FormManager.FD.setUser(u);
        FormManager.FD.show(true);
    }

    private void miDeleteFriendActionPerformed(ActionEvent e) {
        int uid = Integer.parseInt(listFriends.getSelectedValue().split("_")[1]);
        User u = User.getUser(uid);
        Account.deleteFriend(Chatter.curUser, u);
        updateFriendsList();
        Kernel.sendMessage("%");
    }

    private void btnMyDetailActionPerformed(ActionEvent e) {
        FormManager.FD.setUser(Chatter.curUser);
        FormManager.FD.show(true);
    }

    private void btnChangeThemeActionPerformed(ActionEvent e) {
        FormManager.FT.show(true);
    }

    private void miSendMessageActionPerformed(ActionEvent e) {
        sendMessageW();
    }

    private void sendMessageW() {
        boolean online = false;
        String item = listFriends.getSelectedValue();
        String[] temp = item.split("_");
        for (int i = 0; i < listAllUsers.getModel().getSize(); i++) {
            if (listAllUsers.getModel().getElementAt(i).equals(item)) {
                online = true;
                break;
            }
        }
        if (!online) {
            JOptionPane.showMessageDialog(null, "对方不在线！");
        }
        if (FormManager.FC.setChat(Integer.parseInt(temp[1]))) {
            FormManager.FC.updateRecords();
            FormManager.FC.show(true);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Friends = new JFrame();
        lbMyFriends = new JLabel();
        spFriends = new JScrollPane();
        listFriends = new JList<>();
        lbAllUsers = new JLabel();
        spAllusers = new JScrollPane();
        listAllUsers = new JList();
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
            Friends.setResizable(false);
            Friends.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Friends.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    Friends.setTitle(Chatter.curUser.getNickname());
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    Kernel.disconnect();
                }
            });
            var FriendsContentPane = Friends.getContentPane();
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
                listFriends.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        listFriendsFocusLost(e);
                    }
                });
                spFriends.setViewportView(listFriends);
            }
            FriendsContentPane.add(spFriends, "cell 0 1,grow,gapx 2 2");

            //---- lbAllUsers ----
            lbAllUsers.setText("\u6240\u6709\u7528\u6237\uff08\u670d\u52a1\u5668\uff09");
            lbAllUsers.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
            FriendsContentPane.add(lbAllUsers, "cell 0 2,gapx 2");

            //======== spAllusers ========
            {

                //---- listAllUsers ----
                listAllUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                listAllUsers.setFocusable(false);
                listAllUsers.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                listAllUsers.addListSelectionListener(e -> listAllUsersValueChanged(e));
                spAllusers.setViewportView(listAllUsers);
            }
            FriendsContentPane.add(spAllusers, "cell 0 3,grow,gapx 2 2");

            //---- btnAddFriend ----
            btnAddFriend.setText("\u6dfb\u52a0\u597d\u53cb");
            btnAddFriend.setFocusable(false);
            btnAddFriend.addActionListener(e -> btnAddFriendActionPerformed(e));
            FriendsContentPane.add(btnAddFriend, "cell 0 4,alignx center,growx 0,width 60");

            //---- btnMyDetail ----
            btnMyDetail.setText("\u6211\u7684\u8d44\u6599");
            btnMyDetail.setFocusable(false);
            btnMyDetail.addActionListener(e -> btnMyDetailActionPerformed(e));
            FriendsContentPane.add(btnMyDetail, "cell 0 4,alignx center,growx 0,width 60");

            //---- btnChangeTheme ----
            btnChangeTheme.setText("\u66f4\u6539\u4e3b\u9898");
            btnChangeTheme.setFocusable(false);
            btnChangeTheme.addActionListener(e -> btnChangeThemeActionPerformed(e));
            FriendsContentPane.add(btnChangeTheme, "cell 0 4");
            Friends.setSize(260, 550);
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

    private void listAllUsersValueChanged(ListSelectionEvent e) {
        listFriends.setSelectedIndices(new int []{});
    }

    private void listFriendsFocusLost(FocusEvent e) {
        listFriends.setSelectedIndices(new int []{});
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Friends;
    private JLabel lbMyFriends;
    private JScrollPane spFriends;
    public JList<String> listFriends;
    private JLabel lbAllUsers;
    private JScrollPane spAllusers;
    public JList listAllUsers;
    private JButton btnAddFriend;
    private JButton btnMyDetail;
    private JButton btnChangeTheme;
    private JPopupMenu pmFriends;
    private JMenuItem miSendMessage;
    private JMenuItem miPersonDetail;
    private JMenuItem miDeleteFriend;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
