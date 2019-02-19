package dao;

import entity.po.InfoType;
import entity.po.Task;

import java.util.Map;

public interface TaskDao extends Dao<Task> {

    Map<InfoType, String> getInfo(Task task);
}
