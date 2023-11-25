package com.FitnessFreak.HealthProject.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "userinfo")

public class UserM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
       public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String uname;
       private String uemail;
       private String umob;
       private String upassword;
       private String uconfirmpass;
    public UserM() {
    }
    
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUemail() {
        return uemail;
    }
    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
    public String getUmob() {
        return umob;
    }
    public void setUmob(String umob) {
        this.umob = umob;
    }
    public String getUpassword() {
        return upassword;
    }
    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
    public String getUconfirmpass() {
        return uconfirmpass;
    }
    public void setUconfirmpass(String uconfirmpass) {
        this.uconfirmpass = uconfirmpass;
    }
    @Override
    public String toString() {
        return "UserM [uname=" + uname + ", uemail=" + uemail + ", umob=" + umob + ", upassword=" + upassword
                + ", uconfirmpass=" + uconfirmpass + "]";
    }
}
