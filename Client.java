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
        
        //used to read from the server
        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));
        //used to send to the server
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        //used to read stuff into variables from the user
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        ////////////////////// HANDSHAKE /////////////////////////////////

        //prompt user for a name, which is sent to the server
        System.out.print("Hello client!\n" +
                "Please enter your name (will be provided to server): ");
        //Save name from user input
        NAME = inFromUser.readLine();
        
        //tell server the clients name
        outToServer.writeBytes(NAME + '\n');

        //ensure it gets confirmed
        answer = inFromServer.readLine();
        System.out.println("FROM SERVER: " + answer);
        
        if(answer.equals("OK")) {
            System.out.println("The handshake succeeded.\n" +
                    "Please note, equations must be in the form \"<positive int><space><operation><space><positive int>\".\n" +
                    "You must also tell the server you are exiting by using \"EXIT\"");
        }
        else {
            System.out.println("HANDSHAKE FAILED, PLEASE RESTART PROGRAM & TRY AGAIN");
            return;
        }
        
        ///////////////////////////// BEGIN QUESTION SENDING //////////////////////////////////
        
        

        clientSocket.close();
    }
}
