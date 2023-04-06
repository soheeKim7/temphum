package mini.ksh.service;

import java.util.List;

import mini.ksh.domain.ChartDataVO;
import mini.ksh.domain.DataVO;
import mini.ksh.domain.DiscomVO;

public interface MainService {
	
	//가지고 있는 모든 데이터 리스트로 가져오기
	List<DataVO> getList();
	//현재날짜를 기준으로 그날의 최대 12개 데이터 가져오기
	ChartDataVO chartGetList();
	//불쾌지수 넣어야할 데이터
	List<DiscomVO> discomGraphList();
	
	//현재시간의 30분을 기준으로, 30분이하시, 그 전전 데이터, 30분초과시 바로전 데이터 가져오기
	DataVO standard30Data();
	
}
