<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만든이</title>
<style type="text/css">
		@import url('https://fonts.googleapis.com/css?family=Noto+Sans+KR');

		* { 
			font-family: 'Noto Sans KR', sans-serif;
			user-select: none;D
 		}
		body, ul { margin: 0;, padding: 0; }
		a { color: inherit; text-decoration: none; }
		ul { list-style: none; }

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
		.shs_title {
			padding-top: 40px;
			text-align: center;
			font-size: 30px;
			color: black;
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
		

	</style>
</head>
<body>
	<div class="content">
		<a href="index.jsp">
			<div class="shs_title">
				JAVA기반 스마트하이브리드<br>
				개발자 과정 2기
			</div>
		</a>
			<div class="shs_manager"> - 만든이 - </div>
		
			<div class="in_content">
				
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