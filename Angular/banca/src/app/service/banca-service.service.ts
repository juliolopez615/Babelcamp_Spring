import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movimiento } from '../model/Movimiento';

@Injectable({
  providedIn: 'root'
})
export class BancaServiceService {
  
  //url2 = "http://localhost:8080/16_proyecto_banca/Ingresar"
  url2= "Ingresar"
  //url3="http://localhost:8080/16_proyecto_banca/Extraer"
  url3= "Extraer"
  //url4="http://localhost:8080/16_proyecto_banca/Transferencia"
  url4= "Transferencia"
  //url5="http://localhost:8080/16_proyecto_banca/Movimientos"
  url5= "Movimientos"

  constructor(private http:HttpClient) { }

  ingresar(cantidad:number){
    return this.http.post(this.url2 + "?cantidad=" + cantidad , null);
  }
  extraer(cantidad:number){
    return this.http.post(this.url3 + "?cantidad=" + cantidad , null);
  }
  transferir(cuenta:number, cantidad:number){
    return this.http.post(this.url4 + "?cuenta=" + cuenta +"&cantidad=" +cantidad, null);
  }
  movimientos(fechaIni:string, fechaFin:string){
    return this.http.get<Movimiento[]>(this.url5, {params:{fechaIni:fechaIni, fechaFin:fechaFin}})
  }
}
