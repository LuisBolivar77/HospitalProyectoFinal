package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HOSPITALIZACION")
public class Hospitalizacion implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_HOSP")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_HOSP")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_ENTRADA", nullable = false)
	private Date fechaEntrada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_SALIDA")
	private Date fechaSalida;
	
	@OneToOne
	@JoinColumn(name="CITA_ID")
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="CAMA_NUMERO")
	private Cama cama;
	
	public Hospitalizacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param cita
	 * @param cama
	 */
	public Hospitalizacion(int id, Date fechaEntrada, Date fechaSalida, Cita cita, Cama cama) {
		super();
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cita = cita;
		this.cama = cama;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}

	/**
	 * @return the cama
	 */
	public Cama getCama() {
		return cama;
	}

	/**
	 * @param cama the cama to set
	 */
	public void setCama(Cama cama) {
		this.cama = cama;
	}

}
