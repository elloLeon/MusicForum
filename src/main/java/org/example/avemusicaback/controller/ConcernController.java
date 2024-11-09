package org.example.avemusicaback.controller;

import org.example.avemusicaback.po.User;
import org.example.avemusicaback.service.ConcernService;
import org.example.avemusicaback.service.UserService;
import org.example.avemusicaback.vo.ResultVO;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concern")

public class ConcernController {
    @Autowired
    ConcernService concernService;


    //关注
    @PostMapping("/follow")
    public ResultVO<Boolean> follow(@RequestParam("followerId") Integer followerId, @RequestParam("followedId") Integer followedId) {
        return ResultVO.buildSuccess(concernService.followUser(followerId, followedId));
    }

    //取消关注
    @PostMapping("/unfollow")
    public ResultVO<Boolean> unfollow(@RequestParam("followerId") Integer followerId, @RequestParam("followedId") Integer followedId) {
        return ResultVO.buildSuccess( concernService.unfollowUser(followerId, followedId));
    }

    //获得自己关注的对象
    @GetMapping("/following")
    public ResultVO<List<UserVO>> getFollowing() {
        return ResultVO.buildSuccess(  concernService.getFollowings());
    }

    //获得关注自己的对象
    @GetMapping("/followers")
    public ResultVO<List<User>> getFollowers() {
        return   ResultVO.buildSuccess( concernService.getFollowers());
    }

    //根据username获得信息
    @GetMapping("/getConcernInfo")
    public ResultVO<User> getConcernInfo(@RequestParam("username")String username){
        return ResultVO.buildSuccess(concernService.getConcernInfo(username));
    }
}
