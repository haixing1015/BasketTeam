package com.basket.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.basket.bean.Basket;


public class BasketMapper implements RowMapper<Basket>{
	public Basket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Basket basket = new Basket();
		basket.setId(rs.getInt("id"));
		basket.setName(rs.getString("name"));
		basket.setBirthday(getStringDate(rs.getString("birthday")));
		basket.setAge(rs.getInt("age"));
		basket.setMoney(rs.getDouble("money"));
		basket.setAddress(rs.getString("address"));
		return basket;
	}

	private  String getStringDate(String birthday) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(birthday);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}

}
