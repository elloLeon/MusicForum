package org.example.avemusicaback.service;

import org.example.avemusicaback.po.Music;
import org.example.avemusicaback.vo.MusicVO;
import org.example.avemusicaback.vo.UserVO;

public interface MusicService {

    MusicVO getInformation();

    Boolean addMusic(MusicVO musicVO);

    Music saveMusic(Music music);
}
