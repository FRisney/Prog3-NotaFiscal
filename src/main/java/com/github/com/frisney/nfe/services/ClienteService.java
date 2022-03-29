package com.github.com.frisney.nfe.services;

import com.github.com.frisney.nfe.domain.Cliente;
import com.github.com.frisney.nfe.services.interfaces.ICrudService;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteService implements ICrudService<Cliente,Integer> {
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
    public Cliente update(Cliente entity) {
        return null;
    }

    @Override
    public void delete(Cliente entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
