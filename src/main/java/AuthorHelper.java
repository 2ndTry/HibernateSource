import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {sessionFactory = HibernateUtil.getSessionFactory();}

    public List<Author> getAuthorList() {

        Session session = sessionFactory.openSession();
        session.get(Author.class, 1L);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> postgres = cq.from(Author.class);
        cq.select(postgres);

        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;

    }

    public Author getAuthor(String name) {return null;}

}

