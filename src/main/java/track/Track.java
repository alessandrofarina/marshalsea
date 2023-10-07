package track;

import album.Album;
import artist.Artist;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "track")
public class Track implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int trackId;
    @Column(name = "album")
    private int albumId;
    @Column(name = "title", length = 128)
    private String title;
    @Column(name = "trackindex")
    private int index;
    @Column(name = "duration")
    private int duration;
    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "featuring",
            joinColumns = @JoinColumn(name = "track"),
            inverseJoinColumns = @JoinColumn(name = "artist")
    )
    private Collection<Artist> featuring;

    public Track() {}

    public Track(int trackId, int albumId, String title, int index, int duration) {
        this.trackId = trackId;
        this.albumId = albumId;
        this.title = title;
        this.index = index;
        this.duration = duration;
    }

    public Track(int trackId, int albumId, String title, int index, int duration, Album album, Collection<Artist> featuring) {
        this.trackId = trackId;
        this.albumId = albumId;
        this.title = title;
        this.index = index;
        this.duration = duration;
        this.album = album;
        this.featuring = featuring;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Collection<Artist> getFeaturing() {
        return featuring;
    }

    public void setFeaturing(Collection<Artist> featuring) {
        this.featuring = featuring;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", albumId=" + albumId +
                ", title='" + title + '\'' +
                ", index=" + index +
                ", duration=" + duration +
                ", album=" + album +
                ", featuring=" + featuring +
                '}';
    }
}
