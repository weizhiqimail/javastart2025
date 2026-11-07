package collection_grade;

public class CollectionGradeIterator {

    public static void main(String[] args) {
        iteratorFn1();
    }


    public static void iteratorFn1() {
        ReverseList<String> rList = new ReverseList<>();

        rList.add("Apple");
        rList.add("Banana");
        rList.add("Pear");
        rList.add("Orange");
        rList.add("Cherry");

        int index = rList.size() - 1;
        for(String key: rList) {
            System.out.println("index = " + index +  " key = " + key);
            index--;
        }
    }

}
