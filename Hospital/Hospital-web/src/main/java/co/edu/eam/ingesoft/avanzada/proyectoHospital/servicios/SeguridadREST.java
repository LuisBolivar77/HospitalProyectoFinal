package co.edu.eam.ingesoft.avanzada.proyectoHospital.servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;
import co.edu.eam.ingesoft.pa.banco.web.DTO.RespuestaDTO;
import co.edu.eam.ingesoft.avanzada.DTO.LoginDTO;
import co.edu.eam.ingesoft.avanzada.DTO.LoginRespuestaDTO;
import co.edu.eam.ingesoft.avanzada.negocio.beans.UsuarioEJB;

@Path("/seguridad")
public class SeguridadREST {

	public static Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	@EJB
	private UsuarioEJB ejb;
	
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(LoginDTO dto){
		
		Usuario user = ejb.buscarUsuarioLogIn(dto.getUser());
		if(user != null && user.getPassword().equals(dto.getPassword())){
			String token = UUID.randomUUID().toString();
			usuarios.put(token, user);
			return new RespuestaDTO(new LoginRespuestaDTO(token, user.getIdentificacion()), "EXITO", "000");
			
		}else{
			return new RespuestaDTO(null, "Credenciales Errorneas","-403");
		}
		
		
	}
	
	
	
	
	
	
}
