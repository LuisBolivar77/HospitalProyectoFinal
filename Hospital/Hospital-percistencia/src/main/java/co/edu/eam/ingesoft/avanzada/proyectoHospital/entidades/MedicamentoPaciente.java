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
@IdClass(MedicamentoPacientePK.class)
@Table(name="MEDICAMENTO_PACIENTE")
public class MedicamentoPaciente implements Serializable {


	@Id
	@JoinColumn(name="MEDICAMENTO_ID")
	@ManyToOne
	private Medicamento medicamento;
	
	@Id	
	@ManyToOne
	@JoinColumn(name="CITA_ID")
	private Cita cita;
	
	@Column(name = "CANTIDAD", nullable = false)
	private int cantidad;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ENTREGA", nullable = false)
	private Date fechaEntrega;
	
	@Column(name="DOSIS",nullable = false)
	private String dosis;
	
	public MedicamentoPaciente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param medicamento
	 * @param cita
	 * @param cantidad
	 * @param fechaEntrega
	 * @param dosis
	 */
	public MedicamentoPaciente(Medicamento medicamento, Cita cita, int cantidad, Date fechaEntrega, String dosis) {
		super();
		this.medicamento = medicamento;
		this.cita = cita;
		this.cantidad = cantidad;
		this.fechaEntrega = fechaEntrega;
		this.dosis = dosis;
	}

	/**
	 * @return the medicamento
	 */
	public Medicamento getMedicamento() {
		return medicamento;
	}

	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the dosis
	 */
	public String getDosis() {
		return dosis;
	}

	/**
	 * @param dosis the dosis to set
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	
	

	
}
