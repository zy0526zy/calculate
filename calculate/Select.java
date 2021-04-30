package calculate;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import javax.swing.*;
public class Select extends JFrame 
{
	public static final int DEFAULT_WIDTH = 700;
	public static final int DEFAULT_HEIGHT = 300;
	private JButton button1;
	private JButton button2;
	private JTextField field1;
	private JLabel label1;
	private JTextField field2;
	private JLabel label2;
	private JTextArea textArea1;
	private JLabel label3;
	String c2 ;
	String c1;
	//=========================================================
	public Select(
			final ArrayList<String> integer,
			final ArrayList<String> fraction, final ArrayList<String> intAnswer,
			final ArrayList<String> fraAnswer, final BufferedWriter out,
			final int n,final String c1,final String c2)
	{
		setTitle("四则运算测试");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);//可以自行设置窗口位置
		label1 = new JLabel("学号:",JLabel.LEFT);
		label1.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 18));
		label1.setBounds(100, 100, 150,45);
		add(label1);  
		field1 = new JTextField();
		field1.setColumns(20);
		field1.setBounds(150, 110, 150,25);
		add(field1);
		label2 = new JLabel("姓名:",JLabel.LEFT);
		label2.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 18));
		label2.setBounds(400, 100, 150,45);
		add(label2);
		field2 = new JTextField();
		field2.setColumns(20);
		field2.setBounds(450, 110, 150,25);
		add(field2);   
		button1 = new JButton("整数");
		button1.setBounds(250, 200, 100,25);
		add(button1);
		button2 = new JButton("分数");
		button2.setBounds(350, 200, 100,25);
		add(button2); 
		JPanel panel = new JPanel();
		add(panel);
		button1.addActionListener(new ActionListener()
		{
			String c11;
			String c22;
			public  void actionPerformed(ActionEvent  event)
			{
				c11= field1.getText();
				c22 = field2.getText();
				if(event.getSource()==button1)
				{
					setVisible(false); 
					int x=1;
					Test hh= new Test(integer,intAnswer,out,c11,c22,n);
					setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
				    hh.setVisible(true);
				    setLocationRelativeTo(null);
				}
			}
		});	
		button2.addActionListener(new ActionListener()
		{
			public  String c11;
			public String c22;
			public  void actionPerformed(ActionEvent  event)
			{   
				c11 = field1.getText();
				c22 = field2.getText();
				if(event.getSource()==button2)
				{
					setVisible(false); 
					Test ss	= new Test(fraction,fraAnswer,out,c11,c22,n);
					setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
					ss.setVisible(true);
					setLocationRelativeTo(null);
				}
			}
		});	
	}
}