package org.example.avemusicaback.controller;

import org.example.avemusicaback.po.User;
import org.example.avemusicaback.service.UserService;
import org.example.avemusicaback.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concern")

public class ConcernController {
    @Autowired
    UserService userService;


    @PostMapping("/follow")
    public ResultVO<Boolean> follow(@RequestParam("followerId") Integer followerId, @RequestParam("followedId") Integer followedId) {
        return ResultVO.buildSuccess(userService.followUser(followerId, followedId));
    }

    @PostMapping("/unfollow")
    public ResultVO<Boolean> unfollow(@RequestParam("followerId") Integer followerId, @RequestParam("followedId") Integer followedId) {
        return ResultVO.buildSuccess( userService.unfollowUser(followerId, followedId));
    }

    @GetMapping("/following")
    public ResultVO<List<Integer>> getFollowing(@RequestParam("id") Integer id) {
        return ResultVO.buildSuccess(  userService.getFollowings(id));
    }

    @GetMapping("/followers")
    public ResultVO<List<Integer>> getFollowers(@RequestParam("id")Integer id) {
        return   ResultVO.buildSuccess( userService.getFollowers(id));
    }

    @GetMapping("/getConcernInfo")
    public ResultVO<User> getConcernInfo(@RequestParam("username")String username){
        return ResultVO.buildSuccess(userService.getConcernInfo(username));
    }
}
