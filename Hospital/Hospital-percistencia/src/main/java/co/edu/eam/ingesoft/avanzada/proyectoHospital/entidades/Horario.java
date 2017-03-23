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
@Table(name="HORARIO")
public class Horario implements Serializable{
	
	@Id
	@Column(name="FECHA_HORA")
	@Temporal(TemporalType.DATE)
	private Date fecha_hora;
	
	@Column(name="HORA_FIN")
	@Temporal(TemporalType.DATE)
	private Date horaFin;
	
	@ManyToOne
	@JoinColumn(name="PERSONAL_MEDICO")
	private PersonalMedico personalMedico;
	
	public Horario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fecha_hora
	 * @param horaFin
	 * @param personalMedico
	 */
	public Horario(Date fecha_hora, Date horaFin, PersonalMedico personalMedico) {
		super();
		this.fecha_hora = fecha_hora;
		this.horaFin = horaFin;
		this.personalMedico = personalMedico;
	}

	/**
	 * @return the fecha_hora
	 */
	public Date getFecha_hora() {
		return fecha_hora;
	}

	/**
	 * @param fecha_hora the fecha_hora to set
	 */
	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
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
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the personalMedico
	 */
	public PersonalMedico getPersonalMedico() {
		return personalMedico;
	}

	/**
	 * @param personalMedico the personalMedico to set
	 */
	public void setPersonalMedico(PersonalMedico personalMedico) {
		this.personalMedico = personalMedico;
	}

	

}
