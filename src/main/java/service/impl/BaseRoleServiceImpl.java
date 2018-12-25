package service.impl;

import dao.RoleDao;
import entity.user.BaseRole;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.RoleService;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Repository
public abstract class BaseRoleServiceImpl<T extends BaseRole> implements RoleService<T> {

    protected RoleDao<T> dao;
    public abstract BaseRoleServiceImpl setDao(RoleDao<T> dao);

    @Override
    public Optional<T> get(int id) {
        return dao.get(id);
    }

    @Override
    public boolean add(T user) {
        return dao.add(user);
    }

    @Override
    public boolean delete(T user) {
        return dao.delete(user.getUser().getId());
    }

    @Override
    @Valid
    public boolean update(T user) {
        return dao.update(user);
    }


}
