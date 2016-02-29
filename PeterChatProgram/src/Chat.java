// panel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Chat implements ActionListener
{
  private FontMenu fontmenu = new FontMenu();
  private JFrame f;
  private JPanel p;
  private JPanel south;
  private JPanel chode;
  private JPanel mPan;
  
  private JButton font_button = new JButton("Font");

  private JPanel tab1 = new JPanel();
  private JTabbedPane tabs = new JTabbedPane();
  private JTextArea chat_box = new JTextArea();
  private JLabel buffer = new JLabel();
  
  private JScrollPane scroll1;
  private JScrollPane scroll2;
  
  JList<Person> list = new JList<>();
 // JList<JLabel> mList = new JList<>();
  LinkedList<Message> messages = new LinkedList<>();
  LinkedList<JLabel> labels = new LinkedList<>();
  
  
  private JButton send = new JButton("Send");

  public Chat()
  {
    f = new JFrame("ChasePlace");
    f.setSize(800, 600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    p = new JPanel();
    p.setBackground(Main.back_ground);
    p.setLayout(new BorderLayout());

    tabs.add("Main Channel", tab1);
    tab1.setLayout(new BorderLayout());
   // area.setLineWrap(true);
   // area.setEditable(false);
    south = new JPanel();
    chode = new JPanel();
    chode.setLayout(new BorderLayout());
    south.setLayout(new GridLayout(0, 1));
    south.add(buffer);
    chat_box.setLineWrap(true);
    scroll2 = new JScrollPane(chat_box);
    south.add(scroll2);
    buffer.setBackground(Main.back_ground);
    chode.add(send, BorderLayout.EAST);
    chode.add(font_button, BorderLayout.WEST);
    font_button.addActionListener(this);
   // scroll1 = new JScrollPane(area);
    chode.add(south, BorderLayout.CENTER);
    // tab1.add(scroll1, BorderLayout.CENTER);
    tab1.add(chode, BorderLayout.SOUTH);
    
    DefaultListModel<Person> model = new DefaultListModel<Person>();
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setModel(model);
    for(Person per : Main.People)
    {
        model.addElement(per);
    }
    list.getSelectionModel().addListSelectionListener(e -> {
            Person per = list.getSelectedValue();
            
    });
    
   /* DefaultListModel<JLabel> model2 = new DefaultListModel<>();
    mList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    mList.setModel(model2);
    for(JLabel lab : labels)
    {
        model2.addElement(lab);
    }
    mList.getSelectionModel().addListSelectionListener(e -> {
            JLabel l = mList.getSelectedValue();
            
    });
    scroll1 = new JScrollPane(mList);
    tab1.add(scroll1); */
   
    mPan = new JPanel();
    mPan.setLayout(new GridLayout(0, 1));
    scroll1 = new JScrollPane(mPan);
    tab1.add(scroll1);
    
    p.add(tabs, BorderLayout.CENTER);
    p.add(list, BorderLayout.WEST);
    send.addActionListener(this);    

    f.add(p);
    f.setVisible(true);
  }


  public void actionPerformed(ActionEvent a)
  {
      if(a.getSource() == send);
      {
          JLabel lab = new JLabel(chat_box.getText());
          mPan.add(lab);
          chat_box.setText("");
          f.revalidate();
      }
      
      if(a.getSource() == font_button)
      {
          fontmenu.buildBox();
      }
  }
}