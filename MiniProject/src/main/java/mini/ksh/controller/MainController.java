package mini.ksh.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import mini.ksh.mapper.MainMapper;
import mini.ksh.service.MainService;

@Log4j
@Controller
@AllArgsConstructor
public class MainController {
	
	MainService service;
	
	@GetMapping("main")
	public void main(Model model) {
		Date todaydate=new Date();
		model.addAttribute("todaydate",todaydate);
		model.addAttribute("list",service.getList());
//		model.addAttribute("chartlist",service.chartGetList());
	}

}
