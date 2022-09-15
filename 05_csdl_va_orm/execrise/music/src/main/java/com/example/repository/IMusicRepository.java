package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update( Music music);

    void remove(int id);

    List<Music> findName(String name);
}
