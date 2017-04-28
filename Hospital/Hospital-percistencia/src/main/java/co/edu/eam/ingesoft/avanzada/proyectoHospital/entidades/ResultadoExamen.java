package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RESULTADO_EXAMEN")
@IdClass(ResultadoExamenPK.class)
public class ResultadoExamen implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	private Examen examen;

	@Id
	@ManyToOne
	@JoinColumn(name = "ORDEN_MEDICA_ID")
	private OrdenMedica ordenMedica;

	@Column(name = "RESULTADO")
	private String resultado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA")
	private Date fechaHora;

	public ResultadoExamen(Examen examen, OrdenMedica ordenMedica, String resultado, Date fechaHora) {
		super();
		this.examen = examen;
		this.ordenMedica = ordenMedica;
		this.resultado = resultado;
		this.fechaHora = fechaHora;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public OrdenMedica getOrdenMedica() {
		return ordenMedica;
	}

	public void setOrdenMedica(OrdenMedica ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + ((ordenMedica == null) ? 0 : ordenMedica.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
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
		ResultadoExamen other = (ResultadoExamen) obj;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (ordenMedica == null) {
			if (other.ordenMedica != null)
				return false;
		} else if (!ordenMedica.equals(other.ordenMedica))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}

}
