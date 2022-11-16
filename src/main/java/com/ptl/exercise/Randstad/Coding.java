package com.ptl.exercise.Randstad;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import javax.cache.*;

class SongClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/jersey/app/json/song").path("entity");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        Song song = response.readEntity(Song.class);
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
        System.out.println(10);
    }
}
