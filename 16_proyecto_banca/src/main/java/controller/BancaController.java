package controller;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.CuentaDto;
import dto.MovimientoDto;
import service.ServiceBanca;

@CrossOrigin("*")
@Controller
public class BancaController {
	@Autowired 
	ServiceBanca service;
	
	private CuentaDto cuenta = null;
	
	@PostMapping(value="Validar")
	public String validar(@RequestParam("numeroCuenta") int numeroCuenta) {
		CuentaDto cuentaValidar = service.validar(numeroCuenta);
		if(cuentaValidar != null) {
			this.cuenta = cuentaValidar;
			return "menu";			
		}
		else {
			return "login";
		}
	}
	
	@PostMapping(value="Ingresar")
	public @ResponseBody void ingresar(@RequestParam("cantidad") int cantidad) {
		service.ingresar(cuenta, cantidad);
	}
	
	@PostMapping(value="Extraer")
	public @ResponseBody void extraer(@RequestParam("cantidad") int cantidad) {
		service.extraer(cuenta, cantidad);
	}
	
	@PostMapping(value="Transferencia")
	public @ResponseBody void transferencia(@RequestParam("cuenta") int cuentaDestino, @RequestParam("cantidad") int cantidad) {
		CuentaDto temp = this.cuenta;
		CuentaDto cuentaDes = service.validar(cuentaDestino);
		this.cuenta = temp;
		
		service.extraer(cuenta, cantidad);
		service.ingresar(cuentaDes, cantidad);

	}
	
	@GetMapping(value="Movimientos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientoDto> movimientos(@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni, 
												@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){
		
			return service.movimientosFecha(fechaIni, fechaFin)
					.stream()
					.filter(m->m.getCuenta().getNumeroCuenta() == this.cuenta.getNumeroCuenta())
					.collect(Collectors.toList());
		
	}
	
	
}
