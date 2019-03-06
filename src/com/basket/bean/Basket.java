package com.basket.bean;

public class Basket {
	// �ϐ���`id
	private int id;
	// �ϐ���`����
	private String name;
	// �ϐ���`���N����
	private String birthday;
	// �ϐ���`�N��
	private int age;
	// �ϐ���`����
	private double money;
	public Basket() {
		super();
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
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
