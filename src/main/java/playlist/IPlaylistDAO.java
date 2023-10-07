package playlist;

import jakarta.ejb.Local;

import java.util.Collection;

@Local
public interface IPlaylistDAO {

    Collection<Playlist> getAll();

}
