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
@Table(name="TIPO_EPS")
public class TipoEps implements Serializable{
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEPS")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_TEPS")
	private int id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String Descripcion;
	
	public TipoEps() {
		// TODO Auto-generated constructor stub
	}

	public TipoEps(String descripcion) {
		super();
		Descripcion = descripcion;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	

}
