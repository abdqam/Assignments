package com.lookify.lookify.services;

import com.lookify.lookify.models.Song;
import com.lookify.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    // adding the Song repository as a dependency
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    // returns all the songs
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    // creates a song
    public Song createSong(Song S) {
        return songRepository.save(S);
    }
    // retrieves a song
    public Song findSong(Long id) {
        Optional<Song> optionalBook = songRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public List<Song> songsByArtist(String artist) {
        return songRepository.findByArtistContaining(artist);
    }

    public void deleteSong(Long id){
        songRepository.deleteById(id);
    }
    public List<Song> TopTen(){
        return songRepository.findTop10ByOrderByRatingDesc();
    }
}