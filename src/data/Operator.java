package data;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.lang.*;

public class Operator extends User{

	Operator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showMenu() {
		System.out.println("***欢迎进入档案录入人员入口***");
		System.out.println("1.下载文件"
				+ "\n2.上传文件"
				+ "\n3.文件列表"
				+ "\n4.修改密码"
				+ "\n5.退        出");
		
	}

	public void runMenu(int num) throws SQLException{
		Scanner in=new Scanner(System.in);
		if(num==2){
			System.out.println("请输入文件路径");
			String file_path=in.next();
			System.out.println("请输入文件编号");
			String id=in.next();
			System.out.println("请输入创建者姓名");//??
			String creator=in.next();
			System.out.println("描述");
			String description=in.next();
			String fileName = file_path.substring(file_path.lastIndexOf("\\")+1);
			DataProcessing.insertDoc(id, creator, new Timestamp(System.currentTimeMillis()), description, fileName);
//			System.out.println("");
			try {
				FileInputStream fis=new FileInputStream(file_path);
				FileOutputStream fos=new FileOutputStream(super.getUpload()+fileName);
				byte[] buf = new byte[1024];
				int by = 0;
				while ((by = fis.read(buf)) != -1) {
				fos.write(buf, 0, by);}
				fis.close();
				fos.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				this.runMenu(num);
			} catch (IOException e) {
				e.printStackTrace();
				this.runMenu(num);
			}
			
			System.out.println("上传文件... ...");
		}
		else if(num==1){
			super.downloadFile();
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
