package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    public User getUser() {
        return user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int series;

    @Column(name = "model")
    private String model;

    @OneToOne (mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
