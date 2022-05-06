package converters;

import org.springframework.stereotype.Component;

import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getTipocuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(), dto.getSaldo(), dto.getTipocuenta());
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(), movimiento.getFecha(), movimiento.getCantidad(), movimiento.getOperacion(), cuentaToDto(movimiento.getIdCuenta()));
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		return new Movimiento(dto.getIdMovimiento(), dto.getFecha(), dto.getCantidad(), dto.getOperacion(), dtoToCuenta(dto.getCuenta()));
	}

	

}
