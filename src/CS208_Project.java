import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.*;

public class CS208_Project {
	public static void DDA(double x0, double y0, double x1, double y1) {
		double dx = x1 - x0;
		double dy = y1 - y0;
		float steps = 0;
		float pointX = (float) x0;
		float pointY = (float) y0;
		if (Math.abs(dx) > Math.abs(dy)) {
			steps = (float) Math.abs(dx);
		} else {
			steps = (float) Math.abs(dy);
		}
		double[] x = new double[Math.round(steps) + 2];
		double[] y = new double[Math.round(steps) + 2];
		x[0] = x0;
		y[0] = y0;
		float incrementX = (float) dx / steps;
		float incrementY = (float) dy / steps;
		int i = 0;
		for (i = 0; i < steps; i++) {
			pointX += incrementX;
			pointY += incrementY;
			// System.out.println(Math.round(pointX));
			x[i + 1] = Math.round(pointX);
			y[i + 1] = Math.round(pointY);
			System.out.println("(" + x[i] + ", " + y[i] + ")");
		}
		x[i + 1] = x1;
		y[i + 1] = y1;
		System.out.println("(" + x[i] + ", " + y[i] + ")");
		Plot2DPanel plot = new Plot2DPanel();
		plot.addLinePlot("DDA", x, y);
		JFrame frame = new JFrame("DDA Algorithm");
		frame.setSize(848, 480);
		frame.setContentPane(plot);
		frame.setVisible(true);
	}

	public static void LineInput(Scanner sc, int in) {
		System.out.print("Input x0: ");
		double x0 = sc.nextDouble();
		System.out.print("Input y0: ");
		double y0 = sc.nextDouble();
		System.out.print("Input x1: ");
		double x1 = sc.nextDouble();
		System.out.print("Input y1: ");
		double y1 = sc.nextDouble();
		switch (in) {
		case 1:
			DDA(x0, y0, x1, y1);
			break;
		case 2:
			Bresenham(x0, y0, x1, y1);
			break;
		default:
			System.out.println("Invalid Input");
		}
		
	}
	
	public static void Bresenham(double x0, double y0, double x1, double y1) {
		double dx = x1 - x0;
		double dy = y1 - y0;
		double dy2 = 2*dy;
		double dx2 = 2*dx;
		double err;
		double p;
		double[] x;
		double[] y;
		int i;
		if(dx > dy) {
			p = dy2 - dx;
			err= dy2 - (2*dx);;
			x=new double[(int)Math.round(Math.abs(dx))+1];
			y=new double[(int)Math.round(Math.abs(dx))+1];
			x[0]=x0;
			y[0]=y0;
			System.out.println("(" + x[0] + ", " + y[0] + ")");
			for (i = 0;i < dx;i++) {
				if(p < 0) {
					x[i+1] = x[i]+1;
					y[i+1] = y[i];
					p = p + dy2;
				}
				else {
					x[i+1] = x[i]+1;
					y[i+1] = y[i]+1;
					p = p + err;
				}
				System.out.println("(" + x[i+1] + ", " + y[i+1] + ")");
			}
		}else {
			p = dx2 - dy;
			err= dx2 - (2*dy);
			x=new double[(int)Math.round(Math.abs(dy))+1];
			y=new double[(int)Math.round(Math.abs(dy))+1];
			x[0]=x0;
			y[0]=y0;
			System.out.println("(" + x[0] + ", " + y[0] + ")");
			for (i = 0;i < dy;i++) {
				if(p < 0) {
					y[i+1] = y[i]+1;
					x[i+1] = x[i];
					p = p+ dx2;
				}
				else {
					y[i+1] = y[i]+1;
					x[i+1] = x[i]+1;
					p = p+err;
				}
				System.out.println("(" + x[i+1] + ", " + y[i+1] + ")");
			}
		}
		Plot2DPanel plot = new Plot2DPanel();
		plot.addLinePlot("Bresenham", x, y);
		JFrame frame = new JFrame("Bresenham Algorithm");
		frame.setSize(848, 480);
		frame.setContentPane(plot);
		frame.setVisible(true);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Type 1 for DDA ");
		System.out.println("Type 2 for Bresenham ");
		System.out.print("Select Input: ");
		int in = sc.nextInt();
		switch (in) {
		case 1:
		case 2:
			LineInput(sc, in);
			break;
		default:
			System.out.println("Invalid Input");
		}
		sc.close();

	}

}
