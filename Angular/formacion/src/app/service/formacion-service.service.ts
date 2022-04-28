import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';

@Injectable({
  providedIn: 'root'
})
export class FormacionServiceService {
  //url = "http://localhost:8080/11_proyecto_formacion/BuscadorAlumnos"
  url = "BuscadorAlumnos"
  //url2 = "http://localhost:8080/11_proyecto_formacion/BuscadorCursos"
  url2 = "BuscadorCursos"
  //url3 = "http://localhost:8080/11_proyecto_formacion/AlumnosCurso"
  url3 = "AlumnosCurso"
  //url4 = "http://localhost:8080/11_proyecto_formacion/CursosAlumno"
  url4 = "CursosAlumno"

  constructor(private http:HttpClient) { }
  buscarCursos(){
    return this.http.get<Curso[]>(this.url2);
  }
  buscarAlumnos(){
    return this.http.get<Alumno[]>(this.url);
  }
  alumnosCurso(curso:string){
    return this.http.get<Alumno[]>(this.url3,{params:{curso:curso}});
  }
  cursosAlumno(alumno:string){
    return this.http.get<Curso[]>(this.url4,{params:{alumno:alumno}});
  }
}
