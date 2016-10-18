package br.edu.ifpi.sgp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.sgp.model.Usuario;

/**
 * @author Patrick
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    EntityManager entityManager;

    @Override
    public void adicionarUsuario(Usuario usuario) {
        try {
            entityManager = JPAUtil.getManager();
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        try {
            entityManager = JPAUtil.getManager();
            entityManager.getTransaction().begin();
            Usuario aSerApagado = buscarUsuarioPorId(usuario.getIdUsuario());
            entityManager.remove(aSerApagado);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public boolean alterarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public Usuario buscarUsuarioPorId(long idUsuario) {
        return (Usuario) entityManager.find(Usuario.class, idUsuario);
    }

    @Override
    public Usuario buscarUsuarioNomeSenha(String email, String senha) {
        try {
            Usuario usuario = (Usuario) entityManager
                    .createQuery("SELECT u from Usuario u where u.email = :email and u.senha = :senha")
                    .setParameter("email", email).setParameter("senha", senha).getSingleResult();
            return usuario;
        } catch (Exception e) {
            System.out.println("erro -> " + e.toString());
            return null;
        }
    }

    @Override
    public List<Usuario> listaUsuario() {
        return null;
    }

    @Override
    public List<Usuario> pesquisarUsuario(String nome) {
        return null;
    }
}
