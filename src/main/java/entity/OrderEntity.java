package main.java.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumx.Color;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1980629840027711453L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private long id;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "color")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;
	
	@ManyToOne
	@JoinColumn(name = "sales_man_id", referencedColumnName = "id")
	private SalesRespEntity salesMan;
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getModelYear() {
		return modelYear;
	}
	
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public CustomerEntity getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	public long getId() {
		return id;
	}
	
	public SalesRespEntity getSalesMan() {
		return salesMan;
	}
	
	public void setSalesMan(SalesRespEntity salesMan) {
		this.salesMan = salesMan;
	}
	
}
