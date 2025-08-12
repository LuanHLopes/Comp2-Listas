package lista4;
import java.util.Random;

public class Ex2 extends Thread implements Runnable{
	int dist;
	int pulos;
	int num;
	static int posicao = 1;
	Ex2(int num){
		pulos = 0;
		this.num = num;
		dist = 0;
	}
	
	@Override
	public void run() {
		Random generator = new Random();
		int pulo;
		while(dist<20) {
			pulo=generator.nextInt(1, 4);
			dist+=pulo;
			pulos++;
			System.out.println("Lebre " + num + " pulou " + pulo + " metros.");
			try {
				sleep(1);
			}
			catch (InterruptedException e){
				
			}
		}
		System.out.println("Lebre " + num + " ficou na posicao " + posicao++ + " com " + pulos + " pulos");
				
	}
	
	public static void main(String args[]) {
		Ex2 lebres[] = new Ex2[5];
		for(int i=0 ; i<5 ; i++)
			lebres[i] = new Ex2(i+1);
		for(int i=0 ; i<5 ; i++)
			lebres[i].start();
 	}
	
}
