package collection;

import java.util.LinkedList;

public class CollectionLinkedList {

  public static void main(String[] args) {
    testStack();
  }


  public static void testQueue() {
    LinkedList<String> queue = new LinkedList<>();
    queue.add("赵敏");
    queue.addLast("张无忌");
    queue.addLast("周芷若");
    queue.addLast("小昭");
    queue.addLast("殷素素");
    System.out.println("队列的元素个数：" + queue.size());
    System.out.println(queue);

    System.out.println(queue.removeFirst());
    System.out.println("删除第一个元素后：" + queue);
    System.out.println(queue.removeLast());
    System.out.println("删除最后一个元素后：" + queue);

  }

  public static void testStack() {
    LinkedList<String> stack = new LinkedList<>();

    stack.push("子弹1");
    stack.push("子弹2");
    stack.push("子弹3");
    stack.push("子弹4");
    stack.push("子弹5");

    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println("pop后：" + stack);

  }

}
