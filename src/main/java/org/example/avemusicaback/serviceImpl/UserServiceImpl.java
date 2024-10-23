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

import java.util.Date;
import java.util.List;

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
        userRepository.save(newUser);
        return true;
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
        return user.toVO();
    }

    @Override
    public Boolean updateInformation(UserVO userVO) {
        return null;
    }

    @Override
    public User getOneUser(Integer userId) {
        return null;
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
