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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HORARIO")
public class Horario implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_HORARIO")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_HORARIO")
	private int id;
	
	@Column(name="HORA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicio;
	
	@Column(name="HORA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFin;
	
	@ManyToOne
	@JoinColumn(name="PERSONAL_MEDICO_ID")
	private PersonalMedico personalMedico;
	
	@Column(name="OCUPADO")
	private boolean ocupado;
	
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
		this.ocupado = ocupado;
	}
	
	public String getDiaSemana(){
		String dia = "";
		if (horaInicio.getDay()==0){
			dia = "Domingo";
		} else if (horaInicio.getDay()==1) {
			dia ="Lunes";
		} else if (horaInicio.getDay()==2){
			dia="Martes";
		} else if (horaInicio.getDay()==3){
			dia="Miercoles";
		} else if (horaInicio.getDay()==4){
			dia="Jueves";
		} else if (horaInicio.getDay()==5){
			dia="Viernes";
		} else {
			dia = "sabado";
		}
		return dia;
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
	
	public String getHoraFinHorario(){
		return horaFin.getHours()+":"+horaFin.getMinutes();
	}

	/**
	 * @return the ocupado
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
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
