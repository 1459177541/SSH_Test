package dao.api;

import entity.po.Group;
import entity.po.InfoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    Map<InfoType, String> getInfo(Group group);
}
