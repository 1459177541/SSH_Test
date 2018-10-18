package dao.impl;

import dao.PowerDao;
import entity.Power;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

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
}
