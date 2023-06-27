package com.ptl.exercise.Randstad;

import org.springframework.web.bind.annotation.PathVariable;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.cache.*;

class SongClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/jersey/app/json/song").path("entity");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        Song song = response.readEntity(Song.class);

        //problem2
        Response response2 = invocationBuilder.put(Entity.entity(SongService.class, MediaType.APPLICATION_JSON));
        //
        System.out.println(response.getStatus());
        System.out.println(song.getSinger());
    }
}

@Path("/json/song")
class SongService {
    @GET
    @Path("/entity")
    @Produces(MediaType.APPLICATION_JSON)
    public Song getSongInJson() {
        Song song = new Song();
        song.setTitle("Bailamos");
        song.setSinger("Enrique iglesias");
        return song;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_XML)
    public List<Song> getSongListInJSON() {
        Song song = new Song();
        song.setTitle("Bailamos");
        song.setSinger("Enrique Iglesias");
        List<Song> songs = new ArrayList<>();
        songs.add(song);
        return songs;
    }

    @PUT
    @Path(("/update/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSongById(@PathVariable("id") int id, Song song){
        //detailed code ignored.
    }
}

class Song {
    String title;
    String singer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}

class CachingQuestion {
    public static void main(String[] args) {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<String, String> config = new MutableConfiguration<>();
        Cache<String, String> cache = cacheManager.createCache("cache_id", config);
        cache.put("key", "value");
        cache.close();
    }
}

public class Coding {
    public static void main(String[] args) {

    }

}
