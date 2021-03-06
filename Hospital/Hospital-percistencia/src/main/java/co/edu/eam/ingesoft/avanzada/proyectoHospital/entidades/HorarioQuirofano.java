package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HORARIO_QUIROFANO")
public class HorarioQuirofano implements Serializable{

	@Id
	@Column(name="FECHA_HORA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HORA_FIN")
	private Date horaFin;
	
	@ManyToOne
	@JoinColumn(name="QUIROFANO_ID")
	private Quirofano quirofano;
	
	public HorarioQuirofano() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fechaHora
	 * @param horaFin
	 * @param quirofano
	 */
	public HorarioQuirofano(Date fechaHora, Time horaFin, Quirofano quirofano) {
		super();
		this.fechaHora = fechaHora;
		this.horaFin = horaFin;
		this.quirofano = quirofano;
	}

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the horaFin
	 */
	public Date getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the quirofano
	 */
	public Quirofano getQuirofano() {
		return quirofano;
	}

	/**
	 * @param quirofano the quirofano to set
	 */
	public void setQuirofano(Quirofano quirofano) {
		this.quirofano = quirofano;
	}
	
	
}
