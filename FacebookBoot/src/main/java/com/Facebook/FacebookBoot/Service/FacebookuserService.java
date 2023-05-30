package com.Facebook.FacebookBoot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Facebook.FacebookBoot.Dao.CountryDaoInterface;
import com.Facebook.FacebookBoot.Dao.FacebookuserDaoInterface;
import com.Facebook.FacebookBoot.Dao.FriendListDaoInterface;
import com.Facebook.FacebookBoot.entity.Country;
import com.Facebook.FacebookBoot.entity.Facebookuser;
import com.Facebook.FacebookBoot.entity.FriendList;

@Service
@Transactional
public class FacebookuserService implements FacebookuserServiceInterface {
	
	@Autowired
   private FacebookuserDaoInterface fd;
	
	@Autowired
	private CountryDaoInterface cd;
	
	@Autowired
	private FriendListDaoInterface fl;
	
	public int registeration(Facebookuser fb) {
		int i=0;
		fd.save(fb);
         return  i=1;
	}

	public boolean loginService(Facebookuser fb) {
       Facebookuser fu= fd.login(fb.getEmail(),fb.getPassword());
       if(fu!=null) {
    	   return true;
       }
       else {
		return false;
	}
	}


	public boolean checkmail(Facebookuser fb) {
	return fd.existsById(fb.getEmail());
	
	}


	public List<Country> loadCountry() {
		List<Country> lc= cd.findAll();
		return lc;
	}


	public Facebookuser veiwprofile(Facebookuser fb) {
		Facebookuser fu= fd.getById(fb.getEmail());
		return fu;
	}

	
	public int deleteprofile(Facebookuser fb) {
		fd.delete(fb);
		return 1;
	}

	public ArrayList<Facebookuser> searchprofile(Facebookuser fb) {
		ArrayList<Facebookuser> fu =fd.findAll(fb.getName());
		return fu;
	}

	
	public ArrayList<Facebookuser> viewallprofile() {
	  ArrayList<Facebookuser> fu=(ArrayList<Facebookuser>) fd.findAll();
		return fu;
	}


	public int editprofile(Facebookuser fb) {
		fd.saveAndFlush(fb);
//		fd.editprofileDao(fb.getName(),fb.getEmail(),fb.getPassword(),fb.getAddress());
        return 1;
	}


	public int FriendRequestService(FriendList f) {
		int i=0;
		fl.save(f);
		i=1;
		return i;
	}

	public List<FriendList> viewFriendRequests(String email) {
		List<FriendList> fl1= (List<FriendList>)fl.viewFriendRequestsDAo(email);
		return fl1;
	}

	
	public int ConfirmFriendRequest(long num) {
		String str="active";
		int i=0;
		fl.confirmFriendRequest(num,str);
		i=1;
		return i;
	}


	public int DeleteFriendRequest(long num) {
		int i=0;
		fl.deleteById(num);
		i=1;
		return 1;
	}
}
