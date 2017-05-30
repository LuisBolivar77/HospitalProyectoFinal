package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.ejb.EJB;

import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.UsuarioEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoExamen;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

public class ControladorPaciente implements Serializable {

	private String nombre;

	private String apellido;

	private String telefono;

	private String username;

	private String contraseña;

	private String dentificacion;

	private String tipoIdentiSelec;

	private String email;

	private String celular;

	private String direccion;

	private String rol;

	@EJB
	private UsuarioEJB usuEJB;

	/**
	 * Registra una patologia en la base de datos
	 */
	public void registarExamen() {
		if (nombre == null || apellido == null) {
			Messages.addFlashGlobalInfo("Ingrese todos los campos");
		} else {

			Usuario usu = new Usuario();
			usu.setApellido(apellido);
			usu.setCelular(celular);
			usu.setDireccion(direccion);
			usu.setEmail(email);
			usu.setIdentificacion(dentificacion);
			usu.setNombre(nombre);
			usu.setPassword("1234");
			usu.setTelefono(telefono);
			usu.setRol(rol);
			try {
				usuEJB.registrarUsuario(usu);
				Messages.addFlashGlobalInfo("Registro exitoso");
			} catch (ExcepcionNegocio e) {
				Messages.addFlashGlobalError(e.getMessage());
			}
		}
	}

}
