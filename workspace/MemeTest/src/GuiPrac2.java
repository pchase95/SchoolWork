import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiPrac2 extends JFrame
{
	private JLabel item1;
	
	
	public GuiPrac2()
	{
		super("Dank Memes");
		setLayout(new FlowLayout());
		item1 = new JLabel("I love memes <3");
		item1.setToolTipText("This is my swamp");
		add(item1);
	}
}