package MyGui;
import java.awt.*;
import javax.swing.*;

import MyGui.Login.Login_exam;

import java.awt.event.*;
import java.sql.SQLException;

import data.DataProcessing;
import data.User;
public class Usereframe extends JFrame  implements ActionListener{
	JLabel jb1=new JLabel("用户名");
	JLabel jb2=new JLabel("原口令");
	JLabel jb3=new JLabel("新口令");
	JLabel jb4=new JLabel("确认新口令");
	JLabel jb5=new JLabel("角色");
	JTextField jf1;
	JTextField jf2=new JTextField();
	JTextField jf3=new JTextField();
	JTextField jf4=new JTextField();
	JTextField jf5;
	JButton jb=new JButton("确认");
	
	public Usereframe(){
		jf1=new JTextField(Mainframe.getname());
		jf5=new JTextField(Mainframe.getrole());
		jf1.setEditable(false);
		jf5.setEditable(false);
		setVisible(true);
		setSize(300,400);
		setLocationRelativeTo(null);
		setTitle("用户信息修改");
		setLayout(null);
		jb1.setBounds(30,40,40,20);
		jb2.setBounds(30,90,40,20);
		jb3.setBounds(30,140,40,20);
		jb4.setBounds(30, 190, 40, 20);
		jb5.setBounds(30, 240, 40, 20);
		jf1.setBounds(100,40,100,20);
		jf2.setBounds(100, 90, 100, 20);
		jf3.setBounds(100,140,100,20);
		jf4.setBounds(100,190,100,20);
		jf5.setBounds(100,240,100,20);
		jb.setBounds(130, 280, 60, 20);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jb5);
		add(jf1);
		add(jf2);
		add(jf3);
		add(jf4);
		add(jf5);
		add(jb);
		jb.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String temp1=jf1.getText();
		String temp2=jf2.getText();
		User temp;
		try {
			temp = DataProcessing.searchUser(temp1, temp2);
			if(temp==null){
				JOptionPane.showMessageDialog(getContentPane(),
						"密码输入错误", "系统信息", JOptionPane.ERROR_MESSAGE);
			}
			else if(jf3.getText()!=jf4.getText()){
				JOptionPane.showMessageDialog(getContentPane(),
						"口令输入不匹配", "系统信息", JOptionPane.WARNING_MESSAGE);
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}
	
}
