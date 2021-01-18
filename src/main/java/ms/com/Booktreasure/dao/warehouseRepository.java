package ms.com.Booktreasure.dao;

import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface warehouseRepository extends JpaRepository<Warehouse,Long> {

}
