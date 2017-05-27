package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.UsuarioEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@Named("ControladorLogIn")
@SessionScoped
public class ControladorLogIn implements Serializable {

	private String usuario;

	private String password;

	private Usuario user;

	@EJB
	private UsuarioEJB usuEJB;

	public ControladorLogIn() {
		// TODO Auto-generated constructor stub
	}

	public String iniciarSesion() {

		Usuario usu = usuEJB.buscarUsuario(usuario);
		System.out.println("usuariooooooooo = " + usu);
		if (usuario != null) {
			if (usu != null && password.equals(usu.getPassword())) {
				user = usu;
				usuario = "";
				password = "";
				Faces.setApplicationAttribute("usuario", usu);
				if (usu.getRol().equals("admin")) {
					Messages.addFlashGlobalInfo("BIENVENIDO " + user.getUsuario());
					return "/paginas/Administrador/SolicitudRegistroPacientes.xhtml?faces-redirect=true";
				}
				if(usu.getRol().equals("medico")){
					Messages.addFlashGlobalInfo("BIENVENIDO " + user.getUsuario());
					return "/paginas/Medico/PaginaInicioPersonal.xhtml?faces-redirect=true";
				} if (usu instanceof Paciente){
					Messages.addFlashGlobalError("Señor usuario para acceder a nuestros servicios, "
							+ "por favor utilice nuestra aplicación móvil ");
				}

			} else {
				Messages.addFlashGlobalInfo("La contraseña ingresada es incorrecta");
			}
		} else {
			Messages.addFlashGlobalInfo("debe ingresar un nombre de usuario y una contraseña ");

		}
		return null;
	}

	public String incioSesion() {
		return "/paginas/publico/Login.xhtml?faces-redirect=true";
	}
	
	
	public String cerrarSesion() {
		user = null;
		HttpSession sesion;
		sesion = (HttpSession) Faces.getSession();
		sesion.invalidate();
		return "/paginas/publico/Login.xhtml?faces-redirect=true";

	}
	
	
	public boolean isLogIn(){
		return user != null;
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
