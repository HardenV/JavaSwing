package swingproject;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class FrameLeftShow extends JFrame implements ActionListener {

	private JTable leftCarTable;
	private JScrollPane scrollPane;
	private JLabel leftLabel = new JLabel("出库车辆数据表");
	JButton bReturn = new JButton("返回");
	private JLabel lBackground = new JLabel();
	
	String[] columnTitle = {"车辆编号","出发点（园区位置）编号","出发时刻","道路节点（园区位置）编号",
			"到达时刻","装卸货物的种类及数量","离开时刻"};
	
	Object[][] tableData = 
		{
			new Object[]{"...","...","...","...","...","...","..."},
			new Object[]{"...","...","...","...","...","...","..."},
			new Object[]{"...","...","...","...","...","...","..."},
			new Object[]{"...","...","...","...","...","...","..."},
			new Object[]{"...","...","...","...","...","...","..."}
		};
	
	public FrameLeftShow()
	{
		ImageIcon icon = new ImageIcon("res/背景.jpg");
		icon.setImage(icon.getImage().getScaledInstance(1200,  
                600, Image.SCALE_DEFAULT));
        lBackground.setIcon(icon);; //参数是一个Image对象,
        lBackground.setBounds(0,0,1200,600);
		
		this.setTitle("钢晨物流园区");
		this.setLayout(null);
		//设置界面大小
		this.setSize(1200,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		Font font = new Font("宋体",Font.BOLD,20);
		leftCarTable = new JTable(tableData,columnTitle);
		scrollPane = new JScrollPane(leftCarTable);
		font = new Font("宋体",Font.BOLD,15);
		leftLabel.setBounds(20,3,200,30);
		leftLabel.setFont(font);
		scrollPane.setBounds(3,30,1180,440);
		scrollPane.setVerticalScrollBarPolicy(   
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		font = new Font("宋体",Font.BOLD,15);
		bReturn.setBounds(30,500,100,30);
		bReturn.setFont(font);
		bReturn.addActionListener(this);
		
		lBackground.add(scrollPane);
		lBackground.add(leftLabel);
		lBackground.add(bReturn);
		
		this.add(lBackground);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bReturn)
		{
			this.dispose();
			new FrameLeftCar();
		}
		
	}

}
