import org.junit.Test;
import org.junit.Before;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JUnitTesting{

    BinaryTree<String> fTree = new BinaryTree<>("F");
    BinaryTree<String> gTree = new BinaryTree<>("G");
    BinaryTree<String> hTree = new BinaryTree<>("H");
    BinaryTree<String> bTree = new BinaryTree<>("B");

    // Subtrees:
    BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
    BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
    BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);

    BinaryTree<String> tree = new BinaryTree<>("A", bTree, cTree);

    BinaryNode<String> fNode = new BinaryNode<>("F");
    BinaryNode<String> gNode = new BinaryNode<>("G");
    BinaryNode<String> hNode = new BinaryNode<>("H");
    BinaryNode<String> bNode = new BinaryNode<>("B");

    // Subtrees:
    BinaryNode<String> dNode = new BinaryNode<>("D", fNode, null);
    BinaryNode<String> eNode = new BinaryNode<>("E", gNode, hNode);
    BinaryNode<String> cNode = new BinaryNode<>("C", dNode, eNode);

    BinaryNode<String> nodeTree = new BinaryNode<>("A", bNode, cNode);

    @Test
    /**
     * tests the postorderTraverse methods using the tree and node tree
     */
    public void tryPostOrderTraverse(){
        assertEquals("BFDGHECA", tree.postorderTraverse_test());
        assertEquals("BFDGHECA", tree.postorderTraverse_test(tree.getRootNode()));
        assertEquals("BFDGHECA", tree.postorderTraverse_callBinaryNodeMethod_test());
        assertEquals("BFDGHECA", nodeTree.postorderTraverse_binaryNodeMethod_test());

    }
    @Test
    /**
     * tests the getHeightMethods for binary trees and binary nodes
     */
    public void tryGetHeightMethods(){
        assertEquals(4, tree.getHeight_callBinaryNodeMethod());
        assertEquals(4, nodeTree.getHeight_BinaryNodeMethod());
    }
    @Test
    /**
     * tests the getNumberOfNodes method using the tree and node tree
     */
    public void tryGetNumberOfNodes(){
        assertEquals(8, tree.getNumberOfNodes());
        assertEquals(8, tree.getNumberOfNodes_test(tree.getRootNode()));
    }
    @Test
    /**
     * tests the constructor for prefix and infix subtrees
     */
    public void tryECBinaryTree(){
        try{
            BinaryTree<Character> extraCreditTree = new BinaryTree<Character>("ABDHIECFGJK", "HDIBEAFCJGK");
        }
        catch (Exception e){
            fail("Failure: tryECBinaryTree() threw an exception: " + e);
        }
    }

    
}