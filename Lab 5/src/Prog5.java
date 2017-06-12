import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class Prog5 {
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton repButton = new JButton("Representative");
		JButton custButton = new JButton("Customer");
		JButton qButton = new JButton("Query Representative");
		repButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!inputRepresentative(frame)){
					System.out.println("Error creating Representative");
				}
			}
		});
		
		custButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!inputCustomer(frame)){
					System.out.println("Error creating Customer");
				}
			}
		});
		
		qButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				query(frame);
			}
		});
		
		
		repButton.setBounds(100,150,200, 40);
		custButton.setBounds(100,200,200, 40);
		qButton.setBounds(100,250,200, 40);
		
		frame.setLayout(null);
		frame.setSize(400,450);
		frame.setResizable(false);
		frame.add(repButton);
		frame.add(custButton);
		frame.add(qButton);
		frame.setVisible(true);
	}
	
	public static boolean inputCustomer(JFrame frame){
		String cust_no = JOptionPane.showInputDialog(frame, "Customer No.", "Customer", JOptionPane.QUESTION_MESSAGE);
		if(cust_no == null) return false;
		String cust_name = JOptionPane.showInputDialog(frame, "Cutomer name:", "Customer", JOptionPane.QUESTION_MESSAGE);
		if(cust_name == null) return false;
		String cust_state = JOptionPane.showInputDialog(frame, "Cutomer state:", "Customer", JOptionPane.QUESTION_MESSAGE);
		if(cust_state == null) return false;
		String cust_credit = JOptionPane.showInputDialog(frame, "Cutomer credit limt:", "Customer", JOptionPane.QUESTION_MESSAGE);
		if(cust_credit == null) return false;
		String cust_repNo = JOptionPane.showInputDialog(frame, "Rep number:", "Customer", JOptionPane.QUESTION_MESSAGE);
		if(cust_repNo == null) return false;
		String query_str = "insert into customer values("+Integer.parseInt(cust_no)
								+",'"+cust_name+"','"+cust_state+"',"+Integer.parseInt(cust_credit)
								+","+Integer.parseInt(cust_repNo)+")";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab5","root","root");
			if(con!=null)
			{
				st=con.createStatement();
				st.executeUpdate(query_str);
				System.out.println("Customer created");
				con.close();
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	
	
	public static boolean inputRepresentative(JFrame frame){
		String rep_no = JOptionPane.showInputDialog(frame, "Rep No.", "Representative", JOptionPane.QUESTION_MESSAGE);
		if(rep_no == null) return false;
		String rep_name = JOptionPane.showInputDialog(frame, "Rep name:", "Representative", JOptionPane.QUESTION_MESSAGE);
		if(rep_name == null) return false;
		String rep_state = JOptionPane.showInputDialog(frame, "Rep state:", "Representative", JOptionPane.QUESTION_MESSAGE);
		if(rep_state == null) return false;
		String rep_com = JOptionPane.showInputDialog(frame, "Rep comission:", "Representative", JOptionPane.QUESTION_MESSAGE);
		if(rep_com == null) return false;
		String rep_rate = JOptionPane.showInputDialog(frame, "Rep rate:", "Representative", JOptionPane.QUESTION_MESSAGE);
		if(rep_rate == null) return false;
		String query_str = "insert into representative values("+Integer.parseInt(rep_no)
								+",'"+rep_name+"','"+rep_state+"',"+Integer.parseInt(rep_com)
								+","+Float.parseFloat(rep_rate)+")";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab5","root","root");
			if(con!=null)
			{
				st=con.createStatement();
				st.executeUpdate(query_str);
				System.out.println("Representative created");
				con.close();
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static boolean query(JFrame frame){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab5","root","root");
			if(con!=null)
			{
				st=con.createStatement();
				String query = "select * from representative where repno in (select repno from customer where credit_limit >= 15000)";
				ResultSet rs = st.executeQuery(query);
				System.out.println("Resultset created");
				while(rs.next())
				{
					int num = rs.getInt(1);
					String name = rs.getString(2);
					System.out.println("Rep Num:\t"+num+",\tName:\t"+name);
				}
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
}

