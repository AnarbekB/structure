package ru.balmukanov.structure;

import org.junit.Test;
import ru.balmukanov.structure.array.AssociativeArrayOnBinaryTree;
import ru.balmukanov.structure.binary.BinaryTree;

import static org.junit.Assert.*;

public class AssociativeArrayOnBinaryTreeTest {

    @Test
    public void testArrayInsert() {
        AssociativeArrayOnBinaryTree array = new AssociativeArrayOnBinaryTree();
        array.insert("one", 1);
        array.insert("two", "two");
        TestItem testClass = new TestItem();
        array.insert("three", testClass);

        assertEquals(1, array.get("one"));
        assertEquals("two", array.get("two"));
        assertEquals(testClass, array.get("three"));
    }

    @Test
    public void testArrayDuplicateKeys() {
        AssociativeArrayOnBinaryTree array = new AssociativeArrayOnBinaryTree();
        array.insert("one", 1);
        array.insert("one", "one");

        assertEquals("one", array.get("one"));
    }

    @Test
    public void testIterableTree()
    {
        AssociativeArrayOnBinaryTree array = new AssociativeArrayOnBinaryTree();
        array.insert("one", "sdd");
        array.insert("two", "two");
        array.insert("three", "dsfsd");

        for (BinaryTree.Node<Object> o: array) {
            assertEquals(BinaryTree.Node.class, o.getClass());
            System.out.println(o.getData());
        }

        assertEquals(3, array.size());
    }

    static class TestItem {
        public int value = 1;
    }
}
