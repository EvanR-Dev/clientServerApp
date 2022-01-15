import java.io.*;
import java.net.*;
import java.time.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.regex.Pattern;

class Server {
    //main thread of the program
    //serves to initialize everything we need
    //also establishes connection with clients & logs it
    //+ spawns threads to deal with client requests
    public static void main(String[] argv) throws Exception {
        //create fresh log file
        File logfile = new File("log.txt");
        //creates log file
        //delete it if it already exists
        if(logfile.exists())
            logfile.delete();
        //create fresh file
        logfile.createNewFile();

        //used to write to logfile
        FileWriter log = new FileWriter("log.txt", true);

        //used so dealers can queue up tickets for the worker to execute
        LinkedList<ticket> ticketQ = new LinkedList<ticket>();

        //start up a worker thread for later
        worker workerThread = new worker(ticketQ, log);
        new Thread(workerThread).start();

        ServerSocket welcomeSocket = new ServerSocket(6789);
    }
}

//This thread is responsible for actually processing all the clients requests
//These requests are placed onto a queue that the client's dealers add to
class Worker implements Runnable{
    LinkedList<Ticket> ticketQ;
    FileWriter log;

    public Worker(LinkedList<Ticket> q, FileWriter l) {
        ticketQ = q;
        log = l;
    }
}

//Basically serves as a "struct"
//holds needed information to process a given clients request
class Ticket {
    Socket client;
    String clientName;
    String equation;
    public Ticket(Socket c, String cN, String eq) {
        client = c;
        clientName = cN;
        equation = eq;
    }
}
