package com.bhhan.reactor.app.board.converter;

import com.bhhan.reactor.app.board.domain.Board;
import com.bhhan.reactor.sharedmodel.board.BoardDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Component
public class BoardDtoConverter implements Converter<Board, BoardDto> {
    @Override
    public BoardDto convert(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setTitle(board.getTitle());
        boardDto.setContent(board.getContent());
        boardDto.setWriterId(board.getWriterId());
        return boardDto;
    }
}
