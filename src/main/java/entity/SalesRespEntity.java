package main.java.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "sales_man")
public class SalesRespEntity implements Serializable {
	private static final long serialVersionUID = 3745202571107295915L;
	
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
	
	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "salesResponsible", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CustomerEntity> customers = new HashSet<>();
	
	@OneToMany(mappedBy = "salesMan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderEntity> orders = new HashSet<>();
	
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<OrderEntity> getOrders() {
		return orders;
	}
	
	public void addOrders(OrderEntity order) {
		this.orders.add(order);
	}
	
	public Set<CustomerEntity> getCustomers() {
		return customers;
	}
	
	public void addCustomers(CustomerEntity customer) {
		this.customers.add(customer);
	}
	
}
