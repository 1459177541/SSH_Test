package dao.api;

import dao.entity.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDao extends JpaRepository<Role, Role.RoleId> {


}
