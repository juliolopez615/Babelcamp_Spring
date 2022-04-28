import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './componentes/alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './componentes/cursosAlumno/cursosAlumno.component';


const routes: Routes = [
{
  path : 'alumnosCurso',
  component : AlumnosCursoComponent
},
{
  path : 'cursosAlumno', 
  component : CursosAlumnoComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
