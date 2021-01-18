package ms.com.Booktreasure.services;

import ms.com.Booktreasure.dao.authorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    authorRepository aRepos;

   public Object getAllAuthor(){
        return aRepos.findAll();
    }

    public Object getAuthor(Long idAuthor){
       return aRepos.findById(idAuthor);
    }
}
