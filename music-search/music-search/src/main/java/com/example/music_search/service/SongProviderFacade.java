package com.example.music_search.service;

import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;
import com.example.music_search.dto.SongDTO;

@FeignClient("Song")
public interface SongProviderFacade {

    @PostMapping(value = "/song/search", consumes = "application/json")
    List<SongDTO> searchSongs(@RequestBody Map<String, String> body);

    // @GetMapping("/recommend/songs")
}




