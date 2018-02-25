package com.tsy.cl.main.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.role.bean.RoleBean;
import com.tsy.cl.util.BasicDao;


public class RoleDao extends BasicDao{
	/*public static void main(String[] args) {
		RoleDao roleDao = new RoleDao();
		RoleBean roleBean = new RoleBean("超级管理员","1");
		//roleDao.save(roleBean);
		//roleDao.update("1", "普通管理员", "0");
		//System.out.println(roleDao.getcount("超级管理员"));
		//roleDao.delete(new String[]{"3"});
		//System.out.println(roleDao.findById("1"));
	}*/
	
	/**
	 * 
	 * 
	 * @Description: 添加角色
	 * @param RoleBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月17日 下午8:09:33
	 */
	public boolean save(RoleBean roleBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "insert into role (role_name,role_state) values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, roleBean.getRole_name());
			preparedStatement.setString(2, roleBean.getRole_state());
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
	 * @Description: 分页
	 * @param rname
	 * @param begin
	 * @param size
	 * @return   
	 * List<RoleBean>  
	 * @throws
	 * @author Tang
	 * @date 2017年8月17日 下午8:10:32
	 */
	public List<RoleBean> getPage(String role_name,int begin, int size){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet  = null;
		List<RoleBean> list = null;
		try {
			connection=getConnection(true);
			String sql = "select * from role where role_name like ? order by role_id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, role_name);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, size);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<>();
			while(resultSet.next()){
				RoleBean roleBean = new RoleBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
				list.add(roleBean);
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
	
	/**
	 * 
	 * @Description: 更新修改
	 * @param id
	 * @param name
	 * @param state
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月21日 下午2:31:13
	 */
	public boolean update(String role_id,String role_name,String role_state){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "update role set role_name = ?,role_state = ? where role_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, role_name);
			preparedStatement.setString(2, role_state);
			preparedStatement.setInt(3, Integer.parseInt(role_id));
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
	 * @Description: 模糊查询得到数量
	 * @param rname
	 * @return   
	 * int  
	 * @throws
	 * @author Tang
	 * @date 2017年8月21日 下午2:31:33
	 */
	
	public int getcount(String role_name){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=getConnection(true);
			String sql = "select count(*) from role where role_name like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,role_name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	 * @Description: 删除角色
	 * @param RoleBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月18日 上午9:44:53
	 */
	public boolean delete(String[] role_ids){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "delete from role where role_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			for (String id : role_ids) {
				preparedStatement.setInt(1, Integer.parseInt(id));
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
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
	 * @Description:通过id查找数据
	 * @param id
	 * @return   
	 * RoleBean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月18日 下午3:02:14
	 */
	public RoleBean findById(String role_id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
			String sql  = "select * from role where role_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(role_id));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return new RoleBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
			return null;
		
	
	}

	public boolean onlyRoleName(String role_name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
			String sql  = "select * from role where role_name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, role_name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
			return false;
	}

	public boolean onlyRoleNameOtherId(String role_name, String role_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
			String sql  = "select * from role where role_name = ? and role_id != ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, role_name);
			preparedStatement.setString(2, role_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
			return false;
	}
}
