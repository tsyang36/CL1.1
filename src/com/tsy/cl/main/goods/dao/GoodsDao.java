package com.tsy.cl.main.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.util.BasicDao;


public class GoodsDao extends BasicDao{
	
	
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
    public boolean save(GoodsBean goodsBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "insert into goods(goods_name,goods_Image,goods_price,goods_desc,gclass_id) values(?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,goodsBean.getGoods_name());
			preparedStatement.setString(2,goodsBean.getGoods_image());
			preparedStatement.setBigDecimal(3, goodsBean.getGoods_price());
			preparedStatement.setString(4,goodsBean.getGoods_desc());
			preparedStatement.setInt(5, goodsBean.getGclassId());
			
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

public List<GoodsBean> findByGclassId(int gclass_id ,int begin,int size){
		
		Connection connection = null;             
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<GoodsBean> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "SELECT g.*,gc.gclass_name from goods g LEFT JOIN gclass gc on gc.gclass_id = g.gclass_id WHERE  gc.gclass_id =? order by g.goods_id desc limit ?,?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, gclass_id);
			
			preparedStatement.setInt(2, begin);
			
			preparedStatement.setInt(3, size);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<GoodsBean>();
			
			while(resultSet.next()){
				
				GoodsBean goodsBean = new GoodsBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getBigDecimal(4),resultSet.getString(5),resultSet.getInt(6));
				
				list.add(goodsBean);
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
    
    public List<GoodsBean> getPage(String goods_name ,int begin,int size){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<GoodsBean> list = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select goods_id,goods_name,goods_Image,goods_price, goods_desc,gclass_id from goods where goods_name like ? order by goods_id desc limit ?,?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, goods_name);
			
			preparedStatement.setInt(2, begin);
			
			preparedStatement.setInt(3, size);
			
			resultSet=preparedStatement.executeQuery();
			
			list = new ArrayList<GoodsBean>();
			
			while(resultSet.next()){
				
				GoodsBean goodsBean = new GoodsBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getBigDecimal(4),resultSet.getString(5),resultSet.getInt(6));
				
				list.add(goodsBean);
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
    public int getCount(String goods_name){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			
			String sql = "select count(*) from goods where goods_name like ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, goods_name);
			
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
    public GoodsBean findById(int goods_id){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		
		try {
			connection = getConnection(true);
			
			String sql = "select * from goods where goods_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, goods_id);
			
			resultSet=preparedStatement.executeQuery();
			
			
			if(resultSet.next()){
				
				GoodsBean goodsBean = new GoodsBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getBigDecimal(4),resultSet.getString(5),resultSet.getInt(6));				
				return goodsBean;
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
    
   
    
    public List<GoodsBean> findByGclassId(int goods_id){
    	
    	Connection connection = null;
    	
    	PreparedStatement preparedStatement = null;
    	
    	ResultSet resultSet = null;
    	
    	List<GoodsBean> list = null;
    	
    	try {
    		connection = getConnection(true);
    		
    		String sql = "select * from goods where gclass_id=?";
    		
    		preparedStatement = connection.prepareStatement(sql);
    		
    		preparedStatement.setInt(1, goods_id);
    		
    		resultSet=preparedStatement.executeQuery();
    		
    		list = new ArrayList<GoodsBean>();
    		
    		while(resultSet.next()){
    			
    			GoodsBean goodsBean = new GoodsBean(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getBigDecimal(4),resultSet.getString(5),resultSet.getInt(6));				
    			list.add(goodsBean);
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

    
    public boolean modify(GoodsBean goodsBean){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "update goods set goods_name=?,goods_Image=?,goods_price=?,goods_desc=?,gclass_id=?  where goods_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,goodsBean.getGoods_name());
			
			preparedStatement.setString(2,goodsBean.getGoods_image());
			
			preparedStatement.setBigDecimal(3, goodsBean.getGoods_price());
			
			preparedStatement.setString(4, goodsBean.getGoods_desc());
			
			preparedStatement.setInt(5, goodsBean.getGclassId());
			
			preparedStatement.setInt(6, goodsBean.getGoods_id());
			
			
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
    public boolean remove(String[] goods_ids){
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "delete from goods where goods_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			for (String goods_id : goods_ids) {

				preparedStatement.setInt(1,Integer.parseInt(goods_id));
				
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

	public boolean modifyNoImage(GoodsBean goodsBean) {
		
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			
			String sql = "update goods set goods_name=?,goods_price=?,goods_desc=?,gclass_id=?  where goods_id=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,goodsBean.getGoods_name());
			
			
			preparedStatement.setBigDecimal(2, goodsBean.getGoods_price());
			
			preparedStatement.setString(3, goodsBean.getGoods_desc());
			
			preparedStatement.setInt(4, goodsBean.getGclassId());
			
			preparedStatement.setInt(5, goodsBean.getGoods_id());
			
			
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

}
