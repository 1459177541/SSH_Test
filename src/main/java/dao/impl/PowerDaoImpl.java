package dao.impl;

import dao.PowerDao;
import entity.Power;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public class PowerDaoImpl extends AbstractDaoImpl<Power> implements PowerDao {


    @Override
    public Collection<Power> get() {
        return null;
    }

    @Override
    public Optional<Power> get(int id) {
//        Session session = factory.openSession();
//        Power power = session.get(Power.class, id);
//        return Optional.ofNullable(power);
        assert getHibernateTemplate() != null;
        return Optional.ofNullable(getHibernateTemplate().get(Power.class, id));
    }
}
