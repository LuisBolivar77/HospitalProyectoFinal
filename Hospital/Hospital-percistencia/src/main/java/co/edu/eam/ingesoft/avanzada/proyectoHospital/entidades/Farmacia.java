package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="FARMACIA")
@NamedQueries({
	@NamedQuery(name="LISTAR_FARMACIAS", query="SELECT f FROM Farmacia f ORDER BY ASC")
})
public class Farmacia implements Serializable {

	public static final String LISTAR_FARMACIAS = "ListarFarmacias";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="DESCRIPCION", length=40, nullable=false)
	private String descripcion;
	
	public Farmacia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param descripcion
	 */
	public Farmacia(String descripcion) {
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
