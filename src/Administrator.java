import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User{

	Administrator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("****欢迎进入管理人员菜单****"
				+ "\n1.修改用户"
				+ "\n2.删除用户"
				+ "\n3.新增用户"
				+ "\n4.列出用户"
				+ "\n5.下载文件"
				+ "\n6.文件列表"
				+ "\n7.修改（本人）密码"
				+ "\n8.退        出"
				+ "\n****************");
			}
	public void runMenu(int num){
		Scanner in=new Scanner(System.in);
		if(num==1){
			System.out.println("请输入用户名：");
			String name=in.next();
			System.out.println("请输入口令：");
			String pwd=in.next();
			System.out.println("请输如用户种类：");
			String role=in.next();
			if(!DataProcessing.update(name,pwd,role)){
				System.out.println("不存在此用户！");
			}
		}
		if(num==2){
			System.out.println("请输入要删除的名字：");
			String name=in.next();
			if(DataProcessing.delete(name))
				System.out.println("删除成功");
			else System.out.println("删除失败");
		}
		if(num==3){
			System.out.println("请输入要加入的用户名：");
			String str1=in.next();
			System.out.println("请输入密码：");
			String str2=in.next();
			System.out.println("请输入用户类型：");
			String str3=in.next();
			if(DataProcessing.insert(str1, str2, str3))
			{
				System.out.println("添加成功！");
			}
			else System.out.println("用户已存在！");
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
			System.out.println("请输入要下载的文件：");
			String file_name=in.next();
			if(super.downloadFile(file_name)==false){
				System.out.println("没有查到此文件或者无法下载");
			}
			
		}
		if(num==6)
			super.showFileList();
		if(num==7){
			System.out.println("请输入要修改的密码");
			String pwd=in.next();
			super.changeUserInfo(pwd);
		}
		if(num==8)
			super.exitSystem();

	}
	
}
