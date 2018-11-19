package swingproject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FrameDisplay extends JFrame implements ActionListener  {
	String[] sSpec = {"HRB400", "HRB400E抗震", "HRB500", "HRB500E抗震", 
			"HTRB600", "HTRB600E抗震"};
	String[] sStyle = {"12*9","12*12","14*9","14*12","16*12","16*7","16*9",
			"18*12","18*7","18*9","20*12","20*7","20*9","22*12","22*7","22*9",
			"25*12","25*14","25*7","25*9","28*12","28*9","32*12","32*9"};
	
	private JComboBox chooseSpec = new JComboBox(sSpec);
	private JComboBox chooseStyle = new JComboBox(sStyle);
	private JTextField textTime = new JTextField(1);
	private JButton bQuery = new JButton("点击查询");
	private JLabel lQuery = new JLabel("成品查询");
	private JLabel lSpec = new JLabel("选择钢种");
	private JLabel lStyle = new JLabel("选择规格");
	private JLabel lTime = new JLabel("输入数量");
	JButton bReturn = new JButton("返回");
	
	public FrameDisplay()
	{
		this.setTitle("钢晨物流园区");
		this.setLayout(null);
		//设置界面大小
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		chooseSpec.setBounds(120,60,150,40);
		chooseStyle.setBounds(120,180,150,40);
		chooseSpec.setEditable(true);
		chooseStyle.setEditable(true);
		bQuery.setBounds(360,300,140,80);
		bQuery.addActionListener(this);
		//设置字体
		Font font = new Font("宋体",Font.BOLD,15);
		lSpec.setBounds(30,60,80,40);
		lSpec.setFont(font);
		lStyle.setBounds(30,180,80,40);
		lStyle.setFont(font);
		lTime.setBounds(30,300,80,40);
		lTime.setFont(font);
		textTime.setBounds(120,300,150,40);
		font = new Font("宋体",Font.BOLD,40);
		lQuery.setFont(font);
		lQuery.setBounds(350,110,200,50);
		font = new Font("宋体",Font.BOLD,15);
		bReturn.setBounds(30,400,100,30);
		bReturn.setFont(font);
		bReturn.addActionListener(this);
		
		this.add(chooseSpec);
		this.add(chooseStyle);
		this.add(textTime);
		this.add(lSpec);
		this.add(lStyle);
		this.add(lTime);
		this.add(bQuery);
		this.add(lQuery);
		this.add(bReturn);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bQuery)
		{
			this.dispose();
			String str1 = "摆放在（）号堆场";
			String str2 = "（）号位置";
			String strPostion = "<html><body>"+str1+"<br>"+str2+"<body></html>";
			new FrameChildDisplay(strPostion);
		}
		else if(e.getSource() == bReturn)
		{
			this.dispose();
			new FrameProgram();
		}
	}


}
