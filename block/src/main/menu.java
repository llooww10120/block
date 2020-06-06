package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;




public class menu extends JPanel {

//	private static final JLabel backmenu = new JLabel();

	private static final ImageIcon backmenu = new ImageIcon("C:\\Users\\SPK\\git\\block\\block\\src\\main\\backmenu.gif");
	private static final ImageIcon imstart = new ImageIcon("C:\\Users\\SPK\\git\\block\\block\\src\\main\\space.gif");

	private Timer start;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private JButton button;
	public static final int FRAMEx = 150;
	public static final int FRAMEy = 100;
	public static final int xFRAME = 600;
	public static final int yFRAME = 800;
	public static final int xground = 300;
	public static final int yground = 600;
	
	
	public menu() {
		myImage =  new BufferedImage(700, 500, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();

//		myBuffer.drawImage(backmenu.getImage(), 0, 0, xground, yground, null);
//		repaint();
		start = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myBuffer.drawImage(backmenu.getImage(), FRAMEx, FRAMEy, xground, yground, null);
				repaint();
			}
		});
		start.start();

//		ImageIcon backmenu = new ImageIcon("C:\\Users\\SPK\\git\\block\\block\\src\\main\\backmenu.gif");

//		backmenu.setImage(backmenu.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));



//		myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
//		backmenu.setIcon(new ImageIcon("C:\\Users\\SPK\\git\\block\\block\\src\\main\\backmenu.gif"));

//		add(backmenu,BorderLayout.CENTER);

//		button = new JButton("choose");
//		button.setFont(new Font("Courier New", Font.BOLD, 30));
//		button.setBounds(30, 300, 100, 100);
//		button.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				myBuffer.drawImage(hanged.getImage(), 0, 0, xFRAME, yFRAME, null);
//				
//			}
//			
//		});
//		add(button);
		
	}
	public void paintComponent(Graphics g){
    	g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }

}

