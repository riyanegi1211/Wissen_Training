package com.example.demo.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="Student")

public class Student {
  @Id
  @Column(name="Roll_No")
  private int Roll_No;
  @Column(name="Name")
  private String Name;
  @Column(name="Standard")
  private int Standard;
  @Column(name="Percentage")
  private int Percentage;
  
  Student(){}
  
    public Student(int Roll_No,String Name, int Standard, int Percentage)
    {
      super();
      
      this.Roll_No=Roll_No;
      this.Name=Name;
      this.Standard=Standard;
      this.Percentage=Percentage;
    }
    public int getRoll_No()
    {
      return Roll_No;
    }
    public void setRoll_No(int Roll_No)
    {
      this.Roll_No=Roll_No;
    }
    public String getName()
    {
      return Name;
    }
    public void setName(String Name)
    {
      this.Name=Name;
    }
    public int getStandard()
    {
      return Standard;
    }
    public void setStandard(int Standard)
    {
      this.Standard=Standard;
    }
    public int getPercentage()
    {
      return Percentage;
    }
    public void setPercentage(int Percentage)
    {
      this.Percentage=Percentage;
    }
    @Override
    public String toString()
    {
      return "Student[Roll_No=" +Roll_No+",Name= " + Name + ",Standard=" + Standard+",Percentage=" + Percentage+" ]";
    }
}