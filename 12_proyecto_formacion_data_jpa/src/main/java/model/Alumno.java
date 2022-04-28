package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity //javax persistance
@Table(name="alumnos")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private int edad;
	
	@JsonIgnore
	@ManyToMany()
	@JoinTable(name = "matriculas", 
	joinColumns = @JoinColumn(name="usuario", referencedColumnName = "usuario"), 
	inverseJoinColumns = @JoinColumn(name="idCurso",referencedColumnName ="idCurso"))
	private List<Curso> curso;
	
	
}
