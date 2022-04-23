package com.github.frisney.nfe.repositories;

import com.github.frisney.nfe.domain.Produto;
import com.github.frisney.nfe.repositories.interfaces.IBasicRepository;
import com.github.frisney.nfe.services.DbAccessManager;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoRepository implements IBasicRepository<Produto,Integer> {
    @Override
    public List<Produto> all() {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.createQuery("from Produto", Produto.class).getResultList();
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Produto byId(Integer id) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            return em.find(Produto.class,id);
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Produto insert(Produto produto) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            if(produto.getId() != null){
                em.merge(produto);
            } else{
                em.persist(produto);
            }
            em.getTransaction().commit();
            return produto;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public Produto update(Produto produto) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            Produto newProduto = em.merge(produto);
            em.getTransaction().commit();
            return newProduto;
        } finally {
            if (em!=null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Produto produto) {
        EntityManager em = null;
        try{
            em = DbAccessManager.getEntityManager();
            em.getTransaction().begin();
            em.remove(produto);
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
