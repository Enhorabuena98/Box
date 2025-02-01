package OlBen;

import java.util.ArrayList;

import org.json.JSONObject;

public class Personajes {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	String[] nombres = {"Oliver Atom", "Benji Price", "Mark Lenders", "Tom Misaki", "Steve Hyuga", "Karl Heinz Schneider", "Taro Misaki", "Roberto Hongo", "Hikaru Matsuyama", "Rivaul"};
//	String[] posiciones = {"Portero", "Portero", "Defensa", "Centrocampista", "Delantero", "Delantero", "Centrocampista", "Entrenador", "Centrocampista", "Centrocampista"};
//    String[] ciudades = {"Tokio", "Liverpool", "Hamburgo", "Nagano", "Sao Paulo", "Munich", "Nara", "Buenos Aires", "Osaka", "Río de Janeiro"};
//    int[] edades = {14, 15, 16, 14, 17, 18, 15, 40, 16, 25};
//    double[] latitudes = {35.6895, 53.4084, 53.5511, 36.6486, -23.5505, 48.8566, 34.6851, -34.6118, 34.6937, -22.9068};
//    double[] longitudes = {139.6917, -2.9916, 9.9937, 138.1948, -46.6333, 2.3522, 135.8049, -58.4173, 135.5022, -43.1729};

	String nombre;
    String posicion;
    String ciudad;
    int edad;
    double latitud;
    double longitud;
    

   

	public Personajes(String nombre, String posicion, String ciudad, int edad, double latitud, double longitud) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.ciudad = ciudad;
		this.edad = edad;
		this.latitud = latitud;
		this.longitud = longitud;
	}
    

    @Override
	public String toString() {
		return "Personajes [nombre=" + nombre + ", posicion=" + posicion + ", ciudad=" + ciudad + ", edad=" + edad
				+ ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}


	public Personajes(JSONObject jsonObject) {
		this.nombre = jsonObject.getString("nombre");
		this.posicion = jsonObject.getString("posicion");
		this.ciudad = jsonObject.optString("ciudad","");
		this.edad = jsonObject.getInt("edad");
		JSONObject coordenadas = jsonObject.getJSONObject("coordenadas");
		this.latitud = coordenadas.getDouble("latitud");
		this.longitud = coordenadas.getDouble("longitud");
	}
    
    public JSONObject convertidor() {
    	JSONObject jugador = new JSONObject();
    	jugador.put("nombre", this.nombre);
    	jugador.put("posicion", this.posicion);
    	jugador.put("ciudad", this.ciudad);
    	jugador.put("edad", this.edad);
    	
    	JSONObject coordenadas = new JSONObject();
    	coordenadas.put("latitud", this.latitud);
    	coordenadas.put("longitud", this.longitud);
    	
    	jugador.put("coordenadas", coordenadas);
    	
    	return jugador;
    }


	
	
	 public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getPosicion() {
			return posicion;
		}


		public void setPosicion(String posicion) {
			this.posicion = posicion;
		}


		public String getCiudad() {
			return ciudad;
		}


		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}


		public int getEdad() {
			return edad;
		}


		public void setEdad(int edad) {
			this.edad = edad;
		}


		public double getLatitud() {
			return latitud;
		}


		public void setLatitud(double latitud) {
			this.latitud = latitud;
		}


		public double getLongitud() {
			return longitud;
		}


		public void setLongitud(double longitud) {
			this.longitud = longitud;
		}

}
