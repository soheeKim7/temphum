package mini.ksh.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import mini.ksh.domain.ChartDataVO;
import mini.ksh.domain.DataVO;
import mini.ksh.domain.DiscomVO;
import mini.ksh.service.MainService;

@RestController
@AllArgsConstructor
public class TempRestcontroller  {
	
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
//		return service.standard30Data();
		return service.compareData();
	}
	
	@GetMapping(value="api/discomChart",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DiscomVO> discomGraphList(){
		return service.discomGraphList();
	}
	
	@GetMapping(value="api/test", produces=MediaType.TEXT_PLAIN_VALUE)
	public String test(HttpServletRequest request, HttpServletResponse response){
		BufferedReader in = null;
//		Connection conn=null;
//		PreparedStatement pre=null;
		String result="";
		
		try {
			//1.URL생성
//			URL obj = new URL("http://mit305.iptime.org:10288"); // 호출할 url
			URL obj = new URL("http://59.12.4.106:7777"); // 호출할 url
			//2.연결객체 얻기
			HttpURLConnection httpUrlCon = (HttpURLConnection)obj.openConnection();
			//3.요청정보 셋팅(메소드, 헤더등....)	
			httpUrlCon.setRequestMethod("GET"); 	//생략가능(default값 get)
			//4.요청하기(응답은 in 변수에 저장)
			in = new BufferedReader(new InputStreamReader(httpUrlCon.getInputStream(), "UTF-8"));
			//5.응답결과 찍기
			System.out.println("일단 제이슨인데 어떻게 찍히나 보자 : "+in);
			String line="";
			String tempStr="";
			String humStr="";
			while((line = in.readLine()) != null) { // response를 차례대로 출력
				result=line;
				System.out.println("일단 라인 보자! : "+line);
				//{ "temp" : 27, "hum" : 64 }
				System.out.println("일단 라인 길이 보자 : "+line.length());
//				tempStr=line.substring(11, 13);
//				humStr=line.substring(23,25);
				//제이슨으로 하려다가 교수님이랗 했던거랑 똑같이 세팅해주자! 텍스트파일로 받아서 처리하자
				tempStr=line.substring(0,2);
				humStr=line.substring(2);
			}
		} catch(Exception e) {
        	System.out.println("오류 메시지 출력!");
            e.printStackTrace();
        }
		
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
		
		return result;
	}

	
	
	
//	implements Filter	
//	private static final String[] allowedOrigins = {
//            "http://localhost:8081", "http://m-it.iptime.org:4280/"
//    };
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//        String requestOrigin = request.getHeader("Origin");
//        if(isAllowedOrigin(requestOrigin)) {
//            // Authorize the origin, all headers, and all methods
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", requestOrigin);
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
//                    "GET, OPTIONS, HEAD, PUT, POST, DELETE");
//
//            HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//            // CORS handshake (pre-flight request)
//            if (request.getMethod().equals("OPTIONS")) {
//                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
//                return;
//            }
//        }
//        // pass the request along the filter chain
//        filterChain.doFilter(request, servletResponse);
//    }
//
//    private boolean isAllowedOrigin(String origin){
//        for (String allowedOrigin : allowedOrigins) {
//            if(origin.equals(allowedOrigin)) return true;
//        }
//        return false;
//    }
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
	

}
