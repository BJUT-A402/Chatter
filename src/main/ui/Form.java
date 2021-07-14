package ui;

public class Form {
    public boolean Showing;


    public Form() {
        Showing = false;
    }

    public void show(boolean status) {
        Showing = status;
        Form t = this;
        if (this instanceof FormChat) {
            ((FormChat) t).Chat.setVisible(status);
        } else if (this instanceof FormDetail) {
            ((FormDetail) t).Detail.setVisible(status);
        } else if (this instanceof FormFriends) {
            ((FormFriends) t).Friends.setVisible(status);
        } else if (this instanceof FormLogin) {
            ((FormLogin) t).Login.setVisible(status);
        } else if (this instanceof FormTheme) {
            ((FormTheme) t).Theme.setVisible(status);
        } else if (this instanceof FormRegister) {
            ((FormRegister) t).Register.setVisible(status);
        } else if (this instanceof FormAddFriend) {
            ((FormAddFriend) t).AddFriend.setVisible(status);
        }
    }
}
