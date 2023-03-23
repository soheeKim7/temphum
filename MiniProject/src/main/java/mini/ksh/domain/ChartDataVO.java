package mini.ksh.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ChartDataVO {
	
	private String[] myprodate;
	private int[] mytemp;
	private int[] myhum;
	private double[] mydiscom;

}
