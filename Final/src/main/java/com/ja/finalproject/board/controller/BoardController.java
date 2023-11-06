package com.ja.finalproject.board.controller;

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

import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardService; 
	
	@RequestMapping("mainPage")
	public String mainPage(Model model, 
			@RequestParam(value="pageNum", defaultValue="1") int pageNum,
			String searchType,
			String searchWord
		) {
		//.. 사실상 제일 코드가 많은 구간
		
		List<Map<String, Object>> list = boardService.getArticleList(pageNum, searchType, searchWord);
		model.addAttribute("list", list);
		
		// 페이징 관련
		int totalCount = boardService.getArticleTotalCount(searchType, searchWord); 
		
		int totalPageNumber = (int)Math.ceil(totalCount/(double)10);
		model.addAttribute("totalPageNumber", totalPageNumber);
		model.addAttribute("currentPageNumber", pageNum);
		
		int startPageNumber = ((pageNum-1)/5)*5+1;
		int endPageNumber = ((pageNum-1)/5+1)*5;
		
		if(endPageNumber > totalPageNumber) {
			endPageNumber = totalPageNumber;
		}
		
		model.addAttribute("startPageNumber", startPageNumber);
		model.addAttribute("endPageNumber", endPageNumber);
		
		String searchQueryString = "";
		
		if(searchType != null && searchWord != null) {
			searchQueryString += "&searchType=" + searchType;
			searchQueryString += "&searchWord=" + searchWord;
		}
		
		model.addAttribute("searchQueryString", searchQueryString);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchWord", searchWord);
		
		return "board/mainPage";
	}
	
	@RequestMapping("writeArticlePage")
	public String writeArticlePage() {
		
		return "board/writeArticlePage";
	}
	
	@RequestMapping("writeArticleProcess")
	public String writeArticleProcess(HttpSession session, FreeboardArticleDto params, MultipartFile[] imageFiles) {
		
		List<ArticleImageDto> articleImageDtoList = new ArrayList<>(); 
		
		// 파일 저장 로직
		if(imageFiles != null) {
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
		}
		
		
		
		UserDto sessionUserInfo = (UserDto)session.getAttribute("sessionUserInfo");
		int userPk = sessionUserInfo.getId();
		
		params.setUser_id(userPk);
		
		boardService.writeArticle(params, articleImageDtoList);
		
//		return "board/writeArticleComplete";
		
		return "redirect:./mainPage";
//		return "board/mainPage";
	}
	
	@RequestMapping("readArticlePage")
	public String readArticlePage(Model model, int id) {
		
		boardService.increaseReadCount(id);
		
		Map<String, Object> map = boardService.getArticle(id);
		
		model.addAttribute("qwer", map);		
		
		return "board/readArticlePage";
	}
	
	@RequestMapping("deleteArticleProcess")
	public String deleteArticleProcess(int id) {
		
		boardService.deleteArticle(id);
		
		return "redirect:./mainPage";
	}
	
	@RequestMapping("updateArticlePage")
	public String updateArticlePage(Model model, int id) {
		
//		Map<String, Object> map = boardService.getArticle(id);
//		model.addAttribute("qwer", map);
		
		model.addAttribute("qwer", boardService.getArticle(id));		
		
		return "board/updateArticlePage";
	}
	
	@RequestMapping("updateArticleProcess")
	public String updateArticleProcess(FreeboardArticleDto params) {
		
		boardService.updateArticle(params);
		
		return "redirect:./readArticlePage?id=" + params.getId();
	}
	
}





