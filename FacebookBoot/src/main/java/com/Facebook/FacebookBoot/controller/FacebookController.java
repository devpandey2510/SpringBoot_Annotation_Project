package com.Facebook.FacebookBoot.controller;

import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Facebook.FacebookBoot.Service.FacebookuserServiceInterface;
import com.Facebook.FacebookBoot.entity.Country;
import com.Facebook.FacebookBoot.entity.Facebookuser;
import com.Facebook.FacebookBoot.entity.FriendList;


@Controller
public class FacebookController {
	
	@Autowired
    private	FacebookuserServiceInterface fs;//now spring will create object of it through factory design pattern we need not worry about it
	
	
	@RequestMapping("Registration")
	public ModelAndView registerClient(HttpServletRequest request,@RequestParam("fname") String name,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("address") String address) {
// these all below lines can be subsituted with above line annotation		
		
//		String name = request.getParameter("fname");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String address = request.getParameter("address");
		
		  ModelAndView mv = new ModelAndView();
		
		Facebookuser fb = new Facebookuser();
    	fb.setName(name);
		fb.setEmail(email);
		fb.setPassword(password);
		fb.setAddress(address);
		
//	FacebookuserServiceInterface fs = new FacebookuserService();
	   int i=fs.registeration(fb);
		 
			mv.addObject("first_name", name);
			mv.addObject("e_email", email);
			mv.addObject("result",i);
			
			mv.setViewName("registraitionview.jsp");
	   
		return mv;
}
	
	@RequestMapping("LoadTime")
	public ModelAndView loadClock() {

		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
 		   LocalTime time = LocalTime.now();
 		   String f = formatter.format(time);
 		   
 		   ModelAndView mv= new ModelAndView();
 		   mv.addObject("time", f);
 		   
 		   mv.setViewName("loadtime.jsp");
 		   
  	  return mv;
}
	
	@RequestMapping("Login")
	public ModelAndView LoginController(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("password") String Password ) {

	    Facebookuser fb = new Facebookuser();
	    fb.setEmail(email);
	    fb.setPassword(Password);
	    
	    boolean result = fs.loginService(fb);
	    ModelAndView mv= new ModelAndView();
	   System.out.println(result);
	   System.out.println(email);
	    	 
	 		   mv.addObject("value", result);
	 		   mv.addObject("email",email);
	 		  
	 		   mv.setViewName("login.jsp");
	    
  	  return mv;
}
	@RequestMapping("CheckEmail")
	public ModelAndView Checkemail(@RequestParam("emailvalue") String email) {
	System.out.println(email);
		Facebookuser fb = new Facebookuser();
		fb.setEmail(email);
		boolean i= fs.checkmail(fb);
		
		ModelAndView mv = new ModelAndView();
		String str="";
		if(i==true) {
			   str="<font color=red>This Email has already been taken </font>";
			}
			else {
				str="<font color=green>Valid Email</font>";
			}
		mv.addObject("result",str);
		mv.setViewName("checkmail.jsp");
		return mv;
}
	@RequestMapping("LoadCountry")
	public ModelAndView showCountry() {
	
		
		List<Country> i= fs.loadCountry();
		
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("result",i);
		mv.setViewName("loadCountry.jsp");
		return mv;
}
	
	@RequestMapping("LoadCaptcha")
	public ModelAndView showCaptcha() {
	
		
		int i =(int)((Math.random())*10000);
		
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("result",i);
		mv.setViewName("loadcaptcha.jsp");
		return mv;
}
	@RequestMapping("Viewprofile")
	public ModelAndView viewprofile(HttpServletRequest request) {
	HttpSession ss = request.getSession(true);
	Object ob = ss.getAttribute("userid");
	String email = ob.toString();
	
	Facebookuser fb = new Facebookuser();
	fb.setEmail(email);
		
		Facebookuser i =fs.veiwprofile(fb);
		
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("result",i);
		mv.setViewName("viewprofile.jsp");
		return mv;
}
	
	@RequestMapping("DeleteProfile")
	public ModelAndView Deleteprofile(HttpServletRequest request) {
	HttpSession ss = request.getSession(true);
	Object ob = ss.getAttribute("userid");
	String email = ob.toString();
	
	Facebookuser fb = new Facebookuser();
	fb.setEmail(email);
		
		int i =fs.deleteprofile(fb);
		
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("result",i);
		mv.setViewName("deleteprofile.jsp");
		return mv;
}
	
	@RequestMapping("SearchProfile")
	public ModelAndView searchprofile(@RequestParam("searchname") String name) {
	
	Facebookuser fb = new Facebookuser();
	fb.setName(name);
	
	ArrayList<Facebookuser> i =fs.searchprofile(fb);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",i);
		mv.setViewName("searchprofile.jsp");
		return mv;
}
	
	@RequestMapping("ViewAllProfile")
	public ModelAndView viewAllprofile() {
	
	ArrayList<Facebookuser> i =fs.viewallprofile();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",i);
		mv.setViewName("viewallprofile.jsp");
		return mv;
}
	
	@RequestMapping("EditProfile")
	public ModelAndView Editprofile(HttpServletRequest request) { 
		
		HttpSession ss = request.getSession(true);
		Object ob = ss.getAttribute("userid");
		String email = ob.toString();
		
		Facebookuser fb = new Facebookuser();
		fb.setEmail(email);
			
			Facebookuser i =fs.veiwprofile(fb);
			
			ModelAndView mv = new ModelAndView();
		
			mv.addObject("result",i);
			mv.setViewName("editprofile.jsp");
			return mv;
}
	
	@RequestMapping("EditeProfile1")
	public ModelAndView EditeProfile1(HttpServletRequest request,@RequestParam("nm") String name,@RequestParam("pw") String password,@RequestParam("adrs") String address) {
		
		HttpSession ss = request.getSession(true);
		Object ob = ss.getAttribute("userid");
		String email = ob.toString();
		
	   ModelAndView mv = new ModelAndView();
				
	   Facebookuser fb = new Facebookuser();
	   fb.setName(name);
	   fb.setEmail(email);
	   fb.setPassword(password);
	   fb.setAddress(address);
				
//			FacebookuserServiceInterface fs = new FacebookuserService();
			   int i=fs.editprofile(fb);
				 
			        mv.addObject("msg",name);
					mv.addObject("result",i);
					
					mv.setViewName("editprofile1.jsp");
			   
				return mv;
		}
	
	@RequestMapping("Friends")
	public ModelAndView Friends(HttpServletRequest request) {
		ArrayList<Facebookuser> i =fs.viewallprofile();
		
		HttpSession ss = request.getSession(true);
		Object ob = ss.getAttribute("userid");
		String senderfriend = ob.toString();
		
	    ModelAndView mv = new ModelAndView();
				
				 
		 mv.addObject("sender",senderfriend);
		 mv.addObject("result",i);
					
		 mv.setViewName("Friends.jsp");
			   
		return mv;
		}
	
	@RequestMapping("AddFriend")
	public ModelAndView Friends(HttpServletRequest request,@RequestParam("dost") String receiverfriend) {

		
		HttpSession ss = request.getSession(true);
		Object ob = ss.getAttribute("userid");
		String senderfriend = ob.toString();
		
		Facebookuser fu= new Facebookuser();
		fu.setEmail(senderfriend);
		
		FriendList f = new FriendList();
		f.setReceiverfriend(receiverfriend);
		f.setStatus("inactive");
		f.setSt(fu);
		
		int i = fs.FriendRequestService(f);
		
	    ModelAndView mv = new ModelAndView();
				
		 mv.addObject("result",i);
					
		 mv.setViewName("FriendRequest.jsp");
			   
		return mv;
		}
	
	@RequestMapping("FriendRequests")
	public ModelAndView FriendRequests(HttpServletRequest request) {
		
		HttpSession ss = request.getSession(true);
		Object ob = ss.getAttribute("userid");
		String email = ob.toString();
		
		List<FriendList> flist = fs.viewFriendRequests(email);
		
	    ModelAndView mv = new ModelAndView();
				
		 mv.addObject("result",flist);
					
		 mv.setViewName("FriendRequestShow.jsp");
			   
		return mv;
		}
	
	@RequestMapping("ConfirmRequest")
	public ModelAndView ConfirmRequests(HttpServletRequest request,@RequestParam("senderid") String value) {
		
		//String value =request.getParameter("senderid");
		long num = new Long(value);
		
		int i = fs.ConfirmFriendRequest(num);
		
	    ModelAndView mv = new ModelAndView();
				
		 mv.addObject("result",i);
					
		 mv.setViewName("Confirmation.jsp");
			   
		return mv;
		
		}
	
	@RequestMapping("DeleteRequest")
	public ModelAndView DeleteRequests(@RequestParam("senderid") String value) {
		
		long num = new Long(value);
		int i = fs.DeleteFriendRequest(num);
		
	    ModelAndView mv = new ModelAndView();
				
		 mv.addObject("result",i);
					
		 mv.setViewName("DeletefriendRequest.jsp");
			   
		return mv;
		}

}
