package serveur;

import serveur.service.Mediateque;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable {
    private final ServerSocket listen_socket;
    private final Class<? extends Runnable> service;
    private final Mediateque mediateque;

    // Cree un serveur TCP — objet de la classe ServerSocket
    public Serveur(int port, Class<? extends Runnable> service, Mediateque mediateque) throws IOException {
        listen_socket = new ServerSocket(port);
        this.service = service;
        this.mediateque = mediateque;
    }


    public void run() {
        try {
            System.err.println("Lancement du serveur au port "+this.listen_socket.getLocalPort());
            while(true)
                new Thread(
                        this.service.getDeclaredConstructor(Socket.class, Mediateque.class).newInstance(listen_socket.accept(), mediateque))
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
