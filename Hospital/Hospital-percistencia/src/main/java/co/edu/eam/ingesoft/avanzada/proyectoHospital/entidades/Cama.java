package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAMA")
@NamedQueries({
	@NamedQuery(name="listarCamasDisponibles", query="SELECT c FROM Cama c WHERE c.ocupada = 1")
})
public class Cama implements Serializable{

	public static final String listarCamasDisponibles = "camasDisponibles";
	
	@Id
	@Column(name="NUMERO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CAMA")
	@SequenceGenerator(sequenceName="autoincremental", allocationSize=1,  name="SEQ_CAMA")
	private int numero;
	
	@Column(name="DESCRIPCION", length=200, nullable=false)
	private String descripcion;
	
	@Column(name="OCUPADA")
	private boolean ocupada;
	

	public Cama() {
		// TODO Auto-generated constructor stub
	}


	public Cama(int numero, String descripcion, boolean ocupada) {
		super();
		this.numero = numero;
		this.descripcion = descripcion;
		this.ocupada = ocupada;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public boolean isOcupada() {
		return ocupada;
	}


	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}


	
	
	
}
