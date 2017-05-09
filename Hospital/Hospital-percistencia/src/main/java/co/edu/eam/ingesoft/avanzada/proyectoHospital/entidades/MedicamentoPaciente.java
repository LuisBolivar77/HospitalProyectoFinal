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
	@JoinColumn(name="RECETA_ID")
	private Cita cita;
	
	@Column(name = "CANTIDAD", nullable = false)
	private int cantidad;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ENTREGA", nullable = false)
	private Date fechaEntrega;
	
	public MedicamentoPaciente() {
		// TODO Auto-generated constructor stub
	}
	
	

	public MedicamentoPaciente(Medicamento medicamento, Receta receta, int cantidad, Date fechaEntrega) {
		super();
		this.medicamento = medicamento;
		this.receta = receta;
		this.cantidad = cantidad;
		this.fechaEntrega = fechaEntrega;
	}



	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
	
}
