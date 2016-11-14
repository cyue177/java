import java.util.*;
public class Operator extends User{

	Operator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("***欢迎进入档案录入人员入口***");
		System.out.println("1.下载文件"
				+ "\n2.上传文件"
				+ "\n3.文件列表"
				+ "\n4.修改密码"
				+ "\n5.退        出");
		
	}

	public void runMenu(int num) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		if(num==2){
			System.out.println("请输入文件路径");
			String file_name=in.next();
			System.out.println("上传文件... ...");
		}
		else if(num==1){
			System.out.println("请输入你要下载的文件");
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
