export interface Restaurant{
  illustrationUrl: String;
  id: number;
  adresse: string;
  nom: string;
  evaluations: Evaluation[];
  moyenne: string;
  tags : Tag[];
}


export interface Evaluation{
  id: number;
  commentaire: string;
  nom_evaluateur: string;
  note_recommandee : number;
  date_creation : Date;
  date_mise_a_jour : Date;
}

export interface Tag{
  id: number,
  nom : string,
}
