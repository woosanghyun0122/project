package com.moggoji.member;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moggoji.mail.MailDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping(value="/login")
	public String login() {
		
		logger.info("----------------------------------------------------------------");
		logger.info("로그인 페이지");
		logger.info("----------------------------------------------------------------");

		return "/member/login";
	}
	
	@PostMapping(value="/member/login_proc")
	public HashMap<String,String> member_login_proc(MemberDto dto, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		logger.info("session={}", session);
		MemberDto result = memberService.member_getInfo(dto);
		logger.info("result ={}",result);
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		if(result== null) {
			
			map.put("flag", "1");
			
		}
		else{
			if(result.getPassword().equals(dto.getPassword())) {
				
				map.put("flag", "2");
				session.setAttribute("m_id", result.getM_id());
				session.setAttribute("login_id", result.getLogin_id());
				session.setAttribute("name", result.getName());
				session.setAttribute("nickname", result.getNickname());
			}
			else {
				map.put("flag", "3");
			}
		}
		
		return map;
		
	}
	
	@RequestMapping(value="/member/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redircet:/";
	}
	
	
	@GetMapping(value="/register")
	public String register(Model model) {
		
		logger.info("----------------------------------------------------------------");
		logger.info("회원가입 페이지");
		logger.info("----------------------------------------------------------------");

		MemberDto dto = new MemberDto();
		model.addAttribute("memberDto",dto);

		return "/member/register";
	}
	
	@GetMapping(value="/member/isDuplicate")
	@ResponseBody
	public HashMap<String,String> member_isDuplicate(MemberDto dto){
		
		
		int num = memberService.member_isDuplicate(dto);
		HashMap<String, String> map = new HashMap<>();
		
		if(num ==0) {
			
			map.put("result", "none");
		}
		else {
			map.put("result", "already");
		}
	
		return map;
	}
	
	
	
	@PostMapping(value="/member/myinfo")
	public String member_myinfo(Model model, HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		String login_id = (String)session.getAttribute("login_id");
		
		logger.info("login_id={}",login_id);
		
		if(login_id == null) {
			
			return "redirect:/member/login";
		}

		
		MemberDto result = (MemberDto) session.getAttribute("memberDto");
		model.addAttribute("memberDto",result);
		
		return "/member/mypage";
	}
	

	@GetMapping(value="/findid")
	public String findId() {
		
		logger.info("----------아이디 찾기 페이지---------");
		
		return "/member/findId";
	}
	
	@GetMapping(value="/member/findid_proc")
	@ResponseBody
	public HashMap<String,MemberDto > findid_proc(MemberDto dto){
		
		MemberDto findDto = memberService.member_findId(dto);
		
		HashMap<String, MemberDto> map = new HashMap<>();
		
		if(findDto == null) {
			
			map.put("fail", findDto);
		}
		else {
			
			map.put("success",findDto);
		}
		
		return map;
	}
	
	
	@GetMapping(value="/findpw")
	public String findPw() {
		
		logger.info("비밀번호 찾기 페이지");

		return "/member/findPw";
	}
	
	@Transactional
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("memberEmail") String memberEmail){
        MailDto dto = memberService.createMailAndChangePassword(memberEmail);
        memberService.mailSend(dto);

        return "/member/login";
    }
	
	
	

}
