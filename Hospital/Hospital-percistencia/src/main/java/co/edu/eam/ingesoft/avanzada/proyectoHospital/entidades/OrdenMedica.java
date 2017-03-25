package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ORDEN_MEDICA")
public class OrdenMedica implements Serializable{
	
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="cita")
	private Cita cita;
	
	public OrdenMedica() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param cita
	 */
	public OrdenMedica(int id, String descripcion, Cita cita) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.cita = cita;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
}
