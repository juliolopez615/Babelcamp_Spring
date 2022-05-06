import { Component, OnInit } from '@angular/core';
import { BancaServiceService } from 'src/app/service/banca-service.service';

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html',
  styleUrls: ['./operaciones.component.css']
})
export class OperacionesComponent implements OnInit {
  cantidadIngresar:number
  cantidadExtraer:number
  cantidadTransferir:number
  numeroCuenta:number

  constructor(private service:BancaServiceService) { }

  ngOnInit(): void {
  }
  
  ingresar(){
    this.service.ingresar(this.cantidadIngresar).subscribe()
  }

  extraer(){
    this.service.extraer(this.cantidadExtraer).subscribe()
  }

  transferir(){
    this.service.transferir(this.numeroCuenta,this.cantidadTransferir).subscribe()
  }
}
