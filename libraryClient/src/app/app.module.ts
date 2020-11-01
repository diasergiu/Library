import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartiListaComponent } from './carti-lista/carti-lista.component';
import { CarteSaveComponent } from './carte-save/carte-save.component';

@NgModule({
  declarations: [
    AppComponent,
    CartiListaComponent,
    CarteSaveComponent,
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
