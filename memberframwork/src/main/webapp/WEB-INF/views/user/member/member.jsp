<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%-- <script type="text/javascript" src = "${root}/js/httpRequest.js"></script> --%>
<script type="text/javascript">

var cnt = 1;
$(document).ready(function() {
	
	$("#id").keyup(function() {
		var id = $("#id").val();
		if(id.length < 5 || id.length > 16){
			cnt = 1;
			$("#idresult").css("color", "gray");
			$("#idresult").text("아이디는 5자 이상 16자 이하입니다.");
		}else{	// 사용할 수 있다? 없다?
			$.ajax({
				type : "GET",
				url : "${root}/user/idcheck.kitri",
				dataType : "json",
				data : {"checkid" : id},	// checkid를 찾아서 알아서 들어간다 (String checkid)그렇지만 명시해주자!(MemberController)
				success : function(data){
					cnt = parseInt(data.idcount);
					if(cnt == 0){
						$("#idresult").css("color", "steelblue");
						$("#idresult").html("<strong>" + id + "</strong>는 사용 가능합니다.");
					}else{
						$("#idresult").css("color", "magenta");
						$("#idresult").html("<strong>" + id + "</strong>는 사용중입니다.");
					}
				}
			});
		}
	});
	
	$('#zipcode').focusin(function(){
		$('#zipModal').modal();
	});
	
	$("#registerBtn").click(function() {
		if ($("#id").val().trim().length == 0) {
			alert("아이디 입력!!!");
			return;
		}else if ($("#name").val().trim().length == 0) {
			alert("이름 입력!!!");
			return;
		}else if ($("#pass").val().trim().length == 0) {
			alert("비밀번호 입력!!!");
			return;
		}else if ($("#pass").val() != $("#passcheck").val()) {
			alert("비밀번호 확인!!!");
			return;
		}else if (cnt != 0) {
			alert("아이디 중복 확인!!!");
			return;
		}else{
			$("#memberform").attr("action", "${root}/user/register.kitri").submit();
		}
	});
});

/*
var resultView;
var idcount = 1;

function idcheck(){
	resultView = document.getElementById("idresult");
	var searchId = document.getElementById("id").value;
	if(searchId.length <5 || searchId.length > 16){
		resultView.innerHTML = '<font color = "gray">아이디는 5자이상 16자 이하입니다.</font>';
	}else{
		var params = "act=idcheck&sid=" + searchId;
		sendRequest("${root}/user",params, idcheckResult, "GET");	무조건 컨트롤러 가야한다!
	}
}*/

/* function idcheckResult(){
	if(httpRequest.readyState == 4){	// 모든 데이터가 정상적으로 넘어왔다!   httpRequest이걸 가지고 모든 것을 처리한다!
		if(httpRequest.status == 200){	// 정상적인 데이터가 넘어왔다
			var result = httpRequest.responseXML;
			idcount = parseInt(result.getElementsByTagName("cnt")[0].firstChild.data);																						// 우리가 만든건데 하나뿐이야! list값?이지만 0을 얻기위해 [0]에 있는 첫번째 값을 가져와라
			//alert(result);	//result ==> xml
			if(idcount == 0){
				resultView.innerHTML = '<font color = "steelblue">사용 가능합니다.</font>';
			}else{
				resultView.innerHTML = '<font color = "magenta">사용중입니다. 다른 아이디를 검색하세요.</font>';
			}
		}
	} else{
		// 로딩중...
	}
} */

/*function register() {
	if (document.getElementById("name").value == "") {
		alert("이름 입력!!!");
		return;
	}else if (idcount != 0) {	
		alert("아이디 중복검사를 하세요!!");
		return;
	}else if (document.getElementById("pass").value == "") {
		alert("비밀번호 입력!!!");
		return;
	}else if (document.getElementById("pass").value != document.getElementById("passcheck").value) {
		alert("비밀번호 확인!!!");
		return;
	}else{
		document.getElementById("memberform").action = "${root}/user";	// 갈거다~!!!
		document.getElementById("memberform").submit();	//간다!
	}
	
} */

</script>

<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>회원가입</h2>
		<form id="memberform" method="post" action="">
			<!-- <input type ="hidden" name = "act" value = "register">-->			
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="이름입력">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="5자이상 16자 이하"> <!-- onkeyup="javascript:idcheck();" -->
				<div id = "idresult"></div>
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="form-control" id="passcheck" name="passcheck" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="email">이메일</label><br>
				<div id="email" class="custom-control-inline">
				<input type="text" class="form-control" id="emailid" name="emailid" placeholder="" size="25"> @
				<select class="form-control" id="emaildomain" name="emaildomain">
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label>
				<div id="tel" class="custom-control-inline">
				<select class="form-control" id="tel1" name="tel1">
					<option value="010">010</option>
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="041">041</option>
					<option value="051">051</option>
					<option value="061">061</option>
				</select> _
				<input type="text" class="form-control" id="tel2" name="tel2" placeholder="1234"> _
				<input type="text" class="form-control" id="tel3" name="tel3" placeholder="5678">
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="">주소</label><br>
				<div id="addressdiv" class="custom-control-inline">
					<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" size="7" maxlength="5" readonly="readonly">
					<!--<button type="button" class="btn btn-primary" onclick="javascript:">우편번호</button>-->
				</div>
				<input type="text" class="form-control" id="address" name="address" placeholder="" readonly="readonly">
				<input type="text" class="form-control" id="address_detail" name="addressDetail" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn" >회원가입</button>	<!-- 1. 유효성검사 onclick = "javascript:register();" -->
				<button type="reset" class="btn btn-warning">초기화</button>
			</div>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/user/member/zipsearch.jsp" %>
<!-- <div id="zipModal" class="modal fade" role="dialog">
<h5 class="modal-title" id="myModalLabel">우편번호검색</h5>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>    
            <div class="modal-body text-center">
            	<form id = "zip_codeForm">
            		<div align="center">
            			<label>도로명 주소검색</label>
            		</div>
					<div class="input-group" align="left">
						<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 구로디지털로, 여수울로)">
						<span class="input-group-btn">
						<input type="submit" class="btn btn-warning" value="검색" id="searchBtn">
						</span>
					</div>
                </form>
                <div style="width:100%; height:200px; overflow:auto">
                	<table class = "table text-center">
                		<thead>
                		<tr>
                			<th style="width:150px;">우편번호</th>
                			<th style="width:600px;">주소</th>
                		</tr>
                		</thead>
                		<tbody id="zip_codeList"></tbody>
                	</table>
                </div>
            </div>
        </div>
    </div>
</div> -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>