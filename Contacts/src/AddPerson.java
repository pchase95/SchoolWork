import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

@SuppressWarnings("serial")
public class AddPerson extends JPanel implements ActionListener
{
	private JFrame f;
	private JPanel p;
	private JPanel p2;
	private JPanel p3;
	private JButton save_button = new JButton("Save");
	private JButton cancel_button = new JButton("Cancel");
	private JButton upload_button = new JButton("Upload Photo");
	private JLabel name_label = new JLabel("Name");
	private JLabel phone_label = new JLabel("Phone");
	private JLabel email_label = new JLabel("Email");
	private JLabel address_label = new JLabel("Address");
	private JLabel website_label = new JLabel("Website");
	private JLabel work_label = new JLabel("Work");
	private JLabel comment_label = new JLabel("Comment");
	private JLabel gender_label = new JLabel("Gender");
	private JLabel age_label = new JLabel("Age");
	private JTextField name_field = new JTextField();
	private JTextField phone_field = new JTextField();
	private JTextField email_field = new JTextField();
	private JTextField address_field = new JTextField();
	private JTextField website_field = new JTextField();
	private JTextField work_field = new JTextField();
	private JTextArea comment_field = new JTextArea();
	private JRadioButton male_button = new JRadioButton("Male");
	private JRadioButton female_button = new JRadioButton("Female");
	private ButtonGroup genders = new ButtonGroup();
	private JTextField age_field = new JTextField();
	
	private static Person person;
	private static Integer person_index = null;
	
	private JTextField fileNameField = new JTextField("");
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "tif");
	private File imageFile;
	private JFileChooser fileChooser;
	private int returnVal;
	
	
	public AddPerson(Person a)
	{
		person = a;
		person_index = Main.People.indexOf(person);
		AddPerson addperson = new AddPerson();
		addperson.name_field.setText(person.getName());
		addperson.phone_field.setText(person.getPhone());
		addperson.email_field.setText(person.getEmail());
		addperson.address_field.setText(person.getAddress());
		addperson.website_field.setText(person.getWebsite());
		addperson.work_field.setText(person.getWork());
		addperson.comment_field.setText(person.getComment());
		if(person.getGender() == Gender.MALE)
			addperson.male_button.setSelected(true);
		if(person.getGender() == Gender.FEMALE)
			addperson.female_button.setSelected(true);
		if(person.getAge() == 0)
			addperson.age_field.setText("");
		else
			addperson.age_field.setText(String.valueOf(person.getAge()));
		addperson.fileNameField.setText(person.getImage());
	}
	
	public AddPerson()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		f = new JFrame("Add/Edit Customer");
		f.setSize(400, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		p = new JPanel();
		p.setBackground(Main.bkgr_color);
		p.setLayout(new BorderLayout());
		
		comment_field.setLineWrap(true);
		JScrollPane pan2 = new JScrollPane(comment_field);
		
		
		p2 = new JPanel();
		p2.setBackground(Main.bkgr_color);
		p2.setLayout(new GridLayout(0, 1));
		
		p2.add(name_label);
		p2.add(name_field);
		p2.add(gender_label);
		p2.add(male_button);
		p2.add(female_button);
		p2.add(age_label);
		p2.add(age_field);
		p2.add(phone_label);
		p2.add(phone_field);
		p2.add(email_label);
		p2.add(email_field);
		p2.add(address_label);
		p2.add(address_field);
		p2.add(website_label);
		p2.add(website_field);
		p2.add(work_label);
		p2.add(work_field);
		p2.add(comment_label);
		p2.add(pan2);
		genders.add(male_button);
		genders.add(female_button);
		p2.add(upload_button);
		p2.add(fileNameField);
		
		fileChooser = new JFileChooser();
		fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
		fileChooser.setFileFilter(filter);
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setMultiSelectionEnabled(false);
		
		fileNameField.setEditable(false);
		
		upload_button.addActionListener(this);
		save_button.addActionListener(this);
		cancel_button.addActionListener(this);
		JScrollPane pan = new JScrollPane(p);
		
		JLabel lab1 = new JLabel();
		JLabel lab2 = new JLabel();
		
		lab1.setPreferredSize(new Dimension(10, 0));
		lab2.setPreferredSize(new Dimension(10, 0));
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 0));
		p3.add(save_button);
		p3.add(cancel_button);
		
		p.add(p3, BorderLayout.SOUTH);
		p.add(lab1, BorderLayout.WEST);
		p.add(lab2, BorderLayout.EAST);
		
		p.add(p2, BorderLayout.CENTER);
		f.add(pan);
	}
	
	private void setImageFileName(String s)
	{
	}
	public void actionPerformed(ActionEvent b)
	{
		if(b.getSource() == cancel_button)
		{
			f.dispose();
			new Manager();
		}
		
		
		if(b.getSource() == upload_button)
		{
			returnVal = fileChooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				imageFile = fileChooser.getSelectedFile();
				imageFile.renameTo(new File(Main.path_name + imageFile.getName()));
				fileNameField.setText(imageFile.getName());
				setImageFileName(imageFile.getName());
			}
		}
		
		
		if(b.getSource() == save_button)
		{
			if(age_field.getText().equals(""))
			{}
			else
			{
				try
				{
					person.setAge(Integer.parseInt(age_field.getText()));
				}
				catch(Exception NotInteger)
				{
					JOptionPane.showMessageDialog(f, "Please enter an Integer for Age");
				}
			}
			person = new Person();
			
			person.setName(name_field.getText());
			
			if(male_button.isSelected())
				person.setGender(Gender.MALE);
			if(female_button.isSelected())
				person.setGender(Gender.FEMALE);
			
			person.setPhone(phone_field.getText());
			
			person.setEmail(email_field.getText());
			
			person.setAddress(address_field.getText());
			
			person.setWebsite(website_field.getText());
			
			person.setWork(work_field.getText());
			
			person.setComment(comment_field.getText());
			if(person_index == null)			
				Main.People.add(person);
			else
			{
				int index = person_index;
				Main.People.remove(index);
				Main.People.add(index, person);
			}
			person.setImage(fileNameField.getText());
			
			Main.writeFile();
			f.dispose();
			new Manager();
		}
		
	}


}
