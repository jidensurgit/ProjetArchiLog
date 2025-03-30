package serveur.service;

import java.net.Socket;

public abstract class Service implements Runnable {
    private static int cpt = 1;

    private final int numero;
    private final Socket client;

    public Socket getClient() {
        return client;
    }

    public int getNumero() {
        return numero;
    }

    public Service(Socket socket) {
        this.numero = cpt++;
        this.client = socket;
    }

    public abstract void run();

    protected void finalize() throws Throwable {
        client.close();
    }

}
