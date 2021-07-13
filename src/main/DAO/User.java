package DAO;

public class User {
    public int id;
    public String nickname;
    public String home;
    public int age;
    public int BDay;
    public int BMonth;
    public int BYear;
    public String sex;

    public User(int id, String nickname, String home, int age, int BDay, int BMonth, int BYear, String sex) {
        this.id = id;
        this.nickname = nickname;
        this.home = home;
        this.age = age;
        this.BMonth = BMonth;
        this.BDay = BDay;
        this.BYear = BYear;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return id + " " +
                nickname + " " +
                sex + " " +
                age + " " +
                BYear + " " +
                BMonth + " " +
                BDay + " " +
                home + "\n";
    }
}
