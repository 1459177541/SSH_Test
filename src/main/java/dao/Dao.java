package dao;

import java.util.Collection;

public interface Dao<T> {

    boolean add(T t);

    boolean delete(T t);

    boolean update(T t);

    Collection<T> get();

}
