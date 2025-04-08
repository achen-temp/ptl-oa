package com.ptl.exercise.ig.magnitGlobal.artist.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import com.ptl.exercise.ig.magnitGlobal.artist.model.Artist;
//import com.ptl.exercise.ig.magnitGlobal.artist.repository.ArtistRepository;

/* 
@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist createArtist(ArtistRequest artistRequest) {
        Artist artist = new Artist();
        artist.setFirstName(artistRequest.firstName());
        artist.setLastName(artistRequest.lastName());
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> list = artistRepository.findAll();
        Collections.sort(list, (a1, a2) -> a1.getId().compareTo(a2.getId()));
        return list;
    }

    @Override
    public Artist getArtistByID(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
    
}

*/
