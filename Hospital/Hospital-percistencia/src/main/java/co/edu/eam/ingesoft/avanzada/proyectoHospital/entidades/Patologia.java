package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATOLOGIA")
public class Patologia implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PATOLOGIA")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_PATOLOGIA")
	private int id;

	@Column(name = "NOMBRE", length = 40, nullable = false, unique = true)
	private String nombre;

	@Column(name = "ANOTACIONES", length = 200, nullable = true)
	private String anotacion;

	public Patologia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param anotacion
	 */
	public Patologia(String nombre, String anotacion) {
		super();
		this.nombre = nombre;
		this.anotacion = anotacion;
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
	 * @param anotacion
	 *            the anotacion to set
	 */
	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

}
