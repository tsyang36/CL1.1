package com.tsy.cl.main.addr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.util.BasicDao;


public class JlDao extends BasicDao{
	
	public List<Object[]> getProvince(){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<Object[]> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select provinceId,provinceName from province";
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<Object[]>();
			
			while(resultSet.next()){
				
				Object[] object ={resultSet.getInt(1),resultSet.getString(2)};
				list.add(object);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		return list;
		
	}
	
 public List<Object[]> getCity(int province){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<Object[]> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select cityId,cityName from City  where provinceId=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, province);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<Object[]>();
			
			while(resultSet.next()){
				
				Object[] object ={resultSet.getInt(1),resultSet.getString(2)};
				list.add(object);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		return list;
		
	}
 
 public List<Object[]> getdistrict(int cityId){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<Object[]> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select districtId,districtName from district  where cityId=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, cityId);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<Object[]>();
			
			while(resultSet.next()){
				
				Object[] object ={resultSet.getInt(1),resultSet.getString(2)};
				list.add(object);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		return list;
		
	}
}
