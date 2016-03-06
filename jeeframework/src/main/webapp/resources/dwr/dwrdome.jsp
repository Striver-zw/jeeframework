 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--  <script type='text/javascript' src='dwr/engine.js'> </script>
 <script type='text/javascript' src='dwr/util.js'> </script> -->
 <!-- <script type='text/javascript' src='dwr/interface/Demo.js'></script> -->
<script type="text/javascript" src="dwr/engine.js"></script>
        <script type="text/javascript" src="dwr/util.js"></script>
        <script type="text/javascript" src="dwr/interface/MessagePush.js"></script>
    <SCRIPT type="text/javascript">  
if(!!window.ActiveXObject || "ActiveXObject" in window)
{
    //
    document.write(' <OBJECT id="Player"');  
    document.write(' classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0"');
    document.write(' width=0 height=0 > <param name="URL" value="/static/map3/message.mp3" /> <param name="AutoStart" value="false" />  <embed src="/static/map3/message.mp3" quality="high" wmode="transparent" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash"></embed></OBJECT>');  
}  
else  
{
/* 	alert("非ie"); */
  var audio ;
window.onload = function(){
	initAudio();
}
var initAudio = function(){
	/* alert("init"); */
}
function playOrPaused(){
	 audio = document.getElementById('audio');
	if(audio.paused){
		audio.play();
		/* obj.innerHTML='暂停'; */
		return;
	}
	audio.pause();
	/* obj.innerHTML='播放'; */
}
} 
</SCRIPT>

	<script type="text/javascript">
      function onPageLoad(){
             	/* MessagePush.onPageLoad("123"); */
             	var idu = document.getElementById("uid").value;
             	MessagePush.onPageLoad(idu);
          	}
          	function showMessage(autoMessage) {
          		/* alert(autoMessage); */
          		listreust();
          		/* document.all.bb.innerHTML = autoMessage; */
          		document.getElementById("spt").innerHTML=autoMessage;
          		document.getElementById("datahtml").innerHTML=autoMessage;
	        	if(!!window.ActiveXObject || "ActiveXObject" in window){
	        	 	Player.controls.play(); 
	        	}else{
	        		playOrPaused();
	        	}
          	}
          	
          	function MyShow() 
          	{ 
          	   timer = window.setInterval("onPageLoad()",2000); 
          	}
    </script>
<style>
* { padding: 0; margin: 0; }
li { list-style: none; }
body { background: #eee; }
.float_layer { width: 300px; border: 1px solid #aaaaaa; display:none; background: #fff; }
.float_layer h2 { height: 25px; line-height: 25px; padding-left: 10px; font-size: 14px; color: #333; background: url(http://www.webdm.cn/images/20131124/title_bg.gif) repeat-x; border-bottom: 1px solid #aaaaaa; position: relative; }
.float_layer .min { width: 21px; height: 20px; background: url(http://www.webdm.cn/images/20131124/min.gif) no-repeat 0 bottom; position: absolute; top: 2px; right: 25px; }
.float_layer .min:hover { background: url(http://www.webdm.cn/images/20131124/min.gif) no-repeat 0 0; }
.float_layer .max { width: 21px; height: 20px; background: url(http://www.webdm.cn/images/20131124/max.gif) no-repeat 0 bottom; position: absolute; top: 2px; right: 25px; }
.float_layer .max:hover { background: url(http://www.webdm.cn/images/20131124/max.gif) no-repeat 0 0; }
.float_layer .close { width: 21px; height: 20px; background: url(http://www.webdm.cn/images/20131124/close.gif) no-repeat 0 bottom; position: absolute; top: 2px; right: 3px; }
.float_layer .close:hover { background: url(http://www.webdm.cn/images/20131124/close.gif) no-repeat 0 0; }
.float_layer .content { height: 120px; overflow: hidden; font-size: 14px; line-height: 18px; color: #666; text-indent: 28px; }
.float_layer .wrap { padding: 10px; }
</style>
</head>
 <body onload="dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true);MyShow();">
 <audio  id="audio"  src="static/map3/message.mp3"></audio>

<body style="height: 2200px">
<input id="uid" value="${requestScope.user.id}">
<div class="float_layer" id="miaov_float_layer">
    <h2>
        <strong>订单提醒</strong>
        <a id="btn_min" href="javascript:;" class="min"></a>
        <a id="btn_close" href="javascript:;" class="close"></a>
    </h2>
    <div class="content">
    	<div class="wrap" id="spt">
        	
        </div>
     </div>
 
</div>
<div>
    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td id="datahtml">数据显示&nbsp;</td>
  </tr>
</table>
</div>

<br>
测试数据
<!-- <input type=button value="开始" onclick="send();" /> -->

</body>
</html>



<script type="text/javascript">
function miaovAddEvent(oEle, sEventName, fnHandler)
{
	if(oEle.attachEvent)
	{
		oEle.attachEvent('on'+sEventName, fnHandler);
	}
	else
	{
		oEle.addEventListener(sEventName, fnHandler, false);
	}
}
function listreust()
{
	var oDiv=document.getElementById('miaov_float_layer');
	var oBtnMin=document.getElementById('btn_min');
	var oBtnClose=document.getElementById('btn_close');
	var oDivContent=oDiv.getElementsByTagName('div')[0];
	
	var iMaxHeight=0;
	
	var isIE6=window.navigator.userAgent.match(/MSIE 6/ig) && !window.navigator.userAgent.match(/MSIE 7|8/ig);
	oDiv.style.display='block';
	iMaxHeight=oDivContent.offsetHeight;
	
	if(isIE6)
	{
		oDiv.style.position='absolute';
		repositionAbsolute();
		miaovAddEvent(window, 'scroll', repositionAbsolute);
		miaovAddEvent(window, 'resize', repositionAbsolute);
	}
	else
	{
		oDiv.style.position='fixed';
		repositionFixed();
		miaovAddEvent(window, 'resize', repositionFixed);
	}
	
	oBtnMin.timer=null;
	oBtnMin.isMax=true;
	oBtnMin.onclick=function ()
	{
		startMove
		(
			oDivContent, (this.isMax=!this.isMax)?iMaxHeight:0,
			function ()
			{
				oBtnMin.className=oBtnMin.className=='min'?'max':'min';
			}
		);
	};
	
	oBtnClose.onclick=function ()
	{
		oDiv.style.display='none';
	};
};

function startMove(obj, iTarget, fnCallBackEnd)
{
	if(obj.timer)
	{
		clearInterval(obj.timer);
	}
	obj.timer=setInterval
	(
		function ()
		{
			doMove(obj, iTarget, fnCallBackEnd);
		},30
	);
}

function doMove(obj, iTarget, fnCallBackEnd)
{
	var iSpeed=(iTarget-obj.offsetHeight)/8;
	
	if(obj.offsetHeight==iTarget)
	{
		clearInterval(obj.timer);
		obj.timer=null;
		if(fnCallBackEnd)
		{
			fnCallBackEnd();
		}
	}
	else
	{
		iSpeed=iSpeed>0?Math.ceil(iSpeed):Math.floor(iSpeed);
		obj.style.height=obj.offsetHeight+iSpeed+'px';
		
		((window.navigator.userAgent.match(/MSIE 6/ig) && window.navigator.userAgent.match(/MSIE 6/ig).length==2)?repositionAbsolute:repositionFixed)()
	}
}

function repositionAbsolute()
{
	var oDiv=document.getElementById('miaov_float_layer');
	var left=document.body.scrollLeft||document.documentElement.scrollLeft;
	var top=document.body.scrollTop||document.documentElement.scrollTop;
	var width=document.documentElement.clientWidth;
	var height=document.documentElement.clientHeight;
	
	oDiv.style.left=left+width-oDiv.offsetWidth+'px';
	oDiv.style.top=top+height-oDiv.offsetHeight+'px';
}

function repositionFixed()
{
	var oDiv=document.getElementById('miaov_float_layer');
	var width=document.documentElement.clientWidth;
	var height=document.documentElement.clientHeight;
	
	oDiv.style.left=width-oDiv.offsetWidth+'px';
	oDiv.style.top=height-oDiv.offsetHeight+'px';
}
</script>
