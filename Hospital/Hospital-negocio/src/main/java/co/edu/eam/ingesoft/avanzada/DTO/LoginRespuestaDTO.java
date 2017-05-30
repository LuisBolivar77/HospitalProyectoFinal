package co.edu.eam.ingesoft.avanzada.DTO;

public class LoginRespuestaDTO {

	private String token;
	private String numId;

	public LoginRespuestaDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginRespuestaDTO(String token, String identificacion) {
		super();
		this.token = token;
		this.numId = identificacion;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIdentificacion() {
		return numId;
	}

	public void setIdentificacion(String identificacion) {
		this.numId = identificacion;
	}
	
	

}
