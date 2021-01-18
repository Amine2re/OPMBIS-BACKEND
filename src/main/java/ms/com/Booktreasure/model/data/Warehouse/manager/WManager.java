package ms.com.Booktreasure.model.data.Warehouse.manager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idManager;
		
	
}
