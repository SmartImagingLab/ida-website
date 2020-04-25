/**
 * 
 */
/**
 * Created by Kay on 2016/3/8.
 */
function login() {
 
	//获取用户名和密码
	System.out.println("js");
	var StudentId = document.getElementById("StudentId").value;
	var StudentName = document.getElementById("StudentName").value;
	//发送AJAX POST请求完成登录
	//1、创建AJAX核心对象
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//2、注册回调函数
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){//200表示服务器正常响应结束
				if (xhr.responseText =="正确"){
					window.location.href="via.html";
				}else if (xhr.responseText == "学号错误"){
					alert("学号错误！");
				}else if (xhr.responseText == "姓名错误"){
					alert("姓名错误！");
				}
			}else{
				//弹出错误代码（xhr.status属性可以获取到HTTP的响应状态码）
				alert(xhr.status);
			}
		}
	}
	//3、开启通道
	xhr.open("POST", "login.do", true);
	//发送POST请求必须使用表单form进行提交， 只有form才能提交post请求
	//使用POST请求以下代码行必须有
	//ajax post请求的乱码，需要在这里处理，注意：字符集需要和浏览器的字符集相同，需要和服务器当中的字符集相同。
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");  //模拟表单提交数据
	//xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	//4.发送请求
	xhr.send("StudentId=" + StudentId + "&StudentName=" + StudentName);  //post请求提交数据在send方法当中提交
}


