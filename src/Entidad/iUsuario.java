package Entidad;

public abstract class iUsuario {

	private final String IDUsuario;
	private boolean TipoUsuario;
	private String Email;
	private String Password;
	
	public iUsuario(String iDUsuario, boolean tipoUsuario, String email, String password) {
		IDUsuario = iDUsuario;
		TipoUsuario = tipoUsuario;
		Email = email;
		Password = password;
	}

	public iUsuario(iUsuario user) {
		IDUsuario = user.getIDUsuario();
		TipoUsuario = user.isTipoUsuario();
		Email = user.getEmail();
		Password = user.getPassword();
	}

	public String getIDUsuario() {
		return IDUsuario;
	}

	public boolean isTipoUsuario() {
		return TipoUsuario;
	}

	public String getEmail() {
		return Email;
	}

	public String getPassword() {
		return Password;
	}
	
		
	
}
