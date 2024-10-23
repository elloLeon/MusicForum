package org.example.avemusicaback.controller;

import org.example.avemusicaback.service.UserService;
import org.example.avemusicaback.serviceImpl.UserServiceImpl;
import org.example.avemusicaback.vo.ResultVO;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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

    @PostMapping
    public ResultVO<Boolean> updateInformation(@RequestBody UserVO userVO){
        return ResultVO.buildSuccess(userService.updateInformation(userVO));
    }



}
