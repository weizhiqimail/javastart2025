package org.zida;

public class LinkedListMain {

  public static void testSinglyLinkedList() {
    System.out.println("-----------测试单链表开始-----------");
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

    SinglyNode node1 = linkedList.findNode(1);
    if (node1 == null){
      System.out.println("未找到值为 1 的节点");
    } else {
      System.out.println("找到了值为 1 的节点");
      SinglyNode node1NextNode = node1.next;
      if (node1NextNode != null) {
        System.out.printf("节点 1 的下一个节点是 %d。\n", node1NextNode.data);
      }
    }

    System.out.println("-----------测试单链表结束-----------");
    System.out.println("");
  }

  public static void testDoubleLinkedList() {
    System.out.println("-----------测试双链表开始-----------");
    DoubleLinkedList linkedList = new DoubleLinkedList(5);

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

    DoubleNode node1 = linkedList.findNode(1);
    if (node1 == null){
      System.out.println("未找到值为 1 的节点");
    } else {
      System.out.println("找到了值为 1 的节点");
      DoubleNode node1PrevNode = node1.prev;
      DoubleNode node1NextNode = node1.next;
      if (node1PrevNode != null) {
        System.out.printf("节点 1 的前一个节点是 %d。\n", node1PrevNode.data);
      }
      if (node1NextNode != null) {
        System.out.printf("节点 1 的下一个节点是 %d。\n", node1NextNode.data);
      }
    }

    System.out.println("-----------测试双链表结束-----------");
    System.out.println("");
  }

  public static void main(String[] args) {
    testSinglyLinkedList();
    testDoubleLinkedList();
  }
}
