import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {sessionFactory = HibernateUtil.getSessionFactory();}

    public List<Book> getBookList() {

        Session session = sessionFactory.openSession();
        session.get(Book.class, 1L);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Book> postgres = cq.from(Book.class);
        cq.select(postgres);

        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();

        session.close();

        return bookList;

    }

    public Book getBook(String name) {return null;}

}

