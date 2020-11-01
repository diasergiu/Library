import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Carte } from '../model/carte.model';
import { CartiService } from '../shared/carti.service';

@Component({
  selector: 'app-carti-lista',
  templateUrl: './carti-lista.component.html',
  styleUrls: ['./carti-lista.component.css']
})

export class CartiListaComponent implements OnInit {

  carti: Carte[];

  constructor(private cartiService: CartiService) { }

  ngOnInit() {
    this.cartiService.getAllCarti().subscribe(data =>{
      this.carti = data
    });
  }

}
