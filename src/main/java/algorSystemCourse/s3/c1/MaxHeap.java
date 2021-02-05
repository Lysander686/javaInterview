package algorSystemCourse.s3.c1;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
        System.out.println(data.toString());

    }

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    //    返回堆中元素
    public int size() {
        return data.size();
    }

    //    返回布尔值, 表示队中市不为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //    返回完全二叉树的数组表示中, 一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index - 0 has no parent.");
        }

        return (index - 1) / 2;

    }


    public int leftChild(int index) {
        return index * 2 + 1;
    }


    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //    添加元素
    public void add(E e) {
        System.out.println("add before" + data.toString());
        data.add(e);
        System.out.println("add after" + data.toString());
//        siftUp();
    }

    private void siftUp(int k) {
//        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
//
//        }
    }


}
