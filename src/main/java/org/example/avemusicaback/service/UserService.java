package org.example.avemusicaback.service;



import org.example.avemusicaback.po.User;
import org.example.avemusicaback.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Boolean register(UserVO userVO);

    String login(String phone,String password);

    UserVO getInformation();

    Boolean updateInformation(UserVO userVO);
    User getOneUser(Integer userId);

    User saveUser(User user);

}