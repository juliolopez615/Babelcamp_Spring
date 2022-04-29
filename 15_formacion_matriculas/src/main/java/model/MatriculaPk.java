package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class MatriculaPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private int idCurso;
	
	

}
