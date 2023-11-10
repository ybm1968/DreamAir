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
    public int info(Booking booking) throws Exception {
        log.info("booking.email : " + booking.getEmail());
        int result = bookingMapper.info(booking);
        
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
            
            QR qr = new QR();
            qr.setParentTable("booking");
            qr.setParentNo(ticketNo);
            String url = "http://localhost:" + serverPort + "/admin/Final_check?ticketNo=" + ticketNo;
            qr.setUrl( url );
            qr.setName("QR_" + ticketNo + "B" + bookingNo);

            qrService.makeQR(qr);

            result += count;
        }

        return result;
    }

    // 예매 번호로 탑승권 정보(번호) 조회
    @Override
    public List<Booking> ticketList_bookingNo(int bookingNo) throws Exception {
        List<Booking> ticketList_bookingNo = bookingMapper.ticketList_bookingNo(bookingNo);
        return ticketList_bookingNo;
    }
    
    @Override
    public List<Booking> selectSeatStatus() throws Exception {
        List<Booking> seatList = bookingMapper.selectSeatStatus();


        return  seatList;
    }

    

}
