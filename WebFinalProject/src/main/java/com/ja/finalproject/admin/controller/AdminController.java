package com.ja.finalproject.admin.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.admin.service.AdminServiceImpl;
import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;
import com.ja.finalproject.user.service.UserServiceImpl;

import oracle.net.aso.b;


@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminSerivce;
	
	@Autowired
	private UserServiceImpl userSerivce;
	
	
	@Autowired
	private BoardServiceImpl boardService; 
	
	@RequestMapping("adminMainPage")
	public String adminMainPage(Model model, HttpSession session) {
		AdminDto sessionAdminDto = (AdminDto)session.getAttribute("sessionAdminInfo");

		if(sessionAdminDto != null) {
		//	System.out.println(sessionAdminDto.getId());
			session.setAttribute("sessionAdminInfo", sessionAdminDto);
			
			session.setAttribute("ShopSearchList",adminSerivce.getShopList(sessionAdminDto.getId()));
			//model.addAttribute("ShopSearchList",adminSerivce.getShopList(sessionAdminDto.getId()));
		}
		
		return "admin/adminMainPage";
	}
	
	
	@RequestMapping("adminLoginPage")
	public String adminLoginPage() {
		
		return "admin/adminLoginPage"; //JSP 포워딩
	}
	
	@RequestMapping("adminRegisterPage")
	public String adminRegisterPage() {
		
		return "admin/adminRegisterPage";
	}
	
	@RequestMapping("adminRegisterProcess")
	public String adminRegisterProcess(AdminDto params) {

		adminSerivce.register(params);
		
		return "redirect:./adminLoginPage";
	}
	
	@RequestMapping("adminLoginProcess")
	public String adminLoginProcess(HttpSession session, AdminDto params) {

		AdminDto sessionAdminDto = adminSerivce.getUserInfoByUserIdAndPassword(params);
		
		System.out.println(sessionAdminDto.getId());
		session.setAttribute("sessionAdminInfo", sessionAdminDto);
		
		session.setAttribute("ShopSearchList",adminSerivce.getShopList(sessionAdminDto.getId()));
		
		return "admin/adminMainPage";
		
		
	}
	
	@RequestMapping("setAdminLogoutProcess")
	public String setAdminLogoutProcess(HttpSession session, AdminDto params) {
		
		//adminSerivce userSerivce;
		
		AdminDto sessionUser = adminSerivce.getUserInfoByUserIdAndPassword(params);
		if(sessionUser != null) {
			session.setAttribute("sessionUserInfo", sessionUser);	
		}
		return "redirect:../admin/adminMainPage";
	}	
	
	@RequestMapping("adminLogoutProcess")
	public String adminLogoutProcess(HttpSession session) {
		
		session.invalidate(); // 세션 날림
		
		return "redirect:../admin/adminMainPage";
	}
	
	@RequestMapping("writeArticlePage")
	public String writeArticlePage(Model model) {

		model.addAttribute("categoryList",adminSerivce.getCategoryList());
	//	model.addAttribute("ImageList");
		return "admin/writeArticlePage";
	}
	
	@RequestMapping("readArticlePage")
	public String readArticlePage(AdminDto params, HttpSession session, Model model, int id) {

		Map<String, Object> map = boardService.getArticle(id);
		
		model.addAttribute("qwer", map);		
		
		
		return "admin/readArticlePage";
	}
	
	@RequestMapping("deleteArticleProcess")
	public String deleteArticleProcess(int id) {
		
		boardService.deleteArticle(id);
		
		return "redirect:./mainPage";
	}
	
	@RequestMapping("updateArticlePage")
	public String updateArticlePage(Model model, int id) {
	
		model.addAttribute("qwer", boardService.getArticle(id));		
		
		return "board/updateArticlePage";
	}
	
	@RequestMapping("updateArticleProcess")
	public String updateArticleProcess(FreeboardArticleDto params) {
		
		boardService.updateArticle(params);
		
		return "redirect:./readArticlePage?id=" + params.getId();
	}
	
//	@SuppressWarnings("null")
	@RequestMapping("writeArticleProcess")
	public String writeArticleProcess(HttpSession session, FreeboardArticleDto params, MultipartFile[] imageFiles) {
		
		List<ArticleImageDto> articleImageDtoList = new ArrayList<>(); 
		
		// 파일 저장 로직
		System.out.println(imageFiles);
			System.out.println("이미지 확인2");
			for(MultipartFile multipartFile : imageFiles) {
				
				if(multipartFile.isEmpty()) {
					continue;
				}

				String rootPath = "C:/uploadFiles/";
				
				// 날짜별 폴더 생성.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
				String todayPath = sdf.format(new Date());
				
				File todayFolderForCreate = new File(rootPath + todayPath);
				
				if(!todayFolderForCreate.exists()) {
					todayFolderForCreate.mkdirs();
				}
				
				String originalFileName = multipartFile.getOriginalFilename();

				//파일명 충돌 회피 - 랜덤, 시간 조합
				String uuid = UUID.randomUUID().toString();
				long currentTime = System.currentTimeMillis();
				String fileName = uuid + "_" + currentTime;
				
				// 확장자 추출
				String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
				fileName += ext;
				
				try {
					multipartFile.transferTo(new File(rootPath + todayPath + fileName));					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
				ArticleImageDto articleImageDto = new ArticleImageDto();
				articleImageDto.setLocation(todayPath + fileName);
				articleImageDto.setOriginal_filename(originalFileName);
				
				articleImageDtoList.add(articleImageDto);
				
			}

		AdminDto sessionUserInfo = (AdminDto)session.getAttribute("sessionAdminInfo");
		int userPk = sessionUserInfo.getId();
		System.out.println("userPk : " + userPk);
		params.setUser_id(userPk);
		adminSerivce.writeArticle(params, articleImageDtoList);
	
		
		
		return "redirect:./adminMainPage";

	}
}
