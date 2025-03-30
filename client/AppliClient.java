package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

import static serveur.AppliServeur.*;

public class AppliClient {

    private final static String HOST = "localhost";
    private static Scanner sc;

    public static void main(String[] args) {

        final int SERVICE_INVALIDE = -1;

        sc = new Scanner(System.in);
        String command;
        int port;

        do {
            System.out.println("Entrez une commande [exit], [reservation], [emprunt], [retour]");
            command = sc.nextLine();
            try {
                port = switch (command) {
                    case "reservation" -> PORT_RESERVATION;
                    case "emprunt" -> PORT_EMPRUNT;
                    case "retour" -> PORT_RETOUR;
                    default -> SERVICE_INVALIDE;
                };
                if (port != SERVICE_INVALIDE)
                    demarrerService(port);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (!Objects.equals(command, "exit"));
        sc.close();
    }

    private static void demarrerService(int port) throws IOException {
        if (port != PORT_RESERVATION && port != PORT_EMPRUNT && port != PORT_RETOUR)
            throw new IllegalArgumentException("Port invalide");
        Socket socket = new Socket(HOST, port);
        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String command;

        System.out.println(in.nextLine());

        do {
            System.out.println(in.nextLine());
            System.out.println(in.nextLine());
            command = sc.nextLine();
            out.println(command);
            System.out.println(in.nextLine());
        } while (!command.equals("exit"));

        socket.close();
    }
}