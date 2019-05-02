<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- jstl 라이브러리를 사용하기 위한 선언문 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석부</title>
<link rel="stylesheet" href="css/common.css">
<style type="text/css">
		

		.content {
			width: 390px;
			height: 600px;
			border: 1px solid black;
			margin: 50px auto 0;
			background-color: #eee;
			border-radius: 8px;
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);

		}
		
		.shs_manager {
			padding-top: 20px;
			padding-bottom: 20px;
			text-align: center;
			color: #454552;
			font-size: 20px;
		}
		.btn_index {
			padding: 10px 12px;
			background-color: dodgerblue;
			color: white;
			width: 90px;
			display: inline-block;
			border-radius: 10px;
			font-size: 20px;
		}
		.btn_index:hover {
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
		}
		.div_index {
			padding-top: 20px;
			padding-bottom: 30px;
			text-align: center;
		}
		.btn2 {
			background-color: orange;
		}
		.btn3 {
			background-color: salmon;
		}
		.in_content {
			width: 330px;
			margin: 0 auto;
		}
		table {
			font-size: 18px;
			border-collapse: collapse;
			width: 330px;
		}
		.table_title {
			background-color: lightgray;
			height: 25px;
			color: #515151;
			border: 0px;
		}
		.table_data {
			background-color: white;
			height: 25px;
			font-size: 17px;
		}
		.table_data:hover {
			background-color: lightyellow;
		}
		th { padding: 5px; }
		td { text-align: center; }
		tr {border-bottom: 1px dashed #bbbbbb; }
		.uBtn { color: dodgerblue;	}
		.dBtn { color: tomato; }
		#d_btn { 
			color: white;
			background-color: tomato;
			width: 90px;
			border-radius: 4px;
		}
		#close_btn {
			color: white;
			background-color: dodgerblue;
			width: 90px;
			border-radius: 4px;
		}
		button { 			
			border: 0;
			background-color: transparent;
			cursor: pointer;
		}
		#modal_all {
			position: fixed;
			z-index: 3; 
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			overflow: auto;
			background-color: rgba(0,0,0,0.4);
			display: flex; /* 여기위치가 container이다 */
			align-items: center;
			justify-content: center;
			display: none;
		}
		#modal_content {
			background-color: white;			
			width: 200px;
			height: 200px;
			text-align: center;
			border-radius: 10px;
		}
		.btn_wrap {
			margin-top: 50px;
		}
		.text_wrap {
			margin-top: 50px;
		}
		.name { 
			color: yellowgreen;
			font-weight: bold;
		}

	</style>
</head>
<body>
	<div id="modal_all">
		<div id="modal_content">
				<div class="text_wrap">
					"<span class="name"></span>"학생을<br>
					정말로 삭제 하시겠습니까?
				</div>
			<div class="btn_wrap">
				<a id="close_btn">뒤로가기</a>
				<!-- 여기 a태그에 href="~~~~"안에 있으면 제이쿼리를 안탄다 그러니 #으로 해두자 -->
				<a href="#" id="d_btn" class="dBtn modal_dBtn">삭제</a>
			</div>
		</div>
	</div>
	
	<div class="content">
		<%@ include file="include/header.jsp" %>
			<div class="shs_manager"> - 출석부 - </div>
		
			<div class="in_content">
				<table>
					<tr class="table_title">
						<th>ID</th>
						<th>Name</th>
						<th>Tel.</th>
						<th></th>
						<th></th>
					</tr>
					
					
					<!-- jstl 태그의 자바를 제어하는 core -->
					<c:if test="${shslist.size() == 0}">
						<tr class="table_data">
							<td colspan="5">등록된 학생이 없습니다
						</tr>
					</c:if>
					
					<!-- el태그(${shslist})로 데이터 담아오고 계속 el태그로 담아오면 힘드니까 이름(mDto)을 붙여준다. -->
					<c:forEach items="${shslist}" var="mDto">
					
						<tr class="table_data">
							<td class="sid">${mDto.sid}</td>
							<td class="sname">${mDto.sname}</td>
							<td>${mDto.sphone}</td>
							<td><a href="SHSUpdate?id=${mDto.sid}" class="uBtn">수정</a></td> 
							<td><a id="open_btn" class="dBtn adBtn">삭제</a></td> <!-- 모달창 열림 -->
						</tr>
					</c:forEach>
				</table>
				
			</div>
			<div class="div_index">
				<a href="index" class="btn_index btn3">뒤로가기</a>
			</div>
		



	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		
		
		
		// 삭제 버튼을 눌렀을 때 그 id와 name값을 갖고와야한다.
		var id, name;
		$('.adBtn').click(function(){
			// 조건에 맞는 녀석 중 나에게서 가장 가까운 부모를 선택
			id = $(this).closest('tr').find('.sid').text();
			name = $(this).closest('tr').find('.sname').text();
			$('.name').text(name);
			$('#modal_all').css('display', 'flex');
			alert(id + ", " + name);
		});
		$('#close_btn').click(function(){
			$('#modal_all').css('display', 'none');
		});
		$('.modal_dBtn').click(function(){
			location.href="SHSDelete?id="+id;
		});
		

	});

</script>
</body>
</html>