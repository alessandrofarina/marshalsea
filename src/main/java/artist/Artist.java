package artist;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import album.Album;
import track.Track;

@Entity(name = "artist")
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int artistId;
    @Column(name = "alias")
    private String alias;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist")
    private Collection<Album> albums;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "featuring",
            joinColumns = @JoinColumn(name = "artist"),
            inverseJoinColumns = @JoinColumn(name = "track")
    )
    private Collection<Track> featuring;

    public Artist() {}

    public Artist(int artistId, String alias) {
        this.artistId = artistId;
        this.alias = alias;
    }

    public Artist(int artistId, String alias, Collection<Album> albums, Collection<Track> featuring) {
        this.artistId = artistId;
        this.alias = alias;
        this.albums = albums;
        this.featuring = featuring;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Collection<Album> albums) {
        this.albums = albums;
    }

    public Collection<Track> getFeaturing() {
        return featuring;
    }

    public void setFeaturing(Collection<Track> featuring) {
        this.featuring = featuring;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", alias='" + alias + '\'' +
                '}';
    }
}
