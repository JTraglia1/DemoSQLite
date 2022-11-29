package cs333fa22.hfad.demosqlite;

public class Employee {
    private long id;
    private String name;
    private String designation;
    private long dob;

    public Employee(long id, String name, long dob, String designation) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", dob=" + dob +
                '}';
    }


}
