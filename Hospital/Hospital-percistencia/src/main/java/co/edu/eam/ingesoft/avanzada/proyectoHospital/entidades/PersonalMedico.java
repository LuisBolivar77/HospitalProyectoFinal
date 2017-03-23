package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_PERSONAL_MEDICO")
public class PersonalMedico implements Serializable{

	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="TIPO_PERSONAL")
	private TipoPersonal tipoPersonal;
	
	
	public PersonalMedico() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param tipoPersonal
	 */
	public PersonalMedico(String id, String nombre, String direccion, String telefono, TipoPersonal tipoPersonal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoPersonal = tipoPersonal;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the tipoPersonal
	 */
	public TipoPersonal getTipoPersonal() {
		return tipoPersonal;
	}


	/**
	 * @param tipoPersonal the tipoPersonal to set
	 */
	public void setTipoPersonal(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	
	
	
	
}
