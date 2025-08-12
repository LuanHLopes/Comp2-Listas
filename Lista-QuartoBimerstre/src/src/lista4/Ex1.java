package lista4;
import java.util.Random;

public class Ex1 implements Runnable {
	int mx[][];
	
	Ex1() {
		mx = new int[100][100];
		Random generator = new Random();
		for(int i=0 ; i<100 ; i++) 
			for(int j=0 ; j<100 ; j++)
				mx[i][j] = generator.nextInt(10);
			
	}
	
	@Override
	public void run() {
		int soma = 0;
		for(int i=0 ; i<100 ; i++) 
			for(int j=0 ; j<100 ; j++) {
				soma+=mx[i][j];
				System.out.println(soma);
			}
		
	}
	
	public static void main(String[] args) {
		Ex1 ex1 = new Ex1();
		Thread thrd1 = new Thread(ex1);
		thrd1.start();
	}
	
}
