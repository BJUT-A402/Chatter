package Utils;

import DAO.DAO;
import DTO.User;

import java.util.ArrayList;

public class Account {
    public static boolean online(User user) {
        return true;
    }

    // 数据库验证登录
    public static int validateLogin(int account, String password) {
        ArrayList<Object> IDs = DAO.search("SELECT ID FROM user", "ID");
        if (!findID(account, IDs))
            return CError.ID_NOT_FOUND;
        else {
            ArrayList<Object> passwords = DAO.search("SELECT password FROM user where ID='" + account + "'", "password");
            String pw = (String) passwords.get(0);
            if (!pw.equals(password)) {
                return CError.WRONG_PASSWORD;
            } else {
                return CError.SUCCESS;
            }
        }
    }

    // 数据库验证注册
    public static int validateRegister(int account) {
        ArrayList<Object> IDs = DAO.search("SELECT ID FROM user", "ID");
        if (findID(account, IDs))
            return CError.ID_EXISTED;
        else
            return CError.SUCCESS;
    }

    // 在数据库中注册用户
    public static int register(int ID, String password) {
        String sql = "INSERT INTO user (ID,password,nickname,home,age,birthday,sex,friends)" +
                " VALUES (" + ID + ",'" +
                password + "','" +
                ID + "','',0,'2000-01-01','','')";
        return DAO.executeSQL(sql, DAO.INSERT);
    }

    private static boolean findID(int account, ArrayList<Object> result) {
        for (Object obj : result) {
            int uid = (Integer) obj;
            if (uid == account)
                return true;
        }
        return false;
    }

    public static ArrayList<User> getFriends(ArrayList<Integer> IDs) {
        return null;
    }
}
