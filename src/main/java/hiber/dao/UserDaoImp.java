package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getOwner(String model, int series) {
        String HQL = "FROM User WHERE car.model = :model and car.series = :series";
        TypedQuery<User> query = sessionFactory.openSession().createQuery(HQL)
                .setParameter("series", series)
                .setParameter("model", model);
        return query.getSingleResult();
    }

}
