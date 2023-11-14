package com.joeun.dreamair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joeun.dreamair.dto.Comment;
import com.joeun.dreamair.service.CommentService;

import lombok.extern.slf4j.Slf4j;

/**
 *  댓글 컨트롤러
 */
@Slf4j
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    // 중복된 경로를 수정합니다.
    @GetMapping(value="/read")
    public ResponseEntity<List<Comment>> read(Model model, int boardNo) throws Exception {
        log.info("[GET] - /board/read");

        List<Comment> commentList = commentService.listByBoard(boardNo);
        for (Comment comment : commentList) {
            log.info("comment : " + comment);
        }
        model.addAttribute("commentList", commentList);
        return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
    }

    // 댓글 쓰기 페이지
    @GetMapping(value="/insert")
    public String insert() {
        return "board/insert";
    }

    // 댓글 쓰기 처리
    @PostMapping(value="/insert")
    public String insertPro(@ModelAttribute Comment comment) throws Exception {
        // 댓글 데이터베이스에 삽입
        int result = commentService.insert(comment);
        log.info("댓글 쓰기 결과 : result : " + result);
    
        // `parentNo`가 게시글 번호라고 가정합니다.
        int boardNo = comment.getParent_no();
        log.info("댓글 쓰기 처리 후, boardNo : " + boardNo);
        
        // 성공적으로 댓글을 삽입한 후, 댓글이 달린 게시글로 리다이렉트합니다.
        return "redirect:/board/read/" + boardNo;
    }

    // 댓글 쓰기 처리
    @ResponseBody
    @PostMapping(value="")
    public String commentPost(@ModelAttribute Comment comment) throws Exception {
        // 댓글 데이터베이스에 삽입
        int result = commentService.insert(comment);
        log.info("댓글 쓰기 결과 : result : " + result);
    
        if( result > 0 )
            return "SUCCESS";
        else 
            return "FAIL";
        
    }



    // 댓글 수정
    @GetMapping(value="/update")
    public String update(Model model, int commentNo) throws Exception {
        // 데이터 요청
        Comment comment = commentService.select(commentNo);
        // 모델 등록
        model.addAttribute("comment", comment);
        // 뷰 페이지 지정
        return "board/read";
    }

    // 댓글 수정 처리
    @PostMapping(value="/update")
    public String updatePro(Comment comment) throws Exception {
        // 데이터 처리
        int result = commentService.update(comment);
        int boardtNo = comment.getParent_no();

        // 댓글 수정 실패 ➡ 게시글 상세 화면
        if( result == 0 ) return "redirect:/board/read?commentNo=" + comment.getCommentNo();

        return "redirect:/board/read/" + boardtNo;
    }

    // 댓글 삭제 처리

    @PostMapping(value="/delete")
    public String deletePro(@RequestParam("commentNo") int commentNo, int boardNo) throws Exception {
        // 데이터 처리
        //Comment comment = commentService.select(commentNo);
          //  int boardNo = comment.getParentNo();
        int result = commentService.delete(commentNo);

         // 댓글 삭제 실패 ➡ 게시글 상세 화면
         if( result == 0 ) return "redirect:/board/read/" + commentNo;

        return "redirect:/board/read?boardNo="+boardNo;
    }
}



//     /**
//      * 댓글 쓰기 처리
//      * [POST]
//      * /comment/insert
//      * @param comment
//      * @return
//      * @throws Exception
//      */
//     @PostMapping(value="/insert")
//     public String insert(@ModelAttribute Comment comment) throws Exception {
//         log.info("[POST] - /comment/insert");
//         int result = commentService.insert(comment);
//         int boardNo = comment.getSeqNo();

//         // 댓글 쓰기 실패 ➡ 게시글 조회 페이지
//         if(result == 0) return "redirect:/board/read?boardNo=" + boardNo;
        
//         return "redirect:/board/read?boardNo=" + boardNo;
//     }

//     /**
//      * 댓글 수정 처리
//      * [POST]
//      * /comment/update
//      * @param comment
//      * @return
//      * @throws Exception
//      */
//     @PostMapping(value="/update")
//     public String update(Comment comment) throws Exception {
//         log.info("[POST] - /comment/update");
//         int result = commentService.update(comment);
//         int boardNo = comment.getSeqNo();

//         // 댓글 수정 실패 ➡ 게시글 조회 페이지
//         if(result == 0) return "redirect:/board/read?boardNo=" + boardNo;
        
//         return "redirect:/board/read?boardNo=" + boardNo;
//     }

//     /**
//      * 댓글 삭제 처리
//      * [POST]
//      * /comment/delete
//      * @param commentNo
//      * @return
//      * @throws Exception
//      */
//     @PostMapping(value="/delete")
//     public String delete(int commentNo, int boardNo) throws Exception {
//         log.info("[POST] - /comment/delete");
//         int result = commentService.delete(commentNo);
        
//         // 댓글 삭제 실패 ➡ 게시글 조회 페이지
//         if(result == 0) return "redirect:/board/read?boardNo=" + boardNo;

//         return "redirect:/board/read?boardNo=" + boardNo;
//     }

// }
