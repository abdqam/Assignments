package com.lookify.lookify.repositories;

import com.lookify.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
    // this method retrieves all the Songs from the database
    List<Song> findAll();
    // this method finds songs with artist containing the search string
    List<Song> findByArtistContaining(String artist);
    List<Song> findTop10ByOrderByRatingDesc();
}