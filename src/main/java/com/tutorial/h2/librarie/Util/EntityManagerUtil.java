package com.tutorial.h2.librarie.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guide-to-jpa-with-hibernate");
        return entityManagerFactory.createEntityManager();
    }
}
