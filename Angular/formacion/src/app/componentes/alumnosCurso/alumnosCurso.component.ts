import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';
import { FormacionServiceService } from 'src/app/service/formacion-service.service';

@Component({
  selector: 'app-alumnosCurso',
  templateUrl: './alumnosCurso.component.html',
  styleUrls: ['./alumnosCurso.component.css']
})
export class AlumnosCursoComponent implements OnInit {
  curso:string;
  alumnos:Alumno[];
  cursos:Curso[];
  constructor(private router:Router, private service:FormacionServiceService) { 
    this.service.buscarCursos().subscribe(data=>{this.cursos=data; console.log(this.cursos)});
  }
  
  busqueda(){
    this.service.alumnosCurso(this.curso).subscribe(data=>this.alumnos=data);
    console.log(this.alumnos)
  }

  ngOnInit() {
  }

}
