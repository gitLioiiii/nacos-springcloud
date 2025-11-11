package com.example.music_search.controller;

import java.util.List;
import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;

import com.example.music_search.dto.SongDTO;
import com.example.music_search.service.SongProviderFacade;

@RestController
public class SongRecommendController {
    
    // @Autowired
    // private RestTemplate restTemplate;

    private final SongProviderFacade songproviderFacade;

    public SongRecommendController(
        SongProviderFacade songproviderFacade
    ) {
        this.songproviderFacade = songproviderFacade;
    }

    @PostMapping("/search")
    public List<SongDTO> searchSongs(@RequestBody Map<String, String> body) {
        // String keword = this.restTemplate.getForObject("lb://Song/", String.class);
        String keyword = body.getOrDefault("keyword", "");
        return this.songproviderFacade.searchSongs(Map.of("keyword", keyword));
    }

    // @GetMapping("/")
    // public String index() {
    //     String port = this.restTemplate.getForObject("lb://provider/", String.class);
    //     return port + " -> by Consumer.";
    // }

    // @GetMapping("/hello")
    // public String hello() {
    //     return "hello";
    // }
}
