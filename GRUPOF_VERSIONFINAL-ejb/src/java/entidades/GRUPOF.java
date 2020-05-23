/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
public class GRUPOF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario a1 = new Usuario();
        a1.setNombre("Alberto");
        a1.setApellidos("Aguilera");
        
        Usuario a2 = new Usuario();
        a2.setNombre("Alejandro");
        a2.setApellidos("Martin");
        

        // TODO Auto-generated method stub
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GRUPOF");
        EntityManager em = emf.createEntityManager();
        // 3-Persists the book to the database
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a1);
        em.persist(a2);
        tx.commit();
        
        em.close();
        emf.close();
    }    
}
