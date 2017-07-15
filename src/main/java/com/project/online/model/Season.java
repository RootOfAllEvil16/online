package com.project.online.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "seasonId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seasonId;

    @Column(name = "seasonNum")
    private int seasonNum;


    @ManyToOne
    @JoinColumn(name = "showId")
    private Show show;


    @OneToMany(mappedBy = "season",cascade = CascadeType.ALL)
    private List<Episode> episodes;

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
    }

    public int getSeasonNum() {
        return seasonNum;
    }

    public void setSeasonNum(int seasonNum) {
        this.seasonNum = seasonNum;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}