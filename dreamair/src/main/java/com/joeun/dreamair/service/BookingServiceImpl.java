package com.joeun.dreamair.service;

import java.util.List;

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

    @Override
    public List<Booking> golist(Booking booking) throws Exception {
        log.info("서비스임플 가는편 도착지 : " + booking.getDestination());
        log.info("시버스임플 가는편 출발날짜 : " + booking.getDepartureDate());

        List<Booking> bookingList = bookingMapper.golist(booking);

        return bookingList;
    }

     @Override
    public List<Booking> comelist(Booking booking) throws Exception {
        log.info("서비스임플 오는편 도착지 : " + booking.getDestination());
        log.info("서비스임플 오는편 출발날짜 : " + booking.getDepartureDate());

        List<Booking> bookingList = bookingMapper.comelist(booking);

        return bookingList;
    }


    @Override
    public int infoList(Booking booking) throws Exception {
        // log.info("서비스임플 이메일 : " + booking.getEmails()[0]);
        log.info("서비스임플 인원수 : " + booking.getPasCount());
        int result = 0;
        
        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setProductNoDep(booking.getProductNoDeps()[i]);
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setFirstName(booking.getFirstNames()[i]);
            bookingItem.setLastName(booking.getLastNames()[i]);
            bookingItem.setGender(booking.getGenders()[i]);
            bookingItem.setBirth(booking.getBirths()[i]);
            bookingItem.setPinType(booking.getPinTypes()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            bookingItem.setEmail(booking.getEmails()[i]);

            if ( booking.getRoundTrip().equals("왕복")) {
                bookingItem.setProductNoDes(booking.getProductNoDess()[i]);
            }

            bookingMapper.info(bookingItem);
            result++;
        }

        log.info("왕복 등록결과 : " + result);
        
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
    
    @Override
    public int createTicket(Booking booking) throws Exception {
        String userId = "";
        int result = 0;
        int bookingNo = 0;
        int ticketNo = 0;
        // ✅ TODO : 조건 pasCount 에 따라서 티켓 발행 
        for (int i = 0; i < booking.getPasCount(); i++) {
            int count = bookingMapper.createTicket(booking);
            // 조건 : 회원 비회원
            // 회원
            if( !userId.contains("GUEST") ) {
                bookingNo = bookingMapper.latest_user_bookingNo(booking.getUserNo());
                //ticketNo = ???;
            }
            else {
                bookingNo = bookingMapper.latest_user2_bookingNo(booking.getUserNo2());
                //ticketNo = ???;
            }
            
            QR qr = new QR();
            qr.setParentTable("booking");
            qr.setParentNo(ticketNo);
            String url = "http://localhost:" + serverPort + "/admin/Final_check?ticketNo=" + ticketNo;
            qr.setUrl( url );
            qr.setName("???");

            qrService.makeQR(qr);

            result += count;
        }

        return result;
    }

    // seat 테이블 좌석 상태 조회
    @Override
    public List<Booking> selectSeatStatus() throws Exception {
        List<Booking> seatList = bookingMapper.selectSeatStatus();


        return  seatList;
    }


    // 탑승권 리스트 조회 - 회원
    @Override
    public List<Booking> selectBookingListByUser(String userId) throws Exception {

        List<Booking> bookingList = bookingMapper.selectBookingListByUser(userId);

        return bookingList;

    }


    // 탑승권 상세 조회
    @Override
    public List<Booking> selectTicket(int bookingNo) throws Exception {

        List<Booking> viewTicket = bookingMapper.selectTicket(bookingNo);

        return viewTicket;

    }

    @Override
    public String selectDeparture(int productNoDeps) {

        String departure = bookingMapper.selectDeparture(productNoDeps);

        return departure;
    }

    @Override
    public String selectDestination(int productNoDess) {

        String destination = bookingMapper.selectDestination(productNoDess);

        return destination;
    }


}
