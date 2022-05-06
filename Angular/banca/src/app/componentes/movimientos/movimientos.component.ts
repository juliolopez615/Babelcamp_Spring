import { Component, OnInit } from '@angular/core';
import { Movimiento } from 'src/app/model/Movimiento';
import { BancaServiceService } from 'src/app/service/banca-service.service';

@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {
  movimientoslist:Movimiento[]
  fechaIni:string
  fechaFin:string
  
  constructor(private service:BancaServiceService) { }

  ngOnInit(): void {
  }
  
  movimientos(){
    this.service.movimientos(this.fechaIni, this.fechaFin).subscribe(data=>{this.movimientoslist=data; console.log(this.movimientoslist)});
  }
}
