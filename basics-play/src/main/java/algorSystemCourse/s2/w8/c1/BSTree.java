package algorSystemCourse.s2.w8.c1;

/**
 * @param <E>
 * @description
 * 二分搜索树:
 * - 不一定是完全二叉树
 * - 堆一定是完全二叉树
 * - 左子树中的节点永远比根节点小
 * 进化体:
 * - 平衡二叉搜索树 ( AVL )
 *      - 进化体: 红黑树
 */
public class BSTree<E extends Comparable<E>> {
    private int size;
    private Node root;

    public BSTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            add(root, e);
        }
    }

    // node as root, add e
    private void add(Node node, E e) {

        // 递归中止条件
        if (e.equals(node.e))
            return; // 相同的元素不进行插入
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        // 递归调用
        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            add(node.right, e);
    }


    private class Node {
        public E e;
        public Node left, right;
        private Node root;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }


}
