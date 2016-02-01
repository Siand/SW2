import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OnlineTable
{
	JFrame frame;
	public OnlineTable()
	{
		String oT = "";
		 for(int i=0;i<Online.online.size();i++)
		 {
			oT +=Online.online.get(i) ;
			oT +="\n";
		 }
		 JLabel onlineTable = new JLabel(oT);
		 
		frame = new JFrame("Players Online");
		frame.setSize(250, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(onlineTable);
		frame.setVisible(false);
	}
	public void setVisible(boolean b)
	{
		frame.setVisible(b);
	}
}
