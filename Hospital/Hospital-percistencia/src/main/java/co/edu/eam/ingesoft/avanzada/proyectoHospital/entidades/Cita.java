package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CITA")
@NamedQueries({
		@NamedQuery(name = Cita.LISTAR_CITAS_PERSONAL, query = "SELECT c FROM Cita c "
				+ "WHERE c.personalMedico.identificacion = ?1"),
		@NamedQuery(name = Cita.LISTAR_CITAS_MEDICO_FECHA, query = "SELECT c FROM Cita c "
				+ "WHERE c.personalMedico.identificacion = ?1 AND c.horario.fechaHora = ?2") })
public class Cita implements Serializable {

	/**
	 * Lista las citas de un médico
	 */
	public static final String LISTAR_CITAS_PERSONAL = "PersonalMedico.listarCitas";

	/**
	 * Lista las citas de un médico en una feha determinada
	 */
	public static final String LISTAR_CITAS_MEDICO_FECHA = "PersonalMedico.listarCitasFecha";

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CITA")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_CITA")
	private int id;

	@JoinColumn(name = "HORARIO_ID", unique = true)
	@OneToOne
	private Horario horario;

	@Column(name = "ANOCTACIONES", nullable = false, length = 200)
	private String anotaciones;

	@ManyToOne
	@JoinColumn(name = "CITA_ID", nullable = true)
	private Cita cita;

	@ManyToOne
	@JoinColumn(name = "TIPO_CITA_ID")
	private TipoCita tipoCita;

	@ManyToOne
	@JoinColumn(name = "PERSONAL_MEDICO_ID")
	private PersonalMedico personalMedico;

	@ManyToOne
	@JoinColumn(name = "PACIENTE_ID")
	private Paciente paciente;

	public Cita() {
		// TODO Auto-generated constructor stub
	}

	public Cita(Horario horario, String anotaciones, Cita cita, TipoCita tipoCita, PersonalMedico personalMedico,
			Paciente paciente) {
		super();
		this.horario = horario;
		this.anotaciones = anotaciones;
		this.cita = cita;
		this.tipoCita = tipoCita;
		this.personalMedico = personalMedico;
		this.paciente = paciente;
	}

	
	public int getId() {
		return id;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public PersonalMedico getPersonalMedico() {
		return personalMedico;
	}

	public void setPersonalMedico(PersonalMedico personalMedico) {
		this.personalMedico = personalMedico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	

	

}
