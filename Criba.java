package actividad;

import java.util.Scanner;

public class Criba {
	
public static int dim(int max) {
		
		int i, j;
		if (max >= 2) {
			int dim = max + 1; 
			boolean[] esPrimo = new boolean[dim];
			
			for (i = 0; i < dim; i++)
				esPrimo[i] = true;
			esPrimo[0] = esPrimo[1] = false;
			
			for (i = 2; i < Math.sqrt(dim) + 1; i++) {
				if (esPrimo[i]) {
					for (j = 2 * i; j < dim; j += i)
						esPrimo[j] = false;
				}
			}
			return dim;
		}
		else { 
			return 0;
		}
	}

public static boolean[] esPrimo(int max) {
	
	int i, j;
	if (max >= 2) {
		int dim = max + 1; 
		boolean[] esPrimo = new boolean[dim];
		
		for (i = 0; i < dim; i++)
			esPrimo[i] = true;
		esPrimo[0] = esPrimo[1] = false;
		
		for (i = 2; i < Math.sqrt(dim) + 1; i++) {
			if (esPrimo[i]) {
				for (j = 2 * i; j < dim; j += i)
					esPrimo[j] = false;
			}
		}
		return esPrimo;
	}else { 
		return new boolean[0];
	}
}

public static int[] generarPrimos(int max) {
	
	int i, j;
	if (max >= 2) {
	int dim=dim(max);
	boolean[] esPrimo=esPrimo(max);
		
		int cuenta = 0;
		for (i = 0; i < dim; i++) {
			if (esPrimo[i])
				cuenta++;
		}
		int[] primos = new int[cuenta];
		for (i = 0, j = 0; i < dim; i++) {
			if (esPrimo[i])
				primos[j++] = i;
		}
		return primos;
	} else { 
		return new int[0];
	}
}

public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	System.out.println("Introduce el n�mero para la criba de Erast�tenes:");
	
	int dato = teclado.nextInt();
	int vector[] = new int[dato];
	teclado.close();
	
	System.out.println("\nVector inicial hasta : " + dato);
	
	for (int i = 0; i < vector.length; i++) {
		if (i % 10 == 0)
			System.out.println();
		System.out.print(i + 1 + "\t");
	}
	
	vector = generarPrimos(dato);
	
	System.out.println("\nVector de primos hasta:" + dato);
	
	for (int i = 0; i < vector.length; i++) {
		if (i % 10 == 0)
			System.out.println();
		System.out.print(vector[i] + "\t");
		}
	}
}
