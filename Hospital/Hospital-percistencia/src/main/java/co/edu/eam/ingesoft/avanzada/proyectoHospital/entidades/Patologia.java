package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATOLOGIA")
@NamedQueries({ @NamedQuery(name = "listarPatologias", query = "SELECT p FROM Patologia p"),
		@NamedQuery(name = "listarPatologiasPorNumero", query = "SELECT p FROM Patologia p WHERE p.id = ?1") })
public class Patologia implements Serializable {

	/**
	 * busca una patologia por numero
	 */
	public static final String ListarPatologiasPorNumero = "listarPatologiasPorNumero";
	/**
	 * lista todas las patologias
	 */
	public static final String ListarPatologias = "listarPatologias";

	/**
	 * variable estatica que almacena el numero de una patologia
	 */
	public static int numeroPatologia;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NOMBRE", length = 40, nullable = false, unique = true)
	private String nombre;

	@Column(name = "ANOTACION", length = 200, nullable = true)
	private String anotacion;

	public Patologia() {
		// TODO Auto-generated constructor stub
	}

	

	public Patologia(int id, String nombre, String anotacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anotacion = anotacion;
	}



	public static int getNumeroPatologia() {
		return numeroPatologia;
	}



	public static void setNumeroPatologia(int numeroPatologia) {
		Patologia.numeroPatologia = numeroPatologia;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the anotacion
	 */
	public String getAnotacion() {
		return anotacion;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param anotacion
	 *            the anotacion to set
	 */
	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

}
