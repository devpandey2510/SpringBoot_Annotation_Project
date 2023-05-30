package com.Facebook.FacebookBoot.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="newFriendlist")
public class FriendList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long friendId;
	
	String receiverfriend;
	
	@ManyToOne
	Facebookuser st;
	
	String status;
	
	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}

	public String getReceiverfriend() {
		return receiverfriend;
	}

	public void setReceiverfriend(String receiverfriend) {
		this.receiverfriend = receiverfriend;
	}

	public Facebookuser getSt() {
		return st;
	}

	public void setSt(Facebookuser st) {
		this.st = st;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
