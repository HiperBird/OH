package org.example;

import java.util.Random;

public class Matrix{
	static double[][] a;
	static double[][] b;
	static double[][] c;
	private static int n;

	public Matrix(int size) {
		n = size;
		a = new double[n][n];
		b = new double[n][n];
		c = new double[n][n];
		this.randomize();
	}


	public void randomize(){
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = random.nextDouble();
				b[i][j] = random.nextDouble();
				c[i][j] = 0;
			}
		}

	}

	public static double[][] matmult() {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n;i++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return(c);
	}
}
