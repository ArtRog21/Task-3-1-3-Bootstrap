package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User editUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String username) {
        return (User) entityManager
                .createQuery("from User u inner JOIN FETCH u.roles as roles where u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        return (User) entityManager
                .createQuery("from User u inner JOIN FETCH u.roles as roles where u.email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<Role> getRoleList() {
        return entityManager
                .createQuery("select u from Role u", Role.class)
                .getResultList();
    }
    @Override
    public Role getRole(String role) {
        return entityManager
                .createQuery("select u from Role u where u.role=:role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }
}