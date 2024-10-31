package org.example.avemusicaback.service;

import org.example.avemusicaback.po.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ConcernService {
    User getConcernInfo(String username);
    Boolean followUser(Integer followerId, Integer followedId);
    List<Integer> getFollowings(Integer userId);
    List<Integer> getFollowers(Integer userId);
    Boolean unfollowUser(Integer followerId, Integer followedId);

}
