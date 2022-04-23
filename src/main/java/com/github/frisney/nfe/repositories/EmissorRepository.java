package com.github.frisney.nfe.repositories;

import com.github.frisney.nfe.domain.Emissor;
import com.github.frisney.nfe.repositories.interfaces.IBasicRepository;
import com.github.frisney.nfe.services.DbAccessManager;

import javax.persistence.EntityManager;
import java.util.List;

public class EmissorRepository implements IBasicRepository<Emissor,Integer> {
    @Override
    public List<Emissor> all() {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.createQuery("from Emissor ", Emissor .class).getResultList();
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Emissor byId(Integer id) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.find(Emissor.class,id);
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Emissor insert(Emissor emissor) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.persist(emissor);
            em.getTransaction().commit();
            return emissor;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Emissor update(Emissor emissor) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            Emissor newEmissor = em.merge(emissor);
            em.getTransaction().commit();
            return newEmissor;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Emissor emissor) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.remove(emissor);
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
