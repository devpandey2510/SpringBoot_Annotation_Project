package com.Facebook.FacebookBoot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Facebook.FacebookBoot.entity.FriendList;

@Repository
public interface FriendListDaoInterface extends JpaRepository<FriendList,Long> {

	@Query("from com.Facebook.FacebookBoot.entity.FriendList f where f.receiverfriend=:em ")
	List<FriendList> viewFriendRequestsDAo(@Param("em") String email);

	@Modifying
	@Query("update com.Facebook.FacebookBoot.entity.FriendList f set f.status=:fs where f.friendId=:fid")
	void confirmFriendRequest(@Param("fid") long num,@Param("fs") String str);

}
