package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(user.getCar());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    //   уверен можно проще, только не пойму как
    @Override
    public User userWhoOwnsTheCar(String model, int series) {
        String hql = "FROM Car WHERE model = :paramModel";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("paramModel", model);
        List<Car> car = query.getResultList();
        return listUsers().get(car.get(0).getId() - 1);
    }

}
