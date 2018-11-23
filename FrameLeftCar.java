package swingproject;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FrameLeftCar extends JFrame implements ActionListener {
	private JTextField AccessText = new JTextField(1);
	String str1 = "输入车辆编号，出发地";
	String str2 = "出发时刻，卸货种类";
	String str3 = "装货数量";
	String sAccess = "<html><body>"+str1+"<br>"+str2+"<br>"+str3+"<body></html>"; 
	private JLabel lAccess = new JLabel(sAccess);
	private JButton bEnsure = new JButton("确定");
	JButton bReturn = new JButton("返回");
	private JLabel lBackground = new JLabel();
	
	public FrameLeftCar()
	{
		ImageIcon icon = new ImageIcon("res/背景.jpg");
		icon.setImage(icon.getImage().getScaledInstance(600,  
                500, Image.SCALE_DEFAULT));
        lBackground.setIcon(icon);; //参数是一个Image对象,
        lBackground.setBounds(0,0,600,500);
		
		this.setTitle("钢晨物流园区");
		this.setLayout(null);
		//设置界面大小
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		Font font = new Font("宋体",Font.BOLD,28);
		AccessText.setBounds(100,100,300,30);
		lAccess.setBounds(100,20,300,400);
		lAccess.setFont(font);
		bEnsure.setBounds(400,100,60,30);
		bEnsure.addActionListener(this);
		font = new Font("宋体",Font.BOLD,15);
		bReturn.setBounds(30,400,100,30);
		bReturn.setFont(font);
		bReturn.addActionListener(this);
		
		lBackground.add(AccessText);
		lBackground.add(bEnsure);
		lBackground.add(bReturn);
		lBackground.add(lAccess);
		
		this.add(lBackground);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bEnsure)
		{
			this.dispose();
			new FrameLeftShow();
		}
		else if(e.getSource() == bReturn)
		{
			this.dispose();
			new FrameCar();
		}
	}
}
