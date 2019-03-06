package com.basket.bean;

public class Basket {
	// 変数定義id
	private int id;
	// 変数定義氏名
	private String name;
	// 変数定義生年月日
	private String birthday;
	// 変数定義年齢
	private int age;
	// 変数定義成績
	private double money;
	public Basket() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Basket(int id, String name, String birthday, int age, double money, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.money = money;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Basket [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", money=" + money
				+ ", address=" + address + "]";
	}
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
