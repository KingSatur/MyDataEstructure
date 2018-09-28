package examenPratico2018;

public class Estudiante {

	private double promedio;
	private String sexo;
	private int numeroSemestre;
	
	public Estudiante(double promedio, String sexo, int numeroSemestre) {
		this.promedio = promedio;
		this.sexo = sexo;
		this.numeroSemestre = numeroSemestre;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getNumeroSemestre() {
		return numeroSemestre;
	}

	public void setNumeroSemestre(int numeroSemestre) {
		this.numeroSemestre = numeroSemestre;
	}

	
	
	
	
	
	
}
