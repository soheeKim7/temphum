package mini.ksh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SrcVO {
	
	private  String src;

	public SrcVO() {
		super();
		EmoticonVO vo=new EmoticonVO();
		src=vo.getEmo()[0];
	}

	public SrcVO(double value) {
		super();
		EmoticonVO vo=new EmoticonVO();
		if(value<68.0) 
			src=vo.getEmo()[0];
		else if(value<75.0) 
			src=vo.getEmo()[1];
		else if(value<80.0) 
			src=vo.getEmo()[2];
		else 
			src=vo.getEmo()[3];
	}	
	

//	@Override
//	public String toString() {
//		return "SrcVO [src=" + src + "]";
//	}

}
