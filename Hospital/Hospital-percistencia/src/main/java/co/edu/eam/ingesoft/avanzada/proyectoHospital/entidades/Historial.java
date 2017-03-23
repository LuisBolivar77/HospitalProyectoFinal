package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HISTORIAL")
public class Historial implements Serializable{

	@Id
	@Column(name="ID")
	private String id;
	
	public Historial() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public Historial(String id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
