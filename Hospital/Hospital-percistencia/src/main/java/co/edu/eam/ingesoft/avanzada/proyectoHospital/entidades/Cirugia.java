package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CIRUGIA")
public class Cirugia implements Serializable{

	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="DECRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="TIPO_CIRUGIA")
	private TipoCirugia tipoCirugia;
	
	public Cirugia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param tipoCirugia
	 */
	public Cirugia(String id, String descripcion, TipoCirugia tipoCirugia) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoCirugia = tipoCirugia;
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
	 * @return the tipoCirugia
	 */
	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}

	/**
	 * @param tipoCirugia the tipoCirugia to set
	 */
	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}
	
	
}