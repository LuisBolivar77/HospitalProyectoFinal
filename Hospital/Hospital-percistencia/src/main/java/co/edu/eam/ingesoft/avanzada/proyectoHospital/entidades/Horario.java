package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(HorarioMedicoPK.class)
@Table(name="HORARIO_MEDICO")
public class Horario implements Serializable{
	
	@Id
	@Column(name="DIA_SEMANA")
	private String diaSemana;
	
	@Id
	@Column(name="HORA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicio;
	
	@Column(name="HORA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFin;
	
	@ManyToOne
	@JoinColumn(name="PERSONAL_MEDICO_ID")
	private PersonalMedico personalMedico;
	
	public Horario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fecha_hora
	 * @param horaFin
	 * @param personalMedico
	 */
	public Horario(Date horaInicio, Time horaFin, PersonalMedico personalMedico, boolean ocupado) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.personalMedico = personalMedico;
	}
	
	public String getFecha(){
		return  horaInicio.getDate()+"";
	}
	
	public String getHora(){
		return horaInicio.getTime()+"";
	}
	
	public String getHoraInicioHorario(){
		return horaInicio.getHours()+":"+horaInicio.getMinutes();
	}
	
	/**
	 * @return the diaSemana
	 */
	public String getDiaSemana() {
		return diaSemana;
	}

	/**
	 * @param diaSemana the diaSemana to set
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHoraFinHorario(){
		return horaFin.getHours()+":"+horaFin.getMinutes();
	}

	/**
	 * @return the fecha_hora
	 */
	public Date getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param fecha_hora the fecha_hora to set
	 */
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the horaFin
	 */
	public Date getHoraFin() {
		return horaFin;
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
