package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name = "FARMACEUTA")
public class Farmaceuta extends Usuario implements Serializable {

	@ManyToOne
	@JoinColumn(name = "FARMACIA_ID")
	private Farmacia farmacia;
	
	public Farmaceuta(int identificacion, TipoDocumento tipoDocumento, String usuario, String password, String nombre,
			String apellido, String email, int telefono, int celular, String direccion, Farmacia farmacia) {
		super(identificacion, tipoDocumento, usuario, password, nombre, apellido, email, telefono, celular, direccion);
		this.farmacia = farmacia;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((farmacia == null) ? 0 : farmacia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Farmaceuta other = (Farmaceuta) obj;
		if (farmacia == null) {
			if (other.farmacia != null)
				return false;
		} else if (!farmacia.equals(other.farmacia))
			return false;
		return true;
	}

}
