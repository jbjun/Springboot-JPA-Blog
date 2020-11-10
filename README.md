# JBJ BLOG
##개발환경  
     스프링 부트 버전 2.3.2  
     자바 버전 8  
     템플릿 엔진 JSP  
     bootstrap  
     의존성  
       -lombok  
       -spring JPA  
       -mysql  
     Json통신  
       -query이용(ajax요청)   
<h3>구현 내용</h3> <br>
<b>회원가입, 회원정보변경, 글(쓰기,수정,삭제,댓글달기, 댓글삭제)(수정, 삭제는 본인 글만)</b> <br><br>
<b>스프링 시큐리티 로그인</b><br>
     -로그인 안되면 글쓰기 기능 X 로그인 페이지로 이동<br>
     -비밀번호 암호화<br>
     -회원수정 시 강제 세션 부여 <br><br>
<b>카카오 로그인 Oauth(라이브러리 사용 안하고 직접 구현)</b><br>
     -카카오 로그인인지 db에 표시<br>
     -최초로그인 후 로그인 누르면 자동로그인<br>
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
<h4>로그인, 카카오로그인, 회원가입</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97847956-be68aa00-1d33-11eb-8840-ccfed98c57cb.png" width="400" height="150">
<img src="https://user-images.githubusercontent.com/61040284/97848130-f7a11a00-1d33-11eb-8b35-63162888c14e.png" width="400" height="400">
<img src="https://user-images.githubusercontent.com/61040284/97427498-fcdb1f00-1957-11eb-9f2a-e31c4dd5ad7b.png" width="400" height="150"> <br>
<h4>회원정보수정, 카카오회원정보수정</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97848808-fc1a0280-1d34-11eb-8bdd-226516b461d7.png" >
<img src="https://user-images.githubusercontent.com/61040284/97848813-fd4b2f80-1d34-11eb-8dda-77155f651a62.png" >
<h4>게시판(댓글)</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/98092365-ed188900-1ec9-11eb-8831-bd4527cca5c5.png"><br>
<h4>글수정</h4><br>
<img src="https://user-images.githubusercontent.com/61040284/97426208-770aa400-1956-11eb-8329-8f8f263095ed.png">
