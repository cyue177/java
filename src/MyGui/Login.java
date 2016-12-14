
package MyGui;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import data.DataProcessing;
import data.User;


public class Login {
	private JFrame frame;
//	private JFrame frame2;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton login;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
		login();
	}

	private void initialize() {
		Fileframe ff=new Fileframe();
		frame = new JFrame();
		frame.setSize(300, 300);
		frame.setLocation(500,200);
		frame.setTitle("Login");
		frame.setLayout(null);
		login=new JButton("login");
		username=new JTextField(200);
		passwordField=new JPasswordField(200);
		
		JButton jb1=new JButton("登  录");
		JButton jb2=new JButton("退  出");
		
		jb1.setBounds(30,170,70,25);
		jb2.setBounds(190, 170, 70, 25);
		
		JLabel label1=new JLabel("用户名");
		JLabel label2=new JLabel("密    码");
		
		label1.setBounds(30,40,40,20);
		label2.setBounds(30,100,40,20);
		
		username.setBounds(100,38,120,25);
		passwordField.setBounds(100,98,120,25);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(username);
		frame.add(passwordField);
		frame.add(jb1);
		frame.add(jb2);
		
		Login_exam al = new Login_exam();
		jb1.addActionListener(al);
		
	}
	
	class Login_exam implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String user=username.getText();
			char[] password=passwordField.getPassword();
			String str=new String(password);
			try {
				User temp=DataProcessing.searchUser(user,str);
				frame.setVisible(false);
				 
				//frame2.setVisible(true);
				String role= temp.getRole();
				 if(role=="operator"){username.setText(role);}
				else if(role=="browser"){username.setText(role);}
				else if(role=="administrator"){username.setText(role);}
				
				Mainframe uframe=new Mainframe(temp);
//				uframe.run();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			catch(NullPointerException e2){
				frame.setVisible(true);
				JOptionPane.showMessageDialog(frame.getContentPane(),
						"密码或用户名错误！！请重新输入！", "系统信息", JOptionPane.ERROR_MESSAGE);
				
				e2.printStackTrace();
				
			}
			
		}

		private void name() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void login(){
		Login_exam bl=new Login_exam();


		login.addActionListener(bl);
		
	}

}
