# 이유나 작업 사항


[회원 가입]
- 회원 가입 시, users 테이블 & auth 테이블 & mileage 테이블에 모두 데이터 삽입 필요 => 해결


[회원 탈퇴]
- 회원 탈퇴는 정상적으로 작동하나(DB 삭제), 계속 예외로 튕김
- 회원 탈퇴 시, mileage 테이블 & auth 테이블에 모두 ON DELETE CASCADE 적용하여 일괄 삭제 처리 필요




[유효성 검사]
- 회원 가입 / 회원 정보 수정 => JS로 처리 가능



--------------------------------------------------------------------------------------------------------

- 10/31
- /user/index.html 생성
- /layout/user_layout.html 생성

- 11/1
- UserMapper.java 수정
- UserMapper.xml 수정
- login.html 생성
- join.html 생성
- HomeController.java 파일 controller 폴더로 이동
- HomeController.java 수정
- SecurityConfig 인가처리 코드 수정
- user/index.html 생성
- user/update.html 생성
- 등등

- 11/2
- user_layout.html 수정
- user/index.html & user/update.html 레이아웃 연결 수정
- user/delete.html 생성
- UserController.java 수정
- UserMapper.xml & UserMapper.java 수정
- 등등

- 11/3
- DB 마일리지 테이블 - user_id 속성 추가, 마일리지 default 0 설정
- 회원 등록 시 마일리지 테이블에 해당 회원이 함께 추가 될 수 있도록 추가
- 