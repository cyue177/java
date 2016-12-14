package MyGui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.io.File;

public class Fileframe  extends JFrame implements ActionListener{
	JTabbedPane jp; 
	JPanel p1;
	JPanel p2;
	JTable table;
	JButton jb_down;
	JButton jb_up;
	JButton jb_del;
	JLabel label1=new JLabel("档案编号");
	JLabel label2=new JLabel("上传者");
	JLabel label3=new JLabel("描述");
	JLabel label4=new JLabel("文件路径");
	JTextField tf1=new JTextField();
	JTextField tf2=new JTextField();
	JTextField tf3=new JTextField();
//	TableModel model=new TableModel();
	
	
	
	Fileframe(){
		jb_down=new JButton("下载文件");
		jb_down.setBounds(200,200,50,20);
		jb_del=new JButton("删除文件");
		jb_up=new JButton("上传文件");
		jb_up.setBounds(300,300,50,20);
		Object[][] cellData = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
		String[] columnNames = {"col1", "col2"};
		   
		table = new JTable(cellData, columnNames);
		setTitle("文件管理");
		setVisible(true);
		setSize(400,400);
		jp=new JTabbedPane();
		p1=new JPanel(); 	
		p2=new JPanel();
//		Object a[][]={
//				{1,"w","eee"}
//		};
//		JList jl=new JList(a[0]);
//		p1.add(jl);
		p1.add(table);
		p1.add(jb_down);
		p2.add(jb_up);
		jp.add("上传文件", p1);
		jp.add("下载文件", p2);
		this.add(jp);
		jb_up.addActionListener(this);
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int result=0;
		File file;
		String path = null;
		JFileChooser fc=new JFileChooser();
		result=fc.showOpenDialog(fc);
		 if(result == JFileChooser.APPROVE_OPTION){       
		        path= fc.getSelectedFile().getAbsolutePath();}
		 
		 
	}
}
