package MyGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.*;

import data.User;


public class Mainframe<Userframe> extends JFrame{
	
	public static final GraphicsConfiguration temp = null;
	private JMenuBar bar;
	private JMenu jm1;
	private JMenu jm2;
	private JMenu jm3;
	private JMenuItem item1_1;
	private JMenuItem item1_2;
	private JMenuItem item1_3;
	private JMenuItem item2_1;
	private JMenuItem item2_2;
	private JMenuItem item3_1;
 	public static User t;
	
	
	public Mainframe(User temp){
		setTitle("User");
		setSize(500, 500);
		setLocation(400, 100);
		setVisible(true);
		bar=new JMenuBar();
		jm1=new JMenu("用户管理");
		jm1.addSeparator();
		item1_1=new JMenuItem("修改用户");
		item1_2=new JMenuItem("删除用户");
		item1_3=new JMenuItem("新增用户");
		jm1.add(item1_1);
		jm1.add(item1_2);
		jm1.add(item1_3);
		jm2=new JMenu("档案管理");
		jm2.addSeparator();
		item2_1=new JMenuItem("档案上传");
		item2_2=new JMenuItem("档案下载");
		jm2.add(item2_1);
		jm2.add(item2_2);
		jm3=new JMenu("个人信息管理");
		jm3.addSeparator();
		item3_1=new JMenuItem("信息修改");
		jm3.add(item3_1);
		bar.add(jm1);
		bar.add(jm2);
		bar.add(jm3);
		setJMenuBar(bar);
		user_exam ue=new user_exam();
		item3_1.addActionListener(ue);
		t=temp;
		
	} 
	
	public static String getname(){
		
		return t.getName();
		
	}
	public static String getrole(){
		return t.getRole();
	}

	class user_exam implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Usereframe uf=new Usereframe();
		}
	}
	 class file_exam implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
	 class self_exam implements  ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
	
	 
}
