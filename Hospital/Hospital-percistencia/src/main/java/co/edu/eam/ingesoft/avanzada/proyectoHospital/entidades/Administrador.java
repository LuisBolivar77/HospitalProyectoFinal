package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name="ADMINISTRADOR")
public class Administrador extends Usuario implements Serializable {
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(int identificacion, TipoDocumento tipoDocumento, String usuario, String password,
			String nombre, String apellido, String email, int telefono, int celular, String direccion) {
		super(identificacion, tipoDocumento, usuario, password, nombre, apellido, email, telefono, celular, direccion);
		// TODO Auto-generated constructor stub
	}

	

	
}
