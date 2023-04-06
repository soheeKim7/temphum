package mini.ksh.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import mini.ksh.domain.ChartDataVO;
import mini.ksh.domain.DataVO;
import mini.ksh.domain.DataVO2;
import mini.ksh.domain.DiscomVO;
import mini.ksh.domain.EmoticonVO;
import mini.ksh.domain.SrcVO;
import mini.ksh.mapper.MainMapper;

@Log4j
@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	MainMapper mapper;

	@Override
	public List<DataVO> getList() {
		log.info("getList ... ");
		mapper.getList().forEach(vo -> log.info(vo));
		return mapper.getList();
	}

	@Override
	public ChartDataVO chartGetList() {
		List<DataVO2> list=mapper.getList2();		
		//리턴할 객체를 생성
		ChartDataVO chart=new ChartDataVO();				
		//리턴할 객체에 값 세팅
		// 문자열 배열과, 숫자 배열 생성
		String[] myprodate=new String[list.size()];
		int[] mytemp=new int[list.size()];
		int[] myhum=new int[list.size()];
		double[] mydiscom=new double[list.size()];
				
		// 각각의 배열에 값 매핑후 리턴할 객체에 넣어줌
		int i=0;
		for(DataVO2 vo:list) {
			myprodate[i]=vo.getProdate()+"시";
			mytemp[i]=vo.getTemp();
			myhum[i]=vo.getHum();
			mydiscom[i]=vo.getDiscom();
			i++;
		}
		
//		DataVO vo=new DataVO();
//		for(int i=0;i<12;i++) {
//			vo=list.get(i);
//			myprodate[i]=vo.getProdate();
//			mytemp[i]=vo.getTemp();
//			myhum[i]=vo.getHum();
//			mydiscom[i]=vo.getDiscom();
//		}
		
		//이거 아님
//		DataVO vo=new DataVO();
//		for(int i=0;i<12;i++) {
//			vo=list.get(i);
//			for(int j=11;j==0;j--) {
//				myprodate[j]=vo.getProdate();
//				mytemp[j]=vo.getTemp();
//				myhum[j]=vo.getHum();
//				mydiscom[j]=vo.getDiscom();
//			}
//		}
		
		log.info("시간들 : "+myprodate);
		log.info("온도들 : "+mytemp);
		log.info("습도들 : "+myhum);
		log.info("불쾌지수들 : "+mydiscom);
		chart.setMyprodate(myprodate);
		chart.setMytemp(mytemp);
		chart.setMyhum(myhum);
		chart.setMydiscom(mydiscom);
				
		return chart;
	}

	@Override
	public DataVO standard30Data() {
		Date now=new Date();
		SimpleDateFormat fomat = new SimpleDateFormat("mmss");
		log.info("가져온 날짜 포맷 바꾼 형식 적용~! : "+fomat.format(now));
		//비교를 위해서 가져온 형식 숫자로 변환
		int nowNum=Integer.parseInt(fomat.format(now));		
		log.info("제대로 숫자 변형 되었겠지?"+nowNum);
		return nowNum<=3000 ? mapper.under30Data() : mapper.upper30Data();
	}

	@Override
	public List<DiscomVO> discomGraphList() {
		List<DataVO2> list=mapper.getList2();	
		
		List<DiscomVO> graphList=new ArrayList<>();
		
//		discomvo.setName(list.get(0).getProdate()+"시");
//		discomvo.setValue(list.get(0).getDiscom());
//		discomvo.setBulletSettings(new SrcVO(discomvo.getValue()));
//		graphList.add(discomvo);
		
		for(DataVO2 vo:list) {
			DiscomVO discomvo=new DiscomVO();
			discomvo.setName(vo.getProdate()+"시");
			discomvo.setValue(vo.getDiscom());
			discomvo.setBulletSettings(new SrcVO(discomvo.getValue()));
			graphList.add(discomvo);
		}
		
		return graphList;
	}
}
