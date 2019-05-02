<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- jstl 라이브러리를 사용하기 위한 선언문 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생검색</title> 
<!-- 코드가 수정이 되더라도 기존에 있는 것을 호출하니까 적용되지 않는 경우가 있다
그걸 방지하기 위해서 ?v=1을 쓰면 방문기록을 지워주고 그때그때 새로운 것을 받아서 가지고 온다. -->
<link rel="stylesheet" href="css/common.css?v=1">
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
			color: white;
			width: 90px;
			display: inline-block;
			border-radius: 10px;
			font-size: 17px;
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
		.search_wrap {
			margin-bottom: 15px;
			width: 100%;
			height: 40px;
			position: relative;
		}
		.input_search {
			width: 100%;
			height: 100%;
			padding: 0 10px;
			border: 2.5px solid mediumpurple;
			outline: none;
			color: #515151;
			font-size: 16px;
			border-radius: 50px;
		}
		.search_btn {
			display: inline-flex; /* flex인데 inline-block같은 속성을 가짐. 가로를 다 차지하지 않음 */
			width: 40px;
			height: 100%;
			background-color: mediumpurple;
			position: absolute;
			top: 0;
			right: 0;
			border-radius: 50%;
			justify-content: center;
			align-items: center;
		}
		.search_btn:hover {
			box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),
						0 2px 10px 0 rgba(0,0,0,0.12);
			background-color: slateblue;
						
		}
		.search_btn > i {
			font-size: 20px;
			color: white;
		}
		.search_result {
			padding-left: 10px;
			color:black;
			font-size: 15px;
			
		}
		.err_msg {
			display: none;
			color: tomato;
			margin-top: -15px;
			padding-left: 10px;
		}
		.point {color: dodgerblue;}
		.cnt {color:tomato;}
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
			<div class="shs_manager"> - 학생검색 - </div>
			<div class="in_content">
				<div class="search_wrap">
					<input type="text" placeholder="검색할 이름을 입력해주세요." id="input_search" name="input_search" class="input_search" maxlength="4">
					<a href="#" class="search_btn"><i class="fas fa-search"></i></a>
				</div>
				<!-- 아래 에러메세지는 shs_insert.jsp에서 가져옴-->
				<span class="err_msg"></span>
			</div>
			
			
			<div class="in_content">
				<c:if test="${search_cnt > 0}">
					<span class="search_result">
						"<span class="point">${name}</span>"으로 검색한 결과 총 <span class="cnt">${search_cnt}</span>건 검색됨.
					</span>
				</c:if>
			</div>
			
				
			<div class="in_content">
				<table>
					<tr class="table_title">
						<th>ID</th>
						<th>Name</th>
						<th>Tel.</th>
						<th></th>
						<th></th>
					</tr>
					
					<!-- 기존에는 값이 없으면 size()가 없어서 아예 실행도 안되게 보내주지를 않아서 뜨지도 않음 실행이 안됨 -->
					<!-- SearchAction에서 List<MemberDTO> list = new ArrayList<>(); 리스트는 보내줬지만 데이터가 없다. 0이니까 실행을 한다. -->
					<!-- jstl 태그의 자바를 제어하는 core -->
					<c:if test="${shslist.size() == 0}">
						<tr class="table_data">
							<td colspan="5">검색결과가 없습니다</td>
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
		
		
		
		// 학생검색버튼 클릭 시
		$('.search_btn').click(function(){
			// alert('test');
			var name = $.trim($('#input_search').val());
			
			
			
			// validation.js에서 가져옴 이름 유효성체크, eq(0)지웠음
			var regEmpty = /\s/g;// 공백문자 체크 \s = 공백 //가 한쌍
			var regNum = /[~0-9]/g; // 숫자 못들어오게하는 체크 ^포함해라, ~제외해라
			if (name == '' || name.length == 0) { // '        ' 스페이스바 많이 친 것은 name.length==0 과	//은 한쌍이다
				
				$('.err_msg').css('display', 'block').css('color', 'tomato')
						.text('필수정보입니다.');
				return false;
			} else if (regNum.test(name)) {
				
				// isNAN은 숫자를 보면 flase반환 !를 붙여서 true로 만들어 타게 만든다.)(!isNaN)
				$('.err_msg').css('display', 'block').css('color', 'tomato')
						.text('문자만 입력해주세요.');
				return false;
			} else if (name.match(regEmpty)) {
				
				$('.err_msg').css('display', 'block').css('color', 'tomato')
						.text('공백없이 작성해 주세요.');
				return false;
			} else if (name.length > 4 || name.length < 2) {
				
				$('.err_msg').css('display', 'block').css('color', 'tomato')
						.text('2~4글자로만 작성해 주세요.');
				return false;
			} 
			
			location.href="searchPlay.shs?name=" + name;
			
		});
		

	});

</script>
</body>
</html>