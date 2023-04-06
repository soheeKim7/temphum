package mini.ksh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;
import mini.ksh.domain.ChartDataVO;

@Log4j
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MainServiceTest {
	
	@Autowired
	MainService service;
	
	@Test
	public void testGetList() {
		service.getList().forEach(vo -> log.info(vo));
	}

	@Test
	public void testChartGetList() {
		ChartDataVO chart=service.chartGetList();
		log.info("날짜 : "+chart.getMyprodate());  //배열은 toString 안되어 있어서 주소값이 나옴
		log.info("온도들 : "+chart.getMytemp());      //배열은 toString 안되어 있어서 주소값이 나옴
		log.info("습도들 : "+chart.getMyhum());      //배열은 toString 안되어 있어서 주소값이 나옴
		log.info("불쾌지들 : "+chart.getMydiscom());      //배열은 toString 안되어 있어서 주소값이 나옴
		log.info("만든 객체값 전부 확인 : "+chart);
	}
	
	@Test
	public void testStandard30Data() {
		log.info(service.standard30Data());
	}
	
	@Test
	public void testDiscomGraphList() {
		log.info(service.discomGraphList());
	}
	
}
