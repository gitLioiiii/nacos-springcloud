package com.example.provider;
import java.time.LocalDateTime;

public class SongEntity {
    private Integer songId;
    private String songName;
    private Integer singerId;
    private String singerName;
    private String albumName;
    private String fileUrl;
    private String coverUrl;
    private String duration;
    private Integer likeCount;
    private Integer status;
    private Boolean songRecommended;
    private Boolean singerRecommended;
    private LocalDateTime frozenTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SongEntity() {}

    public SongEntity(
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
        this.songId = songId;
        this.songName = songName;
        this.singerId = singerId;
        this.singerName = singerName;
        this.albumName = albumName;
        this.fileUrl = fileUrl;
        this.coverUrl = coverUrl;
        this.duration = duration;
        this.likeCount = likeCount;
        this.status = status;
        this.songRecommended = songRecommended;
        this.singerRecommended = singerRecommended;
        this.frozenTime = frozenTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getSongId() {
        return songId;
    }
    public void setSongId(Integer songId) {
        this.songId = songId;
    }
    public String getSongName() {
        return songName;
    }
    public String songName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public Integer getSingerId() {
        return singerId;
    }
    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }
    public String getSingerName() {
        return singerName;
    }
    public String singerName() {
        return singerName;
    }
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public String getCoverUrl() {
        return coverUrl;
    }
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public Integer getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Boolean getSongRecommended() {
        return songRecommended;
    }
    public void setSongRecommended(Boolean songRecommended) {
        this.songRecommended = songRecommended;
    }
    public Boolean getSingerRecommended() {
        return singerRecommended;
    }
    public void setSingerRecommended(Boolean singerRecommended) {
        this.singerRecommended = singerRecommended;
    }
    public LocalDateTime getFrozenTime() {
        return frozenTime;
    }
    public void setFrozenTime(LocalDateTime frozenTime) {
        this.frozenTime = frozenTime;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}



