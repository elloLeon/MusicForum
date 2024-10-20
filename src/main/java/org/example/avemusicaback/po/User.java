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







    public UserVO toVO(){
        UserVO userVO=new UserVO();
        userVO.setId(this.id);
        userVO.setSex(this.sex);
        userVO.setAddress(this.address);
        userVO.setUsername(this.username);

        userVO.setTelephone(this.telephone);
        userVO.setPassword(this.password);
        userVO.setCreateTime(this.createTime);
        userVO.setNickname(this.nickName);


        return userVO;
    }
}

