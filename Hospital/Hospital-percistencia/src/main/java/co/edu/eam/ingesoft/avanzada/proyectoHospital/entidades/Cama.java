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
@Table(name = "CAMA")
@NamedQueries({ 
	@NamedQuery(name = "camasDisponibles", query = "SELECT c FROM Cama c WHERE c.ocupada = false"),
	@NamedQuery(name="listaCamas",query="SELECT c FROM Cama c"),
	@NamedQuery(name="camasPorNum",query="SELECT c FROM Cama c WHERE c.numero = ?1")
	})
public class Cama implements Serializable {

	/**
	 * lista de camas desocupadas
	 */
	public static final String listarCamaPorNumero = "camasPorNum";
	
	/**
	 * lista de camas
	 */
	public static final String ListaDeCamas = "listaCamas";
	/**
	 * lista de camas desocupadas
	 */
	public static final String listarCamasDisponibles = "camasDisponibles";

	/**
	 * variable estatica que guarda el numero de la cama
	 */
	public static int numeroCama;
	
	
	@Id
	@Column(name = "NUMERO")
	private int numero;

	@Column(name = "DESCRIPCION", length = 200, nullable = false)
	private String descripcion;

	@Column(name = "OCUPADA")
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

	public static int getNumeroCama() {
		return numeroCama;
	}

	public static void setNumeroCama(int numeroCama) {
		Cama.numeroCama = numeroCama;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

}
