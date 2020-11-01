import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import {Autor} from '../model/autor.model';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  constructor(private http : HttpClient) { }

  getAutori(): Observable<any> {
    return this.http.get('//localhost:8080/Autor');
  }

}
