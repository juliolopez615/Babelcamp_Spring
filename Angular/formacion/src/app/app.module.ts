import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { AlumnosCursoComponent } from './componentes/alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './componentes/cursosAlumno/cursosAlumno.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    AlumnosCursoComponent,
    CursosAlumnoComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
