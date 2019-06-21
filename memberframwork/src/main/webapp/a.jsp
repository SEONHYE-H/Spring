<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%--
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");	//사용자 정보를 request에 담으면 안된다 이것보다 더 넓은걸 써야한다!(session) 정해진 시간 전에 들어가면 그대로 로그인되어있다!
	/* String name = request.getParameter("name"); */
if(memberDto != null){
--%>
<c:if test="${userInfo != null}">
세션있다
</c:if>
<c:if test="${userInfo == null}">
세션없다
</c:if>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>