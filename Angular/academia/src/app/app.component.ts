import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { AlumnoService } from './service/Alumno.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  curso:string;
  alumnos:Alumno[];
  cursos:string[];
  constructor(private service:AlumnoService){
    this.service.buscarCursos().subscribe(data=>{this.cursos=data; console.log(this.cursos)});
  }

  busqueda(){
    this.service.buscar(this.curso).subscribe(data=>this.alumnos=data);
    console.log(this.alumnos)
  }
}
