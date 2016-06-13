package pl.allst.physics;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Window extends JFrame {

	private Physics panel;
	private static final long serialVersionUID = -802346793287712665L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		panel = new Physics();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.setBounds(0, 0,getContentPane().getWidth(), getContentPane().getHeight());
			}
			
		});
		
		

	}
}
