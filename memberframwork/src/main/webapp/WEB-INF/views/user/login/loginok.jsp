<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%--
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");	//사용자 정보를 request에 담으면 안된다 이것보다 더 넓은걸 써야한다!(session) 정해진 시간 전에 들어가면 그대로 로그인되어있다!
	/* String name = request.getParameter("name"); */
if(memberDto != null){
--%>
<c:if test="${userInfo != null}">
<script type = "text/javascript">
function deleteMember(){
	if(confirm("탈퇴하시겠습니까?")){
		$(location).attr("href", "${root}/user/delete.kitri");
	}
}
</script>
<strong><%--=memberDto.getName()--%>${userInfo.name}(<%--=memberDto.getId()--%>${userInfo.id})</strong>님 안녕하세요<br>
<a href="${root}/user/logout.kitri">로그아웃</a>
<a href="${root}/user/mvmodify.kitri">정보수정</a>
<a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
	<%--
	if("ghkdtjsgP".equals(memberDto.getId())){
	--%>
	<c:if test="${'java2' == userInfo.id}">
	<a href="${root}/admin/mvmemberlist.kitri">관리자</a>
	</c:if>
</c:if>
<c:if test="${userInfo == null}">
	<c:redirect url="/user/login.kitri"/>
<%--  
	}
}else{
	MoveUrl.redirect(request, response, "/user?act=mvlogin");	//jsp에서 jsp는 안간다! 무조건 컨트롤러 들려라!
}
--%>
</c:if>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>










<!-- >> 회원탈퇴
t{
	conn =...;
	conn.setAC(false);
	delete
	pstmt.exe..();
	pstmt.close();
	==== connd은 끊으면 안된다! 끝부분에 끊어야한다....?
	
	delete
	pstmt = conn.pre..
	pstmt.exc...()
	conn.commit();
}c{
	conn.rollback();
} -->