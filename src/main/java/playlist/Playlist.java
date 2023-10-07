package playlist;

import added.Added;
import artist.Artist;
import jakarta.persistence.*;
import track.Track;
import user.User;

import java.io.Serializable;
import java.util.Collection;

@Entity(name = "playlist")
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int playlistId;
    @Column(name = "enduser")
    private int userId;
    @Column(name = "title")
    private String title;
    @Column(name = "lastTimeAccess")
    private String lastTimeAccess;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private Collection<Added> tracklist;

    public Playlist() {}

    public Playlist(int playlistId, int userId, String title, String lastTimeAccess, User user, Collection<Added> tracklist) {
        this.playlistId = playlistId;
        this.userId = userId;
        this.title = title;
        this.lastTimeAccess = lastTimeAccess;
        this.user = user;
        this.tracklist = tracklist;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastTimeAccess() {
        return lastTimeAccess;
    }

    public void setLastTimeAccess(String lastTimeAccess) {
        this.lastTimeAccess = lastTimeAccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Added> getTracklist() {
        return tracklist;
    }

    public void setTracklist(Collection<Added> tracklist) {
        this.tracklist = tracklist;
    }
}
