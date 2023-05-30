package com.Facebook.FacebookBoot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Facebook.FacebookBoot.entity.Country;
import com.Facebook.FacebookBoot.entity.Facebookuser;
import com.Facebook.FacebookBoot.entity.FriendList;

public interface FacebookuserServiceInterface {

	public int registeration(Facebookuser fb);

	public boolean loginService(Facebookuser fb);

	public boolean checkmail(Facebookuser fb);

	public List<Country> loadCountry();

	public Facebookuser veiwprofile(Facebookuser fb);

	public int deleteprofile(Facebookuser fb);

	public ArrayList<Facebookuser> searchprofile(Facebookuser fb);

	public ArrayList<Facebookuser> viewallprofile();

	public int editprofile(Facebookuser fb);

	public int FriendRequestService(FriendList f);

	public List<FriendList> viewFriendRequests(String email);

	public int ConfirmFriendRequest(long num);

	public int DeleteFriendRequest(long num);
	

}
