package data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Browser extends User{
	
	Browser(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****��ӭ���뵵�����Ա�˵�****\n");
		System.out.println("1.�����ļ�"
				+ "\n2.�ļ��б�"
				+ "\n3.�޸�����"
				+ "\n4.�˳�");
		System.out.println("****************************\n��ѡ��˵�");
	}

	public void runMenu(int num) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		if(num==1){
			super.downloadFile();
		}
		else if(num==2){
			super.showFileList();
		}
		else if(num==3){
			System.out.println("������Ҫ�޸ĵ�����");
			String password=in.next();
			super.setPassword(password);
		}
		else if(num==4){
			super.exitSystem();
		}
	}
}
