package org.example.avemusicaback.controller;

import org.example.avemusicaback.po.User;
import org.example.avemusicaback.service.UserService;
import org.example.avemusicaback.serviceImpl.UserServiceImpl;
import org.example.avemusicaback.vo.ResultVO;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public ResultVO<Boolean> register(@RequestBody UserVO userVO ){
        return ResultVO.buildSuccess(userService.register(userVO));
    }

    @PostMapping("/login")
    public ResultVO<String> login(@RequestParam("username") String username, @RequestParam("password") String password){
        return ResultVO.buildSuccess(userService.login(username, password));
    }



    @GetMapping
    public ResultVO<UserVO> getInformation(){
        return ResultVO.buildSuccess(userService.getInformation());
    }

    @PostMapping("/update")
    public ResultVO<Boolean> updateInformation(@RequestBody UserVO userVO){
        return ResultVO.buildSuccess(userService.updateInformation(userVO));
    }

    @PostMapping("/changePassword")
    public ResultVO<Boolean> changePassword(@RequestParam("oldPassword")String oldPassword,
                                            @RequestParam("newPassword")String newPassword){
        return ResultVO.buildSuccess(userService.changePassword(oldPassword,newPassword));

    }
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
