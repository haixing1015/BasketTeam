package com.basket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.basket.bean.Basket;
import com.basket.mapper.BasketMapper;


public class BasketDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Basket> queryAll() {
		String sql = "select id,name,birthday,age,money,address from basket";
		List<Basket> basketList = new ArrayList<Basket>();
		basketList = jdbcTemplate.query(sql, new BasketMapper());
		return basketList;

	}

	public List<Basket> queryByName(String basketname) {
	 String sql = "select id,name,birthday,age,money ,address from basket where name like '%"+basketname+"%'";
	 List<Basket> basketList = new ArrayList<Basket>();
	 basketList = jdbcTemplate.query(sql, new BasketMapper());
	 return basketList;
	 }

	public boolean addBasket(Basket basket) {
		String sql = "insert into basket(id,name,birthday,age,money)values(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[]{basket.getName(),basket.getBirthday(),basket.getAge(),basket.getMoney()},
				new int[] {Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.INTEGER})==1;

	}
	public boolean addAddress(String addr11,String id) {
		String sql = "update basket set address=? where id = ?";
		return jdbcTemplate.update(sql,addr11,id)==1;
	}

}
