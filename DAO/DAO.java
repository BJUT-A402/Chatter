package DAO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DAO {
    public static ArrayList<User> users = getUsers();
    public static String file = "E:\\Code\\jfd\\chatter-hw\\A402-Chatter\\source\\users.txt";

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        //数据库
        String str = readFileContent(file);
        String[] usersStr = str.split("\n");
        for (String userStr : usersStr) {
            String[] details = userStr.split(" ");
            users.add(new User(
                    Integer.parseInt(details[0]),
                    details[1],
                    details[7],
                    Integer.parseInt(details[3]),
                    Integer.parseInt(details[6]),
                    Integer.parseInt(details[5]),
                    Integer.parseInt(details[4]),
                    details[2]
            ));
        }
        return users;
    }

    public static User getUser(int uid) {
        for (User user : users) {
            if (user.id == uid) {
                return user;
            }
        }
        return null;
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        int cnt = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                if (cnt == 0) {
                    sbf.append(tempStr);
                }
                else {
                    sbf.append("\n" + tempStr);
                }
                cnt++;
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void continueWriteFile(String fileName, String str) {
        FileWriter fw = null;
        try {
            File f=new File(fileName);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(str);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}