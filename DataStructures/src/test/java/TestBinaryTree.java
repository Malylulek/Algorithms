public class TestBinaryTree {
  public static void main(String[] args)
  {
    BinaryTree tree = new BinaryTree();

    /*create root*/
    tree.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

    tree.root.left  = new Node(2);
    tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */


    tree.root.right.left = new Node(4);
        /* 4 becomes left child of 3
                    1
                /       \
               2          3
             /   \       /  \
          null   null   4   null
           /   \
          null null
         */
    for (int i = 0; i < 4; i++)
      tree.insert((int) (Math.random() * 20));

    tree.display();
    tree.inOrderTraversal();
    tree.preOrderTraversal();
    tree.postOrderTraversal();
  }
}
