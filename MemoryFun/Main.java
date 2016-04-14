import java.util.*;
import java.io.*;

public class Main {
  private List<Task> m_tasks = new ArrayList<>();

  public static void main(String[] args)throws Exception {
    Main main = new Main();
    main.readFile();
  }

  private void readFile()throws Exception {
    Scanner fr = new Scanner(new File("memes.txt"));
    int id = 0;
    while(fr.hasNextLine()) {
      String line = fr.nextLine();
      String[] part = line.split(",");
      m_tasks.add(new Task(Integer.parseInt(part[0]),  Integer.parseInt(part[1]), id));
      id++;
    }
    new Manager(m_tasks);
  }
}
