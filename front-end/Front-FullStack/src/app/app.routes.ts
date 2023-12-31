import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {RestaurantComponent} from "./components/restaurant/restaurant.component";

export const routes: Routes = [
  {
    path:'home',
    component: RestaurantComponent
  },
  {
    path:"",
    redirectTo:"/home",
    pathMatch:'full'
  }
];
