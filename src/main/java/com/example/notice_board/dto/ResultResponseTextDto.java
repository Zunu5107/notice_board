package com.example.notice_board.dto;

import lombok.Getter;

@Getter
public class ResultResponseTextDto {
    String result;

    public ResultResponseTextDto(String result) {
        this.result = result;
    }

}
