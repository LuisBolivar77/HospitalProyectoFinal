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
@Table(name="T_EXAMEN")
public class Examen implements Serializable{

	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_HORA", nullable=false)
	private Date fechaHora;
	
	@Temporal(TemporalType.TIME)
	@Column(name="HORA_FIN")
	private Time horaFin;
	
	@ManyToOne
	@JoinColumn(name="TIP_EXAMEN")
    private TipoExamen tipoExamen;
	
	public Examen() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param fechaHora
	 * @param tipoExamen
	 */
	public Examen(String id, String descripcion, Date fechaHora, TipoExamen tipoExamen) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
		this.tipoExamen = tipoExamen;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the tipoExamen
	 */
	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	/**
	 * @param tipoExamen the tipoExamen to set
	 */
	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}
	
	
	
	
}
