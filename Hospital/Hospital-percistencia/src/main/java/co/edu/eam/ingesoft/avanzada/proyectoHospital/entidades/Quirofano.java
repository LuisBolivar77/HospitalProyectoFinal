package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="QUIROFANO")
@NamedQueries({
	@NamedQuery(name="quirofanosDisponibles", query="SELECT q FROM Quirofano q WHERE q.ocupado = false"),
	@NamedQuery(name="listarQuirofanos",query="SELECT q FROM Quirofano q"),
	@NamedQuery(name="quirofanoPorNumero",query="SELECT q FROM Quirofano q WHERE q.numero = ?1")
})
public class Quirofano implements Serializable{

	public static final String quirofanoPorNumero = "quirofanoPorNumero";
	/**
	 * consulta que retorna los quirofanos disponibles
	 */
	public static final String ListarQuirofanosDispon = "quirofanosDisponibles";
	
	/**
	 * lista todos los quirofanos
	 */
	public static final String ListarQuirofanos = "listarQuirofanos";
	
	/**
	 * variable estatica que almacena el numero de un quirofano
	 */
	public static int numeroQuirofano;
	
	

	@Id
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@Column(name="OCUPADO")
	private boolean ocupado;
	
	public Quirofano() {
		// TODO Auto-generated constructor stub
	}

	

	public boolean isOcupado() {
		return ocupado;
	}



	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}



	public Quirofano(int numero, String descripcion, boolean ocupado) {
		super();
		this.numero = numero;
		this.descripcion = descripcion;
		this.ocupado = ocupado;
	}

	public static int getNumeroQuirofano() {
		return numeroQuirofano;
	}

	public static void setNumeroQuirofano(int numeroQuirofano) {
		Quirofano.numeroQuirofano = numeroQuirofano;
	}

	/**
	 * @return the id
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param id the id to set
	 */
	public void setNumero(int id) {
		this.numero = id;
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
	
	
	
}
