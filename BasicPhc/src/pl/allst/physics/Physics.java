package pl.allst.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Physics extends JPanel {

	private static final long serialVersionUID = -3235749602225648182L;
	private LinkedList<BouncingBal> bb = new LinkedList<>();
	private JLabel label = new JLabel();
	Physics phc;
	
	int nbx;
	int nby;
	int destPointX;
	int destPointY;
	double dirX;
	double dirY;
	double speed;
	
	public Physics() {
		super();
		phc=this;

		this.add(label);
		label.setBounds(0, 0, 50, 20);
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e) {
				destPointX = e.getX();
				destPointY = e.getY();
				
				speed = Math.sqrt(Math.pow(destPointX-nbx,2)+Math.pow(destPointY-nby,2));

				dirX = (destPointX - nbx)/10;
				dirY = (destPointY - nby)/10;
				
				bb.add(new BouncingBal(phc, nbx, nby, dirX, dirY, speed / 200));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				nbx = e.getX();
				nby = e.getY();
				
			}
		});
	}



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		for(BouncingBal b : bb){
			g2.setColor(b.getC());
			g2.fill(b.ball);
		}
		label.setText("Liczba kulek: "+bb.size());
		if(bb.size()>20) bb.removeAll(bb);
	}
	
	public void removeObj(BouncingBal b){
		bb.remove(b);
	}
	
	public LinkedList<BouncingBal> getBb() {
		return bb;
	}


	public void setBb(LinkedList<BouncingBal> bb) {
		this.bb = bb;
	}

}
