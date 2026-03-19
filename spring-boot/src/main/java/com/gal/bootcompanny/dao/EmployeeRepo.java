package com.gal.bootcompanny.dao;

import com.gal.bootcompanny.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
