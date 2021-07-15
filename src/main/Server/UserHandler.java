package Server;

import java.util.Scanner;

public class UserHandler implements Runnable {

    private Server server;
    private ServerUser user;

    public UserHandler(Server server, ServerUser user) {
        this.server = server;
        this.user = user;
        this.server.broadcastAllUsers();
    }

    public void run() {
        String message;

        // when there is a new message, broadcast to all
        Scanner sc = new Scanner(this.user.getInputStream());
        while (sc.hasNextLine()) {
            message = sc.nextLine();

            // Gestion des messages private
            if (message.charAt(0) == '@') {
                if (message.contains(":")) {
                    System.out.println("private msg : <" + message);
                    if (message.charAt(1) == '<') {
                        int firstSpace = message.indexOf(":");
                        String userPrivate = message.substring(2, firstSpace);
                        int userPrivateID = Integer.parseInt(userPrivate);
                        server.sendMessageToUser(
                                message.substring(
                                        firstSpace + 1
                                ), user, userPrivateID, false, true
                        );
                    }
                    else {
                        int firstSpace = message.indexOf(":");
                        String userPrivate = message.substring(1, firstSpace);
                        int userPrivateID = Integer.parseInt(userPrivate);
                        server.sendMessageToUser(
                                message.substring(
                                        firstSpace + 1
                                ), user, userPrivateID, false, false
                        );
                    }
                }
            } else if (message.charAt(0) == '&') {
                System.out.println("Add Friend");
                String userPrivate = message.substring(1);
                int userPrivateID = Integer.parseInt(userPrivate);
                server.sendMessageToUser("", user, userPrivateID, true, false);
            } else if (message.charAt(0) == '%') {
                server.broadcastMessages("%");
            } else {
                // update user list
                server.broadcastMessages(message);
            }
        }
        // end of Thread
        server.removeUser(user);
        this.server.broadcastAllUsers();
        sc.close();
    }
}
