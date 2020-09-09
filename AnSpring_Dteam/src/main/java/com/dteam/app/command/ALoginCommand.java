package com.dteam.app.command;

import org.springframework.ui.Model;

import com.dteam.app.dao.ANDao;
import com.dteam.app.dto.MemberDto;

public class ALoginCommand implements ACommand{

	@Override
	public void execute(Model model) {
		String member_id = (String)model.asMap().get("member_id");
		String member_pw = (String)model.asMap().get("member_pw");	
		
		ANDao adao = new ANDao();
		MemberDto adto = adao.anLogin(member_id, member_pw);
		
		model.addAttribute("anLogin", adto); 
	}

}

