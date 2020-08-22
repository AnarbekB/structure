package ru.balmukanov.structure.binary;

public class BinaryTree {

    private Node<Object> root = null;

    public void insert(String key, Object data) {
        this.root = this.addRecursive(this.root, key, data);
    }

    private Node<Object> addRecursive(Node<Object> current, String key, Object data) {

        if (current == null) {
            return new Node<>(key, data);
        }

        if (current.getKey().equals(key)) {
            //if new key equals exist key, then replace old Node data on new
            current.setData(data);
            return current;
        }

        if (current.getKey().compareTo(key) < 0) {
            current.setLeft(addRecursive(current.getLeft(), key, data));
        } else {
            current.setRight(addRecursive(current.getRight(), key, data));
        }

        return current;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size() {
        return this.getSizeRecursive(this.root);
    }

    private int getSizeRecursive(Node<Object> current) {
        return current == null ? 0 : getSizeRecursive(current.getLeft()) + getSizeRecursive(current.getRight()) + 1;
    }

    public Node<Object> get(String key) {
        return findNodeRecursive(this.root, key);
    }

    private Node<Object> findNodeRecursive(Node<Object> current, String key)
    {
        if (current.key.equals(key)) {
            return current;
        }

        return  current.key.compareTo(key) < 0
                ? this.findNodeRecursive(current.getLeft(), key)
                : this.findNodeRecursive(current.getRight(), key);
    }

    public static class Node<T> {

        private final String key;
        private T data;

        private Node<T> left = null;
        private Node<T> right = null;

        public Node(String key, T data) {
            this.key = key;
            this.data = data;
        }

        public String getKey() {
            return this.key;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}
