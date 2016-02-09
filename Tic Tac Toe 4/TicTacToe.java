import javax.swing.*;


public class TicTacToe
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setSize(622, 956);
		frame.add(new CellPanel());
		frame.setVisible(true);
	}
}