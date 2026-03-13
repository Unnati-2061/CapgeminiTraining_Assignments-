package com.gal.bootcompanny.dao;

import com.gal.bootcompanny.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    EntityManagerFactory emf;
    @Override
    public Department find(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Department.class,id);
    }

    @Override
    public List<Department> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Department> result = em.createQuery("Select c from Department c", Department.class)
                .getResultList();
        return result;
    }
}
