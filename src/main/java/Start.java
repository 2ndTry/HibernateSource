import entity.Author;
import entity.Book;
import org.hibernate.Session;

public class Start {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author : new AuthorHelper().getAuthorList()
        ) {
            System.out.println("Author is: " + author);

        }
        for (Book book : new BookHelper().getBookList()
        ) {
            System.out.println("Book is: " + book);

        }
    }
}

