import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User{

	Administrator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****��ӭ���������Ա�˵�****"
				+ "\n1.�޸��û�"
				+ "\n2.ɾ���û�"
				+ "\n3.�����û�"
				+ "\n4.�г��û�"
				+ "\n5.�����ļ�"
				+ "\n6.�ļ��б�"
				+ "\n7.�޸ģ����ˣ�����"
				+ "\n8.��        ��"
				+ "\n****************");
			}
	public void runMenu(int num) throws SQLException{
		Scanner in=new Scanner(System.in);
		if(num==1){
			System.out.println("�������û�����");
			String name=in.next();
			System.out.println("��������");
			String pwd=in.next();
			System.out.println("�������û����ࣺ");
			String role=in.next();
			try {
				DataProcessing.updateUser(name,pwd,role);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.runMenu(num);
			}
			
		}
		if(num==2){
			System.out.println("������Ҫɾ�������֣�");
			String name=in.next();
			try {
				DataProcessing.deleteUser(name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(num==3){
			System.out.println("������Ҫ������û�����");
			String str1=in.next();
			System.out.println("���������룺");
			String str2=in.next();
			System.out.println("�������û����ͣ�");
			String str3=in.next();
			try {
				DataProcessing.insertUser(str1, str2, str3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(num==4){
			Enumeration<User> e = null;
			try {
				e = DataProcessing.getAllUser();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(e.hasMoreElements()){
				User a = e.nextElement();
				System.out.println("Name:"+a.getName()
						+"\tPwd:"+a.getPassword()
						+"\tRole:"+a.getRole());
			}
		}
		if(num==5){
			System.out.println("������Ҫ���ص��ļ���");
			String file_name=in.next();
			
				try {
					super.downloadFile(file_name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					this.runMenu(num);
				}
				
			
			
		}
		if(num==6){
			super.showFileList();
		}
		if(num==7){
			
			System.out.println("������Ҫ�޸ĵ�����");
			String pwd=in.next();
			super.changeUserInfo(pwd);
		}
		if(num==8)
			super.exitSystem();

	}
	
}