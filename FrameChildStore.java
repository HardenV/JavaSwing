package swingproject;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class FrameChildStore extends JFrame implements ActionListener {
	
	private JLabel lBackground = new JLabel();
	private JTable OutData;
	private JTable InData;
	private JScrollPane scrollPaneOut;
	private JScrollPane scrollPaneIn;
	private JLabel inLabel = new JLabel("入库数据表");
	private JLabel outLabel = new JLabel("出库数据表");
	Vector columnTitleIn = new Vector();
	Vector columnTitleOut = new Vector();
	Vector tableDataIn = new Vector();
	Vector tableDataOut = new Vector();
	Vector strVector;
	int leftNumber;
	double Store;
	
	private JLabel leftStore = new JLabel("剩余库存 = ");
	private JLabel leftStore1;
	private JButton bReturn = new JButton("返回");
	
	public FrameChildStore(String sSpec,String sStyle,String sTime)
	{
		ImageIcon icon = new ImageIcon("res/背景.jpg");
		icon.setImage(icon.getImage().getScaledInstance(800,  
                600, Image.SCALE_DEFAULT));
        lBackground.setIcon(icon);; //参数是一个Image对象,
        lBackground.setBounds(0,0,800,600);
		
		this.setTitle("钢晨物流园区");
		this.setLayout(null);
		//设置界面大小
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		columnTitleIn.add("入库单号");
		columnTitleIn.add("件数");
		columnTitleIn.add("重量（吨）");
		columnTitleOut.add("出库单号");
		columnTitleOut.add("件数");
		columnTitleOut.add("重量（吨）");
		
		try {
	        // read file content from file
	        	FileReader fin = new FileReader("res/入库数据.txt");
	        	FileReader fout = new FileReader("res/出库数据.txt");
	        	FileReader fp = new FileReader("res/历史库存.txt");
				BufferedReader bf = new BufferedReader(fin);
				String str = null;
				int count;
				int index;
				int previous = 0;
				int number = 0;
				double store = 0;
	       
	        while((str = bf.readLine()) != null) {
	        	index = 0;
	        	count = 0;
	             //System.out.println(str+"\r\n");
	        	 //bw.write(str + "\r\n");
	        	strVector = new Vector();
	        	String [] arr = str.split("\\s+");
	        	for(String ss : arr){
	        		index++;
	        		if(index == 3)
	        			continue;
	        		else if(index == 1)
	        		{
	        			if(ss.equals(sTime))
	        			{
	        				previous = 1;
	        				count++;
	        				continue;
	        			}
	        		}
	        		else if(index == 2)
	        		{
	        			strVector.add(ss);
	        		}
	        		else if(index == 4)
	        		{
	        			if(ss.equals(sSpec))
	        			{
	        				count++;
	        				continue;
	        			}
	        			else
	        				break;
	        		}
	        		else if(index == 5)
	        		{
	        			if(ss.equals(sStyle))
	        			{
	        				count++;
	        				continue;
	        			}
	        			else
	        				break;
	        		}
	        		else if(index == 6)
	        		{
	        			if(previous == 0 && count == 2)
	        				number = number + Integer.parseInt(ss);
	        			else if(count == 3)
	        				strVector.add(ss);
	        		}
	        		else if(index == 7)
	        		{
	        			if(previous == 0 && count == 2)
	        				store = store + Double.parseDouble(ss);
	        			else if(count == 3)
	        				strVector.add(ss);
	        		}
	        	}
	        	if(count == 3)
	        	{
	        		tableDataIn.add(strVector);
	        		number = number + Integer.parseInt((String) strVector.get(1));
	        		store = store + Double.parseDouble((String) strVector.get(2));
	        	}
	        }
	        
	        bf = new BufferedReader(fout);
			str = null;
			previous = 0;
			
			 while((str = bf.readLine()) != null) {
		        	index = 0;
		        	count = 0;
		             //System.out.println(str+"\r\n");
		        	 //bw.write(str + "\r\n");
		        	strVector = new Vector();
		        	String [] arr = str.split("\\s+");
		        	for(String ss : arr){
		        		index++;
		        		if(index == 3)
		        			continue;
		        		else if(index == 1)
		        		{
		        			if(ss.equals(sTime))
		        			{
		        				previous = 1;
		        				count++;
		        				continue;
		        			}
		        		}
		        		else if(index == 2)
		        		{
		        			strVector.add(ss);
		        		}
		        		else if(index == 4)
		        		{
		        			if(ss.equals(sSpec))
		        			{
		        				count++;
		        				continue;
		        			}
		        			else
		        				break;
		        		}
		        		else if(index == 5)
		        		{
		        			if(ss.equals(sStyle))
		        			{
		        				count++;
		        				continue;
		        			}
		        			else
		        				break;
		        		}
		        		else if(index == 6)
		        		{
		        			if(previous == 0 && count == 2)
		        				number = number - Integer.parseInt(ss);
		        			else if(count == 3)
		        				strVector.add(ss);
		        		}
		        		else if(index == 7)
		        		{
		        			if(previous == 0 && count == 2)
		        				store = store - Double.parseDouble(ss);
		        			else if(count == 3)
		        				strVector.add(ss);
		        		}
		        	}
		        	if(count == 3)
		        	{
		        		tableDataOut.add(strVector);
		        		number = number - Integer.parseInt((String) strVector.get(1));
		        		store = store - Double.parseDouble((String) strVector.get(2));
		        	}
		        }
			 
			bf = new BufferedReader(fp);
			str = null;
			while((str = bf.readLine()) != null) {
	        	index = 0;
	        	count = 0;
	             //System.out.println(str+"\r\n");
	        	 //bw.write(str + "\r\n");
	        	strVector = new Vector();
	        	String [] arr = str.split("\\s+");
	        	for(String ss : arr){
	        		index++;
	        		if(index == 3)
	        		{
	        			if(ss.equals(sStyle))
	        			{
	        				count++;
	        				continue;
	        			}
	        		}
	        		else if(index == 1)
	        		{
	        			continue;
	        		}
	        		else if(index == 2)
	        		{
	        			if(ss.equals(sSpec))
	        			{
	        				count++;
	        				continue;
	        			}
	        		}
	        		else if(index == 4)
	        		{
	        			if(count == 2)
	        				leftNumber = Integer.parseInt(ss) + number;		
	        		}
	        		else if(index == 5)
	        		{
	        			if(count == 2)
	        				Store = Double.parseDouble(ss) + store;
	        		}
	        }
	        
		}
			bf.close();
	}
		
	  catch(FileNotFoundException e) {
            e.printStackTrace();
      }
      catch(IOException e) {
            e.printStackTrace();
      }
		System.out.println(Store);
		OutData = new JTable(tableDataOut,columnTitleOut);
		InData = new JTable(tableDataIn,columnTitleIn);
		scrollPaneOut = new JScrollPane(OutData);
		scrollPaneIn = new JScrollPane(InData);
		scrollPaneOut.setBounds(30,50,300,250);
		scrollPaneIn.setBounds(390,50,300,250);
		scrollPaneOut.setVerticalScrollBarPolicy(   
	        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneIn.setVerticalScrollBarPolicy(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		Font font = new Font("宋体",Font.BOLD,15);
		inLabel.setBounds(420,20,100,30);
		inLabel.setFont(font);
		outLabel.setBounds(60,20,100,30);
		outLabel.setFont(font);
		leftStore.setBounds(60,400,200,30);
		font = new Font("宋体",Font.BOLD,30);
		leftStore.setFont(font);
		leftStore1 = new JLabel(String.format("%.2f", Store) + "吨");
		leftStore1.setBounds(240,400,200,30);
		leftStore1.setFont(font);
		
		font = new Font("宋体",Font.BOLD,15);
		bReturn.setBounds(30,500,100,30);
		bReturn.setFont(font);
		bReturn.addActionListener(this);
		
		lBackground.add(scrollPaneOut);
		lBackground.add(scrollPaneIn);
		lBackground.add(inLabel);
		lBackground.add(outLabel);
		lBackground.add(leftStore);
		lBackground.add(leftStore1);
		lBackground.add(bReturn);
		
		this.add(lBackground);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bReturn) {
			this.dispose();
			new FrameStore();
		}
	}

}
