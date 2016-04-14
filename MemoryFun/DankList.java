
public class DankList{
  public Node m_head;
  private int m_count = 0;




  public void add(Task t){
    if(m_head == null) {
      m_head = t;
    }
    else {
      
    }
    m_count++;
  }
  public void remove(){}
  public Node next(){}
  public Node previous(){}
  public int size(){
    return m_count;
  }
}

class Node {
  Task m_task;
  Node m_next;
  Node m_previous;
  Node(Task task, Node next, Node previous){
    m_task = task;
    m_next = next;
    m_previous = previous;

  }
}
