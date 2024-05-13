package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entitiy.Memo;
import com.sparta.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // DB 저장
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        return new MemoResponseDto(saveMemo);
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회
        return memoRepository.findAll().stream()
                .map(MemoResponseDto::new)
                .toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = findMemo(id);

        memo.update(requestDto);
        return memo.getId();
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        // memo 삭제
        memoRepository.delete(memo);
        return memo.getId();
    }

    private Memo findMemo(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
                );
    }
}
