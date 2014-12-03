package managers.impls;

import dao.AddressDAO;
import dao.CustomerDAO;
import dao.PhoneDAO;
import engine.MergeRuleEngine;
import exceptions.ResourceException;
import managers.CustomerResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import resources.CustomerResource;

import java.util.List;

/**
 * @author: gmatsu
 */
@Component
public class CustomerResourceManagerImpl implements CustomerResourceManager {

  @Autowired
  private CustomerDAO customerDAO;

  @Autowired
  private AddressDAO addressDAO;

  @Autowired
  private PhoneDAO phoneDAO;

  @Autowired
  private MergeRuleEngine mergeRuleEngine;


  @Override
  public CustomerResource getResource(String id) throws ResourceException {
    //TODO: fetch and build the customer Resource here, or in a ResourceBuilder.
    return new CustomerResource();
  }


  public CustomerResource merge(List<CustomerResource> resources) throws ResourceException {

    return mergeRuleEngine.merge(resources);
  }
}
