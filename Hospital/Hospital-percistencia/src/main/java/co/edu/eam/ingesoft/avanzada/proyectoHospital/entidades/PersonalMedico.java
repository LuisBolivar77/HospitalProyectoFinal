package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.TipoDocumento;

@Entity
@Table(name = "PERSONAL_MEDICO")
@NamedQueries({
	@NamedQuery(name=PersonalMedico.LISTAR_PERSONAL, query="SELECT p FROM PersonalMedico p")
})
public class PersonalMedico extends Usuario implements Serializable {
	
	/**
	 * Obtiene la lista del personal registrado
	 */
	public static final String LISTAR_PERSONAL = "PersonalMedico.listar";

	@ManyToOne
	@JoinColumn(name = "TIPO_PERSONAL_ID")
	private TipoPersonal tipoPersonal;
	
	public PersonalMedico() {
		// TODO Auto-generated constructor stub
	}

	public PersonalMedico(String identificacion, TipoDocumento tipoDocumento, String usuario, String password,
			String nombre, String apellido, String email, String telefono, String celular, String direccion,
			TipoPersonal tipoPersonal, String rol) {
		super(identificacion, tipoDocumento, usuario, password, nombre, apellido, email, telefono, celular, direccion, rol);
		this.tipoPersonal = tipoPersonal;
	}
	
	public String getNombreCompleto(){
		return nombre +" "+ apellido;
	}

	public TipoPersonal getTipoPersonal() {
		return tipoPersonal;
	}

	public void setTipoPersonal(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}

}
