import java.util.*;

public class Browser extends User{
	
	Browser(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****欢迎进入档案浏览员菜单****\n");
		System.out.println("1.下载文件"
				+ "\n2.文件列表"
				+ "\n3.修改密码"
				+ "\n4.退出");
		System.out.println("****************************\n请选择菜单");
	}

	public void runMenu(int num) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		if(num==1){
			System.out.println("请输入要下载的文件名称");
			String filename=in.next();
			super.downloadFile(filename);
		}
		else if(num==2){
			super.showFileList();
		}
		else if(num==3){
			System.out.println("请输入要修改的密码");
			String password=in.next();
			super.setPassword(password);
		}
		else if(num==4){
			super.exitSystem();
		}
	}
}
