package ms.com.Booktreasure.dao;

import ms.com.Booktreasure.model.data.book.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepository extends JpaRepository<Book,Long> {

    Book findBookById(Long idBook);

    List<Book> findByPrice(int i);
}
