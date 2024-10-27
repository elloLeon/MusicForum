package org.example.avemusicaback.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.avemusicaback.po.Music;

@Getter
@Setter
@NoArgsConstructor
public class MusicVO {
        private Integer id;
        private String musicName;
        private String author;
        private String username;
        private String description;
        private String musicUrl;
        private String imgUrl;
        private String createTime;
        public Music toPO()
        {
            Music music = new Music();
            music.setId(this.id);
            music.setMusicName(this.musicName);
            music.setMusicUrl(this.musicUrl);
            music.setUsername(this.username);
            music.setAuthor(this.author);
            music.setDescription(this.description);
            music.setCreateTime(this.createTime);
            music.setImgUrl(this.imgUrl);
            music.setCreateTime(this.createTime);
            return music;
        }
}
