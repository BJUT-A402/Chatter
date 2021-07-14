package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    private int port;
    private List<ServerUser> clients;
    private ServerSocket server;

    public static void main(String[] args) throws IOException {
        new Server(3500).run();
    }

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void run() throws IOException {
        server = new ServerSocket(port) {
            protected void finalize() throws IOException {
                this.close();
            }
        };
        System.out.println("Port 3500 is now open.");

        while (true) {
            // accepts a new client
            Socket client = server.accept();

            // get nickname of newUser
            String nickname = (new Scanner(client.getInputStream())).nextLine();
            nickname = nickname.replace(",", ""); //  ',' use for serialisation
            nickname = nickname.replace(" ", "_");
            int id = Integer.parseInt(nickname);
            System.out.println("New Client: \"" + nickname + "\"\n\t     Host:" + client.getInetAddress().getHostAddress());

            // create new User
            ServerUser newUser = new ServerUser(client, id);

            // add newUser message to list
            this.clients.add(newUser);

            // Welcome msg
//            newUser.getOutStream().println(
//                    "<img src='https://www.kizoa.fr/img/e8nZC.gif' height='42' width='42'>"
//                            + "<b>Welcome</b> " + newUser.toString() +
//                            "<img src='https://www.kizoa.fr/img/e8nZC.gif' height='42' width='42'>"
//            );

            // create a new thread for newUser incoming messages handling
            new Thread(new UserHandler(this, newUser)).start();
        }
    }

    // delete a user from the list
    public void removeUser(ServerUser user) {
        this.clients.remove(user);
    }

    // send incoming msg to all Users
    public void broadcastMessages(String msg) {
        for (ServerUser client : this.clients) {
            client.getOutStream().println(msg);
        }
    }

    // send list of clients to all Users
    public void broadcastAllUsers() {
        for (ServerUser client : this.clients) {
            client.getOutStream().println(this.clients);
        }
    }

    // send message to a User (String)
    public void sendMessageToUser(String msg, ServerUser userSender, int user, boolean add) {
        boolean find = false;
        for (ServerUser client : this.clients) {
            if (client.getUserId() == user && client != userSender) {
                find = true;
                if (add) {
                    client.getOutStream().println(userSender + "&" + client);
                } else {
                    userSender.getOutStream().println(userSender + "->" + client + ":" + msg);
                    client.getOutStream().println(userSender + "->" + client + ":" + msg);
                }
            }
        }
        if (!find && !add) {
            userSender.getOutStream().println(userSender + " -> (<b>no one!</b>): " + msg);
        }
    }

}

