import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';
import { FormacionServiceService } from 'src/app/service/formacion-service.service';

@Component({
  selector: 'app-cursosAlumno',
  templateUrl: './cursosAlumno.component.html',
  styleUrls: ['./cursosAlumno.component.css']
})
export class CursosAlumnoComponent implements OnInit {
  alumno:string;
  alumnos:Alumno[];
  cursos:Curso[];
  
  constructor(private router:Router, private service:FormacionServiceService) { 
    this.service.buscarAlumnos().subscribe(data=>{this.alumnos=data; console.log(this.alumnos)});
  }
  
  busqueda(){
    this.service.cursosAlumno(this.alumno).subscribe(data=>{this.cursos=data; console.log(this.cursos)});
  }
  
  ngOnInit() {
  }

  

}
