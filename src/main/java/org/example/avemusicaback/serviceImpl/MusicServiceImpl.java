package org.example.avemusicaback.serviceImpl;

import org.example.avemusicaback.po.Music;
import org.example.avemusicaback.repository.MusicRepository;
import org.example.avemusicaback.service.MusicService;
import org.example.avemusicaback.vo.MusicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicRepository musicRepository;
    @Override
    public MusicVO getInformation() {

        return null;
    }

    @Override
    public Boolean addMusic(MusicVO musicVO) {
        Music music = musicVO.toPO();
        musicRepository.save(music);
        return true;
    }
    @Override
    public Music saveMusic(Music music) {
        return musicRepository.save(music) ;
    }


}
