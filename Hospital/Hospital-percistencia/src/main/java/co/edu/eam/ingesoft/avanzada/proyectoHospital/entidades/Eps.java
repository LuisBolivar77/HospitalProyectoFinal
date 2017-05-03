package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="EPS")
@NamedQueries({
	
	@NamedQuery(name = "LISTAR_EPS", query = "SELECT e FROM EPS e ORDER BY ASC")
})
public class Eps implements Serializable{
	
	
	public static final String LISTAR_EPS = "Listar_EPS";
	
	
	@Id
	@Column(name="ID", nullable=false)
	private int id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="TIPO_EPS_ID", nullable=false)
	private TipoEps tipoEps;
	
	public Eps() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param tipoEps
	 */
	public Eps(int id, String descripcion, TipoEps tipoEps) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoEps = tipoEps;
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
