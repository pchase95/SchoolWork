import java.awt.Color;
import java.util.*;

public class Main
{
  public static ArrayList<Person> People = new ArrayList<Person>();
    
  public static Color back_ground = new Color(147, 204, 210);

  public static void main(String[] args) throws Exception
  {
    new Main().go();
    new Login();
      new FontMenu();
  }
  
  private void go()
  {
      Person p = new Person();
      p.setName("Peter Chase");
      People.add(p);
  }
}
