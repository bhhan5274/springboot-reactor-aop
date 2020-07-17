package com.bhhan.reactor.app.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Created by hbh5274@gmail.com on 2020-07-17
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "BOARDS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;
    private String content;
    private Long writerId;

    public Board(@NonNull String title, @NonNull String content, @NonNull Long writerId) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }
}
