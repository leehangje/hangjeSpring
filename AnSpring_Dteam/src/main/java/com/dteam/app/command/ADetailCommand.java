package com.dteam.app.command;

import org.springframework.ui.Model;

import com.dteam.app.dao.ANDao;
import com.dteam.app.dto.MdDto;

public class ADetailCommand implements ACommand{

	@Override
	public void execute(Model model) {
		
		 //String member_id = (String)model.asMap().get("member_id"); 
		 //String member_addr = (String)model.asMap().get("member_addr");
		 //String md_name = (String)model.asMap().get("md_name"); 
		 //int md_price = (Integer)model.asMap().get("md_price"); 
		 //int md_deposit = (Integer)model.asMap().get("md_deposit"); 
		 //String md_category = (String)model.asMap().get("md_category"); 
		 //String md_registration_date = (String)model.asMap().get("md_registration_date"); 
		 //int md_hits = (Integer)model.asMap().get("md_hits"); 
		 //int md_fav_count = (Integer)model.asMap().get("md_fav_count"); 
		 //String md_detail_content = (String)model.asMap().get("md_detail_content");
		 //int md_serial_number = (Integer)model.asMap().get("md_serial_number");
		
		 String md_serial_number = (String) model.asMap().get("md_serial_number");
		
		ANDao adao = new ANDao();
		
		 //MdDto mdDto = adao.anDetail(member_id, member_addr, md_name, md_price,
		 //md_deposit, md_category, md_registration_date, md_hits, md_fav_count,
		 //md_detail_content, md_serial_number);
		 
		MdDto mdDto = adao.anDetail(md_serial_number);
		
		model.addAttribute("anDetail", mdDto);
	}

}
