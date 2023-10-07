package artist;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collection;

@Stateless
@EJB(name = "ArtistDAO", beanInterface = IArtistDAO.class)
public class ArtistDAO implements IArtistDAO {

    @Inject
    private EntityManager em;

    @Override
    public Collection<Artist> getAll() {
        TypedQuery<Artist> query = em.createQuery("SELECT a FROM artist a", Artist.class);
        return query.getResultList();
    }

}
