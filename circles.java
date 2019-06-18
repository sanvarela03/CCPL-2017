import java.util.Scanner;

public class circles {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double Case[] = new double[n];

		for (int i = 0; i < n; i++) {
			int b = in.nextInt();
			int a = in.nextInt();
			if (b < a && a < 10000) {
				Case[i] = f(b, a);
			} else {
				Case[i] = -1;
			}
		}

		System.out.println();

		for (int i = 0; i < n; i++) {
			if (Case[i] != -1) {
				System.out.println("Case #" + (i + 1) + ": " + Case[i]);
			} else {
				System.out.println("Case #" + (i + 1) + ": " + "no se cumple: L1<L2<10000");
			}
		}

	}

	public static double f(int b, int a) {
		double h = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		double r = a * b / (a + b + h);
		double areaTotal = Math.PI * r * r;
		final double c = r / Math.sqrt(r * r + Math.pow(a - r, 2));
		final double k = (1 - c) / (1 + c);

		double error = 0;
		double anterior = 0;
		do {
			r = k * r;
			anterior = areaTotal;
			areaTotal = Math.PI * r * r + areaTotal;
			error = ((areaTotal - anterior) / areaTotal) * 100;
		} while (!(error < 0.000000000000001));

		double areaTriangulo = a * b / 2;
		double relacion = areaTotal / areaTriangulo;
		relacion = quitarDecimales(relacion, 4);
		return relacion;
	}

	public static Double quitarDecimales(double relacion, int numeroDecimales) {
		return Math.round(relacion * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}
}