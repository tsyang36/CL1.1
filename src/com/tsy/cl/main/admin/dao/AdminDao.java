package com.tsy.cl.main.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.admin.bean.AdminBean;
import com.tsy.cl.util.BasicDao;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * 
 * @Title: AdminDao.java
 * @Package com.zrycx.millet.admin.admin.dao
 * @Description: Admin表的增删改查
 * @author Tang
 * @date 2017年8月16日 下午3:46:49
 * @version 1.0
 */
public class AdminDao extends BasicDao{
	/*public static void main(String[] args) {
		AdminDao adminDao = new AdminDao();
		for (int i = 0; i < 100; i++) {
			adminDao.save(new AdminBean("tsy"+i+"@qq.com","123345",1,"1"));
		}
	}*/
	
	/**
	 * 
	 * @Description: 校验用户名密码是否正确
	 * @return   
	 * AdminBean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月16日 下午3:59:42
	 */
	public AdminBean findByUserAndPwd(String teloremail, String admin_password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
			String sql  = "select * from admin where (admin_tel = ? or admin_email = ? ) and admin_password = md5(?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teloremail);
			preparedStatement.setString(2, teloremail);
			preparedStatement.setString(3, admin_password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return new AdminBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
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
	
	/**
	 * 
	 * @Description:通过id查找数据
	 * @param id
	 * @return   
	 * AdminBean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月18日 下午3:02:14
	 */
	public AdminBean findById(String admin_id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
			String sql  = "select * from admin where admin_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(admin_id));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return new AdminBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
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
	
	
	
	/**
	 * 
	 * @Description: 添加管理员
	 * @param adminBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月17日 下午8:09:33
	 */
	public boolean save(AdminBean adminBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "insert into admin (admin_tel,admin_email,admin_password,admin_state,role_id) values(?,?,md5(?),?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminBean.getAdmin_tel());
			preparedStatement.setString(2, adminBean.getAdmin_email());
			preparedStatement.setString(3, adminBean.getAdmin_password());
			preparedStatement.setString(4, adminBean.getAdmin_state());
			preparedStatement.setInt(5, adminBean.getRole_id());
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
	 * @Description: 删除管理员
	 * @param adminBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Tang
	 * @date 2017年8月18日 上午9:44:53
	 */
	public boolean delete(String[] admin_ids){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "delete from admin where admin_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			for (String id : admin_ids) {
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
	
	public int getcount(String admin_teloremail){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=getConnection(true);
			String sql = "select count(*) from admin where admin_tel like ? or admin_email like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,admin_teloremail);
			preparedStatement.setString(2,admin_teloremail);
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
	 * @Description: 分页
	 * @param auser
	 * @param begin
	 * @param size
	 * @return   
	 * List<AdminBean>  
	 * @throws
	 * @author Tang
	 * @date 2017年8月17日 下午8:10:32
	 */
	public List<AdminBean> getPage(String admin_teloremail,int begin, int size){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet  = null;
		List<AdminBean> list = null;
		try {
			connection=getConnection(true);
			String sql = "select * from admin where (admin_tel like ? or admin_email like ?) order by admin_id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin_teloremail);
			preparedStatement.setString(2, admin_teloremail);
			preparedStatement.setInt(3, begin);
			preparedStatement.setInt(4, size);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<>();
			while(resultSet.next()){
				AdminBean adminBean =new AdminBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));;
				list.add(adminBean);
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
	
	public void blockByroleid(int role_id) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "update admin set admin_state = 1 where role_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, role_id);
			
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
	
	public boolean update(String pwd,String role_id,String admin_state,String admin_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection=getConnection(false);
			String sql = "update admin set admin_password=md5(?),role_id=?,admin_state=? where admin_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pwd);
			
			preparedStatement.setInt(2, Integer.parseInt(role_id));
			
			preparedStatement.setString(3, admin_state);
			
			preparedStatement.setInt(4, Integer.parseInt(admin_id));
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

	public boolean onlyTelAndEmail(String admin_tel, String admin_email) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection(true);
			String sql  = "select * from admin where admin_tel = ? or admin_email = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin_tel);
			preparedStatement.setString(2, admin_email);
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
