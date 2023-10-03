package Repositories.Hibernate;

import Entities.Usuario;
import Repositories.UsuarioRepository;
import Utils.JpaManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class HibernateUsuarioRepository implements UsuarioRepository {

    private EntityManager entityManager;

    public HibernateUsuarioRepository() {
        this.entityManager = JpaManager.getEntityManager();
    }

    @Override
    public Usuario create(Usuario usuario) {
        if(this.entityManager == null){
            this.entityManager = JpaManager.getEntityManager();
        }
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(usuario);
            this.entityManager.getTransaction().commit();
            return usuario;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        try {
            TypedQuery<Usuario> query = this.entityManager.createQuery("SELECT u FROM Usuario AS u WHERE u.email = :email", Usuario.class);
            query.setParameter("email", email);
            return query.getSingleResult();          
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

}
