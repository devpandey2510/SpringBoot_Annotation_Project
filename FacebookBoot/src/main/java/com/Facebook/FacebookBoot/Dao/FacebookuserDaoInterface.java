package com.Facebook.FacebookBoot.Dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Facebook.FacebookBoot.entity.Facebookuser;

@Repository
public interface FacebookuserDaoInterface extends JpaRepository<Facebookuser,String>{

	@Query("from com.Facebook.FacebookBoot.entity.Facebookuser f where f.email=:em and f.password=:pw")
	Facebookuser login(@Param("em")String email,@Param("pw") String password);
  
	@Query("from com.Facebook.FacebookBoot.entity.Facebookuser f where f.name=:nm")
	ArrayList<Facebookuser> findAll(@Param("nm") String name);

//	 @Modifying
//	@Query("update com.Facebook.FacebookBoot.entity.Facebookuser f set f.name=:nm,f.address=:ad,f.password=:pw where f.email=:em")
//	void editprofileDao(@Param("nm") String name,@Param("ad") String address,@Param("pw") String password,@Param("em")String email);


}
