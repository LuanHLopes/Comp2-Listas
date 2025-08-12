package formageometrica;

public class Circulo extends FormaGeometrica {
	private Ponto centro;
	private double raio;
	
	public Circulo(double x, double y, double raio) {
		this.centro = new Ponto(x, y);
		this.raio = raio;
	}
	
	public double getArea() {
		return this.raio*this.raio*Math.PI;
	}
}
