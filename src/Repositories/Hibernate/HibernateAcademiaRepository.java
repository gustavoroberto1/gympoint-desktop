package Repositories.Hibernate;

import Entities.Academia;
import Repositories.AcademiaRepository;
import Utils.JpaManager;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class HibernateAcademiaRepository implements AcademiaRepository{

    private EntityManager entityManager;

    public HibernateAcademiaRepository() {
        this.entityManager = JpaManager.getEntityManager();
    }
    
    @Override
    public Academia create(Academia academia) {
      try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(academia);
            this.entityManager.getTransaction().commit();
            return academia;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Academia buscarAcademiaPorNome(String nome) {
        try {
            TypedQuery<Academia> query = this.entityManager.createQuery("SELECT u FROM Academia AS u WHERE u.nome = :nome", Academia.class);
            query.setParameter("email", nome);
            return query.getSingleResult();          
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }
    
}
