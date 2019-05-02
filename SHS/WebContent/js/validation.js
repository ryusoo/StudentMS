function nameCheck(){ // name매개변수 지움
	var name = $.trim($('#input_name').val());
	
	var regEmpty = /\s/g;// 공백문자 체크 \s = 공백 //가 한쌍
	var regNum = /[~0-9]/g; // 숫자 못들어오게하는 체크 ^포함해라, ~제외해라
	if (name == '' || name.length == 0) { // '        ' 스페이스바 많이 친 것은 name.length==0 과	//은 한쌍이다
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('필수정보입니다.');
		return false;
	} else if (regNum.test(name)) {
		
		// isNAN은 숫자를 보면 flase반환 !를 붙여서 true로 만들어 타게 만든다.)(!isNaN)
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('문자만 입력해주세요.');
		return false;
	} else if (name.match(regEmpty)) {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('공백없이 작성해 주세요.');
		return false;
	} else if (name.length > 4 || name.length < 2) {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'tomato')
				.text('2~4글자로만 작성해 주세요.');
		return false;
	} else {
		$('.err_msg').eq(0).css('display', 'block').css('color', 'dodgerblue')
				.text('멋진 이름이네요!');
		return true;
	}
}


function ageCheck(){ // age 매개변수 지움
	var age = $.trim($('#input_age').val()); // this라고 하면 모르니까 #input_age로 바꿔줌
	
	if (age == '' || age.length == 0) { // ' ' 스페이스바 많이 친 것은 age.length==0 과	// 같음
		$('.err_msg').eq(1).css('display', 'block').css('color', 'tomato')
				.text('필수정보입니다.');
		return false;
	} else if(isNaN(age)) {
		$('.err_msg').eq(1).css('display', 'block').css('color', 'tomato')
		.text('숫자만 입력해 주세요.');
		return false;
	} else if (age > 99 || age < 19) {
		$('.err_msg').eq(1).css('display', 'block').css('color', 'tomato')
		.text('19~99세까지만 입력해주세요.');
		return false;
	} else {
		$('.err_msg').eq(1).css('display', 'none');
		return true;
	}
}

function majorCheck() {
	var major = $.trim($('#input_major').val());
	
	var regEmpty = /\s/g;// 공백문자 체크 \s = 공백 //가 한쌍
	var regNum = /[~0-9]/g; // 숫자 못들어오게하는 체크 ^포함해라, ~제외해라
	
	if(major.length == 0){
		$('.err_msg').eq(2).css('display', 'none');
		return true; // 필수 입력값이 아니기 때문에 공백이어도 true임
		
	}else if (regNum.test(major)) {
		// isNAN은 숫자를 보면 false반환 !를 붙여서 true로 만들어 타게 만든다.)(!isNaN)
		$('.err_msg').eq(2).css('display', 'block').css('color', 'tomato')
				.text('문자만 입력해주세요.');
		return false;
	} else if (major.match(regEmpty)) {
		$('.err_msg').eq(2).css('display', 'block').css('color', 'tomato')
				.text('공백없이 작성해 주세요.');
		return false;
	} else {
		$('.err_msg').eq(2).css('display', 'block').css('color', 'dodgerblue')
		.text('멋진 전공이네요!');
		return true;
	}
}

function phoneCheck() { // 매개변수 phone 지움
	var phone = $.trim($('#input_phone').val()); // this모르니까 this지우고 #input_phone씀
	
	var regEmpty = /\s/g;// 공백문자 체크 \s = 공백 //가 한쌍
	var regNum = /[~0-9]/g; // 숫자 못들어오게하는 체크 ^포함해라, ~제외해라
	var phoneReg = RegExp(/^[0-9]{8,11}$/); // 전화번호 유효성 검사
	if (phone == '' || phone.length == 0) { // ' ' 스페이스바 많이 친 것은 age.length==0 과	// 같음
		$('.err_msg').eq(3).css('display', 'block').css('color', 'tomato')
				.text('필수정보입니다.');
		return false;
	} else if(isNaN(phone)) {
		$('.err_msg').eq(3).css('display', 'block').css('color', 'tomato')
		.text('숫자만 입력해 주세요.');
		return false;
	} else if(!phoneReg.test(phone)) {
		$('.err_msg').eq(3).css('display', 'block').css('color', 'tomato')
		.text('올바른 값을 입력해 주세요.');
		return false;
	} else {
		$('.err_msg').eq(3).css('display', 'block').css('color', 'dodgerblue')
		.text('유효한 전화번호입니다.');
		return true;
	}
}




