package dao;

import entity.Group;
import entity.InfoType;

import java.util.Map;

public interface GroupDao extends Dao<Group> {

    Map<InfoType, String> getInfo(Group group);
}
