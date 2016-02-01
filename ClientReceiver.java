import java.io.*;
import java.net.*;

// Gets messages from other clients via the server (by the
// ServerSender thread).

public class ClientReceiver extends Thread {

  private BufferedReader server;

  ClientReceiver(BufferedReader server) {
    this.server = server;
  }

  public void run() {
    // Print to the user whatever we get from the server:
	  
    try {
      while (true) {	
        String s = server.readLine();
        boolean flag=false;
		for(int i=0;i<Online.online.size();i++)
        	if(Online.online.get(i).equals(s))
        		flag=true;
		System.out.println(Online.online.size());
        if(flag)
        {
        	Proposal p = new Proposal(s);
        }
      }
    }
    catch (IOException e) {
      System.out.println("Server seems to have died " + e.getMessage());
      System.exit(1); // Give up.
    }
  }
}
