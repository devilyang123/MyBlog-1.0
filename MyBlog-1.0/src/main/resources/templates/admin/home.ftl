<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理端主页</title>
    <link rel="shortcut icon" href="/static/assets/ico/favicon.png">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <script src="/static/js/echarts.min.js"></script>
</head>
<style>
    .my-title{
        /*width: 100%;*/
        height: 50px;
        line-height: 50px;
        font-size: 50px;
        text-align: center;
        margin-top: 30px;
        /*background-color: saddlebrown;*/
    }
    .echarts-container{
        margin-top: 30px;
        /*background-color: sandybrown;*/
    }
</style>
<body>
    <div class="my-title">
        <span>博客后台管理</span>
    </div>
   <div class="echarts-container">
       <div id = "echarts-content" style="width: 600px;height: 400px;"></div>
   </div>
<script src="/static/layui/layui.js"></script>
    <script>
        $(function () {
            myChart=echarts.init(document.getElementById('echarts-content'));//获取容器
            //先设置完其它的样式，显示一个空的直角坐标轴，然后获取数据后填入数据
            myChart.setOption({
                title: {
                    text: '总访问量'
                },
                tooltip: {},
                legend: {
                    data:['访问量']
                },
                xAxis: {
                    data: []
                },
                yAxis: {},
                series: [{
                    name: '访问量',
                    type: 'bar',
                    data: []
                }]
            });
            // 异步加载json格式数据
            $.ajax({
                url:'/admin/blog/getCount',
                type:"GET",
                dataType:"json",
                success:function (data) {
                    console.log(data);
                    myChart.setOption({
                        xAxis: {
                            data: ['访问量']
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '访问量',
                            data: data.count
                        }]
                    });
                }
            });
        });
    </script>
</body>
</html>