package dao.impl;

import dao.CustomerDAO;
import model.Customer;
import org.springframework.stereotype.Component;

/**
 * @author: gmatsu
 */
@Component
public class CustomerDaoImpl extends BaseDaoImpl<Customer,String> implements CustomerDAO {

  @Override
  protected Class<Customer> getDomainClass() {
    return Customer.class;
  }




}
