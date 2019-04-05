package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@DiscriminatorValue(value="Admin")
public class Admin extends User implements Serializable {

	

	public Admin() {
		super();
	}
   
}
