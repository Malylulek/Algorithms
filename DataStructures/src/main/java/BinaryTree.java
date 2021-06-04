public class BinaryTree {
  Node root; //Root of Binary Tree

  BinaryTree(int key){
    root = new Node(key);
  }

  BinaryTree(){
    root=null;
  }

  public boolean insert(int key) {
    if (root == null)
      root = new Node(key);
    else {
      Node n = root;
      Node parent;
      while (true) {
        if (n.key == key)
          return false;

        parent = n;

        boolean goLeft = key < n.key;
        n = goLeft ? n.left : n.right;

        if (n == null) {
          if (goLeft) {
            parent.left = new Node(key);
          } else {
            parent.right = new Node(key);
          }
          break;
        }
      }
    }
    return true;
  }
  /**
   * Travers: left branch then current node and finally the right branch
   */
  public void inOrderTraversal(){
    System.out.println("In-Order Traversal started:");
    inOrderTraversal(root);
  }

  /**
   * Travers: left branch then current node and finally the right branch
   * @param node Tree node
   */
  private void inOrderTraversal(Node node){
    if(node != null){
      inOrderTraversal(node.left);
      visit(node);
      inOrderTraversal(node.right);
    }
  }

  /**
   * Travers: current node then left branch and finally the right branch
   */
  public void preOrderTraversal(){
    System.out.println("Pre-Order Traversal started:");
    preOrderTraversal(root);
  }

  /**
   * Travers: current node then left branch and finally the right branch
   * @param node Tree node
   */
  private void preOrderTraversal(final Node node){
    if(node != null){
      visit(node);
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  /**
   * Travers: current node then left branch and finally the right branch
   */
  public void postOrderTraversal(){
    System.out.println("Post-Order Traversal started:");
    postOrderTraversal(root);
  }

  /**
   * Travers: current node then left branch and finally the right branch
   * @param node Tree node
   */
  private void postOrderTraversal(final Node node){
    if(node != null){
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      visit(node);
    }
  }
  private void visit(Node node){
    System.out.println("Node.item:" + node.key);
  }
  public void display() {
    final int height = 5, width = 64;
    System.out.println("Tree high:" + height + ", width:" + width);
    int len = width * height * 2 + 2;
    StringBuilder sb = new StringBuilder(len);
    for (int i = 1; i <= len; i++)
      sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

    displayR(sb, width / 2, 1, width / 4, width, root, " ");
    System.out.println(sb);
  }

  private void displayR(StringBuilder sb, int c, int r, int d, int w, Node n,
                        String edge) {
    if (n != null) {
      displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");

      String s = String.valueOf(n.key);
      int idx1 = r * w + c - (s.length() + 1) / 2;
      int idx2 = idx1 + s.length();
      int idx3 = idx1 - w;
      if (idx2 < sb.length())
        sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

      displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
    }
  }


}
