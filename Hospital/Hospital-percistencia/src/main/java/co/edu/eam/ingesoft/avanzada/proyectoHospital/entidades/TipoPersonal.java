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
@Table(name="TIPO_PERSONAL")
@NamedQueries({
	@NamedQuery(name=TipoPersonal.LISTAR_TIPOS, query="SELECT tp FROM TipoPersonal tp")
})
public class TipoPersonal implements Serializable{
	
	/**
	 * Lista los tipos de personal registrados
	 */
	public static final String LISTAR_TIPOS = "TipoPersonal.listar";
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TPER")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_TPER")
	private int id;
	
	@Column(name="DESCRIPCION", length=40)
	private String descripcion;
	
	public TipoPersonal() {
		// TODO Auto-generated constructor stub
	}

	public TipoPersonal(String descripcion) {
		super();
		this.descripcion = descripcion;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return descripcion;
	}

	
	

}
