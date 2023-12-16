package com.goit.eugene.module19_hw.repository;

import com.goit.eugene.module19_hw.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
