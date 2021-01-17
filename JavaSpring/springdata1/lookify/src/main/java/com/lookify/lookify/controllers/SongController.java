package com.lookify.lookify.controllers;

import com.lookify.lookify.models.Song;
import com.lookify.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/")
    public String root() {
        return "root.jsp";
    }
    @RequestMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("song")Song song) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "Welcome.jsp";
    }
    @RequestMapping(value="/search", method= RequestMethod.POST)
    public String search(@RequestParam("artist")String artist,Model model) {
        List<Song> songs = songService.songsByArtist(artist);
        model.addAttribute("songs",songs);
        return "search.jsp";
    }
    @RequestMapping("/songs/new")
    public String New(@ModelAttribute("song")Song song){
        return "new.jsp";
    }
    @RequestMapping(value="/newsong", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id")Long id,Model model){
        Song song = songService.findSong(id);
        model.addAttribute("song",song);
        return "show.jsp";
    }
    @RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id")Long id){
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    @RequestMapping("/search/top10")
    public String topTen(Model model){
        model.addAttribute("songs",songService.TopTen());
        return "topten.jsp";
    }
}