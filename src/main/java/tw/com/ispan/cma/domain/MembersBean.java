package tw.com.ispan.cma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class MembersBean {
	@Id
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "member_accouunt")
	private String memberAccouunt;
	
	@Column(name = "member_password")
	private String memberPassword;

	@Column(name = "member_lastname")
	private String memberLastname;

	@Column(name = "member_firstname")
	private String memberFirstname;
	
	@Column(name = "member_gender")
	private String memberGender	;
	
	@Column(name = "member_nickname")
	private String memberNickname;
	
	@Column(name = "member_email")
	private String memberEmail;
	
	@Column(name = "member_tel")
	private String memberTel;

	@Column(name = "member_addr")
	private String memberAddr;
	
	@Column(name = "member_birth")
	private java.util.Date memberBirth;
	
	@Column(name = "create_user")
	private String createUser;
	
	@Column(name = "create_date")
	private java.util.Date createDate;
	
	@Column(name = "update_user")
	private String updateUser;
	
	@Column(name = "update_date")
	private java.util.Date updateDate;

	@Override
	public String toString() {
		return "MembersBean [memberId=" + memberId + ", memberAccouunt=" + memberAccouunt + ", memberPassword="
				+ memberPassword + ", memberLastname=" + memberLastname + ", memberFirstname=" + memberFirstname
				+ ", memberGender=" + memberGender + ", memberNickname=" + memberNickname + ", memberEmail="
				+ memberEmail + ", memberTel=" + memberTel + ", memberAddr=" + memberAddr + ", memberBirth="
				+ memberBirth + ", createUser=" + createUser + ", createDate=" + createDate + ", updateUser="
				+ updateUser + ", updateDate=" + updateDate + "]";
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberAccouunt() {
		return memberAccouunt;
	}

	public void setMemberAccouunt(String memberAccouunt) {
		this.memberAccouunt = memberAccouunt;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberLastname() {
		return memberLastname;
	}

	public void setMemberLastname(String memberLastname) {
		this.memberLastname = memberLastname;
	}

	public String getMemberFirstname() {
		return memberFirstname;
	}

	public void setMemberFirstname(String memberFirstname) {
		this.memberFirstname = memberFirstname;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public java.util.Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(java.util.Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
