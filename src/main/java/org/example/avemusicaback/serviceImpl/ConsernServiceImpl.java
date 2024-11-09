package org.example.avemusicaback.serviceImpl;

import org.example.avemusicaback.Util.SecurityUtil;
import org.example.avemusicaback.po.User;
import org.example.avemusicaback.repository.UserRepository;
import org.example.avemusicaback.service.ConcernService;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConsernServiceImpl implements ConcernService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityUtil securityUtil;
    @Override
    public Boolean followUser(Integer followerId, Integer followedId) {
        User follower = userRepository.findById(followerId).orElseThrow();
        User followed = userRepository.findById(followedId).orElseThrow();

        follower.getFollowings().add(followed.getId());
        followed.getFollowers().add(follower.getId());

        userRepository.save(follower);
        userRepository.save(followed);
        return true;
    }
    @Override
    public Boolean unfollowUser(Integer followerId, Integer followedId) {
        User follower = userRepository.findById(followerId).orElseThrow();
        User followed = userRepository.findById(followedId).orElseThrow();

        follower.getFollowings().remove(followed.getId());
        followed.getFollowers().remove(follower.getId());

        userRepository.save(follower);
        userRepository.save(followed);
        return true;
    }
    @Override
    public List<UserVO> getFollowings() {
        User user = securityUtil.getCurrentUser();
        List<UserVO> userList = new ArrayList<>();
        for (Integer i:user.getFollowings())
        {
            userList.add(userRepository.findUserById(i).toVO());
        }
        return userList;
    }
    @Override
    public List<User> getFollowers() {
        User user = securityUtil.getCurrentUser();
        List<User> userList = new ArrayList<>();
        for (Integer i:user.getFollowers())
        {
            userList.add(userRepository.findUserById(i));
        }
        return userList;
    }
    @Override
    public User getConcernInfo(String username) {
        return userRepository.findByUsername(username);
    }


}
