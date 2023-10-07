package added;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AddedKey implements Serializable {

    @Column(name = "enduser")
    private int user;
    @Column(name = "track")
    private int track;
    @Column(name = "playlist")
    private int playlist;

    public AddedKey() {}


    public AddedKey(int user, int track, int playlist) {
        this.user = user;
        this.track = track;
        this.playlist = playlist;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getPlaylist() {
        return playlist;
    }

    public void setPlaylist(int playlist) {
        this.playlist = playlist;
    }

}
