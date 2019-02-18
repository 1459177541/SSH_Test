package dao.impl;

import dao.RoleDao;
import entity.InfoType;
import entity.Role;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

@Repository
@Transactional(rollbackFor = Exception.class)
public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

    @Override
    public Role alterStatus(Role role) {
        getHibernateTemplate().update(role);
        Role.RoleId id = new Role.RoleId();
        id.setRid(role.getRid());
        id.setUid(role.getUid());
        return getHibernateTemplate().get(Role.class, id);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Map<InfoType, String> getInfo(Role role) {
        return getHibernateTemplate()
                .execute(session -> {
                    Role role1 = session.get(Role.class, role.getUid());
                    Hibernate.initialize(role1.getInfo());
                    return role1.getInfo();
                });
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Role get(Serializable id) {
        return getHibernateTemplate().get(Role.class, id);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Collection<Role> get() {
        return getHibernateTemplate().loadAll(Role.class);
    }

}




