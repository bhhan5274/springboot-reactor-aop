package com.bhhan.reactor.app.board;

import com.bhhan.reactor.app.attachment.Attach;
import com.bhhan.reactor.app.board.converter.BoardDtoConverter;
import com.bhhan.reactor.app.board.domain.Board;
import com.bhhan.reactor.app.board.domain.BoardRepository;
import com.bhhan.reactor.sharedmodel.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardDtoConverter boardDtoConverter;

    @GetMapping
    public List<BoardDto> getAll(){
        return boardRepository.findAll()
                .stream()
                .map(boardDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Attach
    @GetMapping("/{id}")
    public BoardDto getOne(@PathVariable("id") Long id){
        final Board board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return boardDtoConverter.convert(board);
    }
}
