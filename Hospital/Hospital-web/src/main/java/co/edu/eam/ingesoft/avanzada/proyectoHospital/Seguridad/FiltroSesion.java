package co.edu.eam.ingesoft.avanzada.proyectoHospital.Seguridad;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores.ControladorLogIn;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@WebFilter("/paginas/Medico/*")
public class FiltroSesion implements Filter {

	@Inject
	private ControladorLogIn sesion;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		Usuario cus = sesion.getUser();
		if (cus != null) {
			if (cus.getRol().equals("medico")) {
				arg2.doFilter(arg0, arg1);
			} else {
				res.sendRedirect(req.getContextPath() + "/paginas/publico/Login.xhtml");
			}
		} else {
			res.sendRedirect(req.getContextPath() + "/paginas/publico/Login.xhtml");
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
