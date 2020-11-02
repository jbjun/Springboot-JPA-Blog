# JBJ BLOG <br>
<h3>환경설정</h3>
<b>스프링 부트 버전 2.3.2</b><br>
<b>자바 버전 8</b><br>
<b>템플릿 엔진 JSP</b> <br>
<b>의존성</b> <br>
-lombok <br>
-spring JPA <br>
<b>DB</b><br>
-mysql <br>
<b>Json통신</b> <br>
-query이용(ajax요청) <br>
<h3>구현 내용</h3> <br>
<b>회원가입, 회원정보변경, 글(쓰기,수정,삭제)(수정, 삭제는 본인 글만)</b> <br><br>
<b>스프링 시큐리티 로그인</b><br>
     -로그인 안되면 글쓰기 기능 X 로그인 페이지로 이동<br>
     -비밀번호 암호화<br>
     -회원수정 시 강제 세션 부여 <br><br>
<b>카카오 로그인 Oauth(라이브러리 사용 안하고 직접 구현)</b><br>
     -회원 정보 변경 불가<br>
     -카카오 로그인인지 db에 표시<br>
     1. 웹서버주소 ; http://localhost:8000<br>
     2. 클라이언트 키 : 484f55741806beff230ae6b248a9666b<br>
     3. 카카오 로그인 요청 주소 : http://localhost:8000/auth/kakao/callback<br>
     4. 카카오 로그아웃 요청 주소 : http://localhost:8000/auth/kakao/logout<br>
     5. 카카오 동의 구성<br>
     User 오브젝트 : id(번호), username, password, email<br>
     카카오로부터 받을 정보 : profile정보(필수), email(선택)<br>
     6. 로그인 요청 주소(GET방식)<br>
     https://kauth.kakao.com/oauth/authorize?                                    client_id=484f55741806beff230ae6b248a9666b&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code <br>
     7. 응답받은 코드<br>
     http://localhost:8000/auth/kakao/callback?code=mJF_MgiRsEumW70Kt-  YPcse80ITrAutlLmg9Zh60Hi9P0mUq_kkMsR43tvmaKgOmrdRl9QorDKcAAAF1gvn5VA<br>
     8. 토큰 발급 요청 주소(POST방식) - http body에 데이터를 전달 (4가지 데이터)<br>
     요청 주소 : https://kauth.kakao.com/oauth/token<br>
     헤더 값<br>
     application/x-www-form-urlencoded;charset=utf-8<br>
     바디 값<br>
     grant_type=authorization_code<br>
     client_id=484f55741806beff230ae6b248a9666b<br>
     redirect_uri=http://localhost:8000/auth/kakao/callback<br>
     code={동적}<br>
     9. 토큰을 통한 사용자 정보 조회 (POST)<br>
     요청 주소 : https;//kapi.kakao.com/v2/user/me<br>
     헤더 값<br>
     Authorization: Bearer {ACCESS_TOKEN}<br>
     Content-type: application/x-www-form-urlencoded;charset=utf-8<br><br>
<h4>메인화면</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97426184-71ad5980-1956-11eb-99c1-5bae8296b3be.png"><br>
<h4>로그인, 회원가입</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97847657-4dc18d80-1d33-11eb-907b-216e29cd0d80.png" width="400" height="150">
<img src="https://user-images.githubusercontent.com/61040284/97427498-fcdb1f00-1957-11eb-9f2a-e31c4dd5ad7b.png" width="400" height="150"> <br>
<h4>게시판</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97426200-7540e080-1956-11eb-8644-859e18fc43ed.png"><br>
<h4>글수정</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97426208-770aa400-1956-11eb-8329-8f8f263095ed.png">
