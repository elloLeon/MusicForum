package org.example.avemusicaback.po;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.avemusicaback.vo.UserVO;


import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "imgURL")
    private String imgURL;

    @Basic
    @Column(name = "telephone")
    private String telephone;

    @Basic
    @Column(name = "password")
    private String password;

    //必须注意，在Java中用驼峰，在MySQL字段中用连字符_
    @Basic
    @Column(name = "create_time")
    private Date createTime;



    @Basic
    @Column(name = "nick_name")
    private String nickName;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "sex")
    private String sex;


    // 只存储关注的用户的ID
    @ElementCollection
    @CollectionTable(name = "user_followings_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "follower_id")
    private Set<Integer> followings = new HashSet<>();

    // 只存储关注者的ID
    @ElementCollection
    @CollectionTable(name = "user_followers_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "follower_id")
    private Set<Integer> followers = new HashSet<>();




    public UserVO toVO(){
        UserVO userVO=new UserVO();
        userVO.setId(this.id);
        userVO.setImgURL(this.imgURL);
        userVO.setSex(this.sex);
        userVO.setAddress(this.address);
        userVO.setUsername(this.username);
        userVO.setTelephone(this.telephone);
        userVO.setPassword(this.password);
        userVO.setCreateTime(this.createTime);
        userVO.setNickname(this.nickName);
        // 将关注的用户ID和关注者ID传递到UserVO中
        userVO.setFollowing(this.followings);
        userVO.setFollowers(this.followers);
        return userVO;
    }
}

