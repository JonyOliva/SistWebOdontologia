package Entidad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {
	
	static public boolean checkString(String str, boolean permitirNros, boolean permitirLetras) {
		str = str.trim();
		String regex = "[^";
		if(permitirNros) {
			regex += ".,0-9";
		}
		if(permitirLetras) {
			regex += "a-zA-Z";
		}
		regex += "]";
		Matcher m = Pattern.compile(regex).matcher(str);
		return !m.find();

		//ESTA FUNCION DEVUELVE TRUE, SI LA CADENA ESTA ENTRE LOS PARAMETROS DADOS
		//SE PERMITE EL PUNTO Y LA COMA SI SE PERMITEN NUMEROS (POR LOS DECIMALES)
	}
	
	static public String cleanString(String str, boolean permitirEspacios) {
		if(permitirEspacios) {
			return str.replaceAll("[^a-zA-Z0-9 ]", "");
		}else {
			return str.replaceAll("[^a-zA-Z0-9]", "");
		}
	}
	
}