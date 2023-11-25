import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { UserM } from '../user-m';

@Component({
  selector: 'app-show-users',
  templateUrl: './show-users.component.html',
  styleUrls: ['./show-users.component.css']
})
export class ShowUsersComponent implements OnInit{
  users: UserM[]=[];

  constructor(private service: UserService,private router: Router){
    this.service.getApi().subscribe(data=>{
      console.log(data);
      this.users=data;
    });
  }
  confirmDelete(id: number): void {
    const confirmation = window.confirm('Are you sure you want to delete this user?');

    if (confirmation) {
      this.deleteUser(id);
    }
  }

  navigateTo(route:String){
    this.router.navigate([route]);
  }
  ngOnInit(): void {
    this.getUsers();
  }
private getUsers(){
  this.service.getApi().subscribe(data =>{
    this.users= data;
  });
}
  // deleteUser(id: any): void {
  //   this.service.deleteUser(id).subscribe(
  //     () => {
  //       console.log('User deleted successfully');
       
  //     },
  //     (error: any) => {
  //       console.error('Error deleting user:', error);
  //     }
  //   );
  // }
  deleteUser(id: number) {
    console.log('Deleting user with id:', id);
  
    this.service.deleteUser(id).subscribe(
      data => {
        console.log('Delete operation successful:', data);
        this.getUsers();
      },
      error => {
        console.error('Error deleting user:', error);
      }
    );
  }
 
  updateUser(id: number) {
    this.router.navigate(['update-user', id]);
    
  }
}
