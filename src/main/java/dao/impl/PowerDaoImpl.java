package dao.impl;

import dao.PowerDao;
import entity.Power;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class PowerDaoImpl extends AbstractDaoImpl<Power> implements PowerDao {

    @Override
    @Autowired
    public AbstractDaoImpl<Power> setFactory(SessionFactory factory) {
        this.factory = factory;
        return this;
    }

    @Override
    public Collection<Power> get() {
        return null;
    }

    @Override
    public Optional<Power> get(int id) {
        Session session = factory.openSession();
        Power power = session.get(Power.class, id);
        return Optional.ofNullable(power);
    }
}
