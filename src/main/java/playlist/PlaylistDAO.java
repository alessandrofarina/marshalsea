package playlist;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collection;

@Stateless
@EJB(name = "PlaylistDAO", beanInterface = IPlaylistDAO.class)
public class PlaylistDAO implements IPlaylistDAO {

    @Inject
    private EntityManager em;

    @Override
    public Collection<Playlist> getAll() {
        TypedQuery<Playlist> query = em.createQuery("SELECT p FROM playlist p", Playlist.class);
        return query.getResultList();
    }


}
