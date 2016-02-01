import java.net.*;
import java.io.*;

// Gets messages from client and puts them in a queue, for another
// thread to forward to the appropriate client.

public class ServerReceiver extends Thread {
  private String myClientsName;
  private BufferedReader myClient;
  private Scores scores;
  private PrintStream print;
  private ClientTable table;

  public ServerReceiver(String n, BufferedReader c, PrintStream p, Scores s,ClientTable clientTable) {
    myClientsName = n;
    myClient = c;
    scores = s;
    print=p;
    table = clientTable;
  }

  public void run() {
    try {
      while (true) {
        String command = myClient.readLine();
        boolean flag=false;

        	for(int i=0;i<Online.online.size();i++)
        		if(command.equals(Online.online.get(i)))
        			flag=true;
        	if(!flag)
        		print.println("Player not found");
        	else 
        	{
        		Message c = new Message(command,myClientsName);
        		MessageQueue queue = table.getQueue(command);
        		queue.offer(c);	
        	}
        	
       // TODO 	else 
        		//connection
        		// game init
        		// updates?????
      }
    }
    catch (IOException e) {
      System.err.println("Something went wrong with the client " 
                       + myClientsName + " " + e.getMessage()); 
      // No point in trying to close sockets. Just give up.
      // We end this thread (we don't do System.exit(1)).
    }
  }
}
