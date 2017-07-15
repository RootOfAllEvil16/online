package com.project.online.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "episodes")
public class Episode implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "episodeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long episodeId;

    @Column(name = "episodeNum")
    private int episodeNum;


    @ManyToOne
    @JoinColumn(name = "seasonId")
    private Season season;


    @Transient
    private MultipartFile episodeImage;
    @Transient
    private MultipartFile videoFile;


    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> episodeComments;

    public Episode() {
    }


    public Episode(int episodeNum) {
        this.episodeNum = episodeNum;
        episodeComments = new ArrayList<>();

    }


    public long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(long episodeId) {
        this.episodeId = episodeId;
    }

    public int getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(int episodeNum) {
        this.episodeNum = episodeNum;
    }


    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }


    public List<Comment> getEpisodeComments() {
        return episodeComments;
    }

    public void setEpisodeComments(List<Comment> episodeComments) {
        this.episodeComments = episodeComments;
    }

    public void addComment(Comment comment) {
        episodeComments.add(comment);
    }

    public MultipartFile getEpisodeImage() {
        return episodeImage;
    }

    public void setEpisodeImage(MultipartFile episodeImage) {
        this.episodeImage = episodeImage;
    }

    public MultipartFile getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(MultipartFile videoFile) {
        this.videoFile = videoFile;
    }

}











