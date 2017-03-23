package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PACIENTE")
public class Paciente implements Serializable{
	
	@Id
	@Column(name="IDENTIFICACION", nullable=false)
	private String identificadion;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="APELLIDO", nullable=false)
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name="eps", nullable=false)
	private Eps eps;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param identificadion
	 * @param nombre
	 * @param apellido
	 * @param eps
	 */
	public Paciente(String identificadion, String nombre, String apellido, Eps eps) {
		super();
		this.identificadion = identificadion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eps = eps;
	}

	/**
	 * @return the identificadion
	 */
	public String getIdentificadion() {
		return identificadion;
	}

	/**
	 * @param identificadion the identificadion to set
	 */
	public void setIdentificadion(String identificadion) {
		this.identificadion = identificadion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the eps
	 */
	public Eps getEps() {
		return eps;
	}

	/**
	 * @param eps the eps to set
	 */
	public void setEps(Eps eps) {
		this.eps = eps;
	}
	
	
	

}
