package pl.allst.physics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;

public class BouncingBal extends Ellipse2D.Double implements ActionListener{

	private static final long serialVersionUID = -8921641726616092643L;
	
	private Timer clk = new Timer(10, this) ;
	private Physics phc;
	public Ellipse2D.Double ball ;
	private Color c;
	
	double speed;
	double dirX;
	double dirY;
	
	public BouncingBal(Physics phc, double x, double y, double dirX, double dirY,double speed) {
		this.phc = phc;
		clk.start();
		ball = new Double(x, y, 30, 30);
		this.speed = speed;
		this.dirX=dirX;
		this.dirY=dirY;
		this.c= new Color(ThreadLocalRandom.current().nextInt(0, 256),ThreadLocalRandom.current().nextInt(0, 256),ThreadLocalRandom.current().nextInt(0, 256));
	}



	public Color getC() {
		return c;
	}



	public void setC(Color c) {
		this.c = c;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		phc.repaint();
		ball = new Double(ball.getX()+(speed*dirX), ball.getY()+(speed*dirY), 30, 30);
		if(ball.getWidth()+ball.getX() > phc.getWidth()){
			dirX*=-1;
		}
		if (ball.getHeight()+ball.getY() > phc.getHeight()){
			dirY*=-1;
		}
		if(ball.getY() <= 0){
			dirY*=-1;
		}
		if(ball.getX() <= 0){
			dirX*=-1;
		}
		if(ball.getX() > phc.getWidth()+500 || ball.getY() > phc.getHeight()+500 ){
			phc.removeObj(this);
		}
	}}
