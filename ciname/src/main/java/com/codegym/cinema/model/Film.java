//package com.codegym.cinema.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Film {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer filmId;
//    private String filmName;
//
//    @OneToMany(mappedBy = "film")
//    private Set<Cinema> cinemaSet;
//
//    public Film() {
//    }
//
//    public Film(Integer filmId, String filmName, Set<Cinema> cinemaSet) {
//        this.filmId = filmId;
//        this.filmName = filmName;
//        this.cinemaSet = cinemaSet;
//    }
//
//    public Integer getFilmId() {
//        return filmId;
//    }
//
//    public void setFilmId(Integer filmId) {
//        this.filmId = filmId;
//    }
//
//    public String getFilmName() {
//        return filmName;
//    }
//
//    public void setFilmName(String filmName) {
//        this.filmName = filmName;
//    }
//
//    public Set<Cinema> getCinemaSet() {
//        return cinemaSet;
//    }
//
//    public void setCinemaSet(Set<Cinema> cinemaSet) {
//        this.cinemaSet = cinemaSet;
//    }
//}
