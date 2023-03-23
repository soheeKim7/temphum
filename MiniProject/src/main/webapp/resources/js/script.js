function mychart(){
	Highcharts.chart('container', {
	  chart: {
	    zoomType: 'xy'
	  },
	  title: {
	    text: '온도와 습도 그래프',
	    align: 'left'
	  },
	  xAxis: [{
	    categories: myprodate,
	    crosshair: true
	  }],
	  yAxis: [{ // Primary yAxis
	    labels: {
	      format: '{value} °C',
	      style: {
	        color: Highcharts.getOptions().colors[1]
	      }
	    },
	    title: {
	      text: 'Temperature (온도)',
	      style: {
	        color: Highcharts.getOptions().colors[1]
	      }
	    }
	  }, { // Secondary yAxis
	    title: {
	      text: 'Humidity (습도)',
	      style: {
	        color: Highcharts.getOptions().colors[0]
	      }
	    },
	    labels: {
	      format: '{value} %',
	      style: {
	        color: Highcharts.getOptions().colors[0]
	      }
	    },
	    opposite: true
	  }],
	  tooltip: {
	    shared: true
	  },
	  legend: {
	    align: 'left',
	    x: 80,
	    verticalAlign: 'top',
	    y: 40,
	    floating: true,
	    backgroundColor:
	      Highcharts.defaultOptions.legend.backgroundColor || // theme
	      'rgba(255,255,255,0.25)'
	  },
	  series: [{
	    name: 'Humidity (습도)',
	    type: 'column',
	    yAxis: 1,
	    data: myhum,
	    tooltip: {
	      valueSuffix: ' %'
	    }
	
	  }, {
	    name: 'Temperature (온도)',
	    type: 'spline',
	    data: mytemp,
	    tooltip: {
	      valueSuffix: '°C'
	    }
	  }]
	});
}