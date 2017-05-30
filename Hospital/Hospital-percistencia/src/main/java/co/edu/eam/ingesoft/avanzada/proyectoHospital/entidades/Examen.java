package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EXAMEN")
@NamedQueries({
	@NamedQuery(name="lista.examenes", query="select e from Examen e"),
})
public class Examen implements Serializable {

	public static final String listaExamenes = "lista.examenes";
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EXAMEN")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_EXAMEN")
	private int id;

	@Column(name = "DESCRIPCION", nullable = false, length = 200)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "TIPO_EXAMEN")
	private TipoExamen tipoExamen;

	public Examen() {
		// TODO Auto-generated constructor stub
	}

	public Examen(String descripcion, TipoExamen tipoExamen) {
		super();
		this.descripcion = descripcion;
		this.tipoExamen = tipoExamen;
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

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		result = prime * result + ((tipoExamen == null) ? 0 : tipoExamen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examen other = (Examen) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (tipoExamen == null) {
			if (other.tipoExamen != null)
				return false;
		} else if (!tipoExamen.equals(other.tipoExamen))
			return false;
		return true;
	}

	

}
