package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String creator;
    private String title;
    private String book;
    private int amount;
    private int startAmount;

    public BookLibrary() {
    }

    public BookLibrary(int id, String creator, String title, String book, int amount, int startAmount) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.book = book;
        this.amount = amount;
        this.startAmount = startAmount;
    }

    public int getId() {
        return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBook() {
        return book;
    }

    public void setBook(String library) {
        this.book = library;
    }

    public int getAmount() {
        return amount;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(int startAmount) {
        this.startAmount = startAmount;
    }
}
