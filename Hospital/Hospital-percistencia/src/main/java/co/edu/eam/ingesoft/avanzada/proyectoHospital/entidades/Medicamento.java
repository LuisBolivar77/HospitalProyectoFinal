package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICAMENTO")
@NamedQueries({ @NamedQuery(name = "listarMedicamentos", query = "SELECT m FROM Medicamento m") })
public class Medicamento implements Serializable {

	public static int codigomedicamento;
	/*
	 * lista todos los medicamentos
	 */
	public static final String listarMedicamentos = "listarMedicamentos";

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "CANTIDAD", nullable = false)
	private int cantidad;

	@Column(name = "DESCRIPCION", length = 200, nullable = false)
	private String descripcion;

	public Medicamento() {
		// TODO Auto-generated constructor stub
	}

	public Medicamento(int id, int cantidad, String descripcion) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	public Medicamento(int cantidad, String descripcion) {
		super();
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public static int getCodigomedicamento() {
		return codigomedicamento;
	}

	public static void setCodigomedicamento(int codigomedicamento) {
		Medicamento.codigomedicamento = codigomedicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (cantidad != other.cantidad)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
