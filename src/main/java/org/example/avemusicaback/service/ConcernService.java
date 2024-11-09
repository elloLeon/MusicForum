package org.example.avemusicaback.service;

import org.example.avemusicaback.po.User;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ConcernService {
    User getConcernInfo(String username);
    Boolean followUser(Integer followerId, Integer followedId);
    List<UserVO> getFollowings();
    List<User> getFollowers();
    Boolean unfollowUser(Integer followerId, Integer followedId);

}
