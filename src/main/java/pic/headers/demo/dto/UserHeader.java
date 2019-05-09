package pic.headers.demo.dto;

public class UserHeader {

	private String ivUser;
	
	private String ivTicket;
	
	private String nombre;
	
	private String registro;

	public UserHeader(String ivUser, String ivTicket, String nombre, String registro) {
		this.ivUser = ivUser;
		this.ivTicket = ivTicket;
		this.nombre = nombre;
		this.registro = registro;
	}
	
	public String getIvUser() {
		return ivUser;
	}

	public void setIvUser(String ivUser) {
		this.ivUser = ivUser;
	}

	public String getIvTicket() {
		return ivTicket;
	}

	public void setIvTicket(String ivTicket) {
		this.ivTicket = ivTicket;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
}
