package mini.ksh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscomVO {
	
	//X축 시간
	private String name;
	//y축 불쾌지수
	private double value;
	//이모티콘
	private SrcVO bulletSettings; 
	
}
