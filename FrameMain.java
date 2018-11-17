package swingproject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class FrameMain extends JFrame implements ActionListener {

	private JButton alg = new JButton("点击进入");
	private JLabel lName = new JLabel("信息管理查询中心");
	
	public FrameMain()
	{
		this.setTitle("钢晨物流园区");
		this.setLayout(null);
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		Font font=new Font("宋体",Font.BOLD,15);
		alg.setFont(font);
		alg.setBounds(240,350,100,50);
		alg.setFocusPainted(false);
		alg.addActionListener(this);
		lName.setBounds(120,100,400,100);
		font=new Font("宋体",Font.BOLD,40);
		lName.setFont(font);
		this.add(alg);
		this.add(lName);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource()==alg)
        {
            this.dispose();//点击按钮时frame1销毁,new一个frame2
            new FrameProgram();
        }
		
	}
	
}
