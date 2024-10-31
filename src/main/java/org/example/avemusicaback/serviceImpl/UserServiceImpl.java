package org.example.avemusicaback.serviceImpl;

import org.example.avemusicaback.Util.SecurityUtil;
import org.example.avemusicaback.Util.TokenUtil;
import org.example.avemusicaback.exception.AveMusicaException;
import org.example.avemusicaback.po.User;
import org.example.avemusicaback.repository.UserRepository;
import org.example.avemusicaback.service.UserService;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    SecurityUtil securityUtil;

    @Override
    public Boolean register(UserVO userVO) {
        User user = userRepository.findUserByTelephone(userVO.getTelephone());

        if (user != null) {
            throw AveMusicaException.userAlreadyExists();
        }
        User newUser = userVO.toPO();
        newUser.setCreateTime(new Date());
        newUser.setImgURL("");
        userRepository.save(newUser);
        return true;
    }

    @Override
    public User getConcernInfo(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw AveMusicaException.UserNotExist();
        }
        String Password = user.getPassword();
        if (Password.equals(password)) {
            return tokenUtil.getToken(user);
        } else {
            throw AveMusicaException.usernameOrPasswordError();
        }
    }

    @Override
    public UserVO getInformation() {
        User user = securityUtil.getCurrentUser();
        //System.out.println(user.getNickName());
        return user.toVO();
    }

    @Override
    public Boolean updateInformation(UserVO userVO) {
        User user=securityUtil.getCurrentUser();
        if (userVO.getTelephone()!=null){
            user.setTelephone(userVO.getTelephone());
        }
        if (userVO.getUsername()!=null){
            user.setUsername(userVO.getUsername());
        }
        if (userVO.getAddress()!=null){
            user.setAddress(userVO.getAddress());
        }
        if (userVO.getSex()!=null){
            user.setSex(userVO.getSex());
        }
        if (userVO.getNickname()!=null){
            user.setNickName(userVO.getNickname());
        }
        if (userVO.getImgURL()!=null)
        {
            user.setImgURL(userVO.getImgURL());
        }
        userRepository.save(user);
        return true;

    }

    @Override
    public User getOneUser(Integer userId) {
        return null;
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public Boolean changePassword(String oldPassword, String newPassword) {

        User user = securityUtil.getCurrentUser();
        if (!Objects.equals(user.getPassword(), oldPassword))
        {
            return false;
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return true;
    }
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
    public List<Integer> getFollowings(Integer userId) {
        return new ArrayList<>(userRepository.findById(userId).orElseThrow().getFollowings());
    }
    @Override
    public List<Integer> getFollowers(Integer userId) {
        return new ArrayList<>(userRepository.findById(userId).orElseThrow().getFollowers());
    }
}