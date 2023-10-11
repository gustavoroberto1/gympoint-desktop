package Repositories.Hibernate;

import Entities.Academia;
import Repositories.AcademiaRepository;
import Utils.JpaManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
            query.setParameter("nome", nome);
            return query.getSingleResult();          
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Academia> buscarAcademias(String termo) {
        try {
            TypedQuery<Academia> query = this.entityManager.createQuery("SELECT u FROM Academia AS u WHERE u.nome LIKE :termo", Academia.class);
            query.setParameter("termo", "%" + termo + "%");
            return query.getResultList();          
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
        
//        DOCUMENTAÇÃO RECOMENDA  
//        CriteriaBuilder query1 = this.entityManager.getCriteriaBuilder();
//        CriteriaQuery<Academia> criteria = query1.createQuery(Academia.class);
//        Root<Academia> root = criteria.from(Academia.class);
//        criteria.select(root);
//        criteria.where(query1.like(root.get("nome"), "%" + termo + "%"));
//        return this.entityManager.createQuery(criteria).getResultList();
    }
    
}
