package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICAMENTO")
public class Medicamento implements Serializable {

	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DESCRIPCION", length=200, nullable=false)
	private String descripcion;
	
	@JoinColumn(name="FARMACIA_ID")
	@ManyToOne
	private Farmacia farmacia;
	
	public Medicamento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param farmacia
	 */
	public Medicamento(String descripcion, Farmacia farmacia) {
		super();
		this.descripcion = descripcion;
		this.farmacia = farmacia;
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
	 * @return the farmacia
	 */
	public Farmacia getFarmacia() {
		return farmacia;
	}

	/**
	 * @param farmacia the farmacia to set
	 */
	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}	
	
}
