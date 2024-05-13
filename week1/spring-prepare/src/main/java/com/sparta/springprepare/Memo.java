package com.sparta.springprepare;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Memo {

    private final String username;
    private String contents;
}