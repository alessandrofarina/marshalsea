package artist;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import album.Album;

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

    public Artist() {}

    public Artist(int artistId, String alias) {
        this.artistId = artistId;
        this.alias = alias;
    }

    public Artist(int id, String alias, Collection<Album> albums) {
        this.artistId = id;
        this.alias = alias;
        this.albums = albums;
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

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", alias='" + alias + '\'' +
                ", albums=" + albums +
                '}';
    }
}
