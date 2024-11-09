package org.example.avemusicaback.controller;


import org.example.avemusicaback.po.Music;
import org.example.avemusicaback.service.MusicService;
import org.example.avemusicaback.service.OssService;
import org.example.avemusicaback.vo.MusicVO;
import org.example.avemusicaback.vo.ResultVO;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/musics")
public class MusicController {
    @Autowired
    OssService ossService;
    @Autowired
    MusicService musicService;
    @PostMapping("/uploadMusic")
    public ResultVO<String> upload(@RequestParam MultipartFile file){
        return ResultVO.buildSuccess(ossService.upload(file));
    }

//    @GetMapping
//    public ResultVO<MusicVO> getInformation(){
//        return ResultVO.buildSuccess(musicService.getInformation());
//    }

    @PostMapping("/addMusic")
    public ResultVO<Boolean> addMusic(@RequestBody MusicVO musicVO){
        return ResultVO.buildSuccess(musicService.addMusic(musicVO));
    }

    //获得page music
    @GetMapping
    public ResultVO <Page<MusicVO>> getMusics(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return  ResultVO.buildSuccess(musicService.getAllMusic(pageable)) ;
    }

    //通过username获得musiclist
    @GetMapping("/getMusicList")
    public ResultVO<List<MusicVO>>getMusicList(@RequestParam("username") String username)
    {
        return ResultVO.buildSuccess(musicService.getMusicList(username));
    }
}