package com.model;
// Generated 08 7, 15 10:09:21 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Leaves generated by hbm2java
 */
@Entity
@Table(name = "leaves")
public class Leaves implements java.io.Serializable {

	private int leaveId;
	private String leaveName;
	private Set<HrmsEmployeeLeaves> hrmsEmployeeLeaveses = new HashSet<HrmsEmployeeLeaves>(0);

	@Id

	@Column(name = "leaveId", unique = true, nullable = false)
	public int getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	@Column(name = "leaveName", nullable = false, length = 50)
	public String getLeaveName() {
		return this.leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leaves")
	public Set<HrmsEmployeeLeaves> getHrmsEmployeeLeaveses() {
		return this.hrmsEmployeeLeaveses;
	}

	public void setHrmsEmployeeLeaveses(Set<HrmsEmployeeLeaves> hrmsEmployeeLeaveses) {
		this.hrmsEmployeeLeaveses = hrmsEmployeeLeaveses;
	}

}
