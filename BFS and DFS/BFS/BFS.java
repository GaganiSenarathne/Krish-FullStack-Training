import java.util.*;

public class BFS {
  private int V;
  private LinkedList<Integer> adj[];

  // Create a BFS
  BFS(int v) {
    V = v;
    adj = new LinkedList[v]; // Creating new lLinked list
    for (int i = 0; i < v; ++i) // Looping through the BFS values
      adj[i] = new LinkedList();
  }

  // Add edges to the BFS
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // BFS algorithm
  void BFS(int s) {

    boolean visited[] = new boolean[V]; // Keeping a visited value

    LinkedList<Integer> queue = new LinkedList(); // Queue linked list

    visited[s] = true; // Set s as visited
    queue.add(s); // Add s to the queue

    while (queue.size() != 0) { // Looping through the queue
      s = queue.poll();
      System.out.print(s + " ");

      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public static void main(String args[]) {
    BFS g = new BFS(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Breadth First Traversal ");

    g.BFS(2);
  }
}
