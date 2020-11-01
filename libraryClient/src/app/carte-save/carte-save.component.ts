import { Editura } from '../model/editura.model';
import { Component, OnInit } from '@angular/core';
import { CartiService } from '../shared/carti.service';
import { Carte } from '../model/carte.model';
import { Autor } from '../model/autor.model';
import { AutorService } from '../shared/autor.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-carte-save',
  templateUrl: './carte-save.component.html',
  styleUrls: ['./carte-save.component.css']
})
export class CarteSaveComponent implements OnInit {

  carte: Carte = new Carte();
  edituri: Editura[];
  autori: Autor[];
  autor: Autor[];
  sub ;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private carteService: CartiService, private autorService: AutorService) {

    this.sub = this.route.params.subscribe(params => {
      const id = params.id;
      if (id) {
        this.carteService.getCarteById(id).subscribe((carte: any) => {
          if (carte) {
            this.carte = carte;
            console.log(this.carte);
          } else {
            console.log(`Carte with id '${id}' not found, returning to main page`);
            this.gotoList();
          }
        });
      }

      this.carte.editura = new Editura();
      this.carte.autoriCarti = [];

    })
  }
  
  gotoList() {
    this.router.navigate(['/app-carti-lista']);
  }
  compareFn(c1: Autor, c2: Autor): boolean {
    console.log("calling compare function")
    return c1 && c2 ? c1.idAutor === c2.idAutor : c1 === c2;
}
onChange(date: string) {
  console.log(date)
  // this.expires_formatted = this.datePipe.transform(expires_at, 'dd/MM/yyyy HH:mm:ss');
}
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  ngOnInit() {
    this.autorService.getAutori().subscribe(data => {
      this.autori = data;
    });
    this.carteService.getEditurii().subscribe(data => {
      console.log(data);
      this.edituri = data;
    });
  }

  saveCarte(carte: NgForm) {
    this.carte = carte.value;
    console.log(JSON.stringify(this.carte.editura));
    console.log(carte);
    this.carteService.saveCarte(this.carte);
  }
}
