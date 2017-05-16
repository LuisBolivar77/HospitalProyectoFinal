package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_CITA")
public class TipoCita implements Serializable{
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TCITA")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_TCITA")
	private int id;
	
	@Column(name="DURACION", nullable=false)
	private int duracion;
	
	public TipoCita() {
		// TODO Auto-generated constructor stub
	}

	public TipoCita(int duracion) {
		super();
		this.duracion = duracion;
	}

	
	public int getId() {
		return id;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}



}
