import java.util.*;
public class Operator extends User{

	Operator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("***��ӭ���뵵��¼����Ա���***");
		System.out.println("1.�����ļ�"
				+ "\n2.�ϴ��ļ�"
				+ "\n3.�ļ��б�"
				+ "\n4.�޸�����"
				+ "\n5.��        ��");
		
	}

	public void runMenu(int num) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		if(num==2){
			System.out.println("�������ļ�·��");
			String file_name=in.next();
			System.out.println("�ϴ��ļ�... ...");
		}
		else if(num==1){
			System.out.println("��������Ҫ���ص��ļ�");
			String filename=in.next();
			super.downloadFile(filename);
		}
		else if(num==3){
			super.showFileList();
		}
		else if(num==4){
			String password=in.next();
			super.setPassword(password);
		}
		else if(num==5){
			super.exitSystem();
		}
	}

	

}
