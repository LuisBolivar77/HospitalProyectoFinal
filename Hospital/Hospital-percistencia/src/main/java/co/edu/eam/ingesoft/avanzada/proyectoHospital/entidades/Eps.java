package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_EPS")
public class Eps implements Serializable{
	
	@Id
	@Column(name="ID", nullable=false)
	private String id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="tipoEps", nullable=false)
	private TipoEps tipoEps;
	
	public Eps() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param tipoEps
	 */
	public Eps(String id, String descripcion, TipoEps tipoEps) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoEps = tipoEps;
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
	 * @return the tipoEps
	 */
	public TipoEps getTipoEps() {
		return tipoEps;
	}

	/**
	 * @param tipoEps the tipoEps to set
	 */
	public void setTipoEps(TipoEps tipoEps) {
		this.tipoEps = tipoEps;
	}
	
	
	

}
