<%--
  User: ZHOU
  Date: 2018/10/21
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Echart图</title>
    <%--映入echart--%>
    <script src="js/echarts.common.min.js"></script>
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div class="col-md-12">
    <div id="eChart" style="height: 200px;">
    </div>
</div>
<script>
    var myChart=echarts.init(document.getElementById('eChart'))
    //显示标题
    myChart.setOption({
        title:{
            text:'高程显示'
        },
        tooltip:{},
        legend:{
            data:['高程']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '高程',
            type: 'bar',
            data: []
        }]
    });
    myChart.showLoading();
    var names=[];   //用来放x坐标值
    var nums=[];    //用来放y坐标值

    $.ajax({
        type:"post",
        async:true,
        url:"/hello",
        data:{},
        dataType:"json",   //返回为json数据
        success:function (result) {
            if (result){
                for (var i=0;i<result.length;i++){
                    names.push(result[i].riqi);
                }
                for (var i=0;i<result.length;i++){
                    nums.push(result[i].attu);
                }
                myChart.hideLoading();//隐藏加载动画
                myChart.setOption({
                    xAxis:{
                        data:names
                    },
                    series:[{
                        name:"高程",
                        data:nums
                    }]
                });
            }
        },
        error: function (errorMsg) {

            //请求失败时执行该函数

            alert("图表请求数据失败!");

            myChart.hideLoading();

        }

    })
</script>

</body>
</html>
