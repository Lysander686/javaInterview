package myCollections;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node RootNode;       //根节点
    private int count;          //节点数

    public BinarySearchTree() {
        RootNode = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean contain(int key) {
        return contain(RootNode, key);
    }

    public void insert(int key, String value) {
        RootNode = this.insert(RootNode, key, value);
    }

    public String search(int key) {
        return search(RootNode, key);
    }

    public void preOrder() {
        preOrder(RootNode);
    }

    public void inOrder() {
        inOrder(RootNode);
    }

    public void postOrder() {
        postOrder(RootNode);
    }

    //层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();    //通过LinkedList来实现队列
        queue.offer(RootNode);     //头元素入队
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            queue.poll();      //头元素出队列
            System.out.println(node.getKey());
            if (node.getLeftChild() != null) {   //左孩子不为空，则左孩子入队
                queue.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {  //右孩子不为空，则右孩子入队
                queue.offer(node.getRightChild());
            }
        }
    }

    //寻找最小的键值
    public int minimum() {
        assert (count != 0);
        Node minNode = minimum(RootNode);
        return minNode.getKey();
    }

    //返回最大的键值
    public int maximum() {
        assert (count != 0);
        Node maxNode = maximum(RootNode);
        return maxNode.getKey();
    }

    //删除最小键值的节点
    public void removeMin() {
        if (RootNode != null) {
            RootNode = removeMin(RootNode);
        }
    }

    //删除最大键值的节点
    public void removeMax() {
        if (RootNode != null) {
            RootNode = removeMax(RootNode);
        }
    }

    //删除键值为key的节点
    public void remove(int key) {
        RootNode = remove(RootNode, key);
    }


    //向以RootNode为根的二叉搜索树中插入节点(key,value)
    //返回插入新节点后的二叉搜索树的根
    private Node insert(Node RootNode, int key, String value) {
        if (RootNode == null) {         //这是没有左孩子或右孩子的情况
            count++;
            return new Node(key, value);
        }
        if (key == RootNode.getKey()) {
            RootNode.setValue(value);
        } else if (key < RootNode.getKey()) {
            RootNode.setLeftChild(insert(RootNode.getLeftChild(), key, value));
        } else {     //key>RootNode.getKey()
            RootNode.setRightChild(insert(RootNode.getRightChild(), key, value));
        }
        return RootNode;

    }

    //查看以RootNode为根的二叉搜索树中是否包含键为key的节点
    private boolean contain(Node RootNode, int key) {
        if (RootNode == null) {
            return false;
        }
        if (key == RootNode.getKey()) {
            return true;
        } else if (key < RootNode.getKey()) {
            return contain(RootNode.getLeftChild(), key);
        } else {
            return contain(RootNode.getRightChild(), key);
        }
    }

    //查找以RootNode为根的二叉搜索树中以key为键的value
    private String search(Node RootNode, int key) {
        if (RootNode == null)
            return null;
        if (key == RootNode.getKey()) {
            return RootNode.getValue();
        } else if (key < RootNode.getKey()) {
            return search(RootNode.getLeftChild(), key);
        } else {
            return search(RootNode.getRightChild(), key);
        }
    }

    //前序遍历
    private void preOrder(Node RootOrder) {
        if (RootOrder != null) {
            System.out.println(RootOrder.getKey());
            preOrder(RootOrder.getLeftChild());
            preOrder(RootOrder.getRightChild());
        }
    }

    //中序遍历
    private void inOrder(Node RootNode) {
        if (RootNode != null) {
            inOrder(RootNode.getLeftChild());
            System.out.println(RootNode.getKey());
            inOrder(RootNode.getRightChild());
        }
    }

    //后序遍历
    private void postOrder(Node RootNode) {
        if (RootNode != null) {
            postOrder(RootNode.getLeftChild());
            postOrder(RootNode.getRightChild());
            System.out.println(RootNode.getKey());
        }
    }

    //返回最小键值的节点
    private Node minimum(Node RootNode) {
        if (RootNode.getLeftChild() == null) {
            return RootNode;
        }
        return minimum(RootNode.getLeftChild());
    }

    //返回最大键值的节点
    private Node maximum(Node RootNode) {
        if (RootNode.getRightChild() == null) {
            return RootNode;
        }
        return maximum(RootNode.getRightChild());
    }

    //删除以RootNode为根的二分搜索树的最小节点
    //返回删除节点后的新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.getLeftChild() == null) {
            Node rightNode = node.getRightChild();
            count--;
            return rightNode;
        }
        node.setLeftChild(removeMin(node.getLeftChild()));
        return node;

    }

    //删除以RootNode为根的二分搜索树的最大节点
    //返回删除节点后的新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.getRightChild() == null) {
            Node leftNode = node.getLeftChild();
            count--;
            return leftNode;
        }
        node.setRightChild(removeMax(node.getRightChild()));
        return node;

    }

    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, int key) {
        if (node == null)
            return null;
        if (key == node.getKey()) {
            if (node.getLeftChild() == null) {   //删除只有右孩子的节点或左右孩子都没有的节点
                count--;
                return node.getRightChild();
            }
            if (node.getRightChild() == null) {  //删除只有左孩子的节点
                count--;
                return node.getLeftChild();
            }

            //node->left!=null&&node->right!=null         删除左右都有孩子的节点
            Node successor = new Node(minimum(node.getRightChild())); //代替被删除节点的节点
            count++;
            successor.setRightChild(removeMin(node.getRightChild()));
            successor.setLeftChild(node.getLeftChild());
            count--;
            return successor;
        } else if (key < node.getKey()) {
            node.setLeftChild(remove(node.getLeftChild(), key));
            return node;
        } else {
            node.setRightChild(remove(node.getRightChild(), key));
            return node;
        }

    }

}