<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만든이</title>
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
			margin-top: 20px;
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
			
			padding: 10px;
			width: 330px;
			margin: 0 auto;
		}
		.txt_wrap {
			width: 100%;
			margin: 0 auto;
		}
		p { 
		text-align: center;
		font-family: 'Roboto Condensed', sans-serif;
		margin-bottom: 10px;
		}
		.txt_head {
			margin-bottom: 30px;
		}
		

	</style>
</head>
<body>
	<div class="content">
		<%@ include file="include/header.jsp" %>
			<div class="shs_manager"> - Developer - </div>
		
			<div class="in_content">
				<p class="txt_head">

					StudentMS<br>
					Version 1.0.0<br>

				</p>

				<p class="txt_content">

					Developed by RSJ<br>
					e-mail: ryusoo0610@gmail.com<br>
				</p>
					
				<p class="txt_bottom">
					
					본 사이트는 학생관리 웹 프로그램입니다. <br>
					Copyrightⓒ 2019 RCDI All rights reserved.
				</p>

			</div>


			<div class="div_index">
				<a href="index.jsp" class="btn_index btn3">뒤로가기</a>
			</div>
		



	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- CDN방식으로 jQuery쓰는 방법 -->
	<script type="text/javascript">
		$(function(){
			


		});
	</script>
</body>
</html>