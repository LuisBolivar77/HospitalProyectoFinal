package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EPS")
@NamedQueries({
	@NamedQuery(name = "LISTAR_EPS", query = "SELECT e FROM Eps e ")
})
public class Eps implements Serializable{
	
	
	public static final String LISTAR_EPS = "Listar_EPS";
	
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EPS")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_EPS")
	private int id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="TIPO_EPS_ID", nullable=false)
	private TipoEps tipoEps;
	
	public Eps() {
		// TODO Auto-generated constructor stub
	}

	public Eps(String descripcion, TipoEps tipoEps) {
		super();
		this.descripcion = descripcion;
		this.tipoEps = tipoEps;
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

	public TipoEps getTipoEps() {
		return tipoEps;
	}

	public void setTipoEps(TipoEps tipoEps) {
		this.tipoEps = tipoEps;
	}

	
	
	

}
