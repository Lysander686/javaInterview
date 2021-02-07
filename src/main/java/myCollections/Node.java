package myCollections;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int key;
    private String value;
    private Node LeftChild;
    private Node RightChild;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        LeftChild = null;
        RightChild = null;
    }

    public Node(Node node) {
        this.key = node.getKey();
        this.value = node.getValue();
        LeftChild = node.getLeftChild();
        RightChild = node.getRightChild();
    }

    public int getKey() {
        return key;
    }


}