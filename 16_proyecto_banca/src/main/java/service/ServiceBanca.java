package service;

import java.util.Date;
import java.util.List;

import dto.CuentaDto;
import dto.MovimientoDto;

public interface ServiceBanca {
	CuentaDto validar(int numeroCuenta);
	void ingresar(CuentaDto cuenta, int cantidad);
	void extraer(CuentaDto cuenta, int cantidad);
	List<MovimientoDto> movimientosFecha(Date fechaIni, Date fechaFin);
}
