package com.github.com.frisney.nfe.repositories;

import com.github.com.frisney.nfe.domain.Cliente;
import com.github.com.frisney.nfe.repositories.interfaces.IBasicRepository;
import com.github.com.frisney.nfe.services.DbAccessManager;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteRepository implements IBasicRepository<Cliente,Integer> {
    @Override
    public List<Cliente> all() {
        return null;
    }

    @Override
    public Cliente byId(Integer id) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.find(Cliente.class,id);
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Cliente insert(Cliente cliente) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return cliente;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        return null;
    }

    @Override
    public void delete(Cliente cliente) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        this.delete(this.byId(id));
    }
}
