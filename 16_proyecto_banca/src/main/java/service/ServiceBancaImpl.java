package service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.CuentaDao;
import dao.MovimientoDao;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Service
public class ServiceBancaImpl implements ServiceBanca{
	@Autowired
	ConversorEntityDto converter;
	
	private CuentaDao cuentaDao;
	private MovimientoDao movimientoDao;
	
	
	public ServiceBancaImpl(@Autowired CuentaDao cuentaDao, @Autowired MovimientoDao movimientoDao) {
		this.cuentaDao = cuentaDao;
		this.movimientoDao = movimientoDao;
	}

	@Override
	public CuentaDto validar(int numeroCuenta) {
		Cuenta c = cuentaDao.findById(numeroCuenta);
		if(c!=null) {
			CuentaDto cuenta = converter.cuentaToDto(c);
			return cuenta;
		}
		return null;
	}

	@Override
	public void ingresar(CuentaDto cuenta, int cantidad) {
		cuenta.setSaldo(cuenta.getSaldo() + cantidad);
		cuentaDao.save(converter.dtoToCuenta(cuenta));
		movimientoDao.save(converter.dtoToMovimiento(new MovimientoDto(0, new Date(), cantidad, "ingreso", cuenta)));
	}

	@Override
	public void extraer(CuentaDto cuenta, int cantidad) {
		cuenta.setSaldo(cuenta.getSaldo() - cantidad);
		cuentaDao.save(converter.dtoToCuenta(cuenta));
		movimientoDao.save(converter.dtoToMovimiento(new MovimientoDto(0, new Date(), cantidad, "extracción", cuenta)));		
	}

	@Override
	public List<MovimientoDto> movimientosFecha(Date fechaIni, Date fechaFin) {
		return movimientoDao.findMovimientoFecha(fechaIni, fechaFin)
				.stream()
				.map(m->converter.movimientoToDto(m))
				.collect(Collectors.toList());	
	}


}
