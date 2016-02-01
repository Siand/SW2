import java.io.PrintStream;

import javax.swing.JFrame;

public class Menu
{
	public Menu(PrintStream stream,String nickname)
	{
		MenuOptions1 m1= new MenuOptions1(stream,nickname);
		JFrame frame = new JFrame("Noughts and Crosses ONLINE");
		frame.setSize(250, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(m1);
		frame.setVisible(true);
	}
}
