package artist;

import jakarta.ejb.Local;

import java.util.Collection;

@Local
public interface IArtistDAO {

    Collection<Artist> getAll();

}
