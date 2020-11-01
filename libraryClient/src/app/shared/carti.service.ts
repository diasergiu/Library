import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Autor} from '../model/autor.model';
import { Carte} from '../model/carte.model';


@Injectable({
  providedIn: 'root'
})
export class CartiService {

  constructor(private http: HttpClient) {}

   getAllCarti(): Observable<any> {
      return this.http.get('//localhost:8080/Carte');
   }

  saveCarte(carte : Carte){
      console.log('sad', carte);

      return this.http.post('//localhost:8080/Carte/SaveCarte', carte).subscribe({
        next: data => {

        },
        error: error => {
            console.error('There was an error!', error);
        }
    })
  }

  getCarteById(id: string): Observable<any> {
      return this.http.get('//localhost:8080/Carte/CarteById?id=' + id);
  }
  getEditurii(): Observable<any> {
      return this.http.get('//localhost:8080/Editura');
  }
}


