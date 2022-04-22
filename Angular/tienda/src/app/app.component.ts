import { Component } from '@angular/core';
import { Producto } from './model/Producto';
import { ProductosService } from './service/Producto.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  seccion:string;
  productos:Producto[];

  constructor(private service:ProductosService){
  }

  busqueda(){
    this.service.buscar(this.seccion).subscribe(data=>this.productos=data);
  }
}

