package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.UsuarioEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@Named("ControladorSesion")
@SessionScoped
public class ControladorSesion implements Serializable {

	/**
	 * 
	 */
	private String usuario;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private Usuario user;

	@EJB
	private UsuarioEJB usuarioEJB;

	public String iniciarSesion() {
		Usuario usu = usuarioEJB.buscarUsuario(usuario);
		if (usu != null) {
			if (usu.getPassword().equals(password)) {
				user = usu;
				usuario = "";
				password = "";
				Faces.setApplicationAttribute("usuario", usu);
				if (usu instanceof PersonalMedico) {
				Messages.addFlashGlobalInfo("BIENVENIDO " + user.getNombre());
				return "/paginas/Segura/PaginaInicioPersonal.xhtml?faces-redirect=true";
				}
				if (usu.getRol().equals("Administrador")){
					Messages.addFlashGlobalInfo("BIENVENIDO " + user.getNombre());
					return "/paginas/Segura/PaginaInicioAdmin.xhtml?faces-redirect=true";
				}
				if (usu instanceof Paciente){
					Messages.addFlashGlobalInfo("SEÑOR " + user.getNombre() +" Para realizar "
							+ "alguna operación, por favor utilice nuestra aplicación móvil");
				}
			} else {
				Messages.addFlashGlobalError("Su contraseña es incorrecta");
			}
		} else {
			Messages.addFlashGlobalError("Este nombre de usuario no se ecuentra registrado");
		}
		return null;
	}

	public String cerrarSesion() {
		user = null;
		HttpSession sesion;
		sesion = (HttpSession) Faces.getSession();
		sesion.invalidate();
		return "/paginas/publico/LogIn.xhtml?faces-redirect=true";

	}

	public boolean isLogIn() {
		return user != null;
	}

	public boolean isLogOut() {
		if (user == null) {
			return true;
		}
		return false;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}

}
