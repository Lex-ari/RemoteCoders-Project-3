public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   /**
    * Extra Credit Opportunity. Constructor that takes in a prefix expression and infix expression and creates a tree.
    * Assumptions are made here. the preFixExpression and the inFixExpression are guaranteed to create a tree.
    * Each node is represented by a "letter" in the prefix and infix strings.
    * Each node is given the letter that correspondes to the infix and prefix expression.
    * @param preFixExpression of the tree.
    * @param inFixExpression of the tree.
    */
   public BinaryTree(String preFixExpression, String inFixExpression){
      if (!preFixExpression.isEmpty()) {
         int inFixRootIndex = inFixExpression.indexOf(preFixExpression.charAt(0));
         root = new BinaryNode(preFixExpression.charAt(0));
         if (preFixExpression.length() > 1) {
            BinaryTree<T> leftTree = new BinaryTree(preFixExpression.substring(1, inFixRootIndex + 1), inFixExpression.substring(0, inFixRootIndex)); // noninclusive of root node
            BinaryTree<T> rightTree = new BinaryTree(preFixExpression.substring(inFixRootIndex + 1), inFixExpression.substring(inFixRootIndex + 1)); // noninclusive of root node
            root.setLeftChild(leftTree.getRootNode());
            root.setRightChild(rightTree.getRootNode());
         }
      }
   }

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                       BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
              (BinaryTree<T>)rightTree);
   } // end setTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData

   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData

   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty

   public void clear()
   {
      root = null;
   } // end clear

   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode

   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode

   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);

      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);

      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if

      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();

      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end initializeTree

   /** -------------------------------------------------------------------- */
   /** Task 1: Implement the 4 methods
    *     . In BinaryTree.java
    *          1. public void postorderTraverse();
    *          2. private void postorderTraverse(BinaryNode<T> node)
    *          3. public void postorderTraverse_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          4. public void postorderTraverse_binaryNodeMethod() */

   /** calls postorderTraverse(BinaryNode<T> node)
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse()
   {
      postorderTraverse(getRootNode());
   }
   protected String postorderTraverse_test()
   {
      return postorderTraverse_test(getRootNode());
   }

   /** A Recursive Method in the BinaryTree Class
    * prints (using post-order traversal) all nodes in the subtree rooted at this node.*/
   private void postorderTraverse(BinaryNode<T> node)
   {
      if (node != null) {
         if (node.hasLeftChild()) {
            postorderTraverse(node.getLeftChild());
         }
         if (node.hasRightChild()) {
            postorderTraverse(node.getRightChild());
         }
         System.out.print(node.getData());
      }
   }
   protected String postorderTraverse_test(BinaryNode<T> node)
   {
      if (node != null) {
         if (node.hasLeftChild()) {
            postorderTraverse(node.getLeftChild());
         }
         if (node.hasRightChild()) {
            postorderTraverse(node.getRightChild());
         }
         return (String)node.getData();
      }
      return "";
   }

   /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse_callBinaryNodeMethod()
   {
      if (root != null){
         root.postorderTraverse_binaryNodeMethod();
      }
   }
   protected String postorderTraverse_callBinaryNodeMethod_test()
   {
      if (root != null){
         return root.postorderTraverse_binaryNodeMethod_test();
      }
      return "";
   }


   /** -------------------------------------------------------------------- */
   /** Task 2: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getHeight_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          2. public int getHeight_binaryNodeMethod()*/
   /** calls getHeight(BinaryNode<T> node)
    @return  The height of the "whole" tree */
   public int getHeight()
   {
      return getHeight(root);
   } // end getHeight

   /** A Recursive Method in the BinaryTree Class
    * Computes the height of the subtree rooted at this node.
    @return  The height of the subtree rooted at this node. */
   private int getHeight(BinaryNode<T> node)
   {
      int height = 0;
      if (node != null)
         height = 1 + Math.max(getHeight(node.getLeftChild()),
                 getHeight(node.getRightChild()));
      return height;
   } // end getHeight

   /** The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
    * Computes the height of the "whole" tree.
    @return  The height of the "whole" tree. */
   public int getHeight_callBinaryNodeMethod()
   {
      int height = 0;
      if(isEmpty()){
         throw new EmptyTreeException();
      }else if(root != null)
         height = root.getHeight_BinaryNodeMethod();
      return height;
   } // end getHeight_callBinaryNodeMethod

   /** -------------------------------------------------------------------- */
   /** Task 3: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getNumberOfNodes()
    *          2. private int getNumberOfNodes(BinaryNode<T> node)*/

   /** calls getNumberOfNodes(BinaryNode<T> node)
    @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
      if(root == null){
         return 0;
      }
      else{
         return getNumberOfNodes(getRootNode());
      }
   } // end getNumberOfNodes

   /** A Recursive Method in the BinaryTree Class
    * Counts the nodes in the subtree rooted at this node.
    @return  The number of nodes in the subtree rooted at this node. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
      int leftNumber = 0;
      int rightNumber = 0;
      if (node.hasLeftChild())
         leftNumber=getNumberOfNodes(node.getLeftChild());
      if (node.hasRightChild())
         rightNumber = getNumberOfNodes(node.getRightChild());

      return 1 + leftNumber + rightNumber;
   } // end getNumberOfNodes
   protected int getNumberOfNodes_test(BinaryNode<T> node)
   {
      int leftNumber = 0;
      int rightNumber = 0;
      if (node.hasLeftChild())
         leftNumber=getNumberOfNodes(node.getLeftChild());
      if (node.hasRightChild())
         rightNumber = getNumberOfNodes(node.getRightChild());

      return 1 + leftNumber + rightNumber;
   }

   /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
    * Counts the nodes in the "whole" tree
    @return  The number of nodes in the "whole" tree. */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
      int numberOfNodes = 0;
      if (root != null)
         numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
      return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod
} // end BinaryTree