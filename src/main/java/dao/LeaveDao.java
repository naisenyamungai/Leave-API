package dao;

import models.Leave;

import java.util.List;

public interface LeaveDao {

    List<Leave> getAll();

    Leave findById (int id);

    void update(int id, int entitled, int carryover, int taken, int balance);

}
