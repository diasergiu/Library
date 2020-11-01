import { Autor } from '../model/autor.model';
import { Editura } from '../model/editura.model';

export class Carte {
  idCarte: number;
  titlu: string;
  ISBN: string;
  anPublicatie: Date;
  editura : Editura;
  autoriCarti: Autor[];
}
