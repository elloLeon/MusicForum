package org.example.avemusicaback.vo;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.avemusicaback.po.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserVO {

    private Integer id;

    private String username;

    private String telephone;

    private String password;


    private String address;


    private Date createTime;

    private String nickname;




    public User toPO(){
        User user=new User();
        user.setId(this.id);
        user.setAddress(this.address);
        user.setUsername(this.username);
        user.setTelephone(this.telephone);
        user.setPassword(this.password);
        user.setCreateTime(this.createTime);
        user.setNickName(this.nickname);
        return user;
    }
}
