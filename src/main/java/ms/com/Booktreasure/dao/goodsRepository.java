package ms.com.Booktreasure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms.com.Booktreasure.model.data.good.Good;

@Repository
public interface goodsRepository extends JpaRepository<Good, Long>{

     Good findGoodById(Long idGood);


}
