package com.sparta.memo.entitiy;

import com.sparta.memo.dto.MemoRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequestDto dto) {
        this.username = dto.getUsername();
        this.contents = dto.getContents();
    }
}
