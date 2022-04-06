package src;
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


    public void tryPostOrderTraverse(){
        assertEquals("B F D G H E C A", tree.postorderTraverse());
    }
    public void tryGetHeight_callBinaryMethod(){
        assertEquals(4, tree.getHeight());
    }
    public void tryGetNumberOfNodes(){
        assertEquals(8, tree.getNumberOfNodes());
        assertEquals(8, tree.postorderTraverse_callBinaryNodeMethod())
    }
    public void tryCreateTree2(){
        
    }
    public void tryECBinaryTree(){

    }

    
}