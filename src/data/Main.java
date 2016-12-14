package data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		print();
	}
	
	
	public static void print() throws SQLException, IOException{
		String top="档案管理";
		String tip_login="1.登陆系统";
		String tip_logout="2.退出系统";
		System.out.println("****************\n欢迎进入"+top+'\n'
				+tip_login+'\n'
				+tip_logout+'\n'+"****************");
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		if(num==1){
			System.out.println("1.请输入你的姓名");
			String temp1=in.next();
			System.out.println("2.请输入你的密码");
			String temp2=in.next();
			User temp=DataProcessing.searchUser(temp1, temp2);
			if(temp==null){
				System.out.println("查无此人!");
				System.exit(0);
				}
			//System.out.println(temp.getRole());
			int num_a,num_b,num_c;
			if(temp.getRole()=="browser")
			{
				Browser temp_a=new Browser(temp1,temp2,temp.getRole());
				do{
					temp_a.showMenu();
					num_a=in.nextInt();
					temp_a.runMenu(num_a);
				}while(num_a>0);
			}
			else if(temp.getRole()=="operator")
			{
				Operator temp_b=new Operator(temp1,temp2,temp.getRole());
				do{
					temp_b.showMenu();
					num_b=in.nextInt();
					temp_b.runMenu(num_b);
					}while(num_b>0);
			}
			else if(temp.getRole()=="administrator")
			{
				Administrator temp_c=new Administrator(temp1,temp2,temp.getRole());
				do{
					temp_c.showMenu();
					num_c=in.nextInt();
					temp_c.runMenu(num_c);
				}while(num_c>0);
			}
			
		}
	}

}
