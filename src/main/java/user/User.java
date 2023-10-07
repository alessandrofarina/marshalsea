package user;

import artist.Artist;
import jakarta.persistence.*;
import playlist.Playlist;

import java.io.Serializable;
import java.util.Collection;

@Entity(name = "enduser")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int userId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "alias")
    private String alias;
    @Column(name = "isPublic")
    private boolean isPublic;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Collection<Playlist> playlists;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "invite",
            joinColumns = @JoinColumn(name = "guest"),
            inverseJoinColumns = @JoinColumn(name = "playlist")
    )
    private Collection<Playlist> collabPlaylists;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "enduser"),
            inverseJoinColumns = @JoinColumn(name = "artist")
    )
    private Collection<Artist> followed;

    public User() {}

    public User(int userId, String email, String password, String alias, boolean isPublic, Collection<Playlist> playlists, Collection<Playlist> collabPlaylists, Collection<Artist> followed) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.alias = alias;
        this.isPublic = isPublic;
        this.playlists = playlists;
        this.collabPlaylists = collabPlaylists;
        this.followed = followed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Collection<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Collection<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Collection<Playlist> getCollabPlaylists() {
        return collabPlaylists;
    }

    public void setCollabPlaylists(Collection<Playlist> collabPlaylists) {
        this.collabPlaylists = collabPlaylists;
    }

    public Collection<Artist> getFollowed() {
        return followed;
    }

    public void setFollowed(Collection<Artist> followed) {
        this.followed = followed;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}
