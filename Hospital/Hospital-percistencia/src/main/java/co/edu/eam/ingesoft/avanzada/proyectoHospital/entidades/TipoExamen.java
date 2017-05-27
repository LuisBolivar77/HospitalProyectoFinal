package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "listarTiposExamenes", query = "SELECT t FROM TipoExamen t")
})
@Table(name="TIPO_EXAMEN")
public class TipoExamen implements Serializable{
	
	public static final String listarTiposExamen = "listarTiposExamenes";
	
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

	public int getId() {
		return id;
	}

	public TipoExamen(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

	
}
