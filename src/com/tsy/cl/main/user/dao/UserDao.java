package com.tsy.cl.main.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.user.bena.UserBean;
import com.tsy.cl.util.BasicDao;


public class UserDao extends BasicDao {
	
	/**
	 * 
	 * @Description: 娣诲姞
	 * @param userBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017骞�8鏈�23鏃� 涓婂崍10:18:23
	 */
	public boolean save(UserBean userBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into user(user_tel,user_email,user_password) values(?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, userBean.getUser_tel());
			
			preparedStatement.setString(2, userBean.getUser_email());
			
			preparedStatement.setString(3, userBean.getUser_password());
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
		
		
	}
	
	public UserBean findTelEmaAndPwd(UserBean userBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet  resultSet =null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select * from user where (user_tel=? or user_email=?) and user_password=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, userBean.getUser_tel());
			
			preparedStatement.setString(2, userBean.getUser_email());
			
			preparedStatement.setString(3, userBean.getUser_password());
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				//	System.out.println(resultSet);
				 userBean = new UserBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
				 return userBean;
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	

	public List<UserBean> getPage(String user_teloremail,int begin, int size){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet  = null;
		List<UserBean> list = null;
		try {
			connection=getConnection(true);
			String sql = "select * from user where (user_tel like ? or user_email like ?) order by usesr_id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_teloremail);
			preparedStatement.setString(2, user_teloremail);
			preparedStatement.setInt(3, begin);
			preparedStatement.setInt(4, size);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<>();
			while(resultSet.next()){
				UserBean userBean = new UserBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));;
				list.add(userBean);
			}
			return list;
		} catch (Exception e) {e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
			return list;
		
	}

	public void updatepassword(String user_password,int user_id) {
		// TODO Auto-generated method stub

		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "update user set user_password = ? where user_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user_password);
			
			preparedStatement.setInt(2, user_id);
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	public boolean isexist(String TelorEamil) {
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select * from user where user_tel = ? or user_email = ?";
			//String sql = "insert into user(user_tel,user_email,user_password) values(?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, TelorEamil);
			
			preparedStatement.setString(2, TelorEamil);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				return true;
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
		
		
	}
	
	
	
	
}
