package dao;

import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * @author: gmatsu
 */
public interface BaseDAO<DomainObject,KeyType> {

  public DomainObject load(KeyType id);

  public List<DomainObject> lookUpByCriteria(Criterion... criterias);

  public DomainObject lookUpByCriteriaUnique(Criterion... criterias);

  public void update(DomainObject object);

  public void save(DomainObject object);

  public void saveOrUpdate(DomainObject object);

  public void delete(DomainObject object);

  public void deleteById(KeyType id);

  public List<DomainObject> getList();

  public void deleteAll();

  public int count();

}
