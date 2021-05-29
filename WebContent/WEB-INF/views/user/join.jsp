<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var ='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<script>
	function checkUserIdExist(){
		
		var user_id = $("#user_id").val()
		
		if(user_id.length == 0){
			alert('아이디를 입력해주세요');
			return;
		}
		
		// 상단에 jquery를 가져다 쓰기때문에 가능한 jquery ajax문법
		$.ajax({
			url : '${root}user/checkUserIdExist/' + user_id,
			type : 'get',	// 요청방식
			dataType : 'text', // 응답결과 타입
			success : function(result){
				if(result.trim() == 'true'){
					alert('사용할 수 있는 아이디입니다.');
					$("#userIdExist").val('true');
				} else{
					alert('사용할 수 없는 아이디입니다.');
					$("#userIdExist").val('false');
				}
			}
		})
	}
	
	function resetUserIdExist(){
		// jquery 선택자만 제대로 알아도 디버깅 시간 확 줄일 수 있었다..
		$("#userIdExist").val('false');	// 사용자 아이디를 입력하는 칸에 키보드를 누르면 무조건 false를 셋팅한다.
	}
</script>

<body>

<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<!-- 스프링에서 제공하는 form태그,  ModelAttribute는  -->
					<form:form action="${root}user/join_pro" method='post' modelAttribute="joinUserBean">
						<form:hidden path="userIdExist"/>
						<div class="form-group">
							<form:label path="user_name">이름</form:label>	<!-- bean에있는 user_name 이다, 이하 동일-->
							<form:input path="user_name" class="form-control"/>
							<form:errors path="user_name" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<div class="input-group">
								<form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>
								<div class="input-group-append">
									<button type="button" class="btn btn-primary" onclick="checkUserIdExist()">중복확인</button>
								</div>
							</div>
							<form:errors path="user_id" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control"/>
							<form:errors path="user_pw" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw2">비밀번호 확인</form:label>
							<form:password path="user_pw2" class="form-control"/>
							<form:errors path="user_pw2" style="color:red"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">회원가입</form:button>
							</div>
						</div>
					</form:form>
					<%-- <form action="${root }user/login" method="get">
						<div class="form-group">
							<label for="user_name">이름</label>
							<input type="text" id="user_name" name="user_name" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="user_id">아이디</label>
							<div class="input-group">
								<input type="text" id="user_id" name="user_id" class="form-control"/>
								<div class="input-group-append">
									<button type="button" class="btn btn-primary">중복확인</button>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="user_pw">비밀번호</label>
							<input type="password" id="user_pw" name="user_pw" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="user_pw2">비밀번호 확인</label>
							<input type="password" id="user_pw2" name="user_pw2" class="form-control"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<button type="submit" class="btn btn-primary">회원가입</button>
							</div>
						</div>
					</form> --%>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url="/WEB-INF/views/include/bottom_info.jsp"/>	

</body>
</html>
