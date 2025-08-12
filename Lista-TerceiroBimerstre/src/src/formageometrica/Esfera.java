package formageometrica;

public class Esfera extends FormaGeometrica{
	private Ponto centro;
	private double raio;
	
	public Esfera(double x, double y, double raio) {
		this.centro = new Ponto(x,y);
		this.raio = raio;
	}
	
	public double getArea() {
		return this.raio*this.raio*Math.PI*4;
	}
}
