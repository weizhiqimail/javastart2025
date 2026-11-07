package constructor;


public class Main {

    public static void main(String[] args) {
        Object child1 = new Child1("Jack");
        boolean isChild1 = child1 instanceof Child1;
        boolean isChild2 = child1 instanceof Child2;
        boolean isChild3 = child1 instanceof Parent;

    }
}
