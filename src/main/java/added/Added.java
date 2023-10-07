package added;

import jakarta.persistence.*;
import playlist.Playlist;
import track.Track;
import user.User;

import java.io.Serializable;

@Entity
public class Added implements Serializable {

    @EmbeddedId
    private AddedKey id;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "enduser")
    private User user;

    @ManyToOne
    @MapsId("track")
    @JoinColumn(name = "track")
    private Track track;

    @ManyToOne
    @MapsId("playlist")
    @JoinColumn(name = "playlist")
    private Playlist playlist;

    @Column(name = "date")
    private String date;

    public Added() {}

    public Added(AddedKey id, User user, Track track, Playlist playlist, String date) {
        this.id = id;
        this.user = user;
        this.track = track;
        this.playlist = playlist;
        this.date = date;
    }

    public AddedKey getId() {
        return id;
    }

    public void setId(AddedKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
