package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	
	@OneToMany(mappedBy="farmacia", cascade=CascadeType.ALL)
	private List <Punto> colPuntos = new ArrayList<Punto>();
	
	@OneToMany(mappedBy="farmacia", cascade=CascadeType.ALL)
	private List <Direccion> colDirecciones = new ArrayList<Direccion>();
	
	// EMPTY CONSTRUCT
	public Farmacia(){}

	
	// 	GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Punto> getColPuntos() {
		return colPuntos;
	}


	public void setColPuntos(List<Punto> colPuntos) {
		this.colPuntos = colPuntos;
	}


	public List<Direccion> getColDirecciones() {
		return colDirecciones;
	}


	public void setColDirecciones(List<Direccion> colDirecciones) {
		this.colDirecciones = colDirecciones;
	}


	public String getDiaDeTurno() {
		return diaDeTurno;
	}

	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	
	
	
}