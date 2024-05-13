package com.sparta.memo.repository;

import com.sparta.memo.entitiy.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByOrderByModifiedAtDesc();

    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);

    default List<Memo> findAllByKeyword(String keyword) {
        return findAllByContentsContainsOrderByModifiedAtDesc(keyword);
    }
}
