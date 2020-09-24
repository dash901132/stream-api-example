package com.java.feature.model;

import java.io.Serializable;

public class Employee implements Serializable ,Comparable{
    protected int id;
    protected String ename;
    protected long salary;
    protected String dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Employee(int id, String ename, long salary, String dept) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

    public Employee(){}


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
