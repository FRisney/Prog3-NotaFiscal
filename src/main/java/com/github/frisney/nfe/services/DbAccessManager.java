package com.github.frisney.nfe.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbAccessManager {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = null;
    private DbAccessManager(){}
    public static EntityManager getEntityManager() {
        if (ENTITY_MANAGER_FACTORY == null) {
            ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("frisney-nfe");
        }
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
