package P2Examen;

public class Pokemons2 {

		String nombre , tipo , entrenador , movimiento;
		Double peso , altura;
		int ataque;
		
		public Pokemons2(String nombre, String tipo, Double peso,
				int ataque, Double altura, String entrenador, String movimiento) {
			super();
			this.nombre = nombre;
			this.tipo = tipo;
			this.peso = peso;
			this.ataque = ataque;
			this.altura = altura;
			this.entrenador = entrenador;
			this.movimiento = movimiento;
		}
		public String toCSV() {
			return nombre + "," + tipo + "," + entrenador + "," + movimiento + "," + peso + "," + altura + "," + ataque;
		}
		@Override
		public String toString() {
			return "Pokemons2 [nombre=" + nombre + ", tipo=" + tipo + ", entrenador=" + entrenador + ", movimiento="
					+ movimiento + ", peso=" + peso + ", altura=" + altura + ", ataque=" + ataque + "]";
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getEntrenador() {
			return entrenador;
		}

		public void setEntrenador(String entrenador) {
			this.entrenador = entrenador;
		}

		public String getMovimiento() {
			return movimiento;
		}

		public void setMovimiento(String movimiento) {
			this.movimiento = movimiento;
		}

		public Double getPeso() {
			return peso;
		}

		public void setPeso(Double peso) {
			this.peso = peso;
		}

		public Double getAltura() {
			return altura;
		}

		public void setAltura(Double altura) {
			this.altura = altura;
		}

		public int getAtaque() {
			return ataque;
		}

		public void setAtaque(int ataque) {
			this.ataque = ataque;
		}
}
