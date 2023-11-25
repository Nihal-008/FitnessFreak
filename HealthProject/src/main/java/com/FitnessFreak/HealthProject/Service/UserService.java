package com.FitnessFreak.HealthProject.Service;

import java.util.List;

import com.FitnessFreak.HealthProject.Model.UserM;

public interface UserService {
    public void addUser(UserM user);
    // public void deleteUser(int id); 
    public UserM getUserById(int id);
    // public void updateUser(String uemail, String newPassword, String confirmPassword);
    UserM updateUser(UserM user);
    public List<UserM> getAllUsers();
    UserM save(UserM user);
}
