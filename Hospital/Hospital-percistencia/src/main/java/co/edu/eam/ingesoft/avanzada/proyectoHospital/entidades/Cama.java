package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CAMA")
@NamedQueries({
	@NamedQuery(name="listarCamasDispon ", query="SELECT c FROM Cama c WHERE c.ocupado = 1")
})
public class Cama implements Serializable{

	public static String listarCamasDispon = "camasDisponibles";
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DESCRIPCION", length=200, nullable=false)
	private String descripcion;
	
	public Cama() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public Cama(String descripcion) {
		super();
		this.descripcion = descripcion;
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
	
	
	
}
