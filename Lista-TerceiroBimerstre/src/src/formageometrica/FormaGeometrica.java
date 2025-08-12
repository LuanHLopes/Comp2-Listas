package formageometrica;

public abstract class FormaGeometrica {
	public  FormaGeometrica() {}
	public abstract double getArea();
	
	static public void main(String[] args) {
		Ponto p1 = new Ponto(1, 1);
		Ponto p2 = new Ponto(4, 4);
		FormaGeometrica formas[] = new FormaGeometrica[4];
		formas[0] = new Circulo(1, 1, 5);
		formas[1] = new Retangulo(p1, p2);
		formas[2] = new Triangulo(p2, p1);
		formas[3] = new Esfera(1, 1, 5);
		for(FormaGeometrica forma : formas) {
			System.out.printf("Area = %.02f\n", forma.getArea());
		}
	}
}
