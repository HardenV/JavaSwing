package swingproject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FrameProgram extends JFrame implements ActionListener {
	
	private JButton bStore = new JButton("库存查询");
	private JButton bTran = new JButton("车辆监控");
	private JButton bDisplay = new JButton("成品摆放");
	private JButton bReturn = new JButton("返回");
	/*private JLabel lQuantity = new JLabel("产品数量：");
	private JLabel lKind = new JLabel("产品种类：");
	JTextField quantity = new JTextField(1);
	JTextField needMaterial = new JTextField(1);*/
	//JTable table = new JTable("现货数据");
	
	public FrameProgram()
	{
		this.setTitle("钢晨物流园区");
		//取消界面垂直布局
		this.setLayout(null);
		//设置界面大小
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		//设置字体
		Font font = new Font("宋体",Font.BOLD,30);
		
		bTran.setFont(font);
		bDisplay.setFont(font);
		bStore.setFont(font);
		bStore.setFocusPainted(false);
		//设置按钮大小位置
		bTran.setBounds(185,180,200,70);
		bDisplay.setBounds(185,300,200,70);
		bStore.setBounds(185,60,200,70);
		//设置标签大小位置
		//lQuantity.setBounds(50,85,200,30);
		//lKind.setBounds(50,20,200,30);
		//lQuantity.setFont(font);
		//lKind.setFont(font);
		//设置输入框大小位置
		//quantity.setBounds(180,22,250,30);
		//needMaterial.setBounds(180,87,250,30);
		//按钮设置监听事件
		bTran.addActionListener(this);
		bDisplay.addActionListener(this);
		bStore.addActionListener(this);
		
		font = new Font("宋体",Font.BOLD,15);
		bReturn.setBounds(30,400,100,30);
		bReturn.setFont(font);
		bReturn.addActionListener(this);
		
		//将各种控件加入界面
		this.add(bTran);
		this.add(bDisplay);
		this.add(bStore);
		this.add(bReturn);
		//this.add(lQuantity);
		//this.add(lKind);
		//this.add(quantity);
		//this.add(needMaterial);
		//显示
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bStore) {
			this.dispose();
			new FrameStore();
		}
		else if(e.getSource()==bTran) {
			this.dispose();
			new FrameCar();
		}
		else if(e.getSource()==bDisplay) {
			this.dispose();
			new FrameDisplay();
		}
		else if(e.getSource() == bReturn)
		{
			this.dispose();
			new FrameMain();
		}
	}

}
