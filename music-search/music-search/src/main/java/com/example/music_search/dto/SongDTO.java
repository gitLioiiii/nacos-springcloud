package com.example.music_search.dto;
import java.time.LocalDateTime;
 public record SongDTO(
    Integer songId,
    String songName,
    Integer singerId,
    String singerName,
    String albumName,
    String fileUrl,
    String coverUrl,
    String duration,
    Integer likeCount,
    Integer status,
    Boolean songRecommended,
    Boolean singerRecommended,
    LocalDateTime frozenTime,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static SongDTO of(String songName, String singerName) {
        return new SongDTO(
            null, songName, null, singerName, null, 
            null, null, null, 0, 1, 
            false, false, 
            null, null, null
        );
    }
}