package ms.com.Booktreasure.model.data.localization;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCity;
	
	private String nameCity;
	
	private String regionCity;
	
}
