package com.example.board.services;

import com.example.board.beans.vo.BoardVO;
import com.example.board.sevices.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//public void register(BoardVO boardVO);
//public BoardVO get(Long bno);
//public boolean modify(BoardVO board);
//public boolean remove(Long bno);
//public List<BoardVO> getList();


@SpringBootTest
@Slf4j
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("수정된 글 제목5");
        board.setContent("수정된 글 내용5");
        board.setWriter("user04");

        boardService.register(board);
        log.info("------------------------------------------");
        log.info(board.getBno() + "");
        log.info("------------------------------------------");
    }

    @Test
    public void testGet(){
        log.info(boardService.get(8L).toString());
    }

    @Test
    public void testModify(){
            BoardVO board = new BoardVO();
            board.setBno(8L);
            board.setTitle("수정된 글 제목5");
            board.setContent("수정된 글 내용5");
            log.info("UPDATE COUNT : " + boardService.modify(board));
    }

    @Test
    public void testRemove(){
        log.info("DELETE : " + boardService.remove(8L));
    }

    @Test
    public void testGetList(){
        boardService.getList().forEach(board -> log.info(board.toString()));
    }
}
