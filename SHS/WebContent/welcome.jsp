<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		.text1 {
			font-size: 30px;
			color: #515151;
			font-weight: bold;
		}
		.text2 {
			font-size: 18px;
			color: #515148;
		}
		.container {
			height: 250px;
			display: flex;
			flex-direction: column;
			text-align: center;
			justify-content: center;
		}
		#rCnt {
			font-size: 25px;
			color: dodgerblue;
			font-weight: bold;
		}
</style>
</head>
<body>
	<div class="content">
		<%@ include file="include/header.jsp" %>
		<div class="shs_manager"> - 환영합니다. - </div>
		
		<div class="container">
			<div class="welcome_text text1">등록해주셔서 감사합니다!</div>
				<div class="welcome_text text2">
					<span id="rCnt">3</span>
				초후에 메인 페이지로 이동합니다.
				</div>
			
		</div>
	</div>

		<script type="text/javascript">
			var cnt=2;
			function countDown(){
				if(cnt == 0) {
					clearInterval(s);
					location.href="index.shs";
				}
				document.getElementById("rCnt").innerHTML=cnt;
				cnt--;
			}
			var s = setInterval(countDown, 1000); // 1초 단위로 countdown() 실행
		</script>
</body>
</html>