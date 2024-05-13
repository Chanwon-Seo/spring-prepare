package com.sparta.memo.repository;

import com.sparta.memo.entitiy.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}
