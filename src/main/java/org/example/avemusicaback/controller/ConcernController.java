package org.example.avemusicaback.controller;

import org.example.avemusicaback.po.User;
import org.example.avemusicaback.service.ConcernService;
import org.example.avemusicaback.service.UserService;
import org.example.avemusicaback.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concern")

public class ConcernController {
    @Autowired
    ConcernService concernService;


    @PostMapping("/follow")
    public ResultVO<Boolean> follow(@RequestParam("followerId") Integer followerId, @RequestParam("followedId") Integer followedId) {
        return ResultVO.buildSuccess(concernService.followUser(followerId, followedId));
    }

    @PostMapping("/unfollow")
    public ResultVO<Boolean> unfollow(@RequestParam("followerId") Integer followerId, @RequestParam("followedId") Integer followedId) {
        return ResultVO.buildSuccess( concernService.unfollowUser(followerId, followedId));
    }

    @GetMapping("/following")
    public ResultVO<List<Integer>> getFollowing(@RequestParam("id") Integer id) {
        return ResultVO.buildSuccess(  concernService.getFollowings(id));
    }

    @GetMapping("/followers")
    public ResultVO<List<Integer>> getFollowers(@RequestParam("id")Integer id) {
        return   ResultVO.buildSuccess( concernService.getFollowers(id));
    }

    @GetMapping("/getConcernInfo")
    public ResultVO<User> getConcernInfo(@RequestParam("username")String username){
        return ResultVO.buildSuccess(concernService.getConcernInfo(username));
    }
}
