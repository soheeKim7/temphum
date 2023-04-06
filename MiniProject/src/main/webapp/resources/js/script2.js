function mychart2(mydata){
	
	/**
	 * ---------------------------------------
	 * This demo was created using amCharts 5.
	 * 
	 * For more information visit:
	 * https://www.amcharts.com/
	 * 
	 * Documentation is available at:
	 * https://www.amcharts.com/docs/v5/
	 * ---------------------------------------
	 */
	
	// Create root element
	// https://www.amcharts.com/docs/v5/getting-started/#Root_element
	var root = am5.Root.new("chartdiv");
	
	// Set themes
	// https://www.amcharts.com/docs/v5/concepts/themes/
	root.setThemes([
	  am5themes_Animated.new(root)
	]);
	
	// Create chart
	// https://www.amcharts.com/docs/v5/charts/xy-chart/
	var chart = root.container.children.push(am5xy.XYChart.new(root, {
	  panX: false,
	  panY: false,
	  wheelX: "none",
	  wheelY: "none"
	}));
	
	// Add cursor
	// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
	var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));
	cursor.lineY.set("visible", false);
	
	// Create axes
	// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
	var xRenderer = am5xy.AxisRendererX.new(root, { minGridDistance: 30 });
	
	var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
	  maxDeviation: 0,
	  categoryField: "name",
	  renderer: xRenderer,
	  tooltip: am5.Tooltip.new(root, {})
	}));
	
	xRenderer.grid.template.set("visible", false);
	
	var yRenderer = am5xy.AxisRendererY.new(root, {});
	var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
	  maxDeviation: 0,
	  min: 0,
	  extraMax: 0.1,
	  renderer: yRenderer
	}));
	
	yRenderer.grid.template.setAll({
	  strokeDasharray: [2, 2]
	});
	
	// Create series
	// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
	var series = chart.series.push(am5xy.ColumnSeries.new(root, {
	  name: "Series 1",
	  xAxis: xAxis,
	  yAxis: yAxis,
	  valueYField: "value",
	  sequencedInterpolation: true,
	  categoryXField: "name",
	  fill: am5.color("#90ee90"),
	  stroke: am5.color("#90ee90"),
	  tooltip: am5.Tooltip.new(root, { dy: -25, labelText: "{valueY}" })
	}));
	
	// Set data
//	var data = [
//		  {
//			for(var i=0;i<myprodate.length;i++){
//			    name: myprodate[i],
//			    value: mydiscom[i],
//			    bulletSettings: { src: "https://www.amcharts.com/lib/images/faces/A04.png" }
//			};
//		  }
//		];
	
//	var data = [
//		  {			  
//		    name: myprodate,
//		    value: 68.21,
//		    bulletSettings: { src: "resources/img/낮음.png" }
//		  },
//		  {
//		    name: "Damon",
//		    value: 72.65,
//		    bulletSettings: { src: "resources/img/보통.png" }
//		  },
//		  {
//		    name: "Patrick",
//		    value: 84.65,
//		    bulletSettings: { src: "resources/img/불쾌.png" }
//		  },
//		  {
//		    name: "Mark",
//		    value: 63.12,
//		    bulletSettings: { src: "resources/img/매우불쾌.png" }
//		  }
//	];
	var data=mydata;
	
	series.bullets.push(function() {
	  return am5.Bullet.new(root, {
	    locationY: 1,
	    sprite: am5.Picture.new(root, {
	      templateField: "bulletSettings",
	      width: 50,
	      height: 50,
	      centerX: am5.p50,
	      centerY: am5.p50,
	      shadowColor: am5.color(0x000000),
	      shadowBlur: 4,
	      shadowOffsetX: 4,
	      shadowOffsetY: 4,
	      shadowOpacity: 0.6
	    })
	  });
	});
	
	xAxis.data.setAll(data);
	series.data.setAll(data);
	
	// Make stuff animate on load
	// https://www.amcharts.com/docs/v5/concepts/animations/
	series.appear(1000);
	chart.appear(1000, 100);
}