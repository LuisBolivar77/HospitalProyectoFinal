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
@Table(name="TIPO_EXAMEN")
public class TipoExamen implements Serializable{
	
	@Id
	@Column(name="EXAMEN_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEXAMEN")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_TEXAMEN")
	private int id;
	
	@Column(name="DESCRIPCION", nullable=false, length=30)
	private String descripcion;
	
	public TipoExamen() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public TipoExamen(int id, String descripcion) {
		super();
		this.id = id;
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
