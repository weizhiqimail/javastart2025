package org.zida;

class DoubleNode {
  public int data;
  DoubleNode prev;
  DoubleNode next;

  public DoubleNode(int data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }

}

public class DoubleLinkedList {

  public DoubleNode head;
  public DoubleNode tail;
  public int size;
  public int capacity;

  public DoubleLinkedList(int capacity) {
    if (capacity <= 0) {
      System.out.println("双链表的容量不能为空");
      return;
    }
    this.capacity = capacity;
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  int getSize() {
    return this.size;
  }

  int getCapacity() {
    return this.capacity;
  }

  boolean isEmpty() {
    return this.size == 0;
  }

  boolean isFull() {
    return this.capacity == this.size;
  }

  DoubleNode getHeadNode() {
    return this.head;
  }

  DoubleNode getLastNode() {
    return this.tail;
  }

  int addNodeFromHead(int data) {

    return 0;
  }

  int addNodeFromTail(int data) {

    return 0;
  }

  // 删除节点
  int removeNode(int data) {

    return 0;
  }

  // 遍历链表
  void traverse() {
    if (this.isEmpty()) {
      System.out.println("当前链表为空，无需遍历。");
      return;
    }

    DoubleNode currentNode = this.head;
    System.out.printf("开始遍历链表：[ ");
    while (currentNode != null) {
      System.out.printf("%d ", currentNode.data);
      currentNode = currentNode.next;
    }
    System.out.printf("] 长度: %d\n", this.size);
  }

}
