package com.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 */
@Entity
@Table(name ="hrms_employee_details")
public class HrmsEmployeeDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empId;
	private Department department;
	private String firstName;
	private String lastName;
	private String midName;
	private Date birthDate;
	private int age;
	private String sex;
	private String address;
	private Date employedDate;
	private int supervisorId;
	private Set<HrmsLogin> hrmsLogins = new HashSet<HrmsLogin>(0);
	//private Set<HrmsEmployeeLeaves> hrmsEmployeeLeaveses = new HashSet<HrmsEmployeeLeaves>(0);

	

	@Id
	@Column(name = "empId", unique = true, nullable = false)
	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptId", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "firstName", nullable = false, length = 50)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 50)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "midName", nullable = false, length = 50)
	public String getMidName() {
		return this.midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	
	@Column(name = "birthDate", nullable = false, length = 10)
	@Temporal(TemporalType.TIMESTAMP.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "sex", nullable = false, length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
	@Column(name = "employedDate", nullable = false, length = 10)
	@Temporal(TemporalType.TIMESTAMP.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getEmployedDate() {
		return this.employedDate;
	}

	public void setEmployedDate(Date employedDate) {
		this.employedDate = employedDate;
	}

	@Column(name = "supervisorId", nullable = false)
	public int getSupervisorId() {
		return this.supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hrmsEmployeeDetails")
	public Set<HrmsLogin> getHrmsLogins() {
		return this.hrmsLogins;
	}

	public void setHrmsLogins(Set<HrmsLogin> hrmsLogins) {
		this.hrmsLogins = hrmsLogins;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "hrmsEmployeeDetails")
	public Set<HrmsEmployeeLeaves> getHrmsEmployeeLeaveses() {
		return this.hrmsEmployeeLeaveses;
	}

	public void setHrmsEmployeeLeaveses(Set<HrmsEmployeeLeaves> hrmsEmployeeLeaveses) {
		this.hrmsEmployeeLeaveses = hrmsEmployeeLeaveses;
	}*/
	
	@Override
	public String toString() {
		return "HrmsEmployeeDetails [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", midName=" + midName + ", birthDate=" + birthDate + ", age=" + age + ", sex=" + sex + ", address="
				+ address + ", employedDate=" + employedDate + ", supervisorId=" + supervisorId + "]";
	}

}
