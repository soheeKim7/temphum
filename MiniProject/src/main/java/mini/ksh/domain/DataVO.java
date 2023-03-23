package mini.ksh.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DataVO {
	
	private Date prodate;
	private int temp;
	private int hum;
	private double discom;

}
