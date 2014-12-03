package resources;

import model.Address;
import model.AddressType;
import model.Phone;
import model.PhoneType;

import java.util.Map;

/**
 * @author: gmatsu
 */

public class CustomerResource {

  String name;
  String emailAddress;

  Map<PhoneType,Phone> phones;
  Map<AddressType,Address> addresses;


}
