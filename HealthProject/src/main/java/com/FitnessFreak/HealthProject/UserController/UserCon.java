package com.FitnessFreak.HealthProject.UserController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.FitnessFreak.HealthProject.Model.UserM;
import com.FitnessFreak.HealthProject.Repositary.UserRepo;
import com.FitnessFreak.HealthProject.Service.UserServiceIMPL;
import com.FitnessFreak.HealthProject.exception.RosourceNotFound;

import ch.qos.logback.core.model.Model;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCon {
    @Autowired
    UserServiceIMPL obj;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/index")
    public String  indexPage(){
        
        System.out.println("this is index page");
        return "index";
    }
    @GetMapping("/SignupUser")
    public String signInPage(){

        return "SignupUser";
    }
    
    // @PostMapping("/signInUser")

    // public String signuppage(@ModelAttribute UserM a){
           
    //     obj.addUser(a);
    //     System.out.println("User Added");
    //     return "signInUser";
    // }
    
    @PostMapping("/signInUser")
public ResponseEntity<UserM> signuppage(@RequestBody UserM a){
    obj.addUser(a);
    System.out.println("User Added");
    System.out.println(a);
    return ResponseEntity.ok(a); // Return the added user as JSON
}


   @GetMapping("/uend")
   public String endpage(){
    return "uend";
   }
   @GetMapping("/signInUser")
   public String signInpage(){
    return "signInuser";
   }
   @GetMapping("/blogs")
   public String blogsPage(){
    return "blogs";
   }
   @GetMapping("/performance")
   public String performancPage(){
    return "performance";
   }
     @GetMapping("/nutritions")
   public String nutritionsPage(){
    return "nutritions";
   }
   @GetMapping("/workoutPlans")
   public String workoutPlansPage(){
    return "workoutPlans";
   }
   @GetMapping("/forgotPassword")
   public String forgotPassPage(){
    return "forgotPassword";
   }
//    @GetMapping("/deleteUser/{id}")
// public String deleteUser(@PathVariable int id) {
//     obj.deleteUser(id);
//     System.out.println("user deleted");
//     return "redirect:/index";
// }
@DeleteMapping("/deleteUser/{id}")
public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id){
    UserM user = userRepo.findById(id)
    .orElseThrow(() -> new RosourceNotFound("Member not exist with id :" + id));

userRepo.delete(user);
Map<String, Boolean> response = new HashMap<>();
response.put("deleted", Boolean.TRUE);
return ResponseEntity.ok(response);
}

@GetMapping("/getUser/{id}")
public ResponseEntity<UserM> getEmployeeById(@PathVariable int id) {
   UserM user= obj.getUserById(id);

  
   return ResponseEntity.ok(user);
}
// @PostMapping("/passwordUpdated")
// public String updatePassword(@RequestParam("uemail") String uemail, @RequestParam("newPassword") String newPassword,@RequestParam("confirmPassword") String confirmPassword) {
//     if (uemail == null || uemail.isEmpty() && newPassword==" " && confirmPassword==" ") {
       
//         System.out.println("All fiels are required.");
//         return "/forgotPassword";
//     }
//      if(!newPassword.equals(confirmPassword)){
//             System.out.println("both password should match");
//             return "/forgotPassword";
//         }
//     else
//     obj.updateUser(uemail, newPassword,confirmPassword);
//     System.out.println("Password updated successfully");
  
//     return "passwordUpdated";
// }
// @PostMapping("/passwordUpdated")
// public String updatePassword(
//     @RequestParam("uemail") String uemail,
//     @RequestParam("newPassword") String newPassword,
//     @RequestParam("confirmPassword") String confirmPassword
// ) {
// if (uemail == null || uemail.isEmpty() || newPassword.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
//     System.out.println("All fields are required.");
//     return "/forgotPassword";
// }

// if (!newPassword.equals(confirmPassword)) {
//     System.out.println("Both passwords should match");
//     return "/forgotPassword";
// }

// try {
//     // Assuming updateUser may throw an exception if the update fails
//     obj.updateUser(uemail, newPassword, confirmPassword);
//     System.out.println("Password updated successfully");
//     return "passwordUpdated";
// } catch (Exception e) {
//     System.out.println("Failed to update password: " + e.getMessage());
//     // Handle the failure case, maybe return to a specific error page
//     return "/errorPage";
// }
// }
@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserM> updateUser(@PathVariable int id, @RequestBody UserM userDetails){
		UserM user = obj.getUserById(id);
				// .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		user.setUname(userDetails.getUname());
	
		user.setUemail(userDetails.getUemail());
		user.setUmob(userDetails.getUmob());
        user.setUpassword(userDetails.getUpassword());
        user.setUconfirmpass(userDetails.getUconfirmpass());
		UserM updatedUser = obj.save(user);
		return ResponseEntity.ok(updatedUser);
	}



// @GetMapping("/getAllUsers")
// public String getAllUsers(Model model) {
//     List<UserM> users = obj.getAllUsers(); 
//     obj.addAttribute("users", users);
//     System.out.println(users);
//     return "index";
// }

@GetMapping("/getAllUsers")
    @ResponseBody
    public List<UserM> showAllUsers() {
        return obj.getAllUsers();
    }

@PostMapping("/index")
public String login(@RequestParam String uemail, @RequestParam String upassword, Model model) {
    UserM user = obj.findByUemail(uemail);
    
    if (user != null && user.getUpassword().equals(upassword) && user.getUemail().equals(uemail)) {
        System.out.println("Logged in successfully");
        return "index";
    } else {
        System.out.println("login failed");
        return "signInUser";
    }
}


       
}