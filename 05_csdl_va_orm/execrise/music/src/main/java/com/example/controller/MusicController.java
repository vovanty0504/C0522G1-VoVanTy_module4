package com.example.controller;


import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList",musicList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("musicList", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music ,RedirectAttributes redirectAttributes) {
        music.setId((int) (Math.random() * 1000));
        musicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "add new successful!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("musicList", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Music music,RedirectAttributes redirectAttributes) {
        musicService.update( music);
        redirectAttributes.addFlashAttribute("mess","Update product successful!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , Model model){
        model.addAttribute("musicList",musicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes){
        musicService.remove(music.getId());
        redirectAttributes.addFlashAttribute("mess","Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("musicList",musicService.findById(id));
        return "view";
    }

    @GetMapping ("/search")
    public String search(@RequestParam String name , Model model){
        model.addAttribute("musicList",musicService.findName(name));
        return "list";
    }
}
