package com.FitnessFreak.HealthProject.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FitnessFreak.HealthProject.Model.UserM;

public interface UserRepo extends JpaRepository<UserM , Integer> {
     @Query("SELECT u FROM UserM u WHERE u.uemail = :uemail")
  public  UserM findByUemail(@Param("uemail") String uemail);
}
 