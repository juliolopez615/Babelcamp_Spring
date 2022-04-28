import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';


@Injectable({
  providedIn: 'root'
})
export class AlumnoService {
//url:string="http://localhost:8080/07_alumno/Buscador"
url:string="Buscador"
url2:string="BuscadorCursos"
//url2:string="http://localhost:8080/07_alumno/BuscadorCursos"

constructor(private http:HttpClient) { }

buscar(curso:string){
  return this.http.get<Alumno[]>(this.url,{params:{curso:curso}});
}

buscarCursos(){
  return this.http.get<string[]>(this.url2);
}



}
