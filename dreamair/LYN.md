# 이유나 작업 사항


[해야할 일]
1) 언니 코드랑 성민님 코드 내거에서 합치기
2) 헤더 정리하기
3) 좌석 선택!!!!!!

좌석 선택하고 넘길 때 passenger_no랑 passenger_name notice로 넘기기
좌석 선택하고 넘기면서 탑승객 테이블에 passenger_no에 맞는 좌석 번호 passengers table에 update문으로 업데이트 해주기





[회원 가입]
- 회원 가입 시, users 테이블 & auth 테이블 & mileage 테이블에 모두 데이터 삽입 필요 => 해결


[회원 탈퇴]
- 회원 탈퇴는 정상적으로 작동하나(DB 삭제) 계속 예외로 튕김
- 회원 탈퇴 시, mileage 테이블 & auth 테이블에 모두 ON DELETE CASCADE 적용하여 일괄 삭제 처리 필요 => 그냥 테이블 별로 삭제 하자........




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

- 11/8
- booking/seat 체크 박스 보이게 하느라 checkIn.css에서 checkbox 안 보이게 설정해둔 것들 다 주석 처리 함