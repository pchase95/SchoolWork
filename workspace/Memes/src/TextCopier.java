import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextCopier extends JPanel implements ActionListener
{
	private JTextField textField = new JTextField();
	private JButton copyButton = new JButton("Copy");
	private JRadioButton radioNormal = new JRadioButton("Normal");
	private JRadioButton radioUpper = new JRadioButton("Upper Case");
	private JRadioButton radioLower = new JRadioButton("Lower Case");
	private JTextArea textArea = new JTextArea();
	
	
	public TextCopier()
	{
		JFrame f = new JFrame("Text Copier");
		f.setVisible(true);
		f.setSize(600, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		f.add(p);
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setBackground(Color.black);
		
		JScrollPane pane = new JScrollPane(textArea);
		textArea.setColumns(40);
		textArea.setRows(5);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		p.add(pane, BorderLayout.SOUTH);
		
		p.add(textField, BorderLayout.NORTH);
		
		p.add(copyButton, BorderLayout.WEST);
		copyButton.addActionListener(this);
		
		GridLayout gridLayout = new GridLayout(3, 0);
		JPanel grid = new JPanel();
		grid.setLayout(gridLayout);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioNormal);
		grid.add(radioNormal);
		radioNormal.setSelected(true);
		group.add(radioUpper);
		grid.add(radioUpper);		
		group.add(radioLower);
		grid.add(radioLower);
		p.add(grid,BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args)
	{
		new TextCopier();
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(radioNormal.isSelected())
			textArea.append(textField.getText());
		if(radioUpper.isSelected())
			textArea.append(textField.getText().toUpperCase());
		if(radioLower.isSelected())
			textArea.append(textField.getText().toLowerCase());
	}
}