package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto  {
    private int id;

    @NotBlank
    @Size(max = 800,message = "Không Được Quá 800 Kí Tự")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$")
    private String nameMusic;

    @NotBlank
    @Size(max = 300,message = "Không Được Quá 300 Kí Tự")
    @Pattern(regexp = "^[a-zA-Z0-9 \\+]*$")
    private String performingArtist;

    @NotBlank
    @Size(max = 1000,message = "Không Được Quá 1000 Kí Tự")
    @Pattern(regexp = "^[a-zA-Z0-9, \\+]*$")
    private String kindOfMusic;
    private String songFilePath;

    public MusicDto() {
    }

    public MusicDto(int id, String nameMusic, String performingArtist, String kindOfMusic, String songFilePath) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.performingArtist = performingArtist;
        this.kindOfMusic = kindOfMusic;
        this.songFilePath = songFilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getPerformingArtist() {
        return performingArtist;
    }

    public void setPerformingArtist(String performingArtist) {
        this.performingArtist = performingArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(String songFilePath) {
        this.songFilePath = songFilePath;
    }
}
