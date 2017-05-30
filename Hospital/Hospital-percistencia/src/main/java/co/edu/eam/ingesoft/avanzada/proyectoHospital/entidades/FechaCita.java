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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="FECHA_CITA")
public class FechaCita implements Serializable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FECHA_CITA")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_FECHA_CITA")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA")
	private Date fecha;
	
	@Column(name="OCUPADO")
    private boolean ocupado;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="DIA_SEMANA", referencedColumnName="DIA_SEMANA"),
		@JoinColumn(name="HORA_INICIO", referencedColumnName="HORA_INICIO")
	})
	private Horario horario;
	
	public FechaCita() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param fecha
	 * @param ocupado
	 * @param horario
	 */
	public FechaCita(int id, Date fecha, boolean ocupado, Horario horario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.ocupado = ocupado;
		this.horario = horario;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @return the horario
	 */
	public Horario getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	
	
}
