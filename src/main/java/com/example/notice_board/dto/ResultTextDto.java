package com.example.notice_board.dto;

import lombok.Getter;

@Getter
public class ResultTextDto {
    String result;

    public ResultTextDto(String result) {
        this.result = result;
    }
}
