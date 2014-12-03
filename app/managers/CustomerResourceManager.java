package managers;

import exceptions.ResourceException;
import resources.CustomerResource;

import java.util.List;

/**
 * @author: gmatsu
 */
public interface  CustomerResourceManager extends BaseResourceManager<CustomerResource,String> {

  //CRUD
  //merge
  public CustomerResource merge(List<CustomerResource> resources) throws ResourceException;


}
