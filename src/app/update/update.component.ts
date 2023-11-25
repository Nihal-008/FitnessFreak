import { Component, OnInit, ViewChild } from '@angular/core';
import { UserM } from '../user-m';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit{
  @ViewChild('updateForm', { static: false }) updateForm!: NgForm;
  submitted=false;

  id!: number;
  user: UserM = new UserM();
 constructor(private userService: UserService,
    private route: ActivatedRoute,
    private router: Router) { }
  
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.userService.getUserById(this.id).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
  }
 onSubmit() {
  if (this.user.upassword !== this.user.uconfirmpass) {
    this.updateForm.control.setErrors({ passwordMismatch: true });
    this.submitted = true;
    return;
  }
    this.userService.updateUser(this.id, this.user).subscribe( data =>{
      this.goToUserList();
    }
    , error => console.log(error));
 }
  goToUserList(){
    this.router.navigate(['/showUsers']);
  }
}