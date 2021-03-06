import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class Manager extends JPanel implements ActionListener
{
	public JFrame f;
	private JPanel p;
	private JPanel grid;
	private JPanel p2;
	private JButton add_button = new JButton("Add");
	private JButton edit_button = new JButton("Edit");
	private JButton delete_button = new JButton("Delete");
	private JLabel sort_label = new JLabel("Sort By");
	private JButton sort_name = new JButton("Name");
	private JButton sort_age = new JButton("Age");
	private JSplitPane splitPane = new JSplitPane();
	JPanel tab;
    private JPanel conTab = new JPanel(); 
    private JPanel perTab= new JPanel();
    //layouts for the contact info and personal info tabs
    private GridLayout conLayout = new GridLayout(4, 2);
    private GridLayout perLayout = new GridLayout(4, 2);
    private JTabbedPane tabbedPane = new JTabbedPane();        
    private JLabel phone,email, address, website, gender, age, comment, phoneLabel, eLabel, addressLabel,
            webLabel, genderLabel,ageLabel,commentLabel, workLabel, work;
    private String genderString = "";
	private JPanel overview;
	private JLabel image_label;
	private String selected_name;
	private JLabel name_label;
	private ImageIcon image;
	private Image image2;
	private ImageIcon image3;
    
	
	private JList<Person> list;
	
	public Manager(Integer n)
	{
		if(n == 0)
			sortName();
		if(n == 1)
			sortAge();
		
		new Manager();
	}
	
	
	public Manager()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tab = new JPanel();
		
		f = new JFrame("Contacts");
		f.setSize(1000, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout blay = new BorderLayout();
		p = new JPanel();
		p.setLayout(blay);
		
		GridLayout glay = new GridLayout(0, 1);
		grid = new JPanel();
		grid.setLayout(glay);
		
		tab.setPreferredSize(new Dimension(0, 150));
		grid.add(edit_button);
		grid.add(delete_button);
				
        conTab.setLayout(conLayout);
        perTab.setLayout(perLayout);

        tabbedPane.add("Contact", conTab);
        tabbedPane.add("Personal", perTab);
        
        phoneLabel= new JLabel("Phone:");;
        eLabel= new JLabel("Email:");
        addressLabel= new JLabel("Address:");
        webLabel= new JLabel("Website:");
        
        phone=new JLabel();
        email=new JLabel();
        address=new JLabel ();
        website = new JLabel ();        
            
        conTab.add(phoneLabel);
        conTab.add(phone);
        conTab.add(eLabel);
        conTab.add(email);
        conTab.add(addressLabel);
        conTab.add(address);
        conTab.add(webLabel);
        conTab.add(website);
                   
        genderLabel= new JLabel("Gender:");
        ageLabel= new JLabel("Age:");
        commentLabel = new JLabel("Comment:");
        workLabel = new JLabel("Work");
       
        gender=new JLabel(genderString);
        age=new JLabel();
        comment = new JLabel();
        work = new JLabel();
        
        perTab.add(genderLabel);
        perTab.add(gender);
        perTab.add(ageLabel);
        perTab.add(age);
        perTab.add(workLabel);
        perTab.add(work);
        perTab.add(commentLabel);                 
        perTab.add(comment);
        
    	phone.setFont(Main.font);
    	email.setFont(Main.font);
    	address.setFont(Main.font);
    	website.setFont(Main.font);
    	gender.setFont(Main.font);
    	age.setFont(Main.font);
    	comment.setFont(Main.font);
    	phoneLabel.setFont(Main.font);
    	eLabel.setFont(Main.font);
    	addressLabel.setFont(Main.font);
    	webLabel.setFont(Main.font);
    	genderLabel.setFont(Main.font);
    	ageLabel.setFont(Main.font);
    	commentLabel.setFont(Main.font);
    	workLabel.setFont(Main.font);
    	work.setFont(Main.font);	
		
		
		image_label = new JLabel();
		image_label.setText("");
		image_label.setPreferredSize(new Dimension(200, 400));	
		
		
		
		list = new JList<>();
		list.setFont(Main.font);
		DefaultListModel<Person> model = new DefaultListModel<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(model);
		for(Person per : Main.People)
		{
			model.addElement(per);
		}		
    	JPanel splitPanel = new JPanel();
		splitPanel.setBackground(Main.bkgr_color);
		splitPane.setLeftComponent(new JScrollPane(list));
		
		splitPane.setRightComponent(splitPanel);
		list.getSelectionModel().addListSelectionListener(e -> {
			Person per = list.getSelectedValue();
			 if(per.getGender()==Gender.MALE)
		            genderString="Male";        
		     if(per.getGender()==Gender.FEMALE)
		            genderString="Female";
		     gender.setText(genderString);
		     if(per.getAge() == 0)
		    	 age.setText("");
		     else
		    	 age.setText(Integer.toString(per.getAge()));
		     website.setText(per.getWebsite());
		     address.setText(per.getAddress());
		     work.setText(per.getWork());
		     comment.setText(per.getComment());
		     phone.setText(per.getPhone());
		     email.setText(per.getEmail());
		     selected_name = per.getName();
		     name_label.setText(selected_name);
		     if(!Main.People.isEmpty())
		     {
		    	 if(per.getImage() != null)
		    	 {
			    	 image = new ImageIcon(Main.path_name + per.getImage());
			    	 image2 = image.getImage();
			    	 image3 = new ImageIcon(image2.getScaledInstance(200, 300, UNDEFINED_CONDITION));
			    	 image_label.setIcon(image3);
		    	 }
		    	 else
		    	 {
		    		 image_label.setIcon(null);
		    		 image_label.setFont(Main.font);
		    		 image_label.setText("No Image");
		    	 }
		     }
				});
		
		
		tab.setLayout(new BorderLayout());
		tab.add(tabbedPane, BorderLayout.CENTER);
		p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 1));
		p2.setBackground(Main.bkgr_color);
		p2.add(sort_label);
		p2.add(sort_name);
		p2.add(sort_age);
		tab.add(p2, BorderLayout.WEST);
		
		
		if(!Main.People.isEmpty())
			 selected_name = Main.People.get(0).getName();
		else
			selected_name = "";
		
		BorderLayout blay2 = new BorderLayout();
		overview = new JPanel();
		overview.setLayout(blay2);
		blay2.setVgap(-50);
		
		

		
		
		name_label = new JLabel(selected_name, SwingConstants.CENTER);
		name_label.setFont(Main.font);
		
		overview.add(name_label, BorderLayout.NORTH);
		overview.add(image_label, BorderLayout.CENTER);
		overview.setBackground(Main.bkgr_color);
		tab.setPreferredSize(new Dimension(800, 150));
		
		
		splitPanel.add(overview, BorderLayout.CENTER);
		p.add(add_button, BorderLayout.NORTH);
		p.add(splitPane, BorderLayout.CENTER);
		p.add(grid, BorderLayout.EAST);
		p.add(tab, BorderLayout.SOUTH);
		
		//p.add(SearchPanel, BorderLayout.WEST);
		
	
		tab.setBackground(Main.bkgr_color);
		overview.setBackground(Main.bkgr_color);
	

		
		add_button.addActionListener(this);
		edit_button.addActionListener(this);
		delete_button.addActionListener(this);
		sort_name.addActionListener(this);
		sort_age.addActionListener(this);
		if(!Main.People.isEmpty())
			list.setSelectedIndex(0);
		JScrollPane scroll = new JScrollPane(p);
		f.add(scroll);
		f.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource() == sort_name)
		{
			f.dispose();
			new Manager(0);
		}
		
		if(a.getSource() == sort_age)
		{
			f.dispose();
			new Manager(1);
		}
		
		
		if(a.getSource() == add_button)
		{
			f.dispose();
			new AddPerson();	
		}
		
		if(a.getSource() == edit_button)
		{
			if(list.isSelectionEmpty())
				JOptionPane.showMessageDialog(f, "Select a Person to Edit");
			else
			{
				f.dispose();
				new AddPerson(Main.People.get(list.getSelectedIndex()));
			}
		}
		
		if(a.getSource() == delete_button)
		{
			Main.People.remove(list.getSelectedIndex());
			Main.writeFile();
			f.dispose();
			new Manager();
		}
	}
	
	
	public void sortName()
	{
		Collections.sort(Main.People, new Comparator<Person>() {
	        public int compare(Person per1, Person per2)
	        {
	        	return per1.getName().compareTo(per2.getName());
	        }
	    });
	}
	
	public void sortAge()
	{
		Collections.sort(Main.People, new Comparator<Person>() {
	        public int compare(Person per1, Person per2)
	        {
	        	return per1.getAge().compareTo(per2.getAge());
	        }
	    });		
	}

}
