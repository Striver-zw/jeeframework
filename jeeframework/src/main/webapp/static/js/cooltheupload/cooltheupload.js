/**
 * 拖拽事件监听
 * 使用html5 drag
 * 使用： 拖放位置： id="uploadList"
 * 		显示位置：id="preview"
 */
	document.ondragleave = function(e){
		//拖动元素离开的事件
		e.preventDefault();
		//console.log("out");//用谷歌浏览器器可以查看
		$("#uploadList").css({
			background: "#394e48"
		});
	};

	document.ondrop = function(e){
		e.preventDefault();//文件拖放以后执行的事件
		//console.log("stop");
		$("#uploadList").css({
			background: "#394e48"
		});
	};
	document.ondragover = function(e){
		e.preventDefault();
		//console.log("kk");
	};
	document.getElementById("uploadList").ondragover = function(e){
		e.preventDefault();
		//console.log("go");
		$("#uploadList").css({
			background: "#394e00"
		});
	};
	tm_upload();
	
	function tm_upload(){
		var uploaderar = document.getElementById("uploadList");
		//监听文件上传到区域松开事件
		uploaderar.addEventListener("drop",function(e){
			e.preventDefault();
			//获取文件列表信息
			var filteList = e.dataTransfer.files;
			var length = filteList.length;
			for(var i=0;i<length;i++){
				//得到流 回显数据
				var img = window.webkitURL.createObjectURL(filteList[i]);
				//图片过滤i
				if(filteList[i].type.indexOf("image")!=-1){
					var fileName = filteList[i].name;
					var fileSize = filteList[i].size;
					/*console.log(fileName+fileSize);*/
					
					var str = "<div><img src='"+img+"'><p>"+fileName+"</p></div>";
					document.getElementById("preview").innerHTML+=str;
					//使用原生态的ajax来异步操作
					xhr = new XMLHttpRequest();
					xhr.open("post", "/jeeframework/upload2.do",true);
					xhr.setRequestHeader("X-Requested-With","XMLHttpRequest");
					//动态赋值，传递二进制文件
					var formdata = new FormData();
					formdata.append("doc",filteList[i]);
					xhr.send(formdata);					
				}
			}
			//注册响应函数
			xhr.onreadystatechange = function jiao(){
		        if(xhr.readyState==4){
					 if(xhr.status==200){
		             //获取值
		             var ds = xhr.responseText;
		             /*console.log(ds);*/
			             if(ds){
			            	/*alert("data---------ok"); */
			             }
		             }                   
		         }
		     };
		});
	};    