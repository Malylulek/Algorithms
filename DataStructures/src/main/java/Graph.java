import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Queue;

public class Graph<T> {

  // We use Hashmap to store the edges in the graph
  private final Map<T, List<T> > map = new HashMap<>();

  // This function adds a new vertex to the graph
  public void addVertex(T s)
  {
    map.put(s, new LinkedList<T>());
  }

  // This function adds the edge
  // between source to destination
  public void addEdge(T source,
                      T destination,
                      boolean bidirectional)
  {

    if (!map.containsKey(source))
      addVertex(source);

    if (!map.containsKey(destination))
      addVertex(destination);

    map.get(source).add(destination);
    if (bidirectional == true) {
      map.get(destination).add(source);
    }
  }

  // This function gives the count of vertices
  public void getVertexCount()
  {
    System.out.println("The graph has "
        + map.keySet().size()
        + " vertex");
  }

  // This function gives the count of edges
  public void getEdgesCount(boolean bidirection)
  {
    int count = 0;
    for (T v : map.keySet()) {
      count += map.get(v).size();
    }
    if (bidirection == true) {
      count = count / 2;
    }
    System.out.println("The graph has "
        + count
        + " edges.");
  }

  // This function gives whether
  // a vertex is present or not.
  public void hasVertex(T s)
  {
    if (map.containsKey(s)) {
      System.out.println("The graph contains "
          + s + " as a vertex.");
    }
    else {
      System.out.println("The graph does not contain "
          + s + " as a vertex.");
    }
  }

  // This function gives whether an edge is present or not.
  public void hasEdge(T s, T d)
  {
    if (map.get(s).contains(d)) {
      System.out.println("The graph has an edge between "
          + s + " and " + d + ".");
    }
    else {
      System.out.println("The graph has no edge between "
          + s + " and " + d + ".");
    }
  }

  // Prints the adjancency list of each vertex.
  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();

    for (T v : map.keySet()) {
      builder.append(v.toString() + ": ");
      for (T w : map.get(v)) {
        builder.append(w.toString() + " ");
      }
      builder.append("\n");
    }

    return (builder.toString());
  }

  //Depth-First Search
  public void searchDFS(){
    System.out.println("Start travers using Depth-First Search...");
    Set<T> visited = new HashSet<T>();
    for(T vertex : map.keySet()){
      searchDFS(vertex, visited);
    }
  }
  //Depth-First Search
  private void searchDFS(T source, Set<T> visited){
    if(source==null || visited.contains(source)) return;
      visit(source);
      visited.add(source);
    for (T neighbor: map.get(source)) {
      if(!visited.contains(neighbor))
        searchDFS(neighbor, visited);
    }
  }

  //Breadth-First Search
  public void searchBFS(){
    System.out.println("Start travers using Breadth-First Search...");
    Set<T> visited = new HashSet<T>();
    for(T vertex : map.keySet()){
      searchBFS(vertex, visited);
    }
  }
  //Breadth-First Search
  private void searchBFS(T source, Set<T> visited){
    MyQueue<T> queue = new MyQueue<T>();
    if(source==null || visited.contains(source)) return;

    queue.add(source);

    while(!queue.isEmpty()){
      T node = queue.remove();
      visit(node);
      for (T neighbor : map.get(node)) {
        if(!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.add(neighbor);
        }
      }
    }
  }


  private void visit(T vertex){
    System.out.println("Visited: " + vertex.toString());
  }
}

