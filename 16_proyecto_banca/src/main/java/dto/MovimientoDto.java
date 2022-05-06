package dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientoDto {
	int idMovimiento;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date fecha;
	int cantidad;
	String operacion;
	CuentaDto cuenta;
}
