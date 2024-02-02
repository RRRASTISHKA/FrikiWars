import java.util.Arrays;
import java.util.Scanner;
public class Poder2Consola implements Comparable<Poder2Consola> {
	private int power;
	private int number;
	private static int num;
	private  static int powers[]=new int [10];
	public int getPower() {
		return this.power;
	}
	public int getNumber() {
		return this.number;
	}
	public int compareTo(Poder2Consola c) {
		if(this.power<c.getPower()) {
			return -1;
		}else if(this.power>c.getPower()) {
			return 1;
		}else {
			return 0;
		}
	} 
	private static void darPoder() {
		for(int i=0;i<10;i++) {
			 int num = (int) (Math.random() * (100 - 1)) + 1;
			 powers[i]=num;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		darPoder();
		Arrays.sort(powers);
		System.out.println("Que cromo quieres elegir, escribe su poder");
		num=sc.nextInt();
		while(num<=0||num>100) {
			System.out.println("Escribe un nivel de poder válido entre 1 y 100");
			num=sc.nextInt();
		}
		int index=Arrays.binarySearch(powers, num);
		if (index >= 0) {
            System.out.println("El cromo con poder " + num + " está en la posición " + index);
            if (index > 0) {
                System.out.println("El cromo por debajo tiene: " + powers[index - 1]+" puntos de poder");
            }
            if (index < powers.length - 1) {
                System.out.println("El cromo por encima tiene: " + powers[index + 1]+" puntos de poder");
            }
        } else {
            int index2 = -index - 1;
            System.out.println("El cromo con poder " + num + " no está en la lista.");
            if (index2 > 0) {
                System.out.println("El cromo por debajo: " + powers[index2 - 1]+" puntos de poder");
            }
            if (index2 < powers.length) {
                System.out.println("El cromo por encima: " + powers[index2]+" puntos de poder");
            }
        }
		sc.close();
	}
}