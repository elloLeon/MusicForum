package org.example.avemusicaback.serviceImpl;

import org.example.avemusicaback.po.Music;
import org.example.avemusicaback.repository.MusicRepository;
import org.example.avemusicaback.service.MusicService;
import org.example.avemusicaback.vo.MusicVO;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public Page<MusicVO> getAllMusic(Pageable pageable) {
        List<MusicVO> vos= ((MusicServiceImpl) AopContext.currentProxy()).getAllMusicInPageAsList(pageable);
        int allCount=((MusicServiceImpl) AopContext.currentProxy()).getAllMusicCount(pageable);
        return new PageImpl<>(vos, pageable, allCount);

    }
    @Cacheable(value = "allMusicCache_count", key = "#pageable")
    @Transactional
    @Override
    public int getAllMusicCount(Pageable pageable) {
        return musicRepository.findAll().size();
    }


    @Cacheable(value = "allMusicCache_content", key = "#pageable")
    @Transactional
    @Override
    public List<MusicVO> getAllMusicInPageAsList(Pageable pageable) {
        Page<Music> page =musicRepository.findAll(pageable);
        return page.getContent().stream()
                .map(Music::toVO)
                .collect(Collectors.toList());
    }
}
