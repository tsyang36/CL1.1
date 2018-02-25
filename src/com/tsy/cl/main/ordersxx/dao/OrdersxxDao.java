package com.tsy.cl.main.ordersxx.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.main.orders.bena.OrderBean;
import com.tsy.cl.main.ordersxx.bena.OrdersxxBean;
import com.tsy.cl.main.user.bena.UserBean;
import com.tsy.cl.util.BasicDao;


public class OrdersxxDao extends BasicDao{
	
	public boolean save(OrdersxxBean ordersxxBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into ordersxx(orders_id,goods_id,goods_number) values(?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,ordersxxBean.getOrders_id());
			
			preparedStatement.setInt(2,ordersxxBean.getGoods_id());
			
			preparedStatement.setInt(3,ordersxxBean.getGoods_number());
			
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
	
	public List<OrderBean> getpage(int user_id){
		List<OrderBean> listob = null;
		
		List<GoodsBean> listgb = null;
		
		//List<List<OrderBean>> list = null;
		
		OrderBean orderBean = new OrderBean();
		
		GoodsBean goodsBean = new GoodsBean();
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		
		try {
			connection = getConnection(false);
			
			String sql = "SELECT o1.orders_code,o1.orders_time,o1.orders_state,o2.goods_number,g.goods_price,g.goods_image,g.goods_desc,g.goods_name,o1.orders_id FROM (orders o1 LEFT JOIN ordersxx o2 on o1.orders_id=o2.orders_id) LEFT JOIN goods g on o2.goods_id=g.goods_id WHERE o1.user_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,user_id);

			resultSet =  preparedStatement.executeQuery();
			
			connection.commit();
			
			BigDecimal orders_sumprice = new BigDecimal(0);
			boolean first = true;
			int orders_id = 0;
			String orders_code = null;
			Timestamp orders_time = null ;
			String orders_state = null;
			
			listob = new ArrayList<>();
			listgb = new ArrayList<>();
			//list = new ArrayList<>();
			
			
			
			while(resultSet.next()){
				int goods_number =resultSet.getInt(4);//��Ʒ����
				BigDecimal goods_price = resultSet.getBigDecimal(5);//�۸�
				String goods_image = resultSet.getString(6);//ͼƬ
				String goods_desc = resultSet.getString(7);//����
				String goods_name = resultSet.getString(8);//����
				BigDecimal goods_sumprice= goods_price.multiply(new BigDecimal(goods_number));//��Ʒ�ܼ�
				
				
				if(first || orders_code.equals(resultSet.getString(1))){
					first =false;
					orders_sumprice = orders_sumprice.add(goods_sumprice);//�����ܼ�
					orders_code = resultSet.getString(1);//������
					orders_time = resultSet.getTimestamp(2);//ʱ��
					orders_state = resultSet.getString(3);//״̬
					orders_id = resultSet.getInt(9);//״̬
					goodsBean.setGoods_number(goods_number);
					goodsBean.setGoods_price(goods_price);
					goodsBean.setGoods_image(goods_image);
					goodsBean.setGoods_desc(goods_desc);
					goodsBean.setGoods_name(goods_name);
					listgb.add(goodsBean);
					goodsBean = new GoodsBean();
				}else{
					orderBean.setOrders_sumprice(orders_sumprice);
					orderBean.setOrder_code(orders_code);
					orderBean.setOrder_id(orders_id);
					orderBean.setOrder_time(orders_time);
					orderBean.setOrder_state(orders_state);
					orderBean.setGoodsBeans(listgb);
					listob.add(orderBean);
					orderBean = new OrderBean();
					//list.add(listob);
					listgb = new ArrayList<>();
					//listob = new ArrayList<>();
					
					goodsBean.setGoods_number(goods_number);
					goodsBean.setGoods_price(goods_price);
					goodsBean.setGoods_image(goods_image);
					goodsBean.setGoods_desc(goods_desc);
					goodsBean.setGoods_name(goods_name);
					listgb.add(goodsBean);
					goodsBean = new GoodsBean();
					
					goods_sumprice= goods_price.multiply(new BigDecimal(goods_number));//��Ʒ�ܼ�
					orders_sumprice = goods_sumprice;//�����ܼ�
					orders_code = resultSet.getString(1);//������
					orders_id = resultSet.getInt(9);//������
					orders_time = resultSet.getTimestamp(2);//ʱ��
					orders_state = resultSet.getString(3);//״̬
				}
				
			}
			orderBean.setOrders_sumprice(orders_sumprice);
			orderBean.setOrder_code(orders_code);
			orderBean.setOrder_id(orders_id);
			orderBean.setOrder_time(orders_time);
			orderBean.setOrder_state(orders_state);
			orderBean.setGoodsBeans(listgb);
			listob.add(orderBean);
			orderBean = new OrderBean();
			//list.add(listob);
			
			return listob;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
			
		}
		
		return listob;
		
		
	}

	public List<GoodsBean> getPageByOrderId(int orders_id) {

		List<GoodsBean> Myordersxxlist = null;
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		
		try {
			connection = getConnection(false);
			
			String sql = "SELECT g.goods_name,o.goods_number,g.goods_price from ordersxx o LEFT JOIN goods g on o.goods_id = g.goods_id where o.orders_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,orders_id);

			resultSet =  preparedStatement.executeQuery();
			
			connection.commit();
			
		/*	BigDecimal orders_sumprice = new BigDecimal(0);
			boolean first = true;
			String orders_code = null;
			Timestamp orders_time = null ;
			String orders_state = null;*/
			
			Myordersxxlist = new ArrayList<>();
			//list = new ArrayList<>();
			
			
			
			while(resultSet.next()){
				String goods_name = resultSet.getString(1);
				int goods_number =resultSet.getInt(2);
				BigDecimal goods_price = resultSet.getBigDecimal(3);
				GoodsBean goodsBean = new GoodsBean();
				goodsBean.setGoods_name(goods_name);
				goodsBean.setGoods_number(goods_number);
				goodsBean.setGoods_price(goods_price);
				Myordersxxlist.add(goodsBean);
			}
			
			return Myordersxxlist;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
			
		}
		
		return Myordersxxlist;
		
		
	
	}

	

}
