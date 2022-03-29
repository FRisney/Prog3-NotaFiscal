package com.github.com.frisney.nfe.services.interfaces;

import java.util.List;

public interface ICrudService<T,K> {
    public List<T> all();
    public T byId(K id);
    public T insert(T entity);
    public T update(T entity);
    public void delete(T entity);
    public void deleteById(K id);
}
