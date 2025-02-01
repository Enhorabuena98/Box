package PExamen;

import org.json.JSONObject;

public class Personajes {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	String[] nombres = {
//		    "Rick Sanchez", "Morty Smith", "Summer Smith", "Beth Smith", "Jerry Smith", 
//		    "Birdperson", "Mr. Meeseeks", "Squanchy", "Mr. Poopybutthole", "Tammy Guetermann",
//		    "Evil Morty", "Pickle Rick", "Abradolf Lincler", "Unity", "Krombopulos Michael", 
//		    "Noob-Noob", "Jessica", "Scary Terry", "Beth Clone", "Phoenixperson"
//		};
//
//		String[] rangos = {
//		    "Científico", "Aventurero", "Estudiante", "Veterinaria", "Desempleado", 
//		    "Guerrero", "Asistente", "Revolucionario", "Amigo de la Familia", null,
//		    "Dictador", "Pepinillo", null, "Conciencia Colectiva", "Asesino a Sueldo", 
//		    "Empleado", "Interés Amoroso", "Pesadilla", "Clon", null
//		};
//
//		String[] planetas = {
//		    "Tierra (C-137)", "Tierra (C-137)", "Tierra (C-137)", null, "Tierra (C-137)", 
//		    "Planeta Fénix", "Tierra (C-137)", "Planeta Squanch", null, "Planeta Gazorpazorp",
//		    "Tierra (Desconocida)", "Tierra (C-137)", "Tierra (C-137)", "Planeta Unity", null, 
//		    "Tierra (C-137)", null, "Dimensión de Pesadillas", "Tierra (C-137)", "Planeta Fénix"
//		};
//
//		int[] edades = {
//		    70, 14, 17, 34, 35, 
//		    50, 0, 45, 30, 0, 
//		    14, 70, 35, 1000, 0, 
//		    22, 17, 0, 34, 50
//		};
//
//		double[] salarios = {
//		    150000, 50000, 30000, 0, 0, 
//		    120000, 10000, 0, 75000, 60000, 
//		    200000, 0, 60000, 150000, 85000, 
//		    0, 25000, 50000, 80000, 120000
//		};
//
//		String[] productoras = {
//		    "Adult Swim", null, "Adult Swim", "Adult Swim", "Adult Swim", 
//		    "Adult Swim", "Adult Swim", "Adult Swim", "Adult Swim", "Adult Swim",
//		    "Adult Swim", null, "Adult Swim", "Adult Swim", null, 
//		    "Adult Swim", "Adult Swim", "Adult Swim", null, "Adult Swim"
//		};
		String nombre, rango, planeta,productora;
		int edad;
		double salario;
		
		public Personajes(String nombre, String rango, String planeta, String productora, int edad, double salario) {
			this.nombre = nombre;
			this.rango = rango;
			this.planeta = planeta;
			this.productora = productora;
			this.edad = edad;
			this.salario = salario;
		}
		
		@Override
		public String toString() {
			return "Personajes [nombre=" + nombre + ", rango=" + rango + ", planeta=" + planeta + ", productora="
					+ productora + ", edad=" + edad + ", salario=" + salario + "]";
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getRango() {
			return rango;
		}

		public void setRango(String rango) {
			this.rango = rango;
		}

		public String getPlaneta() {
			return planeta;
		}

		public void setPlaneta(String planeta) {
			this.planeta = planeta;
		}

		public String getProductora() {
			return productora;
		}

		public void setProductora(String productora) {
			this.productora = productora;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public double getSalario() {
			return salario;
		}

		public void setSalario(double salario) {
			this.salario = salario;
		}

		public Personajes(JSONObject jsonObject) {
			this.nombre = jsonObject.getString("nombre");
			this.rango = jsonObject.optString("rango", "");
			this.planeta = jsonObject.optString("planeta", "");
			this.productora = jsonObject.optString("productora", "");
			this.edad = jsonObject.getInt("edad");
			this.salario = jsonObject.getDouble("salario");
		}
		
		public JSONObject convertidor() {
			JSONObject personaje = new JSONObject();
			personaje.put("nombre", nombre);
			personaje.put("rango", rango);
			personaje.put("planeta", planeta);
			personaje.put("productora", productora);
			personaje.put("edad", edad);
			personaje.put("salario", salario);
		
			return personaje;
		
		}
		}

