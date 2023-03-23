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

}
