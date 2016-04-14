import java.util.*;
import java.util.concurrent.*;

public class Ram {
  private List<Task> m_tasks;
  private final Semaphore sem = new Semaphore(0, true);

  public Ram(List<Task> tasks) {
    m_tasks = tasks;
  }

  private void load() {
    try {
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void unload() {
    try {

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
