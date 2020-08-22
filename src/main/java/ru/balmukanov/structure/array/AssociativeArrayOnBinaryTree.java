package ru.balmukanov.structure.array;

import ru.balmukanov.structure.binary.BinaryTree;

public class AssociativeArrayOnBinaryTree {

    private final BinaryTree tree = new BinaryTree();

    public void insert(String key, Object value) {
        this.tree.insert(key, value);
    }

    public Object get(String key) {
        BinaryTree.Node<Object> node = this.tree.get(key);
        if (node == null) {
            return null;
        }

        return node.getData();
    }
}
