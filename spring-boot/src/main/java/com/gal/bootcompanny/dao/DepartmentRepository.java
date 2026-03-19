package com.gal.bootcompanny.dao;

import com.gal.bootcompanny.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("from Department d where d.name = :name")
    Department findByName(String name);
//
//    Department save(Department dept);
}
