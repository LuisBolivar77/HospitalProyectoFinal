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
	@JoinColumn(name = "CITA_ID")
	private Cita cita;

	@Column(name = "RESULTADO")
	private String resultado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_HORA")
	private Date fechaHora;

	public ResultadoExamen() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param examen
	 * @param cita
	 * @param resultado
	 * @param fechaHora
	 */
	public ResultadoExamen(Examen examen, Cita cita, String resultado, Date fechaHora) {
		super();
		this.examen = examen;
		this.cita = cita;
		this.resultado = resultado;
		this.fechaHora = fechaHora;
	}

	public String getFechaExamen() {
		return fechaHora.getDay() + "/" + fechaHora.getMonth() + "/" + fechaHora.getYear();
	}

	/**
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * @param examen
	 *            the examen to set
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * @param cita
	 *            the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

}
