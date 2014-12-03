package managers;

import exceptions.ResourceException;

/**
 * @author: gmatsu
 */
public interface BaseResourceManager<T,K>{

  public T getResource(K id) throws ResourceException;


}
