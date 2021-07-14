package ui;

import java.util.ArrayList;

public class FormManager {
    public static FormFriends FF = new FormFriends();
    public static FormChat FC = new FormChat();
    public static FormDetail FD = new FormDetail();
    public static FormLogin FL = new FormLogin();
    public static FormTheme FT = new FormTheme();
    public static FormRegister FR = new FormRegister();
    public static FormAddFriend FAF = new FormAddFriend();
    private static ArrayList<Form> allForms = new ArrayList<>();

    public static void hideAllForms() {
        if (allForms.isEmpty()) {
            initAllForms();
        }

        for (Form form : allForms) {
            form.show(false);
        }
    }

    private static void initAllForms() {
        allForms.add(FC);
        allForms.add(FF);
        allForms.add(FL);
        allForms.add(FD);
        allForms.add(FT);
        allForms.add(FR);
        allForms.add(FAF);
    }
}
