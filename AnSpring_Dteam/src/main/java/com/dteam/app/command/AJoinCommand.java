package com.dteam.app.command;

import org.springframework.ui.Model;

import com.dteam.app.dao.ANDao;

public class AJoinCommand implements ACommand{

	@Override
	public void execute(Model model) {
		String member_id = (String) model.asMap().get("member_id");
		String member_pw = (String) model.asMap().get("member_pw");
		String member_nickname = (String) model.asMap().get("member_nickname");
		String member_tel = (String) model.asMap().get("member_tel");
		String member_addr = (String) model.asMap().get("member_addr");
		String member_latitude = (String) model.asMap().get("member_latitude");
		String member_longitude = (String) model.asMap().get("member_longitude");
		String member_name = (String) model.asMap().get("member_name");
		
		ANDao adao = new ANDao();
		int state = adao.anJoin(member_id, member_pw, member_nickname, member_tel, member_addr, 
								member_latitude, member_longitude, member_name);
		
		model.addAttribute("anJoin", String.valueOf(state));	//model에 집어넣기
	
	}

}

