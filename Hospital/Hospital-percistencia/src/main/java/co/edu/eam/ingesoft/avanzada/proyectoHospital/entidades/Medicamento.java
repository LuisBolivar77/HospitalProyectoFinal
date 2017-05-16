package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MED")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_MED")
	private int id;

	@Column(name = "CANTIDAD", nullable = false)
	private int cantidad;

	@Column(name = "DESCRIPCION", length = 200, nullable = false)
	private String descripcion;

	public Medicamento() {
		// TODO Auto-generated constructor stub
	}


	public Medicamento(int id, int cantidad, String descripcion) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
