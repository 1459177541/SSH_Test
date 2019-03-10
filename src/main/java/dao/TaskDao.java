package dao;

import entity.po.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Integer> {

}
