package excepciones;

public class ErrorConexionException extends Exception {

		public ErrorConexionException(String message) {
			//pasamos el mensaje de error a la superclase
			super(message);
		}
}
