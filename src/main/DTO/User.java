package DTO;

import DAO.DAO;

import java.sql.Date;
import java.util.ArrayList;

public class User {
    public static ArrayList<User> users = new ArrayList<>();

    private int ID;
    private String nickname;
    private String home;
    private Date birthday;
    private int age;
    private String sex;
    private ArrayList<Integer> friends;
    private ArrayList<String> records = new ArrayList<>();

    public User(int id, String nickname, String home, int age, Date Birthday, String sex, ArrayList<Integer> friends) {
        this.ID = id;
        this.nickname = nickname;
        this.home = home;
        this.age = age;
        this.birthday = Birthday;
        this.sex = sex;
        this.friends = friends;
    }

    public ArrayList<String> getRecords() {
        return records;
    }

    public int getID() {
        return ID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public String getHome() {
        return home;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public static User getUser(int ID) {
        for (User u : users) {
            if (u.getID() == ID)
                return u;
        }
        User nu;
        ArrayList<String> columnLabels = initColumnLabels(true);
        ArrayList<ArrayList<Object>> userObjs = DAO.search("SELECT ID,nickname,home,age,birthday,sex,friends FROM user where ID=" + ID, columnLabels);
        String f = (String) userObjs.get(6).get(0);
        String[] fs = f.split(",");
        ArrayList<Integer> friends = new ArrayList<Integer>();
        for (String fi : fs) {
            if (!fi.isBlank())
                friends.add(Integer.parseInt(fi));
        }
        if (userObjs.get(0).size() > 0) {
            nu = new User(
                    (Integer) userObjs.get(0).get(0),
                    (String) userObjs.get(1).get(0),
                    (String) userObjs.get(2).get(0),
                    (Integer) userObjs.get(3).get(0),
                    (Date) userObjs.get(4).get(0),
                    (String) userObjs.get(5).get(0),
                    friends);
            users.add(nu);
            return nu;
        }
        else
            return null;
    }

   private static ArrayList<String> initColumnLabels(boolean friends) {
        ArrayList<String> columnLabels = new ArrayList<>();
        columnLabels.add("ID");
        columnLabels.add("nickname");
        columnLabels.add("home");
        columnLabels.add("age");
        columnLabels.add("birthday");
        columnLabels.add("sex");
        if (friends)
            columnLabels.add("friends");
        return columnLabels;
    }

}
