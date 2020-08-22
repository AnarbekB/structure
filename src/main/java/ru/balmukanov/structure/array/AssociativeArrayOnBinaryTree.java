package ru.balmukanov.structure.array;

import ru.balmukanov.structure.binary.BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AssociativeArrayOnBinaryTree implements Iterable<BinaryTree.Node<Object>> {

    private final BinaryTree tree = new BinaryTree();

    public void insert(String key, Object value) {
        this.tree.insert(key, value);
    }

    public int size() {
        return this.tree.size();
    }

    public Object get(String key) {
        BinaryTree.Node<Object> node = this.tree.get(key);
        if (node == null) {
            return null;
        }

        return node.getData();
    }

    public Iterator<BinaryTree.Node<Object>> iterator() {
        List<BinaryTree.Node<Object>> res = new LinkedList<>();
        Queue<BinaryTree.Node<Object>> q = new LinkedList<>();
        if (this.tree.getRoot() != null) q.add(this.tree.getRoot());
        BinaryTree.Node<Object> current;
        while (!q.isEmpty()) {
            current = q.remove();
            res.add(current);
            if (current.getLeft() != null) q.add(current.getLeft());
            if (current.getRight() != null) q.add(current.getRight());
        }
        return res.iterator();
    }
}
