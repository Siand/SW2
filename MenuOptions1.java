import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.PrintStream;

public class MenuOptions1 extends JPanel
{
	public MenuOptions1(PrintStream server, String nickname,BufferedReader reader)
	{
		super();
		OpponentChallenger opponent= new OpponentChallenger(server);
		OnlineTable onlineTable= new OnlineTable();
		JLabel nick = new JLabel("Logged in as " + nickname);
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(e->
		{
			opponent.setVisible(true);
			onlineTable.setVisible(false);
		});
		
		JButton online = new JButton("Online opponents");
		online.addActionListener(e->
		{
			server.println("online");
			String x="";
			try {
				x=reader.readLine();
				System.out.println(x);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			onlineTable.setTable(x);
			opponent.setVisible(false);
			onlineTable.setVisible(true);
			
		});


		setLayout(new BorderLayout());
		
		add(nick, BorderLayout.NORTH);
		add(newGame, BorderLayout.CENTER);
		add(online, BorderLayout.SOUTH);
	}
}
