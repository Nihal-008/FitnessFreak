import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';

import { FormsModule } from '@angular/forms';
import { ShowUsersComponent } from './show-users/show-users.component';
import { PerformanceComponent } from './performance/performance.component';
import { UpdateComponent } from './update/update.component';
import { NutritionComponent } from './nutrition/nutrition.component';
import { WorkoutPlansComponent } from './workout-plans/workout-plans.component';
import { MenWorkoutComponent } from './men-workout/men-workout.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SignUpComponent,
    SignInComponent,
    HomeComponent,
   
    ShowUsersComponent,
    PerformanceComponent,
    UpdateComponent,
    NutritionComponent,
    WorkoutPlansComponent,
    MenWorkoutComponent,
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
