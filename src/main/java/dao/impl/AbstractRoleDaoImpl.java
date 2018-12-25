package dao.impl;


import dao.RoleDao;
import entity.user.BaseRole;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractRoleDaoImpl<T extends BaseRole> extends AbstractDaoImpl<T> implements RoleDao<T> {

    @Override
    public boolean delete(int id) {
        return delete(get(id).orElse(null));
    }

}
