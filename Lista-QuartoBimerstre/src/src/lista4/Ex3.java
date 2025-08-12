package lista4;

public class Ex3 extends Thread implements Runnable{
	public int pontuacao;
	public int num;
	static int posicao=1;
	static int qtd=10;
	
	Ex3(int num){
		this.num = num;
		pontuacao = 0;
	}
	
	public static void novacorrida(){
		posicao=1;
	}
	
	@Override
	public void run() {
		while(qtd>0) {
			pontuacao += 11-posicao;
			System.out.println("Competidor " + num + " ficou na posicao "+ posicao);
			posicao++;
			if(posicao==11) {
				novacorrida();
				qtd--;
				if(qtd>0) System.out.println("Nova corrida");
			}
			try {
				sleep(1000);
			}
			catch (InterruptedException e) {
			}
		}
	}
	
	public static void main(String args[]) {
		Ex3 corredores[] = new Ex3[10];
		int maior, num;
		for(int i=0 ; i<10 ; i++) 
			corredores[i] = new Ex3(i+1);
		
		System.out.println("Iniciando corridas");
		
		for(int i=0 ; i<10 ; i++) {
			corredores[i].start();
		}
		for(int i=0 ; i<10 ; i++) {
			try {
				corredores[i].join();
			} catch (InterruptedException e) {}
		}
		maior = corredores[0].pontuacao;
		num = corredores[0].num;
		for(int i=1 ; i<10 ; i++) {
			if(corredores[i].pontuacao > maior) {
				maior = corredores[i].pontuacao;
				num = corredores[i].num;
			}
		}
		System.out.println("Campeao: " + num + " Pontos: " + maior);		
		
	}
}
