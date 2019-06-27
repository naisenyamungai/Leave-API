package dao;

import models.DB;
import models.Leave;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLeaveDao implements LeaveDao{


    @Override
    public List<Leave> getAll() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM leave_balance")
                    .executeAndFetch(Leave.class);
        }

    }

    @Override
    public Leave findById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM leave_balance where id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Leave.class);
        }
    }

    @Override
    public void update(int id, int newEntitled, int newCarryover, int newTaken, int newBalance) {
        String sql = "UPDATE leave_balance SET entitled = :entitled WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("entitled", newEntitled)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
