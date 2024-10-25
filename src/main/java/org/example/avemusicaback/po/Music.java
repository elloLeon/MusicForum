package org.example.avemusicaback.po;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.avemusicaback.vo.MusicVO;
import org.example.avemusicaback.vo.UserVO;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Music {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name="musicname")
    private String musicName;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name="author")
    private String author;

    @Basic
    @Column(name="description")
    private String description;

    @Basic
    @Column(name="musicurl")
    private String musicUrl;

    public MusicVO toVO(){
        MusicVO musicVO = new MusicVO();
        musicVO.setId(this.id);
        musicVO.setMusicName(this.musicName);
        musicVO.setMusicUrl(this.musicUrl);
        musicVO.setUsername(this.username);
        musicVO.setDescription(this.description);
        return musicVO;
    }

}
