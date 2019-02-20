package dao;

import java.io.Serializable;
import java.util.Collection;

public interface Dao<T> {

    /**
     * @param id id
     * @return the single result or null
     */
    T get(Serializable id);

    boolean add(T t);

    boolean delete(T t);

    boolean update(T t);

    Collection<T> get();

}
