<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록</title>
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
			border: none;
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
			<div class="shs_manager"> - 학사관리 - </div>
		
		<form action="insertPlay.shs" id="frm_insert" name="frm_insert" method="POST"> <!-- action은 목적지  -->
			<div class="in_content">
				<div class="div_input">
					<label for="input_name">이름: </label>
					<input type="text" id="input_name" name="input_name" class="shs_input" placeholder="NAME"><br>
					<span class="err_msg"></span>
				</div>

				<div class="div_input">
					<label for="input_age">나이: </label>
					<input type="text" id="input_age" name="input_age" class="shs_input" placeholder="AGE"><br>
					<span class="err_msg"></span>
				</div>

				<div class="div_input">
					<label for="input_major">전공: </label>
					<input type="text" id="input_major" name="input_major" class="shs_input" placeholder="MAJOR"><br>
					<span class="err_msg"></span>
				</div>

				<div class="div_input">
					<label for="input_phone">전화번호: </label>
					<input type="text" id="input_phone" name="input_phone" class="shs_input" placeholder="PHONE"><br>
					<span class="err_msg"></span>
				</div>

			</div>

			<div class="div_index btn_wrap">
				<!-- 경로를 화면단(jsp)이 아니라 servlet으로 지정해 준다 -->
				<a href="index.shs" class="btn_index btn3">취소</a> 
				
				<!-- <a href="#" class="btn_index btn1 submitBtn">등록</a>  -->
				<!-- (1) button 클릭시 jQuery의 click() 이벤트 발생 
					 jQuery click()이벤트 function()으로 이동 -->
				
				<button type="submit" class="btn_index btn1 submitBtn">등록</button>
				
			</div>


		</form>



	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- CDN방식으로 jQuery쓰는 방법 -->
	<script type="text/javascript" src="js/validation.js"></script> <!-- validation.js import해준것 -->
	<script type="text/javascript">
		
		$(function(){
			
			// input태그 focus()& blur() ->border효과
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
			
			
			
			
			// 등록버튼 클릭시 form태그 안에 있는 input태그의 값을 servlet으로 전송
			$('.submitBtn').click(function(){
				
				
				// (2) 유효성체크 시작!
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
				
				// (3) 유효성체크 완료: 모두 유효한 값으로 판명
				// #frm_insert 속성을 가진 form태그를 submit()함
				
				// * submit 동작
				// * METHOD = POST
				// * Action = "insertPlay.shs"
				// * form 태그 내부에 있는 input태그들의 value(이름, 나이, 전공, 번호)를 
				// * POST방식으로 insertPlay.shs(FrontController)로 전송
				
				// Action: SHSInsert(Servlet)
				// Method: POST 방식
				$('#frm_insert').submit();
			});
		});
		
		
		
	</script>
</body>
</html>