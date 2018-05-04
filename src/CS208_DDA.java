import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.*;

public class CS208_DDA {
	public static void DDA (double x0, double y0, double x1, double y1) {
		double dx = x1 - x0;
		double dy = y1 - y0;
		float steps = 0;
		float pointX = (float)x0;
		float pointY = (float)y0;
		if(Math.abs(dx) > Math.abs(dy)) {
			steps = (float) Math.abs(dx);
		}else {
			steps = (float) Math.abs(dy);
		}
		double[] x = new double[Math.round(steps)+2];
		double[] y = new double[Math.round(steps)+2];
		x[0] = x0;
		y[0] = y0;
		float incrementX = (float)dx / steps;
		float incrementY = (float)dy / steps;
		int i = 0;
		for (i=0; i < steps; i++) {
			pointX += incrementX;
			pointY += incrementY;
			//System.out.println(Math.round(pointX));
			x[i+1] = Math.round(pointX);
			y[i+1] = Math.round(pointY);
			System.out.println("("+x[i]+", "+y[i]+")");
		}
		x[i+1] = x1;
		y[i+1] = y1;
		System.out.println("("+x[i]+", "+y[i]+")");
		Plot2DPanel plot = new Plot2DPanel();
		plot.addLinePlot("DDA", x, y);
		JFrame frame = new JFrame("DDA Algorithm");
		frame.setSize(848, 480);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}
	public static void DDA_input(Scanner sc) {
		System.out.print("Input x0: ");
		double x0 = sc.nextDouble();
		System.out.print("Input y0: ");
		double y0 = sc.nextDouble();
		System.out.print("Input x1: ");
		double x1 = sc.nextDouble();
		System.out.print("Input y1: ");
		double y1 = sc.nextDouble();
		DDA(x0,y0,x1,y1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		DDA_input(sc);
		sc.close();
		
	}

}
