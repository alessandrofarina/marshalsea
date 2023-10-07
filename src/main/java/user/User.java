package user;

import artist.Artist;
import jakarta.persistence.*;
import playlist.Playlist;

import java.io.Serializable;
import java.util.Collection;

@Entity(name = "user")
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
            name = "guest",
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

}
