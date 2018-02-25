package com.tsy.cl.main.role_menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tsy.cl.util.BasicDao;


public class RMDao extends BasicDao {
	
	public boolean savesuperone(int menu_id) {
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into role_menu values(1,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, menu_id);
			
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
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

	public boolean save(String[] ids,int rid){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into role_menu values(?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			for (String id : ids) {
				
				preparedStatement.setInt(1, rid);
				preparedStatement.setInt(2,Integer.parseInt(id));
				
				preparedStatement.addBatch();
				
			}
			
			preparedStatement.executeBatch();
			
			connection.commit();
			
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
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
	
	/*
	 * É¾³ý
	 */
	public boolean remove(int rid){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "delete from role_menu where rid=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, rid);
				
			preparedStatement.executeUpdate();
			
			connection.commit();
			
			return true;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
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
