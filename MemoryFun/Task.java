public class Task implements Runnable {
  private int m_memory;
  private int m_time;
  private int m_id;
  private boolean m_complete = false;

  public Task(int memory, int time, int id) {
    m_memory = memory;
    m_time = time;
    m_id = id;
  }

  public void run() {
    try {
      System.out.printf("Task %d is starting...%n", m_id);
      Thread.sleep(m_time*1000);
      m_complete = true;
      System.out.printf("Task %d has finished%n", m_id);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public boolean isDone() {
    return m_complete;
  }

  @Override
  public String toString() {
    return "Memory:"+m_memory + ", Time:"+m_time + ", ID:"+m_id;
  }

}
