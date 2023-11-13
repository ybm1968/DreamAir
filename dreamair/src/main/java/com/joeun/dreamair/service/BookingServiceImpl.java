package com.joeun.dreamair.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.mapper.BookingMapper; 

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service 
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    // 가는편 항공권 조회
    public List<Booking> golist(Booking booking) throws Exception {
        log.info("서비스임플 가는편 도착지 : " + booking.getDestination());
        log.info("시버스임플 가는편 출발날짜 : " + booking.getDepartureDate());

        List<Booking> bookingList = bookingMapper.golist(booking);

        return bookingList;
    }

    @Override
    // 오는편 항공권 조회
    public List<Booking> comelist(Booking booking) throws Exception {
        log.info("서비스임플 오는편 도착지 : " + booking.getDestination());
        log.info("서비스임플 오는편 출발날짜 : " + booking.getDepartureDate());

        List<Booking> bookingList = bookingMapper.comelist(booking);

        return bookingList;
    }


    @Override
    // 탑승객들 정보 입력
    public int infoPassngers(Booking booking) throws Exception {
        log.info("서비스임플 이메일 : " + booking.getEmails()[0]);
        log.info("서비스임플 인원수 : " + booking.getPasCount());
        int result = 0;
         
        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setProductNoDep(booking.getProductNoDeps()[i]);
            bookingItem.setRouteNoDep(booking.getRouteNoDeps()[i]);
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
                bookingItem.setProductNoDes(booking.getProductNoDess()[i]);
                bookingItem.setRouteNoDes(booking.getRouteNoDess()[i]);
            }

            bookingMapper.infoPassngers(bookingItem);
            result++;
        }

        log.info("왕복 등록결과 : " + result);
        
        return result;
    }

    // @Override
    // 여권 정보 입력
    // public int infoPassport(Users user) throws Exception {
    //     log.info("여권번호 : " + user.getPassportNos()[0]);
    //     log.info("라스트네임 : " + user.getLastNames()[0]);
    //     log.info("여권만료일자 : " + user.getExpirationDates()[0]);
    //     log.info("여권번호 : " + user.getUserId());

    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
    //     int result = 0;
        
    //     for (int i = 0; i < user.getPassportNos().length; i++) {
    //         Users userItem = new Users();
    //         userItem.setPassportNo(user.getPassportNos()[i]);
    //         userItem.setPinType(user.getPinTypes()[i]);
    //         userItem.setLastName(user.getLastNames()[i]);
    //         userItem.setFirstName(user.getFirstNames()[i]);
    //         userItem.setNationality(user.getNationalitys()[i]);
    //         userItem.setExpirationDate(user.getExpirationDates()[i]);
            
    //         if(authentication.isAuthenticated()) {
    //             userItem.setUserId(user.getUserId()); 
    //         } 

    //         bookingMapper.infoPassport(userItem);
    //         result++;
    //     }

    //     return result;
    // }


    @Override
    // 편도 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> goScheduleList(Booking booking) throws Exception {
        log.info("탑승객 이름 배열 서비스: " + booking.getPassengerNames()[0]);
        log.info("탑승객 인원: " + booking.getPasCount());
        log.info("탑승객 번호: " + booking.getPhones()[0]);
        List<Booking> bookingList = new ArrayList<Booking>();

        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            int passengerNo = bookingMapper.getPasNo(bookingItem);
            bookingItem.setPassengerNo(passengerNo); 

            bookingItem = bookingMapper.goScheduleList(bookingItem);

            bookingList.add(bookingItem);
        }
        
        return bookingList;
    }
    
    @Override
    // 왕복 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> comeScheduleList(Booking booking) throws Exception {
         log.info("왕복 탑승객 이름 배열 서비스: " + booking.getPassengerNames()[0]);
        log.info("왕복 탑승객 인원: " + booking.getPasCount());
        log.info("왕복 탑승객 번호: " + booking.getPhones()[0]);
        List<Booking> bookingList = new ArrayList<Booking>();

        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            int passengerNo = bookingMapper.getPasNo(bookingItem);
            bookingItem.setPassengerNo(passengerNo);

            bookingItem = bookingMapper.comeScheduleList(bookingItem);

            bookingList.add(bookingItem);
        }

        return bookingList;
    }

    @Override
    // 예매 테이블 등록
    public int bookingInsert(Booking booking, Principal principal) throws Exception {
        log.info("회원이름 : " + booking.getNames()[0]);
        log.info("가는편 상품 번호 : " + booking.getProductNoDep());
        log.info("가는편 상품 아이디 : " + booking.getProductIdDeps()[0]);  
        log.info("탑승인원 : " + booking.getPasCount());            
        log.info("왕복여부 : " + booking.getRoundTrip());          
        log.info("상태 : " + booking.getStatus());           
        log.info("비회원넘버 : " + booking.getUserNo2());
        int result = 0;
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            String loginId = principal != null ? principal.getName() : "GUEST";
            bookingItem.setName(booking.getNames()[i]);

            if (loginId.equals("GUEST")) {
                bookingItem.setUserNo2(booking.getUserNo2());
                log.info("비회원넘버if : " + booking.getUserNo2());
            } else {
                bookingItem.setUserNo(booking.getUserNo());
                log.info("회원넘버if : " + booking.getUserNo());
            }
            
            bookingItem.setPasCount(booking.getPasCount());
            bookingItem.setRoundTrip(booking.getRoundTrip());
            bookingItem.setStatus(booking.getStatus());
            bookingItem.setProductNoDep(booking.getProductNoDep());
            bookingItem.setProductIdDep(booking.getProductIdDeps()[0]);
            bookingItem.setRouteNoDep(booking.getRouteNoDep());
            log.info("가는편 상품 아이디 : " + bookingItem.getProductIdDep());
            
            if (booking.getRoundTrip().equals("왕복")) {
                bookingItem.setProductNoDes(booking.getProductNoDes());
                bookingItem.setProductIdDes(booking.getProductIdDess()[0]);
                bookingItem.setRouteNoDes(booking.getRouteNoDes());
                log.info("오는편 상품 번호 : " + booking.getProductNoDes());
                log.info("오는편 상품 아이디 : " + bookingItem.getProductIdDes());
                result2 = bookingMapper.comeBookingInsert(bookingItem);
            }
                result1 = bookingMapper.goBookingInsert(bookingItem);
        }

        result = result1 + result2;

        return result;
    }

    // 탑승권 번호 발행 + QR 코드 발행
    @Override
    public int createTicket(Booking booking) throws Exception {
        String userId = "";
        int result = 0;
        // int bookingNo = 0;
        // int ticketNo = 0;
        // // ✅ TODO : 조건 pasCount 에 따라서 티켓 발행 
        // for (int i = 0; i < booking.getPasCount(); i++) {
        //     int count = bookingMapper.createTicket(booking);
        //     // 조건 : 회원 비회원
        //     // 회원 
        //     if( !userId.contains("GUEST") ) {
        //         bookingNo = bookingMapper.latest_user_bookingNo(booking.getUserNo());

        //         List<Booking> ticketList = bookingMapper.ticketList_bookingNo(bookingNo);
        //             for(int j = 0; j < ticketList.size(); j++){
        //                 Booking ticket = new Booking();
        //                 ticket = ticketList.get(i);
        //                 ticketNo = ticket.getTicketNo();
        //             }
        //     }
        //     else {
        //         bookingNo = bookingMapper.latest_user2_bookingNo(booking.getUserNo2());
        //         List<Booking> ticketList = bookingMapper.ticketList_bookingNo(bookingNo);
        //             for(int j = 0; j < ticketList.size(); j++){
        //                 Booking ticket = new Booking();
        //                 ticket = ticketList.get(i);
        //                 ticketNo = ticket.getTicketNo();
        //             }
        //     }
            
        //     QR qr = new QR();
        //     qr.setParentTable("booking");
        //     qr.setParentNo(ticketNo);
        //     String url = "http://localhost:" + serverPort + "/admin/Final_check?ticketNo=" + ticketNo;
        //     qr.setUrl( url );
        //     qr.setName("QR_" + ticketNo + "B" + bookingNo);

        //     qrService.makeQR(qr);

        //     result += count;
        // }

        return result;
    }

     // 예매 번호로 탑승권 정보(번호) 조회
    @Override
    public List<Booking> ticketList_bookingNo(int bookingNo) throws Exception {
        List<Booking> ticketList_bookingNo = bookingMapper.ticketList_bookingNo(bookingNo);
        return ticketList_bookingNo;
    }
}
