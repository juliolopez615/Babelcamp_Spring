import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovimientosComponent } from './componentes/movimientos/movimientos.component';
import { OperacionesComponent } from './componentes/operaciones/operaciones.component';

const routes: Routes = [
  {
    path : 'operaciones',
    component : OperacionesComponent
  },
  {
    path : 'movimientos', 
    component : MovimientosComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
