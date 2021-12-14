package main.java.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumx.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = -6078998591482739532L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private long id;
	
	@Lob
	@Column(name = "picture", nullable = true)
	private byte[] picture;
	
	@Column(name = "first_name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "sr_id", referencedColumnName = "id")
	private SalesRespEntity salesResponsible;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderEntity> orderList = new ArrayList<>();
	
	public byte[] getPicture() {
		return picture;
	}
	
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public SalesRespEntity getSalesResponsible() {
		return salesResponsible;
	}
	
	public void setSalesResponsible(SalesRespEntity salesResponsible) {
		this.salesResponsible = salesResponsible;
	}
	
	public long getId() {
		return id;
	}
	
	public List<OrderEntity> getOrderList() {
		return orderList;
	}
	
	public void addOrderList(OrderEntity order) {
		this.orderList.add(order);
	}
	
}
