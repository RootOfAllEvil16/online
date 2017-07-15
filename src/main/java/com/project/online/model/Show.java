package com.project.online.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "showId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showId;

    @Column(name = "showName")
    private String showName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Transient
    private MultipartFile showImage;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Season> seasons;

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public MultipartFile getShowImage() {
        return showImage;
    }

    public void setShowImage(MultipartFile showImage) {
        this.showImage = showImage;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}

