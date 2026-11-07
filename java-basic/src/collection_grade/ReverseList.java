package collection_grade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ReverseList<T> implements Iterable<T> {

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverIterator(list.size());
    }

    public int size() {
        return list.size();
    }

    class ReverIterator implements Iterator<T> {
        int index;

        ReverIterator(int index) {
            this.index = index;
        }


        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index--;
            return ReverseList.this.list.get(index);
        }

    }

}
