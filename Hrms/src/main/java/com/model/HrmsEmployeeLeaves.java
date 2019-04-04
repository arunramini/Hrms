package com.model;
// Generated 08 7, 15 10:09:21 AM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "hrms_employee_leaves")
public class HrmsEmployeeLeaves implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private HrmsEmployeeDetails hrmsEmployeeDetails;
	private Leaves leaves;
	private Date startDate;
	private Date endDate;
	private double totalDays;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "empId")
	public HrmsEmployeeDetails getHrmsEmployeeDetails() {
		return this.hrmsEmployeeDetails;
	}

	public void setHrmsEmployeeDetails(HrmsEmployeeDetails hrmsEmployeeDetails) {
		this.hrmsEmployeeDetails = hrmsEmployeeDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "leaveId")
	public Leaves getLeaves() {
		return this.leaves;
	}

	public void setLeaves(Leaves leaves) {
		this.leaves = leaves;
	}

	@Column(name = "startDate",  length = 10)
	@Temporal(TemporalType.TIMESTAMP.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "endDate", length = 10)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "totalDays", precision = 22, scale = 0)
	public double getTotalDays() {
		return this.totalDays;
	}

	public void setTotalDays(double totalDays) {
		this.totalDays = totalDays;
	}

}
