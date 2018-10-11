package service;

import java.util.Collection;

public interface Service<T> {

    boolean add(T t);

    boolean delete(T t);

    boolean update(T t);

    Collection<T> get();
}
