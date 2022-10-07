package com.codegym.cinema.model;

import javax.persistence.*;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;
    private String cinemaCode;
    private String cinemaName;
    private String cinemaDate;
    private String cinemaAmounts;

//    khai báo thuộc tính boolean mặc đinh là false rồi không nên để false
//    private boolean isDelete = false;
    private boolean isDelete ;

//    @ManyToOne()
//    @JoinColumn(name = "film_id", referencedColumnName = "filmId")
//    private Film film;

    public Cinema() {
    }

    public Cinema(Integer cinemaId, String cinemaCode, String cinemaName, String cinemaDate, String cinemaAmounts) {
        this.cinemaId = cinemaId;
        this.cinemaCode = cinemaCode;
        this.cinemaName = cinemaName;
        this.cinemaDate = cinemaDate;
        this.cinemaAmounts = cinemaAmounts;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaCode() {
        return cinemaCode;
    }

    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }


    public String getCinemaDate() {
        return cinemaDate;
    }

    public void setCinemaDate(String cinemaDate) {
        this.cinemaDate = cinemaDate;
    }

    public String getCinemaAmounts() {
        return cinemaAmounts;
    }

    public void setCinemaAmounts(String cinemaAmounts) {
        this.cinemaAmounts = cinemaAmounts;
    }


}
