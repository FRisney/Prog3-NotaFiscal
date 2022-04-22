package com.github.com.frisney.nfe.repositories;

import com.github.com.frisney.nfe.domain.NotaFiscal;
import com.github.com.frisney.nfe.repositories.interfaces.IBasicRepository;
import com.github.com.frisney.nfe.services.DbAccessManager;

import javax.persistence.EntityManager;
import java.util.List;

public class NotaFiscalRepository implements IBasicRepository<NotaFiscal,Integer> {
    @Override
    public List<NotaFiscal> all() {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.createQuery("from NotaFiscal", NotaFiscal.class).getResultList();
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public NotaFiscal byId(Integer id) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.find(NotaFiscal.class,id);
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public NotaFiscal insert(NotaFiscal nota) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.persist(nota);
            em.getTransaction().commit();
            return nota;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public NotaFiscal update(NotaFiscal nota) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            NotaFiscal newNotaFiscal = em.merge(nota);
            em.getTransaction().commit();
            return newNotaFiscal;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(NotaFiscal nota) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.remove(nota);
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
