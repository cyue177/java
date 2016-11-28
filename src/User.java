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
		//д�û���Ϣ���洢
		try {
			if (DataProcessing.updateUser(name, password, role)){
				this.password=password;
				System.out.println("�޸ĳɹ�");
				return true;
			}else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�޸Ĳ��ɹ��������ԣ�");
			this.changeUserInfo(password);
		}
		return true;
	}
	
	public abstract void showMenu();
	
	public boolean downloadFile(String filename) throws IOException, SQLException{
		
		System.out.println("�����ļ�");
		System.out.println("��������Ҫ���ص��ļ���ţ�");
		Scanner in=new Scanner(System.in);
		String id=in.next();
		System.out.println("������Ҫ���ص���·��");
		String path=in.next();
		DataProcessing.searchDoc(id);
		
		return true;
	}
	
	public void showFileList() throws SQLException{
		System.out.println("�ļ��б�");
		Enumeration<Doc> e = DataProcessing.getAllDocs();
		System.out.println("id\tcreator\ttimestamp\t\tdescription\tfilename");
		while(e.hasMoreElements()){
			Doc a = e.nextElement();
			System.out.println(a.getID()+"\t"+a.getCreator()+"\t"+a.getTimestamp()+"\t\t"+a.getDescription()+"\t"+a.getFilename());;
		}
	}
	
	public void exitSystem(){
		System.out.println("ϵͳ�˳�, ллʹ�� ! ");
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