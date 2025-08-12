package formageometrica;

public class Retangulo extends FormaGeometrica{
	private Ponto p1;
	private Ponto p2;
	
	public Retangulo (Ponto p1, Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public double getArea() {
		double x1 = p1.getX();
		double x2 = p2.getX();
		double y1 = p1.getY();
		double y2 = p2.getY();
		return Math.abs(x1-x2) * Math.abs(y1-y2);
	}
	
}
