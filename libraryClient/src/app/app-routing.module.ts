import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CarteSaveComponent } from './carte-save/carte-save.component';
import { CartiListaComponent } from './carti-lista/carti-lista.component';


const routes: Routes = [
];

@NgModule({
  imports: [
      RouterModule.forRoot([
        { path: '', redirectTo: '/app-carti-lista', pathMatch: 'full' },
        { path: 'app-carti-lista', component: CartiListaComponent },
        { path: 'app-carte-save', component: CarteSaveComponent },
        { path: 'app-carte-edit/:id', component: CarteSaveComponent },
      ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
