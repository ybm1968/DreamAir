package com.joeun.dreamair.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.QR;
import com.joeun.dreamair.mapper.BookingMapper;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service 
public class BookingServiceImpl implements BookingService{

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private QRService qrService;

    // 가는편 항공권 조회
    @Override
    public List<Booking> golist(Booking booking) throws Exception {
        List<Booking> bookingList = bookingMapper.golist(booking);
        return bookingList;
    }

    // 오는편 항공권 조회
    @Override
    public List<Booking> comelist(Booking booking) throws Exception {
        List<Booking> bookingList = bookingMapper.comelist(booking);
        return bookingList;
    }

    // 탑승객들 정보 입력
    @Override
    public int infoPassngers(Booking booking, HttpServletRequest request, Principal principal) throws Exception {
        int result = 0;
         
        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            // bookingItem.setProductNoDep(booking.getProductNoDeps()[i]);
            // bookingItem.setRouteNoDep(booking.getRouteNoDeps()[i]);
            bookingItem.setProductNoDep(booking.getProductNoDep());
            bookingItem.setRouteNoDep(booking.getRouteNoDep());
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setFirstName(booking.getFirstNames()[i]);
            bookingItem.setLastName(booking.getLastNames()[i]);
            bookingItem.setGender(booking.getGenders()[i]);
            bookingItem.setBirth(booking.getBirths()[i]);
            bookingItem.setPinType(booking.getPinTypes()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            bookingItem.setEmail(booking.getEmails()[i]);
            bookingItem.setUserPw(booking.getUserPw());

            if ( booking.getRoundTrip().equals("왕복")) {
                // bookingItem.setProductNoDes(booking.getProductNoDess()[i]);
                // bookingItem.setRouteNoDes(booking.getRouteNoDess()[i]);
                bookingItem.setProductNoDes(booking.getProductNoDes());
                bookingItem.setRouteNoDes(booking.getRouteNoDes());
            }

            bookingMapper.infoPassngers(bookingItem);

            if ( principal == null ) {
                
                String userId = "GUEST_" + UUID.randomUUID().toString().substring(0, 5);
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                bookingItem.setUserId(userId);
                bookingItem.setStatus("GUEST");
                bookingMapper.user2Insert(bookingItem); 
            }
            result++;
        }
        return result;
    }

    // 회원 - 가장 최근 예매 번호 조회
    @Override
    public int latest_user_bookingNo(int userNo) throws Exception {
        int result = bookingMapper.latest_user_bookingNo(userNo);
        return result;
    }

    // 비회원 - 가장 최근 예매 번호 조회
    @Override
    public int latest_user2_bookingNo(int userNo2) throws Exception {
        int result = bookingMapper.latest_user2_bookingNo(userNo2);
        return result;
    }
    
    // 탑승권 번호 발행 + QR 코드 발행
    @Override
    public int createTicket(Booking booking, Principal principal, HttpServletRequest request) throws Exception {
        String userId = "";
        int result = 0;
        int bookingNo = 0;
        int ticketNo = 0;
        int count1 = 0;
        int count2 = 0;
        HttpSession session = request.getSession();
        userId = (String) session.getAttribute("userId");

        // ✅ TODO : 조건 pasCount 에 따라서 티켓 발행 
        for (int i = 0; i < booking.getPasCount(); i++) {
            int bookingNum = (principal == null) ? booking.getBookingNo2() : booking.getBookingNo();
            booking.setName(booking.getNames()[i]);
            booking.setPassengerNo(booking.getPassengerNos()[i]);

            Booking gobooking = bookingMapper.goTickeData(booking);
            
            gobooking.setUserId(principal == null ? userId : principal.getName());
            gobooking.setBoarding("0");
            gobooking.setRouteNo(booking.getRouteNoDep());
            gobooking.setSeatNo(booking.getSeatNoDepss()[i]);
            gobooking.setFlightNo(booking.getGoFlightNo());
            
            if( principal == null ) {
                gobooking.setBookingNo2(bookingNum);
            } else {
                gobooking.setBookingNo(bookingNum);
            }
            count1 = bookingMapper.createTicket(gobooking);

            int ticketNo2 = bookingMapper.selectTicketNo();

            QR qr = new QR();
            qr.setParentTable("booking");
            qr.setParentNo(ticketNo2);
            String url = "http://localhost:" + serverPort + "/admin/Final_check?ticketNo=" + ticketNo2;
            qr.setUrl( url );
            qr.setName("QR_" + ticketNo2);

            qrService.makeQR(qr);


            if(booking.getRoundTrip().equals("왕복")) {
                Booking comeBooking = bookingMapper.comeTicketData(booking);
                comeBooking.setUserId(principal == null ? userId : principal.getName());
                comeBooking.setBoarding("0");
                comeBooking.setRouteNo(booking.getRouteNoDes());
                comeBooking.setSeatNo(booking.getSeatNoDesss()[i]);
                comeBooking.setFlightNo(booking.getComeFlightNo());

                if( principal == null ) {
                    comeBooking.setBookingNo2(bookingNum);
                } else {
                    comeBooking.setBookingNo(bookingNum);
                }

                count2 = bookingMapper.createTicket(comeBooking);

                int ticketNo3 = bookingMapper.selectTicketNo();

                QR qr2 = new QR();
                qr2.setParentTable("booking");
                qr2.setParentNo(ticketNo3);
                String url2 = "http://localhost:" + serverPort + "/admin/Final_check?ticketNo=" + ticketNo3;
                qr2.setUrl( url2 );
                qr2.setName("QR_" + ticketNo3);

                qrService.makeQR(qr2);

            }
        
            int count = count1 + count2;
            // 조건 : 회원 비회원
            // 회원
            if( principal != null ) {
                bookingNo = bookingMapper.latest_user_bookingNo(booking.getUserNo());

                List<Booking> ticketList = bookingMapper.ticketList_bookingNo(bookingNo);
                    for(int j = 0; j < ticketList.size(); j++){
                        Booking ticket = new Booking();
                        ticket = ticketList.get(i);
                        ticketNo = ticket.getTicketNo();
                    }
            }
            else {
                bookingNo = bookingMapper.latest_user2_bookingNo(booking.getUserNo2());
                List<Booking> ticketList = bookingMapper.ticketList_bookingNo(bookingNo);
                    for(int j = 0; j < ticketList.size(); j++){
                        Booking ticket = new Booking();
                        ticket = ticketList.get(i);
                        ticketNo = ticket.getTicketNo();
                    }
            }
            

            result += count;
        }
        return result;
    }

    // seat 테이블 좌석 상태 조회
    @Override
    public List<Booking> selectSeatStatus(int flightNo) throws Exception {
        List<Booking> seatList = bookingMapper.selectSeatStatus(flightNo);
        return  seatList;
    }

    // 탑승권 리스트 조회 - 회원
    @Override
    public List<Booking> selectBookingListByUser(String userId) throws Exception {
        List<Booking> bookingList = bookingMapper.selectBookingListByUser(userId);
        return bookingList;
    }
    
    // 탑승권 리스트 조회 - 비회원
    @Override
    public List<Booking> selectBookingListByGuest(String phone, String userPw) throws Exception {
        List<Booking> bookingList = bookingMapper.selectBookingListByGuest(phone, userPw);
        return bookingList;
    }

    // 탑승권 상세 조회
    @Override
    public List<Booking> selectTicket(int ticketNo) throws Exception {
        List<Booking> viewTicket = bookingMapper.selectTicket(ticketNo);
        return viewTicket;
    }

    // 출발지 조회
    @Override
    public String selectDeparture(int productNoDeps) {
        String departure = bookingMapper.selectDeparture(productNoDeps);
        return departure;
    }

    // 도착지 조회
    @Override
    public String selectDestination(int productNoDeps) {
        String destination = bookingMapper.selectDestination(productNoDeps);
        return destination;
    }

    // 출발지명과 도착지명으로 노선 번호 조회
    @Override
    public int selectRouteNo(String departure, String destination) {
        int selectRouteNo = bookingMapper.selectRouteNo(departure, destination);
        return selectRouteNo;
    }

    // 탑승객 수만큼 info 테이블의 passenger_no 조회
    @Override
    public List<String> selectLastPasNos(int pasCount) {
        List<String> selectLastPasNos = bookingMapper.selectLastPasNos(pasCount);
        return selectLastPasNos;
    }

    // 편도 항공 스케줄(탑승객 유의사항 안내)
    @Override
    public List<Booking> goScheduleList(Booking booking) throws Exception {
        List<Booking> bookingList = new ArrayList<Booking>();

        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            int passengerNo = bookingMapper.getPasNo(bookingItem);
            bookingItem.setPassengerNo(passengerNo); 

            bookingItem = bookingMapper.goScheduleList(bookingItem);
            if ( booking.getPayment() != null && booking.getPayment().equals("확인") ) { 
                bookingItem.setSeatNoDep(booking.getSeatNoDepss()[i]);   // 페이먼트
            } else {
                bookingItem.setSeatNoDep(booking.getSeatNoDeps().get(i));   // 노티스
            }

            bookingList.add(bookingItem);
        }
        return bookingList;
    }
    
    // 왕복 항공 스케줄(탑승객 유의사항 안내)
    @Override
    public List<Booking> comeScheduleList(Booking booking) throws Exception {
        List<Booking> bookingList = new ArrayList<Booking>();

        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            int passengerNo = bookingMapper.getPasNo(bookingItem);
            bookingItem.setPassengerNo(passengerNo);

            bookingItem = bookingMapper.comeScheduleList(bookingItem);
             if ( booking.getPayment() != null && booking.getPayment().equals("확인") ) { 
                bookingItem.setSeatNoDes(booking.getSeatNoDesss()[i]);   // 페이먼트
            } else {
                bookingItem.setSeatNoDes(booking.getSeatNoDess().get(i));   // 노티스
            }

            bookingList.add(bookingItem);
        }
        return bookingList;
    }

    // 예매 테이블 등록
    @Override
    public int bookingInsert(Booking booking, Principal principal, HttpServletRequest request) throws Exception {
        int result = 0;
        int result1 = 0;
        int result2 = 0;
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            userId = principal != null ? principal.getName() : userId;
            bookingItem.setUserId(userId);
            bookingItem.setName(booking.getNames()[i]);
            bookingItem.setPassengerNo(booking.getPassengerNos()[i]);
            bookingItem.setSeatNoDep(booking.getSeatNoDepss()[i]);
            bookingItem.setSeatNo(booking.getSeatNoDepss()[i]);
            
            if ( principal == null ) {
                bookingItem.setUserNo2(booking.getUserNo2());
            } else {
                bookingItem.setUserNo(booking.getUserNo());
            }
            
            bookingItem.setPasCount(booking.getPasCount());                 
            bookingItem.setRoundTrip(booking.getRoundTrip());
            bookingItem.setStatus("예매완료");
            bookingItem.setProductNoDep(booking.getProductNoDep());         
            bookingItem.setProductIdDep(booking.getProductIdDeps()[0]);
            bookingItem.setRouteNoDep(booking.getRouteNoDep());             

            result1 = bookingMapper.goBookingInsert(bookingItem);           // 가는편 Booking 테이블 insert
            bookingMapper.goPasUpdate(bookingItem);                         // 가는편 좌석번호 등록

            if (booking.getRoundTrip().equals("왕복")) {
                bookingItem.setSeatNoDes(booking.getSeatNoDesss()[i]);
                bookingItem.setSeatNo(booking.getSeatNoDesss()[i]);
                bookingMapper.comePasUpdate(bookingItem);                   // 오는편 좌석번호 등록
                bookingItem.setProductNoDes(booking.getProductNoDes());
                bookingItem.setProductIdDes(booking.getProductIdDess()[0]);
                bookingItem.setRouteNoDes(booking.getRouteNoDes());
                result2 = bookingMapper.comeBookingInsert(bookingItem);     // 오는편 Booking 테이블 insert
            }
        }
        result = result1 + result2;

        return result;
    }

   
    // 예매 번호로 탑승권 정보(번호) 조회
    @Override
    public List<Booking> ticketList_bookingNo(int bookingNo) throws Exception {
        List<Booking> ticketList_bookingNo = bookingMapper.ticketList_bookingNo(bookingNo);
        return ticketList_bookingNo;
    }

    // 도착지명으로 노선 조회
    @Override
    public int selectRouteNoByDes(String destination) {
        int selectRouteNoByDes = bookingMapper.selectRouteNoByDes(destination);
        return selectRouteNoByDes;
    }

    // 예매된 좌석 확인
    @Override
    public List<Booking> bookedSeatStatus(int flightNo) throws Exception {
        List<Booking> bookedSeatStatus = bookingMapper.bookedSeatStatus(flightNo);
        return bookedSeatStatus; 
    }

    // 최근 예매 번호 조회
    @Override
    public int selectLastBookingNo(int bookingNo) throws Exception {
        int result = bookingMapper.selectLastBookingNo(bookingNo);
        return result;
    }

    // 결제 완료 시, seat 테이블 업데이트
    @Override
    public int updateSeat(int flightNo, String seatNo) throws Exception {
        int updateSeat = bookingMapper.updateSeat(flightNo, seatNo);
        return updateSeat;
    }
}