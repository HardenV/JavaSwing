package swingproject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FrameCar extends JFrame implements ActionListener  {
	
	JButton bAccess = new JButton("入库");
	JButton bLeft = new JButton("出库");
	JButton bReturn = new JButton("返回");
	
	public FrameCar()
	{
		this.setTitle("钢晨物流园区");
		this.setLayout(null);
		//设置界面大小
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		Font font = new Font("宋体",Font.BOLD,30);
		bAccess.setFont(font);
		bLeft.setFont(font);
		bAccess.setFocusPainted(false);
		bLeft.setFocusPainted(false);
		//设置按钮大小位置
		bAccess.setBounds(185,80,200,80);
		bLeft.setBounds(185,280,200,80);
		bAccess.addActionListener(this);
		bLeft.addActionListener(this);
		
		font = new Font("宋体",Font.BOLD,15);
		bReturn.setBounds(30,400,100,30);
		bReturn.setFont(font);
		bReturn.addActionListener(this);
		
		this.add(bAccess);
		this.add(bLeft);
		this.add(bReturn);
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bAccess)
		{
			this.dispose();
			new FrameAccessCar();
		}
		else if(e.getSource() == bLeft)
		{
			this.dispose();
			new FrameLeftCar();
		}
		else if(e.getSource() == bReturn)
		{
			this.dispose();
			new FrameProgram();
		}
	}

}
