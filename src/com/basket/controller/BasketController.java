package com.basket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basket.bean.Basket;
import com.basket.dao.BasketDao;

@Controller
public class BasketController {
	/**
	 * 处理主页的超链接请求，请求名称为gotoBasketPage
	 * @return
	 */
//	@RequestMapping(value = "gotoBasketPage")
//	public String queryAll(Model model) {
//		//使用ApplicationContext方法，连接dao曾，获取查询数据库的相关方法
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//创建一个BasketDao类型的变量，将使用context方法获取到的applicationContext.xml怕配置文件里的dao曾的路径；
//		BasketDao dao = (BasketDao) context.getBean("basketdao");
//		//创建集合，将从数据库查询到的信息存放在集合中
//		List<Basket> basketList = new ArrayList<>();
//		//调取dao曾里的queryAll方法，获取数据库总信息
//		basketList = dao.queryAll();
//		//使用model方法，将获取到的信息，返回到前台jsp页面，
//		//其中addAttribute括号内，第一个参数，是用来指定将结果返回打破jsp页面的那个位置，第二个参数，是用来指定将那些结果来返回；
//        model.addAttribute("", basketList);
//        //此处的return，是指返回到那个jsp页面，
//	return "indexbasket";
//}


	@RequestMapping(value = "/all")

	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BasketDao dao = (BasketDao) context.getBean("basketdao");
		List<Basket> basketList = new ArrayList<Basket>();
		basketList = dao.queryAll();
		model.addAttribute("baskets", basketList);

		return "indexbasket";

	}

	@RequestMapping(value = "/addbasket")
	public String Addbasket(String name, String birthday, String age, String money, Model model) {
		// フィルター情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// iocからdaoを取る
		BasketDao dao = (BasketDao) context.getBean("basketdao");
		// 新規doctor対象
		Basket basket = new Basket();
		basket.setName(name);
		basket.setBirthday(birthday);
		basket.setAge(Integer.valueOf(age));
		basket.setMoney(Double.parseDouble(money));
		boolean result = dao.addBasket(basket);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("不ok");
		}
		model.addAttribute("baskets", dao.queryAll());

		return "indexbasket";
	}
	@RequestMapping(value = "/address")
	//此处的addAddress中的变量，String id，String addr01，与前台jsp页面获取信息框对应的name属性名一致。
	public String addAddress(String addr11,String id,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BasketDao basketDao = (BasketDao) context.getBean("basketdao");
		//Basket basket = new Basket();
		//setId（）中的变量，即将jsp中获得的数据导入set方法中，所以属性名称也要对应jsp中的名称。
		//basket.setId(Integer.valueOf(id));
		//basket.setAddress(addr01);
		//此处通过调用Dao里的addAddress方法后，把获取的值给返回请求result。
		boolean result=basketDao.addAddress(addr11,id);
		if(result) {
			System.out.println("住所を追加しました");
		}else {
			System.out.println("住所を追加しませんでした");
		}
		model.addAttribute("baskets",basketDao.queryAll());
		return "indexbasket";
		}


}
