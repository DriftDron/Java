import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class BinTreeTest {

    @Test
    void testAddOneElementToEmptyBinaryTree() {
        BinTree<String, String> tree = new BinTree<>();
        tree.add("One", "1");
        Assertions.assertNull(tree.root.getLeft());
        Assertions.assertNull(tree.root.getRight());
        Assertions.assertEquals("One", tree.root.getKey());
    }

    @Test
    void testAddElementToRightOfBinaryTree() {
        BinTree<String, Integer> tree = new BinTree<>();
        tree.add("1", 1);
        tree.add("2", 2);
        Assertions.assertNull(tree.root.getLeft());
        Assertions.assertEquals("2", tree.root.getRight().getKey());
        Assertions.assertEquals(2, tree.root.getRight().getVal());
        Assertions.assertEquals("1", tree.root.getKey());
        Assertions.assertEquals(1, tree.root.getVal());
    }

    @Test
    void testAddElementToLeftOfBinaryTree() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(1, "One");
        tree.add(-1, "-One");
        Assertions.assertNull(tree.root.getRight());
        Assertions.assertEquals(-1, tree.root.getLeft().getKey());
        Assertions.assertEquals("-One", tree.root.getLeft().getVal());
        Assertions.assertEquals(1, tree.root.getKey());
        Assertions.assertEquals("One", tree.root.getVal());
    }

    @Test
    void testAddElementWithLeftRotation() {
        BinTree<Integer, Integer> tree = new BinTree<>();
        tree.add(1, 1);
        tree.add(3, 3);
        tree.add(5, 5);
        Assertions.assertEquals(1, tree.root.getLeft().getKey());
        Assertions.assertEquals(3, tree.root.getKey());
        Assertions.assertEquals(5, tree.root.getRight().getKey());
        Assertions.assertEquals(2, tree.root.getHeight());
    }

    @Test
    void testAddElementWithRightRotation() {
        BinTree<String, String> tree = new BinTree<>();
        tree.add("Nine", "Nine");
        tree.add("Four", "Four");
        tree.add("Two", "Two");
        Assertions.assertEquals(2, tree.root.getHeight());
        Assertions.assertEquals("Nine", tree.root.getKey());
        Assertions.assertEquals("Four", tree.root.getLeft().getKey());
        Assertions.assertEquals("Two", tree.root.getRight().getKey());
    }

    @Test
    void testAddElementWithMultipleRotation() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(3, "3");
        tree.add(2, "2");
        tree.add(10, "10");
        tree.add(25, "25");
        tree.add(4, "4");
        tree.add(5, "5");
        Assertions.assertEquals(4, tree.root.getKey());
        Assertions.assertEquals(3, tree.root.getLeft().getKey());
        Assertions.assertEquals(2, tree.root.getLeft().getLeft().getKey());
        Assertions.assertEquals(10, tree.root.getRight().getKey());
        Assertions.assertEquals(5, tree.root.getRight().getLeft().getKey());
        Assertions.assertEquals(25, tree.root.getRight().getRight().getKey());
        Assertions.assertEquals(3, tree.root.getHeight());
    }

    @Test
    void testAddElementWithMultipleRotation2() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(12, "Twelve");
        tree.add(15, "Fifteen");
        tree.add(7, "Seven");
        tree.add(3, "Three");
        tree.add(5, "Five");
        tree.add(6, "Six");
        Assertions.assertEquals(7, tree.root.getKey());
        Assertions.assertEquals(5, tree.root.getLeft().getKey());
        Assertions.assertEquals(3, tree.root.getLeft().getLeft().getKey());
        Assertions.assertEquals(12, tree.root.getRight().getKey());
        Assertions.assertEquals(6, tree.root.getLeft().getRight().getKey());
        Assertions.assertEquals(15, tree.root.getRight().getRight().getKey());
        Assertions.assertEquals(3, tree.root.getHeight());
    }

    @Test
    void testContainsForExistingElement() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(1, "One");
        boolean contains = tree.contains(1);
        Assertions.assertTrue(contains);
    }

    @Test
    void testContainsForNotExistingElement() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(1, "One");


        Assertions.assertFalse(tree.contains(2));
    }

    //Get
    @Test
    void testGetExistingForElement() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(1, "1");


        Assertions.assertEquals("1", tree.get(1));
    }

    @Test
    void testGetForNotExistingElement() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(-11, "-Eleven");
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            tree.get(11);
        });
    }

    //Remove
    @Test
    void testRemoveElementFromBinaryTree() {
        BinTree<Integer, String> tree = new BinTree<>();
        tree.add(1, "One");
        tree.remove(1);
        Assertions.assertNull(tree.root);
    }

    @Test
    void testRemoveFromBinaryTree2() {
        BinTree<String, Integer> tree = new BinTree<>();
        tree.add("One", 1);
        tree.add("Four", 4);
        tree.remove("Four");
        Assertions.assertNull(tree.root.getLeft());
        Assertions.assertNull(tree.root.getRight());
        Assertions.assertEquals("One", tree.root.getKey());
        Assertions.assertEquals(1, tree.root.getHeight());
    }
}