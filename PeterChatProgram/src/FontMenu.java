import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class FontMenu implements ActionListener
{
    private String fonts2[] = 
      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    
    public Font Lucida = new Font("Lucida Sans", Font.PLAIN, 15);
    public Font Serif = new Font("SansSerif", Font.BOLD, 15);
    public Font Mono = new Font("FreeMono", Font.ITALIC, 15);
    public String[] fonts = {Lucida.getFamily(), Serif.getFamily(), Mono.getFamily()};
    
    private JComboBox<String> FontBox = new JComboBox<>(fonts);
    private JScrollPane ScrollBox;
    private JButton b = new JButton("meme");
    private JPanel p;
    private JFrame f;
    private String selected = "";
    
    private JButton ok = new JButton("Ok");
    
    public void buildBox()
    {
        f = new JFrame("Font Test");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(150, 150);
        p = new JPanel();
        ScrollBox = new JScrollPane(FontBox);
        FontBox.setSelectedIndex(0);
        FontBox.addActionListener(this);
        p.add(ScrollBox);
        p.add(ok);
        ok.addActionListener(this);
        
        f.add(p);
        f.setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent b)
    {
        if(b.getSource() == ok)
        {
             selected = fonts[FontBox.getSelectedIndex()];
             f.dispose();
        }
    }
}
