var options = {
    series: [{
        name: 'series1',
        data: [0, 20, 15, 40, 18, 20, 18, 23, 18, 35, 30, 55, 0]
    }],
    chart: {
        height: 150,
        type: 'area',
        toolbar: {
            show: false
        },
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        curve: 'smooth'
    },
    xaxis: {
        type: 'category',
        low: 0,
        offsetX: 0,
        offsetY: 0,
        show: false,
        categories: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan"],
        labels: {
            low: 0,
            offsetX: 0,
            show: false,
        },
        axisBorder: {
            low: 0,
            offsetX: 0,
            show: false,
        },
    },
    markers: {
        strokeWidth: 3,
        colors: "#ffffff",
        strokeColors: ['#F65365', '#D6FFF9'],
        hover: {
            size: 6,
        }
    },
    yaxis: {
        low: 0,
        offsetX: 0,
        offsetY: 0,
        show: false,
        labels: {
            low: 0,
            offsetX: 0,
            show: false,
        },
        axisBorder: {
            low: 0,
            offsetX: 0,
            show: false,
        },
    },
    grid: {
        show: false,
        padding: {
            left: 0,
            right: 0,
            bottom: 0,
            top: 0
        }
    },
    colors: ['#884FFB', '#884FFB'],
    fill: {
        type: 'gradient',
        gradient: {
            shadeIntensity: 1,
            opacityFrom: 0.7,
            opacityTo: 0.5,
            stops: [0, 80, 100]
        }
    },
    legend: {
        show: false,
    },
    tooltip: {
        x: {
            format: 'MM'
        },
    },
};
var chart = new ApexCharts(document.querySelector("#chart-currently"),options);
chart.render();
var options1 = {
    chart: {
        height: 380,
        type: 'bar',
        toolbar: {
            show: false
        },
    },
    series: [{
        name: 'Net Profit',
        data: [44, 55, 57, 56, 61, 58]
    }, {
        name: 'Revenue',
        data: [76, 85, 101, 98, 87, 105]
    }],
    plotOptions: {
        bar: {
            horizontal: false,
            columnWidth: ['30%'],
            endingShape: 'rounded'
        },
    },
    xaxis: {
        categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
        axisBorder: {
            show: false,
        },
        axisTicks: {
            show: false
        },
        labels: {
            style: {
                fontSize: '12px'
            }
        }
    },
    colors: ["#F65365", "#E5EAEE"],
    markers: {
        size: 6,
        colors: ['#fff'],
        strokeColor: "#F65365",
        strokeWidth: 3,
    },
    legend: {
        show: false
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        show: true,
        width: 2,
        colors: ['transparent']
    },
    states: {
        normal: {
            filter: {
                type: 'none',
                value: 0
            }
        },
        hover: {
            filter: {
                type: 'none',
                value: 0
            }
        },
        active: {
            allowMultipleDataPointsSelection: false,
            filter: {
                type: 'none',
                value: 0
            }
        }
    },
    grid: {
        borderColor: "#FFCCD2",
        strokeDashArray: 4,
        yaxis: {
            lines: {
                show: true
            }
        }
    }
}
var chart1 = new ApexCharts(document.querySelector("#marketchart"),options1);
chart1.render();
