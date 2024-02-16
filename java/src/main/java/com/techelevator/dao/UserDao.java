package com.techelevator.dao;

import com.techelevator.model.DTOs.RegisterUserDTO;
import com.techelevator.model.tables.User;

import java.util.List;

public interface UserDao {

    int getUserIdByUsername(String username);

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDTO user);
}
