package org.example.avemusicaback.service;

import org.example.avemusicaback.po.Music;
import org.example.avemusicaback.vo.MusicVO;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MusicService {

    MusicVO getInformation();

    Boolean addMusic(MusicVO musicVO);

    Music saveMusic(Music music);
    Page<MusicVO> getAllMusic(Pageable pageable);

    @Cacheable(value = "allStoreCache_count", key = "#pageable")
    @Transactional
    int getAllMusicCount(Pageable pageable);

    @Cacheable(value = "allStoreCache_content", key = "#pageable")
    @Transactional
    List<MusicVO> getAllMusicInPageAsList(Pageable pageable);

    List<MusicVO> getMusicList(String username);
}
