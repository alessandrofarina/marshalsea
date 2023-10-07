package album;

import artist.Artist;
import jakarta.persistence.*;
import track.Track;

import java.io.Serializable;
import java.util.Collection;

@Entity(name = "album")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int albumId;
    @Column(name = "title")
    private String title;
    @Column(name = "tracks")
    private int tracks;
    @Column(name = "duration")
    private int duration;
    @Column(name = "year")
    private int year;
    @ManyToOne
    @JoinColumn(name = "artist")
    private Artist artist;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    private Collection<Track> tracklist;

    public Album() {}

    public Album(int albumId, String title, int tracks, int duration, int year) {
        this.albumId = albumId;
        this.title = title;
        this.tracks = tracks;
        this.duration = duration;
        this.year = year;
    }

    public Album(int albumId, String title, int tracks, int duration, int year, Artist artist, Collection<Track> tracklist) {
        this.albumId = albumId;
        this.title = title;
        this.tracks = tracks;
        this.duration = duration;
        this.year = year;
        this.artist = artist;
        this.tracklist = tracklist;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Collection<Track> getTracklist() {
        return tracklist;
    }

    public void setTracklist(Collection<Track> tracklist) {
        this.tracklist = tracklist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                ", tracks=" + tracks +
                ", duration=" + duration +
                ", year=" + year +
                '}';
    }
}
