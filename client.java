import java.io.*;
import java.net.*;


class client {
    public static void main(String[] args) throws Exception {
        //name given to server when handshaking
        String NAME;
        //used to hold what's sent & received from server
        String equation;
        String answer;

        //socket connection
        Socket clientSocket = new Socket("127.0.0.1", 6789);

        clientSocket.close();
    }
}
