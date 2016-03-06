<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>百度地图</title>
<script type="text/javascript"></script>
</head>
<body >

    <input id="address" type="text"/>
	<input type="button" id="search_button" class="btn" value="定位"/>(点击标注获取坐标,双击地图或拖动标注可重新定位)
	<br>
	经纬度：
	<span style="font-size: 13px;color: blue;" id="jwd"></span>
	<br>
	<br>
	<div>
		<div style="width: 600px; height: 300px;" id="container"></div>
	</div>

	<script charset="utf-8" src="http://api.map.baidu.com/api?v=1.2"></script>
	<script>
	/* 要先加载画布（div）才能初始化地图 */
	/* 拿到地址 */
	function getUrlParas(){
        var hash = location.hash,
            para = {},
            tParas = hash.substr(1).split("&");
        for(var p in tParas){
            if(tParas.hasOwnProperty(p)){
                var obj = tParas[p].split("=");
                para[obj[0]] = obj[1];
            }
        }
        return para;
    }
    var para = getUrlParas(),
        center = para.address?decodeURIComponent(para.address) : "侯家塘",
        city = para.city?decodeURIComponent(para.city) : "长沙市";

    document.getElementById("address").value = center;

  	/* 初始化 */
    var marker_trick = false;
    var map = new BMap.Map("container");
    map.enableScrollWheelZoom();

    var marker = new BMap.Marker(new BMap.Point(112.993239,28.178679), {
        enableMassClear: false,
        raiseOnDrag: true
	 });

    marker.enableDragging();
    map.addOverlay(marker);

 // 添加带有定位的导航控件
    var navigationControl = new BMap.NavigationControl({
      // 靠左上角位置
      anchor: BMAP_ANCHOR_TOP_LEFT,
      // LARGE类型
      type: BMAP_NAVIGATION_CONTROL_LARGE,
      // 启用显示定位
      enableGeolocation: true
    });
    map.addControl(navigationControl);
    
    map.addEventListener("click", function(e){
        if(!(e.overlay)){
            map.clearOverlays();
            marker.show();
            marker.setPosition(e.point);
            setResult(e.point.lng, e.point.lat);
        }
    });
    marker.addEventListener("dragend", function(e){
        setResult(e.point.lng, e.point.lat);
    });

    var local = new BMap.LocalSearch(map, {
        renderOptions:{map: map},
		 pageCapacity: 1
    });
    local.setSearchCompleteCallback(function(results){
        if(local.getStatus() !== BMAP_STATUS_SUCCESS){
            alert("无结果");
        } else {
		     marker.hide();
		 }
    });
    local.setMarkersSetCallback(function(pois){
        for(var i=pois.length; i--; ){
            var marker = pois[i].marker;
            marker.addEventListener("click", function(e){
                marker_trick = true;
                var pos = this.getPosition();
                setResult(pos.lng, pos.lat);
            });
        }
    });

    window.onload = function(){
    	 local.search(center);
        document.getElementById("search_button").onclick = function(){
            local.search(document.getElementById("address").value);
        };
        document.getElementById("address").onkeyup = function(e){
            var me = this;
            e = e || window.event;
            var keycode = e.keyCode;
            if(keycode === 13){
                local.search(document.getElementById("address").value);
            }
        };
    };
	
    /*
     * setResult : 定义得到标注经纬度后的操作
     * 请修改此函数以满足您的需求
     * lng: 标注的经度
     * lat: 标注的纬度
     */
    function setResult(lng, lat){
    	 var re=lng + "," + lat;
    	/*  alert(re); */
    	 document.getElementById("jwd").innerHTML = re;
    	/*  document.getElementById("hjwd").value=re; */
     }
    </script>
</body>
</html>