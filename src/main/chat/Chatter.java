package chat;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import DTO.User;
import ui.FormManager;


public class Chatter {
    public static User curUser;

    public static void main(String[] args) {
        FlatGitHubIJTheme.setup();
        FormManager.FL.show(true);
    }
}
