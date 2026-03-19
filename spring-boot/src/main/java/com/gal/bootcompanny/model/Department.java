package com.gal.bootcompanny.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getIdd() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getManager_id() {
        return manager_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }


    @Column(name = "manager_id")
    int manager_id;


}
