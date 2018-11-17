package swingproject;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class OutputAlg {
	
	//JFrame f = new JFrame("产量算法");
	//JTextField quantity = new JTextField(1);
	//JTextField needMaterial = new JTextField(1);
	//JLabel lMaterial = new JLabel("所需原料量");
	
	public void InitGUI()
	{
		FrameMain fm = new FrameMain();
	}
	
	public static void main(String[] args) {
		OutputAlg opAlg = new OutputAlg();
		opAlg.InitGUI();
	}
}
