package main;


import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Tetris");
        frame.setSize(800, 800);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setContentPane(new window());
        frame.setVisible(true);
	}

}
