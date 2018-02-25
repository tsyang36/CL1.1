package com.tsy.cl.main.addr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.addr.bena.AddrBean;
import com.tsy.cl.util.BasicDao;



public class AddrDao extends BasicDao{
	/**
	 * 
	 * @Description: 添加地址
	 * @param addrBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月24日 下午3:04:59
	 */
	public boolean save(AddrBean addrBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "insert into addr(addr_name,addr_province,addr_city,addr_district,addrxx,tel,youbian,user_id) values(?,(select provinceName from province where provinceId=?),(select cityName from city where cityId=?),(select districtName from district where districtId=?),?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addrBean.getAddr_name());
			preparedStatement.setString(2, addrBean.getAddr_province());
			preparedStatement.setString(3, addrBean.getAddr_city());
			preparedStatement.setString(4, addrBean.getAddr_district());
			preparedStatement.setString(5, addrBean.getAddrxx());
			preparedStatement.setString(6, addrBean.getTel());
			preparedStatement.setString(7, addrBean.getYoubian());
			preparedStatement.setInt(8, addrBean.getUser_id());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	public void updateaddr(AddrBean addrBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
						//insert into addr(addr_name,addr_province,addr_city,addr_district,addrxx,tel,youbian,user_id) values(?,(select provinceName from province where provinceId=?),(select cityName from city where cityId=?),(select districtName from district where districtId=?),?,?,?,?)
			String sql = "update addr set addr_name =?,addr_province =(select provinceName from province where provinceId=?),addr_city=(select cityName from city where cityId=?),addr_district=(select districtName from district where districtId=?),addrxx=?,tel=?,youbian=?,user_id=? where addr_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addrBean.getAddr_name());
			preparedStatement.setString(2, addrBean.getAddr_province());
			preparedStatement.setString(3, addrBean.getAddr_city());
			preparedStatement.setString(4, addrBean.getAddr_district());
			preparedStatement.setString(5, addrBean.getAddrxx());
			preparedStatement.setString(6, addrBean.getTel());
			preparedStatement.setString(7, addrBean.getYoubian());
			preparedStatement.setInt(8, addrBean.getUser_id());
			preparedStatement.setInt(9, addrBean.getAddr_id());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public boolean del(String addr_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "delete from addr where addr_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(addr_id));
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	/**
	 * 
	 * @Description: 查询该用户的所有地址
	 * @param user_id
	 * @return   
	 * List<AddrBean>  
	 * @throws
	 * @author Tang
	 * @date 2017年8月24日 下午7:18:26
	 */
	public List<AddrBean> getPage(int user_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AddrBean> list = null;
		try {
			connection = getConnection(true);
			String sql = "select * from addr where user_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<AddrBean>();
			while(resultSet.next()){
				AddrBean addrBean = new AddrBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4), resultSet.getString(5),resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9));
				list.add(addrBean);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	
	
	
	
	public AddrBean getoneaddr(String addr_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		AddrBean addrBean = null;
		try {
			connection = getConnection(true);
			String sql = "select * from addr where addr_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(addr_id));
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				addrBean = new AddrBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4), resultSet.getString(5),resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9));
			}
			return addrBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return addrBean;
	}
	

}
