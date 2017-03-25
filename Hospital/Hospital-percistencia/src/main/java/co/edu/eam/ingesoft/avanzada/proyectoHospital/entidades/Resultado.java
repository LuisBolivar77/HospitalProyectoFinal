package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ResultadoExamenPK.class)
@Table(name="T_RESULTADO")
public class Resultado implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="EXAMEN")
	private Examen examen;
	
	@Id
	@ManyToOne
	@JoinColumn(name="HISTORIAL")
	private Historial historial;
	
	@Column(name="RESULTADO", nullable=false, length=200)
	private String resultado;
	
	public Resultado() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param examen
	 * @param historial
	 * @param resultado
	 */
	public Resultado(Examen examen, Historial historial, String resultado) {
		super();
		this.examen = examen;
		this.historial = historial;
		this.resultado = resultado;
	}

	/**
	 * @return the examen
	 */
	public Examen getExamen() {
		return examen;
	}

	/**
	 * @param examen the examen to set
	 */
	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	/**
	 * @return the historial
	 */
	public Historial getHistorial() {
		return historial;
	}

	/**
	 * @param historial the historial to set
	 */
	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
