# 이유나 작업 사항

- 예매 시, booking_no가 계속 동일하게 들어감
- admin 페이지에서 티켓 관리 페이지 안들어가짐
- 마일리지...
- 비회원 조회


[회원 탈퇴]
- 회원 탈퇴는 정상적으로 작동하나(DB 삭제) 계속 예외로 튕김
- 회원 탈퇴 시, mileage 테이블 & auth 테이블에 모두 ON DELETE CASCADE 적용하여 일괄 삭제 처리 필요 => 그냥 각각 테이블마다 해당 유저 데이터 다 삭제하는걸로




[유효성 검사]
- 회원 가입 / 회원 정보 수정 => JS로 처리 가능



--------------------------------------------------------------------------------------------------------
- 11/19
- booking dto에 mileage, goFlightNo, comeFlightNo 변수 추가
- BookingMapper(xml, java), bookingService, bookingServiceimpl, BookingController(결제 완료 메소드에만) 수정 함


- 11/10
- [header.html], [user_layout.html], [user/index.html], [UI/fragment/sidebar.html] : 위치 등등 수정
- [BookingMapper.xml] : selectBookingListByUser(주문 내역 조회), selectTicket(티켓 상세 조회) 메소드 추가
- [BookingMapper.java] : 이하 동문
- [BookingService.java] : 이하 동문
- [BookingServiceImpl.java] : 이하 동문
- [dto/booking.java] : userId 변수 추가


- 11/2
- user_layout.html 수정
- user/index.html & user/update.html 레이아웃 연결 수정
- user/delete.html 생성
- UserController.java 수정
- UserMapper.xml & UserMapper.java 수정
- 등등

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

- 10/31
- /user/index.html 생성
- /layout/user_layout.html 생성