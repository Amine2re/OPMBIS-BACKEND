package ms.com.Booktreasure.dao;

import ms.com.Booktreasure.model.data.book.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRepository extends JpaRepository<Author,Long> {

}
