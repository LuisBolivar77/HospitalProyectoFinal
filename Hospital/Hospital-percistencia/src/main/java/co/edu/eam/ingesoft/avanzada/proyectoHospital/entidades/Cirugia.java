package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CIRUGIA")
public class Cirugia implements Serializable{

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CIRUGIA")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_CIRUGIA")
	private int id;
	
	@Column(name="DECRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="TIPO_CIRUGIA_ID")
	private TipoCirugia tipoCirugia;
	
	@ManyToOne
	@JoinColumn(name="ESPECIALIZACION_ID")
	private Especializacion especializacion;
	
	public Cirugia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param tipoCirugia
	 */
	public Cirugia(int id, String descripcion, TipoCirugia tipoCirugia) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoCirugia = tipoCirugia;
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