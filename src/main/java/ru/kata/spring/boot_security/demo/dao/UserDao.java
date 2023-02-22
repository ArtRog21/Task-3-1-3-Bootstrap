package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserDao {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(Long id);
    User editUser(User user);
    User getById(Long id);
    User getUserByName(String username);
    User getUserByEmail(String email);
    List<Role> getRoleList();
    Role getRole(String role);
}