package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RECETA")
public class Receta implements Serializable {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "DESCRIPCION", nullable = false, length = 200)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA")
	private Date fecha;

	@OneToOne
	@JoinColumn(name = "ORDEN_MEDICA_ID")
	private OrdenMedica ordenMedica;

	public Receta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param fecha
	 * @param ordenMedica
	 */
	public Receta(int id, String descripcion, Date fecha, OrdenMedica ordenMedica) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.ordenMedica = ordenMedica;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the ordenMedica
	 */
	public OrdenMedica getOrdenMedica() {
		return ordenMedica;
	}

	/**
	 * @param ordenMedica the ordenMedica to set
	 */
	public void setOrdenMedica(OrdenMedica ordenMedica) {
		this.ordenMedica = ordenMedica;
	}
	
	

}
