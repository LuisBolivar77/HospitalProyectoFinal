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
	@NamedQuery(name="ListarQuirofanosDispon", query="SELECT q FROM Quirofano q WHERE q.ocupado = false")
})
public class Quirofano implements Serializable{

	public static String ListarQuirofanosDispon = "quirofanosDisponibles";
	
	
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
