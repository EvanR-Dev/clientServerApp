import java.io.*;
import java.net.*;
import java.time.*;

class server {
    //main thread of the program
    //serves to initialize everything we need
    //also establishes connection with clients & logs it
    //+ spawns threads to deal with client requests
    public static void main(String[] argv) throws Exception {
        
    }
}

//Basically serves as a "struct"
//holds needed information to process a given clients request
class ticket {
    Socket client;
    String clientName;
    String equation;
    public ticket(Socket c, String cN, String eq) {
        client = c;
        clientName = cN;
        equation = eq;
    }
}
