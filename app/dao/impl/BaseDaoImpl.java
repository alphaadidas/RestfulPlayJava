package dao.impl;

import dao.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * @author gmatsu
 */
public abstract class BaseDaoImpl<T extends Serializable,K extends Serializable> extends HibernateDaoSupport implements BaseDAO<T,K> {

  protected Class<T> domainClass = getDomainClass();

  protected abstract Class<T> getDomainClass();


  @SuppressWarnings("unchecked")
  public T load(K id) {

    final Session session = this.getSession();

    return (T) session.load(domainClass,id);
  }

  @SuppressWarnings("unchecked")
  public List<T> lookUpByCriteria(Order order,Criterion... criterias){

    final Session session = this.getSession();
    Criteria crit = session.createCriteria(getDomainClass());
    for(Criterion c: criterias){
      crit.add(c);
    }
    crit.addOrder(order);

    List<T> entity =  crit.list();

    return entity;
  }

  @SuppressWarnings("unchecked")
  public List<T> lookUpByCriteria(Criterion... criterias){

    final Session session = this.getSession();
    Criteria crit = session.createCriteria(getDomainClass());
    for(Criterion c: criterias){
      crit.add(c);
    }

    List<T> entity =  crit.list();

    return entity;
  }
  @SuppressWarnings("unchecked")
  public List<T> lookUpByCriteriaDistinctRoot(Criterion... criterias){

    final Session session = this.getSession();
    Criteria crit = session.createCriteria(getDomainClass());
    for(Criterion c: criterias){
      crit.add(c);
    }
    crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

    List<T> entity =  crit.list();

    return entity;
  }

  @SuppressWarnings("unchecked")
  public T lookUpByCriteriaUnique(Criterion... criterias){

    final Session session = this.getSession();
    Criteria crit = session.createCriteria(getDomainClass());
    for(Criterion c: criterias){
      crit.add(c);
    }

    T entity =  (T)crit.uniqueResult();

    return entity;
  }

  public void update(T t) {
    final Session session = this.getSession();
    session.update(t);
  }


  public void save(T t) {
    final Session session = this.getSession();
    session.saveOrUpdate(t);
    session.flush();
  }

  public void saveOrUpdate(T t) {
    final Session session = this.getSession();
    session.saveOrUpdate(t);
    session.flush();
  }

  public void delete(T t) {
    final Session session = this.getSession();
    session.delete(t);
  }

  @SuppressWarnings("unchecked")
  public List<T> getList() {
    return (getHibernateTemplate().find("from " + domainClass.getName() + " x"));
  }

  public void deleteById(K id) {
    final Session session = this.getSession();
    Object obj = this.load(id);

    session.delete(obj);

  }

  public void deleteAll() {
    final Session session = this.getSession();
    String hqlDelete = "delete " + domainClass.getName();

    @SuppressWarnings("unused")
    int deletedEntities = session.createQuery(hqlDelete).executeUpdate();

  }

  @SuppressWarnings("unchecked")
  public int count() {
    List<T> list = getHibernateTemplate().find(
      "select count(*) from " + domainClass.getName() + " x");
    Integer count = (Integer) list.get(0);
    return count.intValue();
  }

}
