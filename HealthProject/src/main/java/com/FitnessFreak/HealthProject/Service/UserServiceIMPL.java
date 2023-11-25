package com.FitnessFreak.HealthProject.Service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FitnessFreak.HealthProject.Model.UserM;
import com.FitnessFreak.HealthProject.Repositary.UserRepo;

@Service
public class UserServiceIMPL implements UserService {
@Autowired
   UserRepo obj;
   
    @Override
    public void addUser(UserM user) {
        obj.save(user);
    }

    // @Override
    // public void deleteUser(int id) {
    //   obj.deleteById(id);
    // }

    @Override
    public UserM getUserById(int id) {
      return obj.findById(id).orElse(null);
    }

   

    // @Override
    // public void updateUser(String uemail, String newPassword, String confirmPassword) {
    //   UserM user = obj.findByUemail(uemail);
    // if (user != null) {
    //     user.setUpassword(newPassword);
    //     user.setUconfirmpass(confirmPassword);
    //     obj.save(user);
    // }
    // }


    @Override
    public java.util.List<UserM> getAllUsers() {
      return obj.findAll();
    }

    public void addAttribute(String string, java.util.List<UserM> users) {
    }

    public UserM findByUemail(String uemail) {
      return obj.findByUemail(uemail);
    }

    @Override
    public UserM updateUser(UserM user) {
      UserM existingUser = obj.findByUemail(user.getUemail());
    
      if (existingUser != null) {
          existingUser.setUname(user.getUname());
          
      
          existingUser.setUemail(user.getUemail());
          existingUser.setUmob(user.getUmob());
          existingUser.setUpassword(user.getUpassword());
          existingUser.setUconfirmpass(user.getUconfirmpass());
  
         
  
          return obj.save(existingUser);
      }
      
      return null; 
    }

    @Override
    public UserM save(UserM user) {
    return obj.save(user);
    }

    

    

   
    
}
