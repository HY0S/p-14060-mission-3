package com.back.domain.wiseSaying.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WiseSaying {
    private int id;
    private String content;
    private String author;
    public WiseSaying() {}
}
