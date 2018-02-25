package com.tsy.cl.main.orders.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.orders.bena.OrderBean;
import com.tsy.cl.main.ordersxx.bena.OrdersxxBean;
import com.tsy.cl.util.BasicDao;


public class OrderDao extends BasicDao{
	
	
	public boolean save(OrderBean orderBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into orders(orders_code,user_id,orders_time,orders_state,addr_name,addr_province,addr_city,addr_district,addrxx,tel,youbian,sumprice) values(?,?,now(),?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,orderBean.getOrder_code());
			
			preparedStatement.setInt(2, orderBean.getUser_id());
			
			preparedStatement.setString(3, orderBean.getOrder_state());

			preparedStatement.setString(4, orderBean.getAddr_name());
			
			preparedStatement.setString(5, orderBean.getAddr_province());
			preparedStatement.setString(6, orderBean.getAddr_city());
			preparedStatement.setString(7, orderBean.getAddr_district());
			preparedStatement.setString(8, orderBean.getAddrxx());
			preparedStatement.setString(9, orderBean.getTel());
			preparedStatement.setString(10, orderBean.getYoubian());
			preparedStatement.setBigDecimal(11, orderBean.getOrders_sumprice());
			
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

	
	public int  findBycode(String order_code){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select orders_id from orders where orders_code=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,order_code);
			
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
	public BigDecimal  GetSumPriceBycode(int orders_id){
		
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "SELECT sum(ox.goods_number*g.goods_price)订单金额 FROM (orders o LEFT JOIN ordersxx ox on o.orders_id = ox.orders_id)LEFT JOIN goods g on ox.goods_id = g.goods_id GROUP BY o.orders_id having o.orders_id = ? ";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,orders_id);
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				return new BigDecimal(resultSet.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
			
		}
		
		return new BigDecimal(0);
		
	}

	
	public boolean modify(int order_id,String order_status){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "update orders set orders_state=? where orders_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, order_status);
			
			preparedStatement.setInt(2, order_id);
			
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


	public List<OrderBean> getpage(String order_code) {
		List<OrderBean> list = null;
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "SELECT orders_id,orders_code,orders_time,orders_state,user_id,addr_name,addr_province,addr_city,addr_district,addrxx,tel,youbian,sumprice from orders where orders_code like ? ORDER BY orders_time desc";
			/*String sql = "SELECT a.orders_id,a.orders_code,a.orders_time,a.orders_state,a.user_id,b.goods_number,c.addr_name,c.addr_province,c.addr_city,c.addr_district,c.addrxx,c.tel,c.youbian,d.goods_name FROM ((orders a LEFT JOIN ordersxx b on a.orders_id = b.orders_id) LEFT JOIN addr c on a.addr_id = c.addr_id)LEFT JOIN goods d on b.goods_id = d.goods_id where a.orders_code like ?";*/
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, order_code);
			resultSet=preparedStatement.executeQuery();
			list= new ArrayList<>();
			
			while(resultSet.next()){
				OrderBean orderBean = new OrderBean(resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getBigDecimal(13));
				/*OrderBean orderBean = new OrderBean(resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6),resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14));*/
				list.add(orderBean);
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


	public void updateSumpriceByOrderId(BigDecimal sumprice,int orderId) {
		// TODO Auto-generated method stub

		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = getConnection(true);
			
			String sql = "UPDATE orders SET sumprice = ? where orders_id =?";
			//String sql = "SELECT orders_id,orders_code,orders_time,orders_state,user_id,addr_name,addr_province,addr_city,addr_district,addrxx,tel,youbian,sumprice from orders where orders_code like ? ORDER BY orders_time desc";
			/*String sql = "SELECT a.orders_id,a.orders_code,a.orders_time,a.orders_state,a.user_id,b.goods_number,c.addr_name,c.addr_province,c.addr_city,c.addr_district,c.addrxx,c.tel,c.youbian,d.goods_name FROM ((orders a LEFT JOIN ordersxx b on a.orders_id = b.orders_id) LEFT JOIN addr c on a.addr_id = c.addr_id)LEFT JOIN goods d on b.goods_id = d.goods_id where a.orders_code like ?";*/
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setBigDecimal(1, sumprice);
			preparedStatement.setInt(2, orderId);
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	
		}
		
	
	}


}
