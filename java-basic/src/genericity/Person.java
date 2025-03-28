package genericity;

public interface Person<T> {
  void add(T t);

  void remove(T t);

  void update(T t);

  T query(int id);
}
