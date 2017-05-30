package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CIRUGIA")
@NamedQueries({
	@NamedQuery(name="listarCirugias", query="Select c FROM Cirugia c")
})
public class Cirugia implements Serializable{

	/**
	 * lista de las cirugias
	 */
	public static final String listarCirugias = "listarCirugias";
	
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
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

	

	
	
	public Cirugia(int id, String descripcion, TipoCirugia tipoCirugia, Especializacion especializacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoCirugia = tipoCirugia;
		this.especializacion = especializacion;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}

	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	public Especializacion getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(Especializacion especializacion) {
		this.especializacion = especializacion;
	}

	
	
}