package com.tsy.cl.main.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.car.bean.CarBean;
import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.util.BasicDao;


public class CarDao extends BasicDao {
	
	/**
	 * 
	 * @Description: int[0] = 鐠愵厾澧挎潪锕�鏅㈤崫浣癸拷缁樻殶    int[1]= 閹鐜弽锟�
	 * @param uid
	 * @return   
	 * int[]  
	 * @throws
	 * @author Xiao_Ming Liu
	 * @date 2017楠烇拷8閺堬拷23閺冿拷 娑撳宕�4:54:15
	 */
	public int[] getsum(int user_id){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select count(*),sum(goods_number*goods_price) from car c LEFT JOIN goods g on c.goods_id=g.goods_id where user_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, user_id);
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				return new int[]{resultSet.getInt(1),resultSet.getInt(2)};
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
	
	 public boolean save(CarBean carBean){
			
			Connection connection = null;
			
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection(false);
				
				String sql = "insert into car(user_id,goods_id,goods_number) values(?,?,?)";
				
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1,carBean.getUser_id());
				preparedStatement.setInt(2,carBean.getGoods_id());
				preparedStatement.setInt(3,carBean.getGoods_number());
				
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
	  * @Description: 閺屻儲澹樼拠銉ф暏閹寸柉鍠橀悧鈺勬簠閺勵垰鎯佺�涙ê婀ǎ璇插閸熷棗鎼�
	  * @param uid
	  * @param gId
	  * @return   
	  * CarBean  
	  * @throws
	  * @author Xiao_Ming Liu
	  * @date 2017楠烇拷8閺堬拷23閺冿拷 娑撳宕�3:58:34
	  */
	 public CarBean findByUidAndGid(int user_id,int goods_id){
		 
		 Connection connection = null;
		 
		 PreparedStatement preparedStatement = null;
		 
		 ResultSet resultSet =null;
		 
		 try {
			connection = getConnection(true);
			 
			 String sql ="select * from car where user_id=? and goods_id=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setInt(1, user_id);
			 preparedStatement.setInt(2, goods_id);
			 
			 resultSet=preparedStatement.executeQuery();
			 
			 if(resultSet.next()){
				 
				 CarBean carBean = new CarBean(resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4));
				 
				 return carBean;
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
	  * @Description:娣囶喗鏁奸弫浼村櫤
	  * @param carBean
	  * @return   
	  * boolean  
	  * @throws
	  * @author Xiao_Ming Liu
	  * @date 2017楠烇拷8閺堬拷23閺冿拷 娑撳宕�4:02:43
	  */
	 public boolean modify(CarBean carBean){
			
			Connection connection = null;
			
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection(false);
				
				String sql = "update car set goods_number=? where user_id=? and goods_id=?";
				
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1,carBean.getGoods_number());
				
				preparedStatement.setInt(2,carBean.getUser_id());
				
				preparedStatement.setInt(3,carBean.getGoods_id());
				
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
	 
	 public boolean remove(int user_id,int goods_id){
			
			Connection connection = null;
			
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection(false);
				
				String sql = "delete from car where user_id=? and goods_id=?";
				
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1,user_id);
				preparedStatement.setInt(2,goods_id);
				
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
	 
	 public boolean removeall(int user_id){
		 
		 Connection connection = null;
		 
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 connection = getConnection(false);
			 
			 String sql = "delete from car where user_id=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setInt(1,user_id);
			 
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
	  * @Description: 閺屻儴顕楅悽銊﹀煕鐠愵厾澧挎潪锕傚櫡闂堛垻娈戦幍锟介張澶婃櫌閸濓拷
	  * @param userId
	  * @return   
	  * List<CarBean>  
	  * @throws
	  * @author Xiao_Ming Liu
	  * @date 2017楠烇拷8閺堬拷23閺冿拷 娑撳宕�4:13:13
	  */
	 public  List<CarBean>  findByUserId(int userId){
		 
		 Connection connection = null;
		 
		 PreparedStatement preparedStatement = null;
		 
		 ResultSet resultSet =null;
		 
		 List<CarBean> list = null;
		 
		 try {
			connection = getConnection(true);
			 
			 String sql ="select c.goods_number,g.goods_id,g.goods_name,g.goods_image,g.goods_price,g.goods_desc from car c left join goods g on c.goods_id=g.goods_id where c.user_id=?";
			 
			 preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setInt(1, userId);
			 
			 resultSet=preparedStatement.executeQuery();
			 
			 list =new ArrayList<CarBean>();
			 
			 while(resultSet.next()){
				 
				 CarBean carBean = new CarBean();
				 
				 carBean.setGoods_number(resultSet.getInt(1));
				 
				 GoodsBean goodsBean = new GoodsBean();
				 
				 goodsBean.setGoods_id(resultSet.getInt(2));
				 
				 goodsBean.setGoods_name(resultSet.getString(3));
				 
				 goodsBean.setGoods_image(resultSet.getString(4));
				 
				 goodsBean.setGoods_price(resultSet.getBigDecimal(5));
				 
				 goodsBean.setGoods_desc(resultSet.getString(6));
				 
				 carBean.setGoodsBean(goodsBean);
				 
				 list.add(carBean);
				 
				
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
}
