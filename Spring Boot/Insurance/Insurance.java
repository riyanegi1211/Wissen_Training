package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Insurance")

public class Insurance {
	@Id
	@Column(name="PolicyId")
	private int PolicyId;
	@Column(name="Name")
	private String Name;
	@Column(name="PolicyAmt")
	private int PolicyAmt;
	@Column(name="Emi")
	private int Emi;
	
	Insurance(){}
	
	public Insurance(int PolicyId, String Name, int PolicyAmt, int Emi)
	{
		super();
		this.PolicyId=PolicyId;
		this.Name=Name;
		this.PolicyAmt=PolicyAmt;
		this.Emi=Emi;
	}
	
	public int getId()
	{
		return PolicyId;
	}
	public void setId(int PolicyId)
	{
		this.PolicyId =PolicyId;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String Name)
	{
		this.Name=Name;
	}
	public int getPolicyAmt()
	{
		return PolicyAmt;
	}
	public void setPolicyAmt(int PolicyAmt)
	{
		this.PolicyAmt=PolicyAmt;
	}
	public int getEmi()
	{
	return Emi;
	}
	public void setEmi(int Emi)
	{
		this.Emi=Emi;
	}
	@Override
	public String toString()
	{
		return "Insurance[PolicyId=" + PolicyId+",Name= " + Name + ",PolicyAmt=" + PolicyAmt+",Emi=" + Emi+" ]";
	}
}
