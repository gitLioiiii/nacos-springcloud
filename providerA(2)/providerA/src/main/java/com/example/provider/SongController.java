package com.example.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class SongController {

    // http://localhost:9999/search
    // {
    // "keyword": "稻香"
    // }
    @PostMapping(path = "/song/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<SongEntity> search(@RequestBody Map<String, String> body) {
        String raw = body == null ? null : body.get("keyword");
        String keyword = raw == null ? "" : raw.toLowerCase(Locale.ROOT);

        List<SongEntity> all = new ArrayList<>();

        SongEntity a = new SongEntity(
            1,
            "稻香",
            100,
            "周杰伦",
            "魔杰座",
            "https://example.com/audio/daoxiang.mp3",
            "https://example.com/cover/daoxiang.jpg",
            "00:03:43",
            123,
            1,
            Boolean.TRUE,
            Boolean.FALSE,
            null,
            null,
            null
        );
        all.add(a);

        SongEntity b = new SongEntity(
            2,
            "晴天",
            100,
            "周杰伦",
            "叶惠美",
            "https://example.com/audio/qingtian.mp3",
            "https://example.com/cover/qingtian.jpg",
            "00:04:29",
            456,
            1,
            Boolean.TRUE,
            Boolean.TRUE,
            null,
            null,
            null
        );
        all.add(b);

        if (keyword.isEmpty()) {
            return all;
        }

        List<SongEntity> filtered = new ArrayList<>();
        for (SongEntity s : all) {
            String name = s.songName() == null ? "" : s.songName();
            String singer = s.singerName() == null ? "" : s.singerName();
            if (name.toLowerCase(Locale.ROOT).contains(keyword) || singer.toLowerCase(Locale.ROOT).contains(keyword)) {
                filtered.add(s);
            }
        }
        return filtered;
    }
}


