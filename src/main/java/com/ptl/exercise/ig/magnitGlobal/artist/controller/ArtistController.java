package com.ptl.exercise.ig.magnitGlobal.artist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ptl.exercise.ig.magnitGlobal.artist.model.Artist;
//import com.ptl.exercise.ig.magnitGlobal.artist.model;
//import com.ptl.exercise.ig.magnitGlobal.artist.service.ArtistService;

import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/* 
@RestController
@RequestMapping("v1/artists")
public class ArtistController {
    
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody ArtistRequest request) {
        Artist created = artistService.createArtist(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{artistid}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long artistId) {
        Artist artist = artistService.getArtistByID(artistId);
        if (artist == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(artist);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getArtists();
        artists.sort(Comparator.comparingLong(Artist::getId));
        return ResponseEntity.ok(artists);
    }
    
    @DeleteMapping("/{artistid}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long artistId) {
        artistService.deleteArtist(artistId);
        return ResponseEntity.noContent().build();
    }
}

*/