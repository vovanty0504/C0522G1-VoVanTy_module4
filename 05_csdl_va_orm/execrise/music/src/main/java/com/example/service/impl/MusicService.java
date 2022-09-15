package com.example.service.impl;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
     musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
      return musicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void remove(int id) {
     musicRepository.remove(id);
    }

    @Override
    public List<Music> findName(String name) {
        return musicRepository.findName(name);
    }
}
