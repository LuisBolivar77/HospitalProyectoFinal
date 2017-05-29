package co.edu.eam.ingesoft.avanzada.proyectoHospital.servicios;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;
import co.edu.eam.ingesoft.pa.banco.web.DTO.RespuestaDTO;
import co.edu.eam.ingesoft.avanzada.negocio.beans.UsuarioEJB;

@Path("/seguridad")
public class SeguridadREST {

	public static Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	@EJB
	private UsuarioEJB ejb;

	
}
