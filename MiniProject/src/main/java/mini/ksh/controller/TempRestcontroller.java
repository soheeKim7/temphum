package mini.ksh.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mini.ksh.domain.ChartDataVO;
import mini.ksh.domain.DataVO;
import mini.ksh.service.MainService;

@RestController
@AllArgsConstructor
public class TempRestcontroller {
	
	MainService service;
	
	@GetMapping(value="gettemp", produces="text/plain; charset=UTF-8")
	public String gettemp() {
		String[] strArr= {"1730","2440","2951","3270","1090"};
		
		return strArr[(int)(Math.random()*5)];
	}
	
	@GetMapping(value="api/chart",produces=MediaType.APPLICATION_JSON_VALUE)
	public ChartDataVO chart() {
		return service.chartGetList();
	}
	
	@GetMapping(value="api/compare",produces=MediaType.APPLICATION_JSON_VALUE)
	public DataVO standard30Data(){
		return service.standard30Data();
	}
	
	

}
