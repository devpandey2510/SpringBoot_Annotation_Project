package com.Facebook.FacebookBoot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Facebook.FacebookBoot.entity.Country;

@Repository
public interface CountryDaoInterface extends JpaRepository<Country,Integer> {

}
