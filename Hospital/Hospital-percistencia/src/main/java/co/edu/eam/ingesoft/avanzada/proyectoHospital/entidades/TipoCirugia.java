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
@Table(name="TIPO_CIRUGIA")
@NamedQueries({
	@NamedQuery(name ="listaCirugias", query="select t from TipoCirugia t")
	})
public class TipoCirugia implements Serializable{

	/**
	 * lista de los tipos de cirugias
	 */
	public static final String listaCirugias = "listaCirugias";
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	public TipoCirugia() {
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}


	public TipoCirugia(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
