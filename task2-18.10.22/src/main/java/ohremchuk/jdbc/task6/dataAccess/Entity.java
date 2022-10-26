package ohremchuk.jdbc.task6.dataAccess;

public class Entity {
    private Integer id;
    private String name;
    private String email;
    private Double sum;

    public Entity(Integer id, String name, String email, Double sum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSum(double payment_amount) {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Entity{" +
               "id = " + id +
               ", name = '" + name + '\'' +
               ", email = '" + email + '\'' +
               ", sum = " + sum +
               '}';
    }
}
