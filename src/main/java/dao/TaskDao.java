package dao;

import entity.InfoType;
import entity.Task;

import java.util.Map;

public interface TaskDao extends Dao<Task> {

    Map<InfoType, String> getInfo(Task task);
}
