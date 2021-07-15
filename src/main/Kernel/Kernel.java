package Kernel;

import DTO.User;
import Utils.*;
import chat.Chatter;
import ui.FormManager;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Kernel {
    public static Socket server;
    public static BufferedReader input;
    public static Read read;
    public static PrintWriter output;

    public static boolean connectServer() {
        try {
            // 连接服务器，初始化输入输出接收器
            server = new Socket(Utils.SERVER_IP, Utils.SERVER_PORT);
            input = new BufferedReader(new InputStreamReader(server.getInputStream(), StandardCharsets.UTF_8));
            output = new PrintWriter(server.getOutputStream(), true, StandardCharsets.UTF_8);

            // 广播自己的ID上线
            output.println(Chatter.curUser.getID());

            // 初始化读取线程
            read = new Read();
            read.start();
        } catch (IOException e) {
            e.printStackTrace();
            CError.error(CError.CONNECT_ERROR);
        }
        return true;
    }

    public static void sendMessage(String message) {
        try {
            if (message.equals("")) {
                return;
            }
            output.println(message);
        } catch (Exception ex) {
            CError.error(CError.SEND_MESSAGE_ERROR);
        }
    }

    public static void disconnect() {
        read.interrupt();
        output.close();
    }
}

class Read extends Thread {
    public void run() {
        String message;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                message = Kernel.input.readLine();
                if (message != null) {
                    // 获取服务器所有用户
                    if (message.charAt(0) == '[') {
                        message = message.substring(1, message.length() - 1);
                        ArrayList<String> ListUser = new ArrayList<>(
                                Arrays.asList(message.split(", "))
                        );
                        ArrayList<User> allUsers = new ArrayList<>();
                        for (String user : ListUser) {
                            int uid = Integer.parseInt(user);
                            User f = User.getUser(uid);
                            allUsers.add(f);
                            for (int i = 0; i < FormManager.FF.listFriends.getModel().getSize(); i++) {
                                if (FormManager.FF.listFriends.getModel().getElementAt(i).equals(f.getNickname() + "_" + f.getID())) {
                                    String tips = "你的好友 " + f.getNickname() + " 上线了！";
                                    JOptionPane.showMessageDialog(null, tips);
                                    break;
                                }
                            }
                        }
                        Utils.updateAllUsersList(allUsers);
                    }
                    // 获取信息
                    else {
                        if (message.contains("&")) {
                            String from = message.split("&")[0];
                            User fromUser = User.getUser(Integer.parseInt(from));
                            String tips = fromUser.getNickname() + "请求添加你为好友，是否同意？";
                            if (JOptionPane.showConfirmDialog(null, tips, "提示", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                                Account.addFriend(Chatter.curUser, fromUser);
                                Utils.updateFriendsList();
                                Kernel.sendMessage("%");
                            }
                        } else if (message.contains("->")) {
                            String from = message.substring(0, message.indexOf("->"));
                            String msg = message.substring(message.indexOf(":") + 1);
                            int fromID = Integer.parseInt(from);
                            User fromUser = User.getUser(fromID);
                            fromUser.getRecords().add(fromUser.getNickname() + ":" + msg);
                            if (FormManager.FC.tosend != null)
                                FormManager.FC.updateRecords();
                            if (fromID != Chatter.curUser.getID() && !FormManager.FC.showing) {
                                String tips = fromUser.getNickname() + "给你发消息了！";
                                JOptionPane.showMessageDialog(null, tips);
                            }
                        } else if (message.charAt(0) == '%') {
                            Utils.updateFriendsList();
                        }
                    }
                }
            } catch (IOException ex) {
                System.err.println("Failed to parse incoming message");
            }
        }
    }
}