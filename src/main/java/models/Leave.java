package models;

import java.util.Objects;

public class Leave {
    private String type;
    private String staff;
    private int entitled;
    private int carryover;
    private int taken;
    private int balance;
    private int id;

    public Leave(String type, String staff, int entitled, int carryover, int taken, int balance){
        this.type= type;
        this.staff = staff;
        this.entitled = entitled;
        this.carryover = carryover;
        this.taken = taken;
        this.balance = balance;
        this.id = id;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setStaff(String staff){
        this.staff = staff;
    }

    public void setEntitled(int entitled){
        this.entitled = entitled;
    }

    public void setCarryover (int carryover){
        this.carryover = carryover;
    }

    public void setTaken (int taken){
        this.taken = taken;
    }

    public void setBalance (int balance){
        this.balance = balance;
    }

    public void setId (int id){
        this.id = id;
    }

    public String getType() {
        return type;
    }


    public String getStaff() {
        return staff;
    }

    public int getEntitled() {
        return entitled;
    }

    public int getCarryover() {
        return carryover;
    }

    public int getTaken() {
        return taken;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leave leave = (Leave) o;
        return getId() == leave.getId() &&
                Objects.equals(getType(), leave.getType()) &&
                Objects.equals(getEntitled(), leave.getEntitled()) &&
                Objects.equals(getCarryover(), leave.getCarryover()) &&
                Objects.equals(getTaken(), leave.getTaken()) &&
                Objects.equals(getBalance(), leave.getBalance()) &&
                Objects.equals(getStaff(), leave.getStaff());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getStaff(), getBalance(), getCarryover(), getEntitled(), getTaken(), getId());
    }
}





