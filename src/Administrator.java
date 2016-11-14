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
	public void runMenu(int num){
		Scanner in=new Scanner(System.in);
		if(num==1){
			System.out.println("�������û�����");
			String name=in.next();
			System.out.println("��������");
			String pwd=in.next();
			System.out.println("�������û����ࣺ");
			String role=in.next();
			if(!DataProcessing.update(name,pwd,role)){
				System.out.println("�����ڴ��û���");
			}
		}
		if(num==2){
			System.out.println("������Ҫɾ�������֣�");
			String name=in.next();
			if(DataProcessing.delete(name))
				System.out.println("ɾ���ɹ�");
			else System.out.println("ɾ��ʧ��");
		}
		if(num==3){
			System.out.println("������Ҫ������û�����");
			String str1=in.next();
			System.out.println("���������룺");
			String str2=in.next();
			System.out.println("�������û����ͣ�");
			String str3=in.next();
			if(DataProcessing.insert(str1, str2, str3))
			{
				System.out.println("��ӳɹ���");
			}
			else System.out.println("�û��Ѵ��ڣ�");
		}
		if(num==4){
			Enumeration<User> e=DataProcessing.getAllUser();
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
			if(super.downloadFile(file_name)==false){
				System.out.println("û�в鵽���ļ������޷�����");
			}
			
		}
		if(num==6)
			super.showFileList();
		if(num==7){
			System.out.println("������Ҫ�޸ĵ�����");
			String pwd=in.next();
			super.changeUserInfo(pwd);
		}
		if(num==8)
			super.exitSystem();

	}
	
}
