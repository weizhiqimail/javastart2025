package org.zida;

public class LinkedListMain {

  public static void main(String[] args) {
    SinglyLinkedList linkedList = new SinglyLinkedList(5);

    System.out.println("链表里添加 1,2,3,4,5,6 共 6 个 元素");
    linkedList.addNodeFromTail(1);
    linkedList.addNodeFromTail(2);
    linkedList.addNodeFromTail(3);
    linkedList.addNodeFromTail(4);
    linkedList.addNodeFromTail(5);
    linkedList.addNodeFromTail(6);
    linkedList.traverse();

    System.out.println("移除 3,4,5 共 3 个元素");
    linkedList.removeNode(3);
    linkedList.removeNode(4);
    linkedList.removeNode(5);
    linkedList.traverse();

    System.out.println("从头节点开始依次添加 6,7 共 2 个元素");
    linkedList.addNodeFromHead(6);
    linkedList.addNodeFromHead(7);
    linkedList.traverse();

  }
}
