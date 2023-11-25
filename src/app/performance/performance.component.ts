import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-performance',
  templateUrl: './performance.component.html',
  styleUrls: ['./performance.component.css']
})
export class PerformanceComponent {
  weight: number = 0; 
  height: number = 0; 
  bmi: number = 0;    

  calculateBMI() {

    if (this.weight && this.height) {
      this.bmi = this.weight / (this.height * this.height);
    }
  }
  }

