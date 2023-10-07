package playlist;

import added.Added;
import jakarta.persistence.*;
import user.User;

import java.io.Serializable;
import java.util.Collection;

@Entity(name = "playlist")
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int playlistId;
    @Column(name = "title")
    private String title;
    @Column(name = "lastAccessTime")
    private String lastAccessTime;
    @ManyToOne
    @JoinColumn(name = "enduser")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "invite",
            joinColumns = @JoinColumn(name = "playlist"),
            inverseJoinColumns = @JoinColumn(name = "guest")
    )
    private Collection<User> guests;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playlist")
    private Collection<Added> tracklist;

    public Playlist() {}

    public Playlist(int playlistId, String title, String lastAccessTime, User user, Collection<User> guests, Collection<Added> tracklist) {
        this.playlistId = playlistId;
        this.title = title;
        this.lastAccessTime = lastAccessTime;
        this.user = user;
        this.guests = guests;
        this.tracklist = tracklist;
    }

    public Collection<User> getGuests() {
        return guests;
    }

    public void setGuests(Collection<User> guests) {
        this.guests = guests;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastTimeAccess) {
        this.lastAccessTime = lastTimeAccess;
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

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", title='" + title + '\'' +
                ", lastAccessTime='" + lastAccessTime + '\'' +
                '}';
    }
}
