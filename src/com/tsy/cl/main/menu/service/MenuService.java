package com.tsy.cl.main.menu.service;

import java.util.ArrayList;
import java.util.List;

import com.tsy.cl.main.menu.bean.MenuBean;
import com.tsy.cl.main.menu.dao.MenuDao;


public class MenuService {
	
	private MenuDao menuDao = new MenuDao();
	
	public boolean save(MenuBean menuBean){
		
		return menuDao.save(menuBean);
	}
	public int getidbymenuBean(MenuBean menuBean){
		
		return menuDao.getidbymenuBean(menuBean);
	}
	
	public List<MenuBean> getPage(String menu_name,int begin,int size){
		
		return menuDao.getPage(menu_name, begin, size);
	}
	
	public int getCount(String menu_name){
		
		return menuDao.getCount(menu_name);
	}
	
	public MenuBean findById(int menu_id){
		
		return menuDao.findById(menu_id);
	}
	
	public boolean delete(String[] menu_ids){
		
		return menuDao.remove(menu_ids);
	}
	
	public boolean update(MenuBean menuBean){
		
		return menuDao.modify(menuBean);
	}
	

public List<MenuBean> findByRId(int roleId){
		
		List<MenuBean> list=menuDao.findByRid(roleId);
		
		//存放子菜单
		List<MenuBean> list2=null;
		
		//存放封装好的父菜单
		List<MenuBean> list3 = new ArrayList<MenuBean>();
		
		for (MenuBean menuBean : list) {
			
			if(menuBean.getFather_id()==0){
				
				list2 = new ArrayList<MenuBean>();
				
				for (MenuBean menuBean2 : list) {
				
					if(menuBean2.getFather_id()==menuBean.getMenu_id()){
						
						list2.add(menuBean2);
					}
				}
				
				menuBean.setList(list2);
				
				list3.add(menuBean);
			}
			
			
		}
		
		return list3;
		
	} 
}
