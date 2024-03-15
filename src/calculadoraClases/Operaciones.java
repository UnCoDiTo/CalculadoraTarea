package calculadoraClases;

public class Operaciones {
	public float calculo(float num1, float num2, String signo){
		float resultado = 0;
		switch(signo){
		case "+":
			resultado = num1 + num2;
			break;
		case "-":
			resultado = num1 - num2;
			break;
		case "*":
			resultado = num1 * num2;
			break;
		case "/":
			resultado = num1 / num2;
			break;
		}
		return resultado;
	}
}