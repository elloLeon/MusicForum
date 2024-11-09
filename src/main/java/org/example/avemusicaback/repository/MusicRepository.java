package org.example.avemusicaback.repository;

import org.example.avemusicaback.po.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Integer> {
    Music findByUsername(String username);

    Music findByMusicName(String musicName);

    List<Music> findAllByUsername(String username);

}
