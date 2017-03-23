package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_TIPO_CITA")
public class TipoCita implements Serializable{
	
	@Id
	@Column(name="ID", nullable=false)
	private String id;
	
	@Column(name="DURACION", nullable=false)
	private int duracion;
	
	public TipoCita() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param duracion
	 */
	public TipoCita(String id, int duracion) {
		super();
		this.id = id;
		this.duracion = duracion;
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

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	

}
