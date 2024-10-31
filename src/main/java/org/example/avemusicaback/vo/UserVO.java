package org.example.avemusicaback.vo;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.avemusicaback.po.User;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserVO {

    private Integer id;

    private String username;

    private String imgURL;

    private String telephone;

    private String password;


    private String address;


    private Date createTime;

    private String nickname;

    private String sex;
    private Set<Integer> followers = new HashSet<>(); // 粉丝列表
    private Set<Integer> following = new HashSet<>();



    public User toPO(){
        User user=new User();
        user.setId(this.id);
        user.setSex(this.sex);
        user.setImgURL(this.imgURL);
        user.setAddress(this.address);
        user.setUsername(this.username);
        user.setTelephone(this.telephone);
        user.setPassword(this.password);
        user.setCreateTime(this.createTime);
        user.setNickName(this.nickname);
        // 将关注的用户ID和关注者ID传递到User中
        user.setFollowings(new HashSet<>(this.following));
        user.setFollowers(new HashSet<>(this.followers));
        return user;
    }
}

