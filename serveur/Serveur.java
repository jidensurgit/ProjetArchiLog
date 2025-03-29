package serveur;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.*;

public class Serveur implements Runnable {
    private ServerSocket listen_socket;
    private Class<? extends Runnable> service;

    // Cree un serveur TCP — objet de la classe ServerSocket
    public Serveur(int port, Class<? extends Runnable> service) throws IOException {
        listen_socket = new ServerSocket(port);
        this.service = service;
    }

    // Le serveur ecoute et accepte les connexions.
    // pour chaque connexion, il cree un ServiceInversion,
    // qui va la traiter, et le lance
    public void run() {
        try {
            System.err.println("Lancement du serveur au port "+this.listen_socket.getLocalPort());
            while(true)
                new Thread(
                        this.service.getDeclaredConstructor(Socket.class).newInstance(listen_socket.accept()))
                        .start();
        }
        catch (InstantiationException | IllegalAccessException e) {
            try {this.listen_socket.close();} catch (IOException e1) {}
            System.err.println("Arrêt du serveur au port "+this.listen_socket.getLocalPort());
        } catch (InvocationTargetException | NoSuchMethodException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // restituer les ressources → finalize
    protected void finalize() throws Throwable {
        try {this.listen_socket.close();} catch (IOException e1) {}
    }
}
