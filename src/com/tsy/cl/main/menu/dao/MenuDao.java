package com.tsy.cl.main.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.menu.bean.MenuBean;
import com.tsy.cl.util.BasicDao;


public class MenuDao extends BasicDao {
	
	

	public List<MenuBean> findByRid(int roleId){

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		List<MenuBean> list = null;

		try {
			connection = getConnection(true);

			String sql = "select * from menu where menu_id in(select mid from role_menu where rid=?)";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, roleId);

			resultSet=preparedStatement.executeQuery();

			list = new ArrayList<MenuBean>();

			while(resultSet.next()){

				MenuBean menuBean = new MenuBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));

				list.add(menuBean);
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
	
	public boolean save(MenuBean menuBean){

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection(false);

			String sql = "insert into menu(menu_name,menu_url,father_id) values(?,?,?)";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,menuBean.getMenu_name());

			preparedStatement.setString(2,menuBean.getMenu_url());

			preparedStatement.setInt(3, menuBean.getFather_id());

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

	public List<MenuBean> getPage(String menu_name ,int begin,int size){

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		List<MenuBean> list = null;

		try {
			connection = getConnection(true);

			String sql = "select * from menu where menu_name like ? order by menu_id desc limit ?,?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, menu_name);

			preparedStatement.setInt(2, begin);

			preparedStatement.setInt(3, size);

			resultSet=preparedStatement.executeQuery();

			list = new ArrayList<MenuBean>();

			while(resultSet.next()){

				MenuBean menuBean = new MenuBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));

				list.add(menuBean);
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

	public int getCount(String menu_name){

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {
			connection = getConnection(true);

			String sql = "select count(*) from menu where menu_name like ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, menu_name);

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

	public MenuBean findById(int menu_id){

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {
			connection = getConnection(true);

			String sql = "select * from menu where menu_id=?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, menu_id);

			resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){

				MenuBean menuBean = new MenuBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));

				return menuBean;
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

	public boolean modify(MenuBean menuBean){

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection(false);

			String sql = "update menu set menu_name=?,menu_url=?,father_id=? where menu_id=?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, menuBean.getMenu_name());

			preparedStatement.setString(2, menuBean.getMenu_url());

			preparedStatement.setInt(3, menuBean.getFather_id());

			preparedStatement.setInt(4, menuBean.getMenu_id());

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
	
	public boolean remove(String[] menu_ids){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "delete from menu where menu_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			for (String menu_id : menu_ids) {

				preparedStatement.setInt(1,Integer.parseInt(menu_id));
				
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
	/**
	 * 
	 * @Description: 鏍规嵁鐢ㄦ埛ID鏌ユ壘鑿滃崟
	 * @param auser
	 * @param begin
	 * @param size
	 * @return   
	 * List<AdminBean>  
	 * @throws
	 * @author Xiao_Ming Liu
	 * @date 2017骞�8鏈�21鏃� 涓嬪崍4:51:57
	 */
	/*public List<AdminBean> getPage(String auser ,int begin,int size){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<AdminBean> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select * from admin where auser like ? order by id desc limit ?,?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, auser);
			
			preparedStatement.setInt(2, begin);
			
			preparedStatement.setInt(3, size);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<AdminBean>();
			
			while(resultSet.next()){
				
				AdminBean adminBean =new AdminBean (resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
				
				list.add(adminBean);
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
		
	}*/

	public int getidbymenuBean(MenuBean menuBean) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;
		try {
			connection = getConnection(true);

			String sql = "select menu_id from menu where menu_name = ? and menu_url = ? and father_id=?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,menuBean.getMenu_name());

			preparedStatement.setString(2,menuBean.getMenu_url());

			preparedStatement.setInt(3, menuBean.getFather_id());

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				System.out.println(resultSet.getInt(1));
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

}
