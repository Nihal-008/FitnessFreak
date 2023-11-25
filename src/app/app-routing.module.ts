import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';

import { ShowUsersComponent } from './show-users/show-users.component';
import { PerformanceComponent } from './performance/performance.component';
import { UpdateComponent } from './update/update.component';
import { NutritionComponent } from './nutrition/nutrition.component';
import { WorkoutPlansComponent } from './workout-plans/workout-plans.component';
import { MenWorkoutComponent } from './men-workout/men-workout.component';

const routes: Routes = [
  {
    path:'signUp',
    component:SignUpComponent
  },
  {
    path:'signIn',
    component:SignInComponent
  },
  {
    path:'',
    component:HomeComponent
  },
 
  {
  path:'signIn/signUp',
  component:SignUpComponent
  },
  {
    path:'showUsers',
    component:ShowUsersComponent
  }
  ,{
    path:'performance',
    component:PerformanceComponent
  }
  ,{
  
      path: 'update-user/:id', component: UpdateComponent
    
  },
  {
    path:'nutrition',
    component:NutritionComponent
  }
  ,{
    path:'workout',
    component:WorkoutPlansComponent
  },
  {
    path:'workout/men',
    component:MenWorkoutComponent
  }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
