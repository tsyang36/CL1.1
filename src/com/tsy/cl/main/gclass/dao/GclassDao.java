package com.tsy.cl.main.gclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.gclass.bena.GclassBean;
import com.tsy.cl.util.BasicDao;


public class GclassDao extends BasicDao {
	
	/**
	 * 
	 * @Description: 濞ｈ濮�
	 * @param roleBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Xiao_Ming Liu
	 * @date 2017楠烇拷8閺堬拷21閺冿拷 娑撳宕�2:21:15
	 */
    public boolean save(String gclass_name){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into gclass(gclass_name) values(?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,gclass_name);
			
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
			
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
		return false;
		
		
	}
    
    
    public List<Integer> getIdArr(){
    	Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<Integer> arr = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select gclass_id from gclass";
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet=preparedStatement.executeQuery();
			arr = new ArrayList<>();
			while(resultSet.next()){
				arr.add(resultSet.getInt(1));
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		return arr;
    	
    }
    
    /**
     * 
     * @Description: 閸熷棗鎼ч崚鍡欒閸掑棝銆�
     * @param rname
     * @param begin
     * @param size
     * @return   
     * List<RoleBean>  
     * @throws
     * @author Xiao_Ming Liu
     * @date 2017楠烇拷8閺堬拷21閺冿拷 娑撳宕�2:23:50
     */
    public List<GclassBean> getPage(String gclass_name ,int begin,int size){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<GclassBean> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select * from gclass where gclass_name like ? order by gclass_id desc limit ?,?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, gclass_name);
			
			preparedStatement.setInt(2, begin);
			
			preparedStatement.setInt(3, size);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<GclassBean>();
			
			while(resultSet.next()){
				
				GclassBean gclassBean = new GclassBean(resultSet.getInt(1),resultSet.getString(2));
				
				list.add(gclassBean);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
		return list;
		
	}
    /**
     * 
     * @Description: 閺屻儴顕楅幀鏄忣唶瑜版洘鏆�
     * @param rname
     * @return   
     * int  
     * @throws
     * @author Xiao_Ming Liu
     * @date 2017楠烇拷8閺堬拷21閺冿拷 娑撳宕�2:23:36
     */
    public int getCount(String gclass_name){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select count(*) from gclass where gclass_name like ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, gclass_name);
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
		return 0;
		
	}
    /**
     * 
     * @Description: 閺嶈宓両D閺屻儲澹�
     * @param id
     * @return   
     * AdminBean  
     * @throws
     * @author Xiao_Ming Liu
     * @date 2017楠烇拷8閺堬拷21閺冿拷 娑撳宕�2:24:29
     */
    public GclassBean findById(int gclass_id){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select * from gclass where gclass_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, gclass_id);
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				GclassBean gclassBean = new GclassBean(resultSet.getInt(1),resultSet.getString(2));				
				return gclassBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
		return null;
		
	}
    /**
     * 
     * @Description: 閺囧瓨鏌�
     * @param roleBean
     * @return   
     * boolean  
     * @throws
     * @author Xiao_Ming Liu
     * @date 2017楠烇拷8閺堬拷21閺冿拷 娑撳宕�2:26:40
     */
    public boolean modify(GclassBean gclassBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "update gclass set gclass_name=?  where gclass_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,gclassBean.getGclass_name());
			
			preparedStatement.setInt(2, gclassBean.getGclass_id());
			
			
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
			
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
		return false;
		
		
	}
    /**
     * 
     * @Description: 閹靛綊鍣洪崚鐘绘珟閵嗕礁宕熼幐鎴濆灩闂勶拷
     * @param ids
     * @return   
     * boolean  
     * @throws
     * @author Xiao_Ming Liu
     * @date 2017楠烇拷8閺堬拷21閺冿拷 娑撳宕�2:27:27
     */
    public boolean remove(String[] gclass_ids){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "delete from gclass where gclass_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			for (String gclass_id : gclass_ids) {

				preparedStatement.setInt(1,Integer.parseInt(gclass_id));
				
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
			
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
		return false;
		
		
	}
}
