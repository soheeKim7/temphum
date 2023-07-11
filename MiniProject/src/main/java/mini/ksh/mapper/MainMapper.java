package mini.ksh.mapper;

import java.util.List;

import mini.ksh.domain.DataVO;
import mini.ksh.domain.DataVO2;

public interface MainMapper {
	
	//가지고 있는 모든 데이터 리스트로 가져오기
	List<DataVO> getList();
	//현재날짜를 기준으로 그날의 최대 12개 데이터 가져오기
	List<DataVO2> getList2();
	
	//현재시간 30분 이하일때, 비교할 대상 그 전전시간 데이터 가져오기
	DataVO under30Data();
	//현재시간 30분 초과일때, 비교할 대상 바로 전시간 데이터 가져오기
	DataVO upper30Data();
	
	//현재시간 30분말고, 그냥 현재시간 기준으로, 비교할 대상-> 그해당 시간 같을때 데이터 가져오기
	//(예>현재시간 2023-07-11 21:23:02 -> 비교대상 2023-07-11 21:00:00)
	DataVO compareData();

}
