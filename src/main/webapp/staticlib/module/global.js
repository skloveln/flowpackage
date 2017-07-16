var postMap = {};
$.mypost = function(url,param,func) {
	if(postMap[url]) {
		error("点击不要过快哦");
		return;
	}
	postMap[url] = true;
	jQuery.post(url,param,function(data) {
		postMap[url] = null;
		func(data);
	});
};

function showUrl(title,url,wight,height) {
	var dwight = "800px";
	var dheight = "500px";
	if(height) {
		dheight = height+"px";
	}
	if(wight) {
		dwight = wight+"px";
	}
	
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	myLayer.open({
		type: 2,
		area: [dwight,dheight],
	    title:title,
		content:url
	}); 
	
/*	$.post(url,{},function(data) {
		var myLayer = window.parent.layer;
		if(!myLayer) {
			myLayer = layer;
		}
		myLayer.open({
		    type: 1,
		    area: ['800px',dheight],
		    title:title,
		    content: data
		 });
	},"html");*/
}

function msg(content) {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	myLayer.msg(content, {time: 2000});
}

function wait(content) {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	if(!content) {
		content = "请稍后....";
	}
	myLayer.msg(content,{shade:0.3,time: 100000});
}

function hide() {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	myLayer.closeAll();
}

function error(content) {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	myLayer.msg(content, {time: 2000});
}

function success(content) {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	myLayer.msg(content, {time: 2000});
}

function tip(content) {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	myLayer.msg(content, {time: 2000});
}

//确认对话框
function confirm(url,msg) {
	layer.open({
	    content:msg,
	    yes:function() {
	    	window.location.href=url;
	    }
	});
}

function del(url,msg) {
	wait("正在删除请稍后......");
	layer.open({
	    content:msg,
	    yes:function() {
	    	$.post(url,{},function(data) {
	    		hide();
	    		if(data.code == 200) {
	    			success("删除成功！");
	    			window.location.reload();
	    		}
	    		else {
	    			error(data.msg);
	    		}
	    		
	    	},"json");
	    	
	    }
	});
}

function showDomHtml(title,msg,area) {
	var myLayer = layer;
	var defaultArea = ['400px',"300px"];
	if(area) {
		defaultArea = area;
	}
	myLayer.open({
		type: 1,
		title:title,
	    content:msg,
	    area:defaultArea,
	    btn:[]
	});
}

function showDialog(title,msg,callBack,area) {
	var myLayer = window.parent.layer;
	if(!myLayer) {
		myLayer = layer;
	}
	var defaultArea = ['400px','300px'];
	if(area) {
		defaultArea = area;
	}
	myLayer.open({
		title:title,
	    content:msg,
	    area:defaultArea,
	    yes:function(index) {
	    	myLayer.close(index);
	    	if(callBack) {
	    		callBack();
	    	}
	    	return false;
	    }
	});
}

$(function() {
	layui.define(['layer','flow', 'layedit','code', 'form', 'element', 'util','upload'], function(exports){
		var $ = layui.jquery;
		var layer = layui.layer;
		var form = layui.form();
		//var util = layui.util;
		var device = layui.device();
		//阻止IE7以下访问
		if(device.ie && device.ie < 8){
			layer.alert('Layui最低支持ie8，您当前使用的是古老的 IE'+ device.ie + '，你丫的肯定不是程序猿！');
		}
		//手机设备的简单适配
		var treeMobile = $('.site-tree-mobile');
		var shadeMobile = $('.site-mobile-shade');

		treeMobile.on('click', function(){
			$('body').addClass('site-mobile');
		});

		shadeMobile.on('click', function(){
			$('body').removeClass('site-mobile');
		});
		exports('global', {});
		
		//菜单借点 图标
		window.global = {
		  preview: function(){
		    var preview = document.getElementById('LAY_preview');
		    return preview ? preview.innerHTML : '';
		  }()
		};
	});	
});

function str2Json(str) {
	var json = null;
	try{
		json = JSON.parse(str);
		for(var key in json) {
			var tempValue = json[key];
			json[key] = str2Json(tempValue);
		}
		return json;
	}
	catch(e) {
		return str;
	}
}

function map2Param(map) {
	var rs = "";
	for(var key in map) {
		rs = rs + key+"="+map[key]+"&";
	}
	if(rs.length>1) {
		rs = "?"+rs.substring(0,rs.length-1);
	}
	return rs;
}

$.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
};

function resizeShowTab() {
	if(window.parent) {
		window.parent.$(".layui-show").find("iframe").load();
	}
	else {
		$(".layui-show").find("iframe").load();
	}
}

function getVerifyCode(imgId,url) {
	$("#"+imgId).attr("src",url+"?date="+new Date());
}

function showSelectFile(uploaddiv,func,imageId) {
	if(!imageId) {
		imageId = "edui137_body";
	}
	//window.parent.UE.getEditor('editor_image');
	var parentDiv = $(uploaddiv).parent();
	
	var imgWindow = window.parent.window;
	if(!imgWindow) {
		imgWindow = window;
	}
	editor_image = imgWindow.UE.getEditor('editor_image');
	editor_image.removeListener("contentChange");
	editor_image.addListener("contentChange",function(){
		var imgContent = editor_image.getContent();
		var start = imgContent.indexOf("http://");
		var end = imgContent.indexOf(" alt=",start);
		if(start==-1 || end==-1) {
			return ;
		}
		var src = imgContent.substring(start,end-1);
		if(func) {
			func(src);
		}
		else {
			parentDiv.find("img").attr("src",src);
			parentDiv.find("input").val(src);
		}
	});
	
	try {
		editor_image.setContent("");	
	}
	catch(e) {}
	debugger;
	imgWindow.$("#editor_image").find("#"+imageId).click();
	imgWindow.$("#edui_fixedlayer").css("z-index",99999991);
	
}


var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
var num = ['0','1','2','3','4','5','6','7','8','9'];
function randNum(n) {
	var res = "";
    for(var i = 0; i < n ; i ++) {
        var id = Math.floor(Math.random()*10);
        res += num[id];
    }
    return res;
}

function randStr(n) {
	var res = "";
    for(var i = 0; i < n ; i ++) {
        var id = Math.floor(Math.random()*62);
        res += chars[id];
    }
    return res;
}

function cofingArticleUe(serverUrl) {
	UEDITOR_CONFIG.serverUrl = serverUrl;
	UEDITOR_CONFIG.toolbars = [[
	                            'fullscreen', 'source', '|', 'undo', 'redo', '|',
	                            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
	                            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
	                            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
	                            'directionalityltr', 'directionalityrtl', 'indent', '|',
	                            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
	                            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
	                            'simpleupload', 'insertimage', 'emotion', 'scrawl', 'insertvideo', 'music', 'attachment', 'map', 'gmap', 'insertframe', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
	                            'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
	                            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
	                            'print', 'preview', 'searchreplace', 'drafts', 'help'
	                        ]];
}

