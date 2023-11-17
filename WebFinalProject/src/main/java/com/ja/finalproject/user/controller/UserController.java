package com.ja.finalproject.user.controller;

import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ja.finalproject.admin.service.AdminServiceImpl;
import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.UserAdressDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	private UserServiceImpl userSerivce;
	
	@Autowired
	private AdminServiceImpl adminSerivce;
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("mainPage")
	public String mainPage(Model model,HttpSession session, UserDto params) {
		
		UserDto sessionUser = (UserDto)session.getAttribute("sessionUserInfo");
		session.setAttribute("sessionUserInfo", sessionUser);	
		session.setAttribute("ShopList",userSerivce.getUserShop());

		return "user/mainPage";
	}
	
	
	
	@RequestMapping("loginPage")
	public String loginPage() {
		
		return "user/loginPage"; //JSP 포워딩
	}
	
	@RequestMapping("registerProcess")
	public String registerProcess(UserDto params) {
		
		System.out.println("registerProcess - 실행됨!");
		System.out.println(params.getUserid());
		System.out.println(params.getPassword());
		
		userSerivce.register(params);
		
		return "redirect:./loginPage";
//		return "user/loginPage";
	}
	
	@RequestMapping("userloginProcess")
	public String userloginProcess(HttpSession session, UserDto params) {
		
		UserDto sessionUser = userSerivce.getUserInfoByUserIdAndPassword(params);
		session.setAttribute("sessionUserInfo", sessionUser);
		
		session.setAttribute("ShopList",userSerivce.getUserShop());
		
		
		return "user/mainPage";
	
		
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate(); // 세션 날림
		
		return "redirect:../user/mainPage";
	}
	
	@RequestMapping("readUserArticlePage")
	public String readUserArticlePage(UserDto params, HttpSession session, Model model, int id) {

		Map<String, Object> map = boardService.getArticle(id);
		
		model.addAttribute("qwer", map);		
		
		return "user/readUserArticlePage";
	}
	// 상품 구매
	@RequestMapping("buyProduct")
	public String buyProduct(Model model, int id,HttpSession session,UserAdressDto params) {	
		//userSerivce.register(params);	

		UserDto sessionUser = (UserDto)session.getAttribute("sessionUserInfo");
		UserAdressDto UserAdres = (UserAdressDto)session.getAttribute("sessionAdressInfo");
		
		model.addAttribute("sessionUserInfo", sessionUser);
		model.addAttribute("userAdres", UserAdres);
		session.setAttribute("AdressList",userSerivce.getSelectAdressId(sessionUser.getId()));
		
		System.out.println(params.getPhone_number());
		
		return "user/buyProduct";
	}
	
	//마이페이지
	@RequestMapping("myPage")
	public String myPage(Model model,HttpSession session, UserDto params) {
		
		UserDto sessionUser = (UserDto)session.getAttribute("sessionUserInfo");
		session.setAttribute("sessionUserInfo", sessionUser);	
		session.setAttribute("ShopList",userSerivce.getUserShop());

		return "user/myPage";
	}
	
	//배송지페이지
	@RequestMapping("addAdressPage")
	public String addAdressPage(Model model,HttpSession session) {
		
		
		UserDto sessionUser = (UserDto)session.getAttribute("sessionUserInfo");
		session.setAttribute("sessionUserInfo", sessionUser);	

		session.setAttribute("AdressList",userSerivce.getSelectAdressId(sessionUser.getId()));

		return "user/addAdressPage";
	}
	
	//배송지추가
	@RequestMapping("adressProcess")
	public String adressProcess(Model model,HttpSession session,UserAdressDto params) {

		userSerivce.registerAdress(params);

		UserDto sessionUser = (UserDto)session.getAttribute("sessionUserInfo");
		session.setAttribute("sessionUserInfo", sessionUser);	

		session.setAttribute("AdressList",userSerivce.getSelectAdressId(sessionUser.getId()));


		return "redirect:../user/addAdressPage";
	}
	
	@RequestMapping("delectAdressList")
	public String delectAdressList(int id,HttpSession session) {
			
		userSerivce.deleteAdressID(id);
	
		return "redirect:../user/addAdressPage";
	}
}









