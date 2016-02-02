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
        if(s.equals("ONLINE LIST"))
        	Thread.sleep(2000);
        else
        {
	        if(s!="Player not found" && s!="ONLINE LIST")
	        {
	        	Proposal p = new Proposal(s);
	        }
        }
      }
    }
    catch (IOException e) {
      System.out.println("Server seems to have died " + e.getMessage());
      System.exit(1); // Give up.
    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
