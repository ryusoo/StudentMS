<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- jstl 라이브러리를 사용하기 위한 선언문 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생수정</title>
<link rel="stylesheet" href="css/common.css?v=1">
<style type="text/css">
		
		hr { 
			margin: 2px 0px;
			border: 1px dashed #515151;
		}

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
			border: 0;
			cursor: pointer;
		}
		.btn_index:hover {
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
		}
		.div_index {
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
			text-align: right;
		}
		.div_input {
			padding: 3px 20px;
		}
		.div_input > label {
			float: left;
			line-height: 40px;
		}
		.shs_input {
			width: 250px;
			display: inline-block;
			height: 40px;
			font-size: 16px;
			color: #515151;
			outline: none;
			border: 1px solid #aaa;
			padding: 0 10px;
		}
		.btn_wrap {
			display: flex;
			padding: 20px 0px;
			justify-content: space-evenly;
		}
		#input_id {
			background-color: lightyellow;
			border: 1px solid #aaa!important;
			cursor: not-allowed;
		}
		.err_msg {
			color: tomato;
			font-size: 14px;
			display: none;
			text-align: left;
			padding-left: 80px;
		}
	</style>
</head>
<body>
	<div class="content">
		<%@ include file="include/header.jsp" %>
			<div class="shs_manager"> - 학사수정 - </div>
		
		<form action="updatePlay.shs" id="frm_update" name="frm_update" method="POST">
		
			<div class="in_content">
				<hr>
				<div class="div_input">
					<label for="input_id">아이디: </label>
					<input type="text" id="input_id" name="input_id" class="shs_input" placeholder="ID" readonly="readonly" value="${memInfo.sid}"><br>
					
				</div>
				<hr>

				<div class="div_input">
					<label for="input_name">이름: </label>
					<input type="text" id="input_name" name="input_name" class="shs_input" placeholder="NAME" value="${memInfo.sname}"><br>
					<span class="err_msg"></span>
				</div>

				<div class="div_input">
					<label for="input_age">나이: </label>
					<input type="text" id="input_age" name="input_age" class="shs_input" placeholder="AGE" value="${memInfo.sage}"><br>
					<span class="err_msg"></span>
				</div>

				<div class="div_input">
					<label for="input_major">전공: </label>
					<input type="text" id="input_major" name="input_major" class="shs_input" placeholder="MAJOR" value="${memInfo.smajor}"><br>
					<span class="err_msg"></span>
				</div>

				<div class="div_input">
					<label for="input_phone">전화번호: </label>
					<input type="text" id="input_phone" name="input_phone" class="shs_input" placeholder="PHONE" value="${memInfo.sphone}"><br>
					<span class="err_msg"></span>
				</div>

			</div>

			<div class="div_index btn_wrap">
				<a href="shs_index.jsp" class="btn_index btn3">취소</a> 
				<!-- <a href="#" class="btn_index btn1 submitBtn">수정</a>  -->
				<button type="submit" class="btn_index btn3">수정</button>
			</div>
		</form>

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- CDN방식으로 jQuery쓰는 방법 -->
	<script type="text/javascript" src="js/validation.js"></script> <!-- validation.js import해준것 -->
	<script type="text/javascript">
		$(function(){
			$('.shs_input').focus(function(){
				$(this).css('border', '1px solid dodgerblue');
			});
			$('.shs_input').blur(function(){
				$(this).css('border', '1px solid #aaa');
			});
			
			
			// keyup()을 활용한 유효성 체크(input값)
			$('#input_name').keyup(function(){
				// var name = $.trim($(this).val()); // .trim()은 앞뒤 공백제거
				nameCheck(); //name
			});
			$('#input_age').keyup(function(){
				// var age = $.trim($(this).val()); // .trim()은 앞뒤 공백제거
				ageCheck(); //age
			});
			$('#input_major').keyup(function(){
				// var major = $.trim($(this).val()); // .trim()은 앞뒤 공백제거
				majorCheck(); // major
			});
			$('#input_phone').keyup(function(){
				// var phone = $.trim($(this).val()); // .trim()은 앞뒤 공백제거
				phoneCheck(); // phone지움
			});
			
			// 유효성 체크(이름, 나이, 전공, 핸드폰번호)
			// 유효한 값이면 => submit();
			// 등록버튼 클릭시 form태그 안에 있는 input태그의 값을 servlet으로 전송
			$('.submitBtn').click(function(){
				// var name = $.trim($('#input_name').val());
				// 등록 버튼 클릭시 다른 유효성검사한 것이 통과한 것을 보내야 함.
				if(!nameCheck()){ // false가 오면 !만나면서 true가되어서 이 if문을 탄다.
					$('#input_name').focus();
					return false; // 아래로 안내려가고 끝낸다. 멈춤.
				} 
				if(!ageCheck()){
					$('#input_age').focus();
					return false; // 아래로 안내려가고 끝낸다.
				}
				if(!majorCheck()){
					$('#input_major').focus();
					return false;
				}
				if(!phoneCheck()){
					$('#input_phone').focus();
					return false;
				}
				
				
				//-----유효성 체크 완료-----
				// location.href="http://www.naver.com"; // 유효성체크 성공후 등록버튼 누르면 네이버페이지로 넘어감.
				//-----: 유효한 값만 있음 -----
				// form태그의 action주소로 method방식을 통하여 데이터를 전송
				// Action: SHSUpdate(Servlet)
				// Method: POST 방식
				$('#frm_update').submit();
			});
		});
	</script>
</body>
</html>