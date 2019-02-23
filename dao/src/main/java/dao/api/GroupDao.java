package dao.api;

import entity.po.Group;
import entity.po.InfoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface GroupDao extends JpaRepository<Group, Integer> {

    Map<InfoType, String> getInfo(Group group);
}
