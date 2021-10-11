package com.example.board.beans.dao;

import com.example.board.beans.vo.BoardVO;
import com.example.board.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component /*클래스가 Bean으로 등록이 된다.*/
/*다만 DAO는 사용목적에 따라 vo처럼 일반 클래스가 아닌 DAO라는것을 알리기 위해
 * Component를 부모로 가진 Repository를 사용*/

// 원격에서 수정합
@Repository
@RequiredArgsConstructor
public class BoardDAO {
//    @Autowired
//    private BoardMapper mapper;
    private final BoardMapper mapper; 

    public void register(BoardVO board){
        mapper.insertSelectKey_bno(board);
    }

    public BoardVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(BoardVO board){
        return mapper.update(board) == 1;
    }

    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }

    public List<BoardVO> getList(){
        return mapper.getList();
    }

}
