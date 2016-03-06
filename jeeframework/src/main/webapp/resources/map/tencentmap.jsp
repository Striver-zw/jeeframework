<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>腾讯地图</title>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>
</head>
<body onload="init()">
	<script>
        var geocoder, map, marker = null;
        var init = function() {
        	/* 初始化 */
           var center = new qq.maps.LatLng(28.178792, 112.985657);
            map = new qq.maps.Map(document.getElementById('container'), {
                center: center,
                zoom: 15,
            });

            //地址和经纬度之间进行转换服务
            geocoder = new qq.maps.Geocoder({
                //设置服务请求成功的回调函数
                complete: function(result) {
                    map.setCenter(result.detail.location);
                    var marker = new qq.maps.Marker({
                        map: map,
                        position: result.detail.location
                    });
                    /* alert(result.detail.location); */
                   /*  $("#jwd").text(result.detail.location); */
                    document.getElementById("jwd").innerHTML=result.detail.location
                    $("#hjwd").val(result.detail.location);
                   
                    //点击Marker会弹出反查结果
                    //qq.maps.event.addListener(marker, 'click', function() {
                    //    alert("坐标地址为： " + result.detail.location);
                    //});
                },
                //若服务请求失败，则运行以下函数
                error: function() {
                    alert("出错了，请输入正确的经纬度！！！");
                }
            });

        }
        function codeAddress() {
            var address = document.getElementById("address").value;
            //对指定地址进行解析
            geocoder.getLocation(address);
        }
    </script>
    <input id="address" />
	<input type="button" class="btn" value="定位" onclick="codeAddress()" />(获取坐标)
	<br>
	经纬度：
	<span style="font-size: 13px;color: blue;" id="jwd"></span>
	<br>
	<br>
	<div>
		<div style="width: 600px; height: 300px;" id="container"></div>
	</div>
</body>
</html>