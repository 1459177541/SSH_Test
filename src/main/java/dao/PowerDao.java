package dao;

import entity.Power;

import java.util.Optional;

public interface PowerDao extends Dao<Power> {

    Optional<Power> get(int id);

}
