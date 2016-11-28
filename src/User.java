import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

public abstract class User {
	private String name;
	private String password;
	private String role;
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	
	public boolean changeUserInfo(String password) {
		//写用户信息到存储
		try {
			if (DataProcessing.updateUser(name, password, role)){
				this.password=password;
				System.out.println("修改成功");
				return true;
			}else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改不成功，请重试！");
			this.changeUserInfo(password);
		}
		return true;
	}
	
	public abstract void showMenu();
	
	public boolean downloadFile(String filename) throws IOException, SQLException{
		
		System.out.println("下载文件");
		System.out.println("请输入你要下载的文件编号：");
		Scanner in=new Scanner(System.in);
		String id=in.next();
		System.out.println("请输入要下载到的路径");
		String path=in.next();
		DataProcessing.searchDoc(id);
		
		return true;
	}
	
	public void showFileList() throws SQLException{
		System.out.println("文件列表");
		Enumeration<Doc> e = DataProcessing.getAllDocs();
		System.out.println("id\tcreator\ttimestamp\t\tdescription\tfilename");
		while(e.hasMoreElements()){
			Doc a = e.nextElement();
			System.out.println(a.getID()+"\t"+a.getCreator()+"\t"+a.getTimestamp()+"\t\t"+a.getDescription()+"\t"+a.getFilename());;
		}
	}
	
	public void exitSystem(){
		System.out.println("系统退出, 谢谢使用 ! ");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}