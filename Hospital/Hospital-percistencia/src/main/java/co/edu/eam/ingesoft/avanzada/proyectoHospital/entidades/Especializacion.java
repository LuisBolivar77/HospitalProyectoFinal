package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ESPECIALIZACION")
@NamedQueries({
	@NamedQuery (name = Especializacion.LISTAR_ESPECIALIZACIONES, query="SELECT e FROM Especializacion e")
})
public class Especializacion implements Serializable {
	
	/**
	 * Lista las especializaciones registradas
	 */
	public static final String LISTAR_ESPECIALIZACIONES = "Especializacion.listar";

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE", length = 30)
	private String nombre;
	
	
	public Especializacion(){
		
	}


	public Especializacion(String nombre) {
		super();
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
