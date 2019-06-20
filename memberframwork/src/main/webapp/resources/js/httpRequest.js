function getXMLHttpRequest(){
	if(window.ActiveXObject){	// 인터넷익스플로러냐?
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");	//구버전
		}catch(e1){	// 아니냐?
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");	//신버전
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();	// 서버와 통신할 수 있는 거.........
	}else{
		return null;
	}
}

var httpRequest = null;

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : 'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams;	// 주소에 붙여서
	}
	
	//alert("method == " + httpMethod + "\turl == " + httpUrl + "\tparam == " + httpParams);
	httpRequest.open(httpMethod, httpUrl, true);	//true 비동기방식, f 동기방식!!
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');			// ***********반드시 해야한다!
	httpRequest.onreadystatechange = callback;	// 이 상태가 바뀔때마다 callback함수를 가져온다!(비동기)	// ***********반드시 해야한다!
	//alert(httpMethod == 'POST' ? httpParams : null);
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);	//send라는거 안에다가 보내라!			// ***********반드시 해야한다!
}