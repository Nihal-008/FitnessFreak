import { Component, ViewChild } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  @ViewChild('userForm', { static: false }) userForm!: NgForm;
  submitted=false;

  user: any = {}; 

  constructor(private service: UserService, private router: Router) {}

  submitForm() {

    if (this.user.upassword !== this.user.uconfirmpass) {
      this.userForm.control.setErrors({ passwordMismatch: true });
      this.submitted = true;
      return;
    }
    if (this.userForm.invalid) {
      this.submitted = true;
   
      return; 

  }
      this.service.addUser(this.user).subscribe(response => {
         this.goToUserList();
          console.log('User Added:', response);
         
      });
     
  }
  goToUserList(){
    this.router.navigate(['/showUsers']);
  }
}
