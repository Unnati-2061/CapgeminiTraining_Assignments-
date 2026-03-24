package com.gal;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        checkHibernateConnection();
    }
        private static void checkHibernateConnection(){
//            steps
            // connect to persistence unit so that we can manage our entities
            // we neeed entitiymanager to manage our entities
            // so we need entitiy manager factory to get entitiymanager first
            //persisitance was the one who will provide us entity manager factory
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
            EntityManager em = emf.createEntityManager(); //now here our session is opened
            //the moment you create an entity manager you are logged into the session inside
//            persistece unit
            if(em.isOpen()){
                System.out.println("Hibernate is started successfully");
// if it is open and i do soemthing inside my database object then those object
//                are my persistence object
            }else{
                System.   out.println("failed to start hibernate");
            }
//            close the resources for that we have to close the session first
            em.close();
            emf.close(); //cclose the factory

        }
}